package com.eqt.dataenrichment.application;

import com.eqt.dataenrichment.domain.CompanyService;
import com.eqt.dataenrichment.domain.model.Company;
import com.eqt.dataenrichment.utils.DataFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CompanyControllerTest {

    @InjectMocks
    private CompanyController companyController;
    @Mock
    private CompanyService companyService;
    private final List<Company> companies = DataFactory.companies();

    @Test
    public void should_get_all_companies() {
        when(companyService.getAllCompanies()).thenReturn(companies);

        final List<Company> result = companyController.getAllCompanies();

        assertEquals(companies, result);
    }
}