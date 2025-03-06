package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.Person;

/**
 * Define el contrato específico para operaciones con "Person".
 * Hereda las operaciones básicas (CRUD) de IFiscalApiService<Person>.
 */
public interface IPersonService extends IFiscalApiService<Person> {

    /**
     * Ejemplo de método adicional específico de "Person".
     * Por ejemplo, para activar a una persona.
     */
    ApiResponse<Boolean> activatePerson(String personId);
}