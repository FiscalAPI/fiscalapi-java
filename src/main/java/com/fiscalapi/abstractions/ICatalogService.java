package com.fiscalapi.abstractions;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.common.PagedList;

import java.util.List;

public interface ICatalogService extends IFiscalApiService<CatalogDto> {

    /**
     * GET /api/{apiVersion}/catalogs
     * Recupera todos los nombres de los catálogos disponibles para búsquedas.
     * @return ApiResponse con una lista de nombres de catálogos (List&lt; String&gt;).
     */
    ApiResponse<List<String>> getList();

    /**
     * GET /api/{apiVersion}/catalogs/{catalogName}/key/{id}
     * Recupera un registro de un catálogo por catalogName e id.
     * @param catalogName Nombre del catálogo.
     * @param id Id del registro.
     * @return ApiResponse con el CatalogDto correspondiente.
     */
    ApiResponse<CatalogDto> getRecordById(String catalogName, String id);

    /**
     * GET /api/{apiVersion}/catalogs/{catalogName}/{searchText}?pageNumber=x&amp;pageSize=y
     * Busca en un catálogo.
     * @param catalogName Nombre del catálogo.
     * @param searchText Criterio de búsqueda (mínimo 4 caracteres).
     * @param pageNumber Número de página.
     * @param pageSize Tamaño de página (entre 1 y 100).
     * @return ApiResponse con un PagedList de CatalogDto.
     */
    ApiResponse<PagedList<CatalogDto>> searchCatalog(String catalogName, String searchText, int pageNumber, int pageSize);
}