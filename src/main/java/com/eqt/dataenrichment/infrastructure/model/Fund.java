package com.eqt.dataenrichment.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.net.URI;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Fund {
    @JsonProperty("path")
    public URI path;

    @JsonProperty("title")
    public String title;
}
