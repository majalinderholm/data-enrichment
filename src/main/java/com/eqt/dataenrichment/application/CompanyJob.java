package com.eqt.dataenrichment.application;

import com.eqt.dataenrichment.domain.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CompanyJob implements ApplicationRunner {

    private final CompanyService companyService;

    @Autowired
    public CompanyJob(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public void run(ApplicationArguments args) {
        companyService.fetchCompanies();
    }
}
