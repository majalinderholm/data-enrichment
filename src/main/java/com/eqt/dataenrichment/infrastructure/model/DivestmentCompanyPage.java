package com.eqt.dataenrichment.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DivestmentCompanyPage {
    @JsonProperty("_id")
    public UUID id;

    @JsonProperty("country")
    public String country;

    @JsonProperty("entryDate")
    public LocalDate entryDate;

    @JsonProperty("exitDate")
    public LocalDate exitDate;

    @JsonProperty("fund")
    public List<Fund> funds;

    @JsonProperty("path")
    public URI path;

    @JsonProperty("sector")
    public String sector;

    @JsonProperty("title")
    public String title;
}
