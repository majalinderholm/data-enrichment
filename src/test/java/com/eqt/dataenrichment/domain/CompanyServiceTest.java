package com.eqt.dataenrichment.domain;

import com.eqt.dataenrichment.domain.model.Company;
import com.eqt.dataenrichment.utils.DataFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;
    @Mock
    private CompanyRepositroy companyRepositroy;
    private final List<Company> companies = DataFactory.companies();

    @Test
    public void should_get_all_companies() {
        when(companyRepositroy.findAll()).thenReturn(companies);

        final List<Company> result = companyService.getAllCompanies();

        assertEquals(companies, result);
    }
}