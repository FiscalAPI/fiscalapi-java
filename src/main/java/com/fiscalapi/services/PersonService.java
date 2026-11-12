package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IPersonService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.PersonListFilters;
import com.fiscalapi.models.TaxFile;

import java.util.List;

/**
 * Implementa el servicio de "Person", usando la lógica base de BaseFiscalApiService.
 */
public class PersonService extends BaseFiscalApiService<Person> implements IPersonService {
    private final EmployerService employerService;
    private final EmployeeService employeeService;

    /**
     * Crea un PersonService con el path "people" y la versión de API dada.
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public PersonService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "people", settings.getApiVersion());
        employerService = new EmployerService(httpClient, settings);
        employeeService = new EmployeeService(httpClient, settings);
    }

    @Override
    protected Class<Person> getTypeParameterClass() {
        return Person.class;
    }

    @Override
    public EmployerService getEmployerService() {
        return employerService;
    }

    @Override
    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    @Override
    public ApiResponse<PagedList<Person>> getList(PersonListFilters filters) {
        return httpClient.getPagedList(toQuery(filters).appendTo(buildEndpoint("", null)), Person.class);
    }

    @Override
    public ApiResponse<List<TaxFile>> getTaxFiles(String personId) {
        if (personId == null || personId.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la persona es requerido");
        }
        String endpoint = buildEndpoint(personId + "/tax-files", null);
        return httpClient.getList(endpoint, TaxFile.class);
    }

    // Los filtros asignados; los null no se envían.
    private static ListQuery toQuery(PersonListFilters filters) {
        ListQuery query = new ListQuery();
        if (filters == null) {
            return query;
        }
        return query
                .add("search", filters.getSearch())
                .add("userTypeId", filters.getUserTypeId())
                .add("pageNumber", filters.getPageNumber())
                .add("pageSize", filters.getPageSize());
    }
}

