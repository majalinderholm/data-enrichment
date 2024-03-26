package com.eqt.dataenrichment.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.net.URI;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Fund {
    @JsonProperty("title")
    private String title;
    @JsonProperty("path")
    private URI path;
}
