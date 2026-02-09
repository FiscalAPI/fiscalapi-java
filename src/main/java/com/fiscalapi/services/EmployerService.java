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
    private final String baseEndpoint = "api/v4/people";
    
    public EmployerService(IFiscalApiHttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    private String buildEndpoint(String personId) {
        return String.format("%s/%s/employer", baseEndpoint, personId);
    }

    public ApiResponse<EmployerData> getById(String id) {
        return httpClient.get(buildEndpoint(id), EmployerData.class);
    }

    public ApiResponse<EmployerData> create(EmployerData requestModel) {
        return httpClient.post(buildEndpoint(requestModel.getPersonId()), requestModel, EmployerData.class);
    }

    public ApiResponse<EmployerData> update(EmployerData requestModel) {
        return httpClient.put(buildEndpoint(requestModel.getPersonId()), requestModel, EmployerData.class);
    }

    public ApiResponse<Boolean> delete(String id) {
        return httpClient.delete(buildEndpoint(id));
    }
}
