package com.fiscalapi.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ApiResponse<T> {
    private T data;
    private boolean succeeded;
    private String message;
    private String details;
    private int httpStatusCode;

    // Getters / Setters
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public boolean isSucceeded() { return succeeded; }
    public void setSucceeded(boolean succeeded) { this.succeeded = succeeded; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public int getHttpStatusCode() { return httpStatusCode; }
    public void setHttpStatusCode(int httpStatusCode) { this.httpStatusCode = httpStatusCode; }


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
