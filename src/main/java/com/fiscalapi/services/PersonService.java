package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IPersonService;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.Person;

/**
 * Implementa el servicio de "Person", usando la lógica base de BaseFiscalApiService.
 */
public class PersonService extends BaseFiscalApiService<Person> implements IPersonService {

    /**
     * Crea un PersonService con el path "people" y la versión de API dada.
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public PersonService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "people", settings.getApiVersion());
    }

    @Override
    protected Class<Person> getTypeParameterClass() {
        return Person.class;
    }

}