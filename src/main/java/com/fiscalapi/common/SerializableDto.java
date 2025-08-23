package com.fiscalapi.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class SerializableDto {

    // toString to JSON
    @Override
    public String toString() {
        try {

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            //mapper.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS); // Configurar formato ISO-8601 para LocalDateTime
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false); // allow null values
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            //mapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL); //exclude null fields







            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return "{\"error\":\"Error generando JSON\"}";
        }
    }
}
