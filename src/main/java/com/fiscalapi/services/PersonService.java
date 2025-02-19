package com.fiscalapi.services;


import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IPersonService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.Person;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Implementa el servicio de "Person", usando la lógica base de BaseFiscalApiService.
 */
public class PersonService extends BaseFiscalApiService<Person> implements IPersonService {

    /**
     * Crea un PersonService con el path "persons" y la versión de API dada.
     */
    public PersonService(IFiscalApiHttpClient httpClient, String apiVersion) {
        super(httpClient, "persons", apiVersion);
    }

    @Override
    protected Class<Person> getTypeParameterClass() {
        return Person.class;
    }

    @Override
    public CompletableFuture<ApiResponse<Boolean>> activatePerson(String personId) {
        // Ejemplo de endpoint -> "api/v4/persons/{personId}/activate"
        String endpoint = buildEndpoint(personId + "/activate", null);
        // Suponiendo que el body es nulo o requiere un body vacío
        return httpClient.postAsync(endpoint, null, Boolean.class);
    }
}
