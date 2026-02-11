package com.fiscalapi.services;

import com.fiscalapi.abstractions.IEmployeeService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.payroll.EmployeeData;

public class EmployeeService implements IEmployeeService {
    public IFiscalApiHttpClient getHttpClient() {
        return httpClient;
    }

    IFiscalApiHttpClient httpClient;
    private String apiVersion;
    
    public EmployeeService(IFiscalApiHttpClient httpClient, String apiVersion)
    {
        this.httpClient = httpClient;
        this.apiVersion = apiVersion;
    }

    private String buildEndpoint(String personId) {
        if (personId == null || personId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee person ID is required to build endpoint");
        }
        return String.format("api/%s/people/%s/employee", apiVersion, personId);
    }

    public ApiResponse<EmployeeData> getById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee person ID is required to build endpoint");
        }
        String endpoint = buildEndpoint(id);

        return httpClient.get(endpoint, EmployeeData.class);
    }

    public ApiResponse<EmployeeData> create(EmployeeData requestModel) {
        validateRequestModel(requestModel);
        String endpoint = buildEndpoint(requestModel.getEmployeePersonId());

        return httpClient.post(endpoint, requestModel, EmployeeData.class);
    }

    public ApiResponse<EmployeeData> update(EmployeeData requestModel) {
        validateRequestModel(requestModel);
        String endpoint = buildEndpoint(requestModel.getEmployeePersonId());

        return httpClient.put(endpoint, requestModel, EmployeeData.class);
    }

    public ApiResponse<Boolean> delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee person ID is required to build endpoint");
        }
        return httpClient.delete(buildEndpoint(id));
    }

    private void validateRequestModel(EmployeeData requestModel) {
        if (requestModel == null) {
            throw new IllegalArgumentException("Request model cannot be null");
        }

        String personId = requestModel.getEmployeePersonId();
        if (personId == null || personId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee person ID is required");
        }
    }
}
