package com.eqt.dataenrichment.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DivestmentCompanyPageContainer {
    @JsonProperty("nodes")
    public List<DivestmentCompanyPage> nodes;
}
