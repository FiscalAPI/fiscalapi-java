package com.fiscalapi.services;

import com.fiscalapi.abstractions.IEmployeeService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.invoicing.payroll.EmployeeData;

public class EmployeeService implements IEmployeeService {
    public IFiscalApiHttpClient getHttpClient() {
        return httpClient;
    }

    private IFiscalApiHttpClient httpClient;
    private String apiVersion;
    private FiscalApiSettings settings;
    private String resourcePath = "employee";
    
    public EmployeeService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings)
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
            throw new IllegalArgumentException("El ID de la persona requerido");
        }
        return httpClient.delete(buildEndpoint(id));
    }

    private void validateRequestModel(EmployeeData requestModel) {
        if (requestModel == null) {
            throw new IllegalArgumentException("El modelo de solicitud no puede ser nulo");
        }

        String personId = requestModel.getEmployeePersonId();
        if (personId == null || personId.trim().isEmpty()) {
            throw new IllegalArgumentException("Se requiere el ID de la persona para crear o actualizar los datos del empleado");
        }
    }
}
