package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.TaxFile;

import java.util.List;

/**
 * Define el contrato específico para operaciones con "Person".
 * Hereda las operaciones básicas (CRUD) de IFiscalApiService&lt;Person&gt;.
 */
public interface IPersonService extends IFiscalApiService<Person> {
    IEmployerService employerService = null;
    IEmployeeService employeeService = null;

    IEmployeeService getEmployeeService();
    IEmployerService getEmployerService();

    /** Lista los certificados (CSD y FIEL) de una persona, solo metadatos, sin el archivo ni la contraseña. */
    ApiResponse<List<TaxFile>> getTaxFiles(String personId);
}