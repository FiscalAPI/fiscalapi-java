package com.fiscalapi.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;

public class AuditableDto {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    // toString to JSON
    @Override
    public String toString() {
        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // disable "createdAt": 1640995200000 and enable "createdAt": "2022-01-01T10:00:00"
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false); // allow null values
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            //mapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL); //exclude null fields
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return "{\"error\":\"Error generando JSON\"}";
        }
    }
}
