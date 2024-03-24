package com.eqt.dataenrichment.utils;

import com.eqt.dataenrichment.domain.model.Company;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class DataFactory {

    private static final UUID uuid = UUID.fromString("c660e2ac-5eba-45a1-a814-86d63bc1e5e9");
    private static final String name = "Name";
    private static final String sector = "Sector";
    private static final String city = "City";
    private static final String country = "Country";
    private static final String fund = "Fund";
    private static final URL url;

    static {
        try {
            url = new URL("https://localhost:8080");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final LocalDate foundedOn = LocalDate.EPOCH;
    private static final String shortDescription = "Short description";
    private static final String description = "Description";
    private static final int fundingRounds = 1;
    private static final double fundingTotalUsd = 1.00;
    private static final String numberOfEmployees = "1-10";
    private static final int entry = 2020;
    private static final int exit = 2022;

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
                .fund(fund)
                .url(url)
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
}
