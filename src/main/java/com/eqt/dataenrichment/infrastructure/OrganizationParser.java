package com.eqt.dataenrichment.infrastructure;

import com.eqt.dataenrichment.infrastructure.model.organization.Organization;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationParser {

    private final ObjectMapper objectMapper;

    public OrganizationParser() {
        this.objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<Organization> readOrganizationJson() {
        List<Organization> organizations = new ArrayList<>();
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("interview-test-org.json")) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    final Organization organization = objectMapper.readValue(line, Organization.class);
                    organizations.add(organization);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file", e);
        }
        return organizations;
    }

}
