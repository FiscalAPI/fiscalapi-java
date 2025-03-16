package com.fiscalapi.services;
import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.ICatalogService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogService extends BaseFiscalApiService<CatalogDto> implements ICatalogService {

    /**
     * Crea un CatalogService con el path "catalogs" y la versión de API dada.
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public CatalogService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "catalogs", settings.getApiVersion());
    }

    // Métodos heredados de IFiscalApiService<T> que no se implementan en este servicio.
    @Override
    public ApiResponse<PagedList<CatalogDto>> getList(int pageNumber, int pageSize) {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    public ApiResponse<CatalogDto> getById(String id, boolean details) {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    public ApiResponse<CatalogDto> create(CatalogDto model) {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    public ApiResponse<CatalogDto> update(CatalogDto model) {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    public ApiResponse<Boolean> delete(String id) {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    protected Class<CatalogDto> getTypeParameterClass() {
        return CatalogDto.class;
    }

    /**
     * Debido al type erasure, se utiliza este método para retornar la clase base de List.
     * @return La clase de List&lt;String&gt; para manejar la deserialización
     */
    @SuppressWarnings("unchecked")
    protected Class<List<String>> getStringListTypeParameterClass() {
        return (Class<List<String>>) (Class) List.class;
    }

    /**
     * Recupera todos los nombres de los catálogos disponibles para búsquedas.
     * GET /api/{apiVersion}/catalogs
     */
    @Override
    public ApiResponse<List<String>> getList() {
        String endpoint = buildEndpoint("", null);
        return httpClient.get(endpoint, getStringListTypeParameterClass());
    }

    /**
     * Recupera un registro de un catálogo por catalogName e id.
     * GET /api/{apiVersion}/catalogs/{catalogName}/key/{id}
     */
    @Override
    public ApiResponse<CatalogDto> getRecordById(String catalogName, String id) {
        String path = catalogName + "/key/" + id;
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, CatalogDto.class);
    }

    /**
     * Busca en un catálogo.
     * GET /api/{apiVersion}/catalogs/{catalogName}/{searchText}?pageNumber=x&amp;pageSize=y
     */
    @Override
    public ApiResponse<PagedList<CatalogDto>> searchCatalog(String catalogName, String searchText, int pageNumber, int pageSize) {
        String path = catalogName + "/" + searchText;
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("pageNumber", String.valueOf(pageNumber));
        queryParams.put("pageSize", String.valueOf(pageSize));
        String endpoint = buildEndpoint(path, queryParams);
        return httpClient.get(endpoint, (Class<PagedList<CatalogDto>>)(Class) PagedList.class);
    }
}