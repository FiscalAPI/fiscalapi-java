package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.payroll.EmployerData;

public interface IEmployerService {
    ApiResponse<EmployerData> getById(String id);
    ApiResponse<EmployerData> create(EmployerData requestModel);
    ApiResponse<EmployerData> update(EmployerData requestModel);
    ApiResponse<Boolean> delete(String id);
}
