package com.fiscalapi.models;


import com.fiscalapi.common.BaseDto;

public class ApiKey extends BaseDto {

    private String environment;
    private String apiKeyValue;
    private String personId;
    private String tenantId;
    private int apiKeyStatus;
    private String description;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getApiKeyValue() {
        return apiKeyValue;
    }

    public void setApiKeyValue(String apiKeyValue) {
        this.apiKeyValue = apiKeyValue;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public int getApiKeyStatus() {
        return apiKeyStatus;
    }

    public void setApiKeyStatus(int apiKeyStatus) {
        this.apiKeyStatus = apiKeyStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
