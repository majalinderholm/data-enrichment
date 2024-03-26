package com.eqt.dataenrichment.domain.utils;

import com.eqt.dataenrichment.domain.model.Company;
import com.eqt.dataenrichment.domain.model.Fund;
import com.eqt.dataenrichment.infrastructure.model.divestment.DivestmentCompanyResponse;
import com.eqt.dataenrichment.infrastructure.model.portfolio.PortfolioCompanyResponse;

import java.util.List;

public class CompanyMapper {

    private CompanyMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Company> mapToCompanies(final PortfolioCompanyResponse portfolioCompanyResponse) {
        return portfolioCompanyResponse.result.data.allSanityCompanyPage.nodes
                .stream()
                .map(portfolioCompany -> Company.builder()
                        .uuid(portfolioCompany.id)
                        .name(portfolioCompany.title)
                        .sector(portfolioCompany.sector)
                        .country(portfolioCompany.country)
                        .funds(mapToDomain(portfolioCompany.funds))
                        .uri(portfolioCompany.path) //TODO: add full path
                        .promotedSdg(portfolioCompany.promotedSdg)
                        .sdg(portfolioCompany.sdg)
                        .topic(portfolioCompany.topic)
                        .entry(portfolioCompany.entryDate)
                        .build())
                .toList();
    }

    public static List<Company> mapToCompanies(final DivestmentCompanyResponse divestmentCompanyResponse) {
        return divestmentCompanyResponse.result.data.allSanityCompanyPage.nodes
                .stream()
                .map(divestmentCompany -> Company.builder()
                        .uuid(divestmentCompany.id)
                        .name(divestmentCompany.title)
                        .sector(divestmentCompany.sector)
                        .country(divestmentCompany.country)
                        .funds(mapToDomain(divestmentCompany.funds))
                        .uri(divestmentCompany.path) //TODO: add full path
                        .entry(divestmentCompany.entryDate)
                        .exit(divestmentCompany.exitDate)
                        .build())
                .toList();
    }

    private static List<Fund> mapToDomain(final List<com.eqt.dataenrichment.infrastructure.model.Fund> apiFunds) {
        return apiFunds.stream()
                .map(apiFund -> Fund.builder()
                        .title(apiFund.title)
                        .path(apiFund.path)
                        .build()
                )
                .toList();
    }
}
