package com.fiscalapi.common;
import java.util.Map;

public class ValidationFailure  extends SerializableDto {
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

    /**
     * Valor recibido en la propiedad que falló. El de un secreto (contraseñas, códigos, tokens, archivos y contraseñas de
     * CSD/FIEL) llega enmascarado como "[masked: n]" (n es su longitud), o "[masked]" si la falla es de un objeto o una
     * lista que lo contiene. El placeholder PropertyValue de formattedMessagePlaceholderValues sigue la misma regla.
     *
     * @return El valor recibido o su máscara
     */
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
