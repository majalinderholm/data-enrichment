package com.eqt.dataenrichment.domain;

import com.eqt.dataenrichment.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepositroy extends JpaRepository<Company, UUID> {

}
