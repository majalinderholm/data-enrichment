package com.eqt.dataenrichment.domain.utils;

import com.eqt.dataenrichment.domain.model.Fund;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter
public class FundConverter implements AttributeConverter<List<Fund>, String> {

    private final ObjectMapper objectMapper;

    public FundConverter() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Override
    public String convertToDatabaseColumn(final List<Fund> funds) {
        try {
            return objectMapper.writeValueAsString(funds);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }

    @Override
    public List<Fund> convertToEntityAttribute(final String jsonString) {
        try {
            return objectMapper.readValue(jsonString, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }
}
