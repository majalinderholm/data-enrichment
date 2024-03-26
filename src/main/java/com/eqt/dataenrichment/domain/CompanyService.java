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
import java.util.regex.Pattern;

@Service
public class CompanyService {
    private final CompanyRepositroy companyRepositroy;
    private final EqtWebClient eqtWebClient;
    private final OrganizationParser googleStorageWebClient;

    @Autowired
    public CompanyService(final CompanyRepositroy companyRepositroy,
                          final EqtWebClient eqtWebClient,
                          final OrganizationParser googleStorageWebClient) {
        this.companyRepositroy = companyRepositroy;
        this.eqtWebClient = eqtWebClient;
        this.googleStorageWebClient = googleStorageWebClient;
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

        List<Organization> organizations = googleStorageWebClient.readOrganizationJson();

        List<Company> enhancedCompanies = companies.stream()
                .map(company -> organizations.stream()
                        .filter(organization -> matchCompanyName(company, organization))
                        .findFirst()
                        .map(company::enhance)
                        .orElse(company))
                .toList();

        companyRepositroy.saveAll(enhancedCompanies);
        System.out.println("Done fetching and enhancing companies");
    }

    private boolean matchCompanyName(final Company company,
                                     final Organization organization) {
        return Pattern.matches(Pattern.quote(organization.getName()), company.getName());
    }
}
