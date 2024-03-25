package com.eqt.dataenrichment.domain.model;

import com.eqt.dataenrichment.domain.utils.FundConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(name = "company")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    private UUID uuid;
    private String name;
    private String sector;
    private String city; //not on website
    private String country;
    @Convert(converter = FundConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<Fund> funds;
    private URI uri;
    private String promotedSdg;
    private List<String> sdg;
    private String topic;
    private LocalDate foundedOn; //not on website
    private String shortDescription; //not on website
    private String description; //not on website
    private int fundingRounds; //not on website
    private double fundingTotalUsd; //not on website
    private String numberOfEmployees; //not on website
    private LocalDate entry;
    private LocalDate exit; //must be same year or after entry

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Company company = (Company) o;
        return uuid != null && Objects.equals(uuid, company.uuid);
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
