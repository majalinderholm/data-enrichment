package com.eqt.dataenrichment.domain;

import com.eqt.dataenrichment.domain.model.Company;
import com.eqt.dataenrichment.domain.utils.CompanyMapper;
import com.eqt.dataenrichment.infrastructure.EqtWebClient;
import com.eqt.dataenrichment.infrastructure.model.DivestmentCompanyResponse;
import com.eqt.dataenrichment.infrastructure.model.PortfolioCompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepositroy companyRepositroy;
    private final EqtWebClient eqtWebClient;

    @Autowired
    public CompanyService(final CompanyRepositroy companyRepositroy,
                          final EqtWebClient eqtWebClient) {
        this.companyRepositroy = companyRepositroy;
        this.eqtWebClient = eqtWebClient;
    }

    public List<Company> getAllCompanies() {
        return companyRepositroy.findAll();
    }

    public void fetchCompanies() {
        final PortfolioCompanyResponse portfolioCompanyResponse = eqtWebClient.fetchPortfolioCompanies();
        final DivestmentCompanyResponse divestmentCompanyResponse = eqtWebClient.fetchDivestmentCompanies();

        List<Company> companies = new ArrayList<>();
        companies.addAll(CompanyMapper.mapToCompanies(portfolioCompanyResponse));
        companies.addAll(CompanyMapper.mapToCompanies(divestmentCompanyResponse));

        companyRepositroy.saveAll(companies);
    }
}
