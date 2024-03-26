package com.eqt.dataenrichment.domain;

import com.eqt.dataenrichment.domain.model.Company;
import com.eqt.dataenrichment.domain.utils.CompanyMapper;
import com.eqt.dataenrichment.infrastructure.EqtWebClient;
import com.eqt.dataenrichment.infrastructure.OrganizationParser;
import com.eqt.dataenrichment.infrastructure.model.divestment.DivestmentCompanyResponse;
import com.eqt.dataenrichment.infrastructure.model.organization.Organization;
import com.eqt.dataenrichment.infrastructure.model.portfolio.PortfolioCompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Service
public class CompanyService {
    private final CompanyRepositroy companyRepositroy;
    private final EqtWebClient eqtWebClient;
    private final OrganizationParser organizationParser;

    @Autowired
    public CompanyService(final CompanyRepositroy companyRepositroy,
                          final EqtWebClient eqtWebClient,
                          final OrganizationParser organizationParser) {
        this.companyRepositroy = companyRepositroy;
        this.eqtWebClient = eqtWebClient;
        this.organizationParser = organizationParser;
    }

    public List<Company> getAllCompanies() {
        return companyRepositroy.findAll();
    }

    public void fetchAndEnhanceCompanies() {
        final PortfolioCompanyResponse portfolioCompanyResponse = eqtWebClient.fetchPortfolioCompanies();
        final DivestmentCompanyResponse divestmentCompanyResponse = eqtWebClient.fetchDivestmentCompanies();

        List<Company> companies = new ArrayList<>();
        companies.addAll(CompanyMapper.mapToCompanies(portfolioCompanyResponse));
        companies.addAll(CompanyMapper.mapToCompanies(divestmentCompanyResponse));

        List<Organization> organizations = organizationParser.readOrganizationJson();

        AtomicInteger numberOfEnhancedCompanies = new AtomicInteger();

        List<Company> enhancedCompanies = companies.stream()
                .map(company -> organizations.stream()
                        .filter(organization -> matchCompanyName(company, organization))
                        .findFirst()
                        .map(organization -> {
                            numberOfEnhancedCompanies.getAndIncrement();
                            return company.enhance(organization);
                        })
                        .orElse(company))
                .toList();

        double percentageEnhancedCompanies = (double) numberOfEnhancedCompanies.get() / companies.toArray().length * 100;
        System.out.println("Percentage of enhanced companies: " + percentageEnhancedCompanies);

        companyRepositroy.saveAll(enhancedCompanies);
        System.out.println("Done fetching and enhancing companies");
    }

    private boolean matchCompanyName(final Company company,
                                     final Organization organization) {
        return Pattern.matches(
                Pattern.quote(
                        organization.getName().toLowerCase().replace(" ", "")),
                company.getName().toLowerCase().replace(" ", "")
        );
    }
}
