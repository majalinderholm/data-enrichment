package com.eqt.dataenrichment;

import com.eqt.dataenrichment.domain.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataEnrichmentApplication {

    public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DataEnrichmentApplication.class, args);
        final CompanyService companyService = context.getBean(CompanyService.class);
		companyService.fetchAndEnhanceCompanies();
	}

}
