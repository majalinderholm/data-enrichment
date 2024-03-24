package com.eqt.dataenrichment.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    private UUID uuid;
    private String name;
    private String sector;
    private String city;
    private String country;
    private String fund;
    private URL url;
    private LocalDate foundedOn;
    private String shortDescription;
    private String description;
    private int fundingRounds;
    private double fundingTotalUsd;
    private String numberOfEmployees;
    private int entry; //must be a valid year
    private int exit; //must be same year or after entry

}
