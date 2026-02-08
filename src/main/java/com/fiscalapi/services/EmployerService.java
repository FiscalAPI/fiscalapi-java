package com.fiscalapi.services;

import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.payroll.EmployerData;

public class EmployerService {
    public IFiscalApiHttpClient getHttpClient() {
        return httpClient;
    }

    private IFiscalApiHttpClient httpClient;
    private final String baseEndpoint = "api/v4/people";
    
    public EmployerService(IFiscalApiHttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    public ApiResponse<EmployerData> GetById(String id) {
        String endpoint = String.format("%s/%s/employer", baseEndpoint, id);

        return httpClient.get(endpoint, EmployerData.class);
    }

    public ApiResponse<EmployerData>Create(EmployerData requestModel) {
        String endpoint = String.format("%s/%s/employer", baseEndpoint, requestModel.getPersonId());

        return httpClient.post(endpoint, requestModel, EmployerData.class);
    }

    public ApiResponse<EmployerData> Update(EmployerData requestModel) {
        String endpoint = String.format("%s/%s/employer", baseEndpoint, requestModel.getPersonId());

        return httpClient.put(endpoint, requestModel, EmployerData.class);
    }

    public ApiResponse<Boolean> Delete(String id) {
        String endpoint = String.format("%s/%s/employer", baseEndpoint, id);

        return httpClient.delete(endpoint);
    }
}
