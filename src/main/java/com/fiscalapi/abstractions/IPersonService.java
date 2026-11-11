package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.PersonListFilters;
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

    /**
     * Lista las personas del tenant con los filtros asignados (null o sin filtros: la lista de siempre, primera
     * página). GET /api/{apiVersion}/people
     *
     * @param filters Filtros de la consulta
     * @return ApiResponse con la página de personas
     */
    ApiResponse<PagedList<Person>> getList(PersonListFilters filters);

    /**
     * Obtiene una persona por su id. GET /api/{apiVersion}/people/{id}
     *
     * @param id      Id de la persona
     * @param details Obsoleto y sin efecto en personas: la API responde la misma persona con cualquier valor. Se
     *                conserva porque viene de {@link IImmutableFiscalApiService#getById}, donde facturas sí lo usa;
     *                pasa false
     * @return ApiResponse con la persona
     */
    @Override
    ApiResponse<Person> getById(String id, boolean details);

    /** Lista los certificados (CSD y FIEL) de una persona, solo metadatos, sin el archivo ni la contraseña. */
    ApiResponse<List<TaxFile>> getTaxFiles(String personId);
}