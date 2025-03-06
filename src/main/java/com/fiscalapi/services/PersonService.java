package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IPersonService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.Person;

/**
 * Implementa el servicio de "Person", usando la lógica base de BaseFiscalApiService.
 */
public class PersonService extends BaseFiscalApiService<Person> implements IPersonService {

    /**
     * Crea un PersonService con el path "people" y la versión de API dada.
     */
    public PersonService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "people", settings.getApiVersion());
    }

    @Override
    protected Class<Person> getTypeParameterClass() {
        return Person.class;
    }

    @Override
    public ApiResponse<Boolean> activatePerson(String personId) {
        // Ejemplo de endpoint -> "api/v4/persons/{personId}/activate"
        String endpoint = buildEndpoint(personId + "/activate", null);
        // Suponiendo que el body es nulo o requiere un body vacío
        return httpClient.post(endpoint, null, Boolean.class);
    }
}