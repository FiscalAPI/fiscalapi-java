package com.fiscalapi.services;

import com.fiscalapi.abstractions.IEmployeeService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.payroll.EmployeeData;

public class EmployeeService implements IEmployeeService {
    IFiscalApiHttpClient httpClient;
    private final String baseEndpoint = "api/v4/people";

    public EmployeeService(IFiscalApiHttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    private String buildEndpoint(String personId) {
        return String.format("%s/%s/employee", baseEndpoint, personId);
    }

    public ApiResponse<EmployeeData> getById(String id) {
        String endpoint = buildEndpoint(id);

        return httpClient.get(endpoint, EmployeeData.class);
    }

    public ApiResponse<EmployeeData> create(EmployeeData requestModel) {
        String endpoint = buildEndpoint(requestModel.getEmployeePersonId());

        return httpClient.post(endpoint, requestModel, EmployeeData.class);
    }

    public ApiResponse<EmployeeData> update(EmployeeData requestModel) {
        String endpoint = buildEndpoint(requestModel.getEmployeePersonId());

        return httpClient.put(endpoint, requestModel, EmployeeData.class);
    }

    public ApiResponse<Boolean> delete(String id) {
        return httpClient.delete(buildEndpoint(id));
    }
}
