package com.fiscalapi.abstractions;

import com.fiscalapi.models.Person;
import com.fiscalapi.services.EmployeeService;
import com.fiscalapi.services.EmployerService;

/**
 * Define el contrato específico para operaciones con "Person".
 * Hereda las operaciones básicas (CRUD) de IFiscalApiService&lt;Person&gt;.
 */
public interface IPersonService extends IFiscalApiService<Person> {
    EmployerService employer = null;

    EmployeeService getEmployeeService();
    EmployerService getEmployerService();
}