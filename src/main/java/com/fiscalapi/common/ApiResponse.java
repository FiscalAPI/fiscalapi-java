package com.fiscalapi.common;

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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiResponse{");
        sb.append("data=").append(data);
        sb.append(", succeeded=").append(succeeded);
        sb.append(", message='").append(message).append('\'');
        sb.append(", details='").append(details).append('\'');
        sb.append(", httpStatusCode=").append(httpStatusCode);
        sb.append('}');
        return sb.toString();
    }
}
