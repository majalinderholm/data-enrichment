package com.eqt.dataenrichment.infrastructure.model.divestment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DivestmentCompanyData {
    @JsonProperty("allSanityCompanyPage")
    public DivestmentCompanyPageContainer allSanityCompanyPage;
}
