package com.eqt.dataenrichment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URI;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Fund {
    private String title;
    private URI path;
}
