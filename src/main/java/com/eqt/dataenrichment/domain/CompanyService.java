package com.eqt.dataenrichment.domain;

import com.eqt.dataenrichment.domain.model.Company;
import com.eqt.dataenrichment.repository.CompanyRepositroy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    @Autowired
    private final CompanyRepositroy companyRepositroy;

    public List<Company> getAllCompanies() {
        return companyRepositroy.findAll();
    }
}
