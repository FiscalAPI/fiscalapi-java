package com.fiscalapi.common;


public class ValidationFailure {
    private String propertyName;
    private String errorMessage;
    private Object attemptedValue;
    private Object customState;
    private int severity;
    private String errorCode;

    // Getters and Setters
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public Object getAttemptedValue() { return attemptedValue; }
    public void setAttemptedValue(Object attemptedValue) { this.attemptedValue = attemptedValue; }

    public Object getCustomState() { return customState; }
    public void setCustomState(Object customState) { this.customState = customState; }

    public int getSeverity() { return severity; }
    public void setSeverity(int severity) { this.severity = severity; }

    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ValidationFailure{");
        sb.append("propertyName='").append(propertyName).append('\'');
        sb.append(", errorMessage='").append(errorMessage).append('\'');
        sb.append(", attemptedValue=").append(attemptedValue);
        sb.append(", customState=").append(customState);
        sb.append(", severity=").append(severity);
        sb.append(", errorCode='").append(errorCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
