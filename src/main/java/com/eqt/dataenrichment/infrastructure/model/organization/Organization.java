package com.eqt.dataenrichment.infrastructure.model.organization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Organization {
    @JsonProperty("uuid")
    private UUID uuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("homepage_url")
    private String homepageUrl;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("founded_on")
    private LocalDate foundedOn;
    @JsonProperty("short_description")
    private String shortDescription;
    @JsonProperty("num_funding_rounds")
    private int numFundingRounds;
    @JsonProperty("last_funding_on")
    private LocalDate lastFundingOn;
    @JsonProperty("employee_count")
    private String employeeCount;
    @JsonProperty("total_funding_usd")
    private String totalFundingUSD;
}
