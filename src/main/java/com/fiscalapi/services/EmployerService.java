package com.fiscalapi.services;

import com.fiscalapi.abstractions.IEmployerService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.payroll.EmployerData;

public class EmployerService implements IEmployerService {
    public IFiscalApiHttpClient getHttpClient() {
        return httpClient;
    }

    private IFiscalApiHttpClient httpClient;
    private String apiVersion;
    
    public EmployerService(IFiscalApiHttpClient httpClient, String apiVersion)
    {
        this.httpClient = httpClient;
        this.apiVersion = apiVersion;
    }

    private String buildEndpoint(String personId) {
        if (personId == null || personId.trim().isEmpty()) {
            throw new IllegalArgumentException("Person ID is required to build endpoint");
        }
        return String.format("api/%s/people/%s/employer", apiVersion, personId);
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
