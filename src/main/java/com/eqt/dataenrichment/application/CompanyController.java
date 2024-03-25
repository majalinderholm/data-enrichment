package com.eqt.dataenrichment.application;

import com.eqt.dataenrichment.domain.CompanyService;
import com.eqt.dataenrichment.domain.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/company")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

}
