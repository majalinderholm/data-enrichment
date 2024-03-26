package com.eqt.dataenrichment.domain.model;

import com.eqt.dataenrichment.domain.utils.FundConverter;
import com.eqt.dataenrichment.infrastructure.model.organization.Organization;
import jakarta.persistence.*;
import lombok.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(name = "company")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {

    @Id
    private UUID uuid;
    private String name;
    private String sector;
    private String city; //not on website
    private String country;
    private String countryCode;
    @Convert(converter = FundConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<Fund> funds;
    private URI uri;
    private String homePage;
    private String promotedSdg;
    private List<String> sdg;
    private String topic;
    private LocalDate foundedOn; //not on website
    private String shortDescription; //not on website
    private String description; //not on website TODO enhance from 2019 data
    private int fundingRounds; //not on website
    private LocalDate lastFundingOn; //not on website
    private double fundingTotalUsd; //not on website
    private String numberOfEmployees; //not on website
    private LocalDate entry;
    private LocalDate exit; //must be same year or after entry

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return fundingRounds == company.fundingRounds && Double.compare(fundingTotalUsd, company.fundingTotalUsd) == 0 && Objects.equals(uuid, company.uuid) && Objects.equals(name, company.name) && Objects.equals(sector, company.sector) && Objects.equals(city, company.city) && Objects.equals(country, company.country) && Objects.equals(countryCode, company.countryCode) && Objects.equals(funds, company.funds) && Objects.equals(uri, company.uri) && Objects.equals(homePage, company.homePage) && Objects.equals(promotedSdg, company.promotedSdg) && Objects.equals(sdg, company.sdg) && Objects.equals(topic, company.topic) && Objects.equals(foundedOn, company.foundedOn) && Objects.equals(shortDescription, company.shortDescription) && Objects.equals(description, company.description) && Objects.equals(lastFundingOn, company.lastFundingOn) && Objects.equals(numberOfEmployees, company.numberOfEmployees) && Objects.equals(entry, company.entry) && Objects.equals(exit, company.exit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, sector, city, country, countryCode, funds, uri, homePage, promotedSdg, sdg, topic, foundedOn, shortDescription, description, fundingRounds, lastFundingOn, fundingTotalUsd, numberOfEmployees, entry, exit);
    }

    public Company enhance(final Organization organization) {
        return Company.builder()
                .uuid(uuid)
                .name(name)
                .sector(sector)
                .city(organization.getCity())
                .country(country)
                .countryCode(organization.getCountryCode())
                .funds(funds)
                .uri(uri)
                .homePage(organization.getHomepageUrl())
                .promotedSdg(promotedSdg)
                .sdg(sdg)
                .topic(topic)
                .foundedOn(organization.getFoundedOn())
                .shortDescription(organization.getShortDescription())
                .fundingRounds(organization.getNumFundingRounds())
                .lastFundingOn(organization.getLastFundingOn())
                .numberOfEmployees(organization.getEmployeeCount())
                .entry(entry)
                .exit(exit)
                .build();
    }
}
