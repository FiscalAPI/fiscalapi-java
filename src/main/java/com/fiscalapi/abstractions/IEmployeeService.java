package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.payroll.EmployeeData;

public interface IEmployeeService {
    ApiResponse<EmployeeData> getById(String id);
    ApiResponse<EmployeeData> create(EmployeeData requestModel);
    ApiResponse<EmployeeData> update(EmployeeData requestModel);
    ApiResponse<Boolean> delete(String id);
}
