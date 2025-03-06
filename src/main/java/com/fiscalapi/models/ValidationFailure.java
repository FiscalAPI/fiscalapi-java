package com.fiscalapi.models;
import java.util.Map;

public class ValidationFailure {
    private String propertyName;
    private String errorMessage;
    private Object attemptedValue;
    private Object customState;
    private int severity;
    private String errorCode;
    private Map<String, Object> formattedMessagePlaceholderValues;

    // Getters y Setters

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getAttemptedValue() {
        return attemptedValue;
    }

    public void setAttemptedValue(Object attemptedValue) {
        this.attemptedValue = attemptedValue;
    }

    public Object getCustomState() {
        return customState;
    }

    public void setCustomState(Object customState) {
        this.customState = customState;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, Object> getFormattedMessagePlaceholderValues() {
        return formattedMessagePlaceholderValues;
    }

    public void setFormattedMessagePlaceholderValues(Map<String, Object> formattedMessagePlaceholderValues) {
        this.formattedMessagePlaceholderValues = formattedMessagePlaceholderValues;
    }
}
