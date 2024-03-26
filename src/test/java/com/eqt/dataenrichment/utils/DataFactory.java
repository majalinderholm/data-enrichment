package com.eqt.dataenrichment.utils;

import com.eqt.dataenrichment.domain.model.Company;
import com.eqt.dataenrichment.domain.model.Fund;
import com.eqt.dataenrichment.infrastructure.model.divestment.*;
import com.eqt.dataenrichment.infrastructure.model.portfolio.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class DataFactory {

    private static final UUID uuid = UUID.fromString("c660e2ac-5eba-45a1-a814-86d63bc1e5e9");
    private static final String name = "Name";
    private static final String sector = "Sector";
    private static final String city = "City";
    private static final String country = "Country";
    private static final String fundTitle = "Fund";
    private static final URI uri = URI.create("https://localhost:8080");
    private static final String promotedSdg = "Promoted Sdg";
    private static final List<String> sdg = List.of("sdg");
    private static final LocalDate foundedOn = LocalDate.EPOCH;
    private static final String shortDescription = "Short description";
    private static final String description = "Description";
    private static final int fundingRounds = 1;
    private static final double fundingTotalUsd = 1.00;
    private static final String numberOfEmployees = "1-10";
    private static final LocalDate entry = LocalDate.MIN;
    private static final LocalDate exit = LocalDate.MAX;
    private static final String topic = "Topic";

    public static PortfolioCompanyResponse portfolioCompanyResponse() {
        return PortfolioCompanyResponse.builder()
                .result(
                        PortfolioResult.builder()
                                .data(PortfolioData.builder()
                                        .allSanityCompanyPage(PortfolioCompanyPageContainer.builder()
                                                .nodes(List.of(
                                                        portfolioCompanyPage())
                                                )
                                                .build()
                                        ).build()
                                ).build()
                ).build();
    }

    private static PortfolioCompanyPage portfolioCompanyPage() {
        return PortfolioCompanyPage.builder()
                .id(uuid)
                .country(country)
                .entryDate(entry)
                .funds(apiFunds())
                .path(uri)
                .promotedSdg(promotedSdg)
                .sdg(sdg)
                .sector(sector)
                .title(name)
                .topic(topic)
                .build();
    }

    private static List<com.eqt.dataenrichment.infrastructure.model.Fund> apiFunds() {
        return List.of(
                com.eqt.dataenrichment.infrastructure.model.Fund.builder()
                        .title(fundTitle)
                        .path(uri)
                        .build()
        );
    }

    public static List<Company> companiesPortfolioMappingResult() {
        return List.of(
                Company.builder()
                        .uuid(uuid)
                        .name(name)
                        .sector(sector)
                        .country(country)
                        .funds(domainFunds())
                        .uri(uri)
                        .promotedSdg(promotedSdg)
                        .sdg(sdg)
                        .entry(entry)
                        .topic(topic)
                        .build()
        );
    }

    public static DivestmentCompanyResponse divestmentCompanyResponse() {
        return DivestmentCompanyResponse.builder()
                .result(DivestmentCompanyResult.builder()
                        .data(DivestmentCompanyData.builder()
                                .allSanityCompanyPage(DivestmentCompanyPageContainer.builder()
                                        .nodes(List.of(divestmentCompanyPage()))
                                        .build()
                                ).build()
                        ).build()
                ).build();
    }

    private static DivestmentCompanyPage divestmentCompanyPage() {
        return DivestmentCompanyPage.builder()
                .id(uuid)
                .country(country)
                .entryDate(entry)
                .exitDate(exit)
                .funds(apiFunds())
                .path(uri)
                .sector(sector)
                .title(name)
                .build();
    }

    public static List<Company> companiesDivestmentMappingResult() {
        return List.of(
                Company.builder()
                        .uuid(uuid)
                        .name(name)
                        .sector(sector)
                        .country(country)
                        .funds(domainFunds())
                        .uri(uri)
                        .entry(entry)
                        .exit(exit)
                        .build()
        );
    }

    public static List<Company> companies() {
        return List.of(
                company()
        );
    }

    public static Company company() {
        return Company.builder()
                .uuid(uuid)
                .name(name)
                .sector(sector)
                .city(city)
                .country(country)
                .funds(domainFunds())
                .uri(uri)
                .foundedOn(foundedOn)
                .shortDescription(shortDescription)
                .description(description)
                .fundingRounds(fundingRounds)
                .fundingTotalUsd(fundingTotalUsd)
                .numberOfEmployees(numberOfEmployees)
                .entry(entry)
                .exit(exit)
                .build();
    }

    private static List<Fund> domainFunds() {
        return List.of(
                Fund.builder()
                        .title(fundTitle)
                        .path(uri)
                        .build()
        );
    }
}
