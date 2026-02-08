package com.fiscalapi.services;

import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.payroll.EmployeeData;

public class EmployeeService {
    IFiscalApiHttpClient httpClient;
    private final String baseEndpoint = "api/v4/people";

    public EmployeeService(IFiscalApiHttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    private String buildEndpoint(String personId) {
        return String.format("%s/%s/employee", baseEndpoint, personId);
    }

    public ApiResponse<EmployeeData> GetById(String id) {
        String endpoint = buildEndpoint(id);

        return httpClient.get(endpoint, EmployeeData.class);
    }

    public ApiResponse<EmployeeData>Create(EmployeeData requestModel) {
        String endpoint = buildEndpoint(requestModel.getEmployeePersonId());

        return httpClient.post(endpoint, requestModel, EmployeeData.class);
    }

    public ApiResponse<EmployeeData> Update(EmployeeData requestModel) {
        String endpoint = buildEndpoint(requestModel.getEmployeePersonId());

        return httpClient.put(endpoint, requestModel, EmployeeData.class);
    }

    public ApiResponse<Boolean> Delete(String id) {
        return httpClient.delete(buildEndpoint(id));
    }
}
