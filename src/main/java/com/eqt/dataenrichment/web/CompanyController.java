package com.eqt.dataenrichment.web;

import com.eqt.dataenrichment.domain.CompanyService;
import com.eqt.dataenrichment.domain.model.Company;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CompanyController {

    @Autowired
    private final CompanyService companyService;

    @GetMapping("/company")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

}
