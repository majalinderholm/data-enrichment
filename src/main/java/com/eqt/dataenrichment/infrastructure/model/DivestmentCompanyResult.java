package com.eqt.dataenrichment.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DivestmentCompanyResult {
    @JsonProperty("data")
    public DivestmentCompanyData data;
}
