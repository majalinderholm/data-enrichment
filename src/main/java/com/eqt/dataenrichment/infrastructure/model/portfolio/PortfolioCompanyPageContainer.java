package com.eqt.dataenrichment.infrastructure.model.portfolio;

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
public class PortfolioCompanyPageContainer {
    @JsonProperty("nodes")
    public List<PortfolioCompanyPage> nodes;

}
