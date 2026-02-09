package com.fiscalapi.abstractions;

import com.fiscalapi.models.Person;

/**
 * Define el contrato específico para operaciones con "Person".
 * Hereda las operaciones básicas (CRUD) de IFiscalApiService&lt;Person&gt;.
 */
public interface IPersonService extends IFiscalApiService<Person> {
    IEmployerService employerService = null;
    IEmployeeService employeeService = null;

    IEmployeeService getEmployeeService();
    IEmployerService getEmployerService();
}