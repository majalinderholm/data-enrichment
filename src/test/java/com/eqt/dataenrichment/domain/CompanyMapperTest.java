package com.eqt.dataenrichment.domain;

import com.eqt.dataenrichment.domain.model.Company;
import com.eqt.dataenrichment.domain.utils.CompanyMapper;
import com.eqt.dataenrichment.infrastructure.model.divestment.DivestmentCompanyResponse;
import com.eqt.dataenrichment.infrastructure.model.portfolio.PortfolioCompanyResponse;
import com.eqt.dataenrichment.utils.DataFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyMapperTest {
    private final PortfolioCompanyResponse portfolioCompanyResponse = DataFactory.portfolioCompanyResponse();
    private final List<Company> expectedPortfolioMapping = DataFactory.companiesPortfolioMappingResult();
    private final DivestmentCompanyResponse divestmentCompanyResponse = DataFactory.divestmentCompanyResponse();
    private final List<Company> expectedDivestmentMapping = DataFactory.companiesDivestmentMappingResult();

    @Test
    public void should_map_portfolio_company_to_domain() {
        final List<Company> result = CompanyMapper.mapToCompanies(portfolioCompanyResponse);

        assertEquals(expectedPortfolioMapping, result);
    }

    @Test
    public void should_map_divestment_company_to_domain() {
        final List<Company> result = CompanyMapper.mapToCompanies(divestmentCompanyResponse);

        assertEquals(expectedDivestmentMapping, result);
    }
}