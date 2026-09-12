package com.fiscalapi.common;

public class ApiResponse<T> extends  SerializableDto {
    private T data;
    private boolean succeeded;
    private String message;
    private String details;
    private int httpStatusCode;
    private String traceIdentifier;

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

    /**
     * Identificador de rastreo de la petición. Solo viene en las respuestas de error y es el
     * dato que soporte necesita para localizar la falla. En las validaciones SAT es además el
     * referenceId del consumo de créditos registrado en el ledger de timbres.
     *
     * @return El identificador de rastreo, o null cuando la respuesta no lo trae
     */
    public String getTraceIdentifier() { return traceIdentifier; }
    public void setTraceIdentifier(String traceIdentifier) { this.traceIdentifier = traceIdentifier; }

}
