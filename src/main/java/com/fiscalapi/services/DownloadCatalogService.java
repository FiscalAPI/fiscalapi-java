package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IDownloadCatalogService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;

import java.util.List;

/**
 * Servicio para manejar catálogos de descarga masiva.
 * Permite obtener información sobre los catálogos disponibles para descarga masiva.
 */
public class DownloadCatalogService extends BaseFiscalApiService<CatalogDto> implements IDownloadCatalogService {

    /**
     * Crea un DownloadCatalogService con el path "download-catalogs" y la versión de API dada.
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public DownloadCatalogService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "download-catalogs", settings.getApiVersion());
    }

    // Métodos heredados de IFiscalApiService<T> que no se implementan en este servicio.

    /**
     * No se implementa la paginación.
     */
    @Override
    public ApiResponse<PagedList<CatalogDto>> getList(int pageNumber, int pageSize) {
        throw new UnsupportedOperationException("No implementado. Utiliza getList() y listCatalog() en su lugar.");
    }

    /**
     * No se implementa la obtención por ID.
     */
    @Override
    public ApiResponse<CatalogDto> getById(String id, boolean details) {
        throw new UnsupportedOperationException("No implementado. Utiliza getList() y listCatalog() en su lugar.");
    }

    /**
     * No se implementa la creación.
     */
    @Override
    public ApiResponse<CatalogDto> create(CatalogDto model) {
        throw new UnsupportedOperationException("No implementado. Utiliza getList() y listCatalog() en su lugar.");
    }

    /**
     * No se implementa la actualización.
     */
    @Override
    public ApiResponse<CatalogDto> update(CatalogDto model) {
        throw new UnsupportedOperationException("No implementado. Utiliza getList() y listCatalog() en su lugar.");
    }

    /**
     * No se implementa la eliminación.
     */
    @Override
    public ApiResponse<Boolean> delete(String id) {
        throw new UnsupportedOperationException("No implementado. Utiliza getList() y listCatalog() en su lugar.");
    }

    @Override
    protected Class<CatalogDto> getTypeParameterClass() {
        return CatalogDto.class;
    }

    /**
     * Debido al type erasure, se utiliza este método para retornar la clase base de List.
     * @return La clase de List&lt; String&gt; para manejar la deserialización
     */
    @SuppressWarnings("unchecked")
    protected Class<List<String>> getStringListTypeParameterClass() {
        return (Class<List<String>>) (Class) List.class;
    }

    /**
     * Debido al type erasure, se utiliza este método para retornar la clase base de List.
     * @return La clase de List&lt; CatalogDto&gt; para manejar la deserialización
     */
    @SuppressWarnings("unchecked")
    protected Class<List<CatalogDto>> getCatalogDtoListTypeParameterClass() {
        return (Class<List<CatalogDto>>) (Class) List.class;
    }

    /**
     * Recupera todos los nombres de los catálogos de descarga masiva disponibles para listarlos por nombre.
     * GET /api/{apiVersion}/download-catalogs
     */
    @Override
    public ApiResponse<List<String>> getList() {
        String endpoint = buildEndpoint("", null);
        return httpClient.get(endpoint, getStringListTypeParameterClass());
    }

    /**
     * Lista todos los registros de un catálogo pasando el nombre del catálogo.
     * GET /api/{apiVersion}/download-catalogs/{catalogName}/
     * @param catalogName Nombre del catálogo
     * @return Lista de CatalogDto
     */
    @Override
    public ApiResponse<List<CatalogDto>> listCatalog(String catalogName) {
        // api/v4/download-catalogs/<catalogName>/
        String path = catalogName + "/";
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, getCatalogDtoListTypeParameterClass());
    }
}