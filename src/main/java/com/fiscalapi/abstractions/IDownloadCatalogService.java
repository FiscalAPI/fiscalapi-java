package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.CatalogDto;

import java.util.List;

/**
 * Interfaz para el servicio de catálogos de descarga masiva.
 */
public interface IDownloadCatalogService extends IFiscalApiService<CatalogDto> {

    /**
     * GET /api/{apiVersion}/download-catalogs
     * Recupera todos los nombres de los catálogos de descarga masiva disponibles para listarlos por nombre.
     * @return ApiResponse con una lista de nombres de catálogos (List&lt; String&gt;).
     */
    ApiResponse<List<String>> getList();

    /**
     * GET /api/{apiVersion}/download-catalogs/{catalogName}/
     * Lista todos los registros de un catálogo pasando el nombre del catálogo.
     * @param catalogName Nombre del catálogo
     * @return ApiResponse con una lista de CatalogDto
     */
    ApiResponse<List<CatalogDto>> listCatalog(String catalogName);
}