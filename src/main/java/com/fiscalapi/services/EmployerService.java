package com.fiscalapi.services;

import com.fiscalapi.abstractions.IEmployerService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.invoicing.payroll.EmployerData;

public class EmployerService implements IEmployerService {
    public IFiscalApiHttpClient getHttpClient() {
        return httpClient;
    }

    private IFiscalApiHttpClient httpClient;
    private String apiVersion;
    private FiscalApiSettings settings;
    private String resourcePath = "employer";
    
    public EmployerService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings)
    {
        this.httpClient = httpClient;
        this.settings = settings;
        this.apiVersion = settings.getApiVersion();
    }

    private String buildEndpoint(String personId) {
        String baseUrl = settings.getApiUrl();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        StringBuilder fullUrl = new StringBuilder(baseUrl)
            .append("/api/")
            .append(apiVersion)
            .append("/")
            .append("people/")
            .append(personId)
            .append("/")
            .append(resourcePath);

        return fullUrl.toString();
    }

    public ApiResponse<EmployerData> getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Person ID is required to build endpoint");
        }
        return httpClient.get(buildEndpoint(id), EmployerData.class);
    }

    public ApiResponse<EmployerData> create(EmployerData requestModel) {
        validateRequestModel(requestModel);
        return httpClient.post(buildEndpoint(requestModel.getPersonId()), requestModel, EmployerData.class);
    }

    public ApiResponse<EmployerData> update(EmployerData requestModel) {
        validateRequestModel(requestModel);
        return httpClient.put(buildEndpoint(requestModel.getPersonId()), requestModel, EmployerData.class);
    }

    public ApiResponse<Boolean> delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Person ID is required to build endpoint");
        }
        return httpClient.delete(buildEndpoint(id));
    }

    private void validateRequestModel(EmployerData requestModel) {
        if (requestModel == null) {
            throw new IllegalArgumentException("Request model cannot be null");
        }

        String personId = requestModel.getPersonId();
        if (personId == null || personId.trim().isEmpty()) {
            throw new IllegalArgumentException("Person ID is required to create or update employer data");
        }
    }
}
