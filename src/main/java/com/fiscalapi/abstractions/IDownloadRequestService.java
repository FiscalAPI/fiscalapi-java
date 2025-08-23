package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.downloading.DownloadRequest;
import com.fiscalapi.models.downloading.MetadataItem;
import com.fiscalapi.models.downloading.Xml;
import com.fiscalapi.models.invoicing.FileResponse;
import java.time.LocalDate;
import java.util.List;


/**
 * Interfaz para el servicio de solicitudes de descarga.
 */
public interface IDownloadRequestService extends IFiscalApiService<DownloadRequest> {

    /**
     * GET /api/{apiVersion}/download-requests/{requestId}/xmls
     * Lista los XMLs descargados para un requestId.
     * @param requestId ID de la solicitud de descarga
     * @return ApiResponse con una lista paginada de objetos Xml
     */
    ApiResponse<PagedList<Xml>> getXmls(String requestId);

    /**
     * GET /api/{apiVersion}/download-requests/{requestId}/meta-items
     * Lista los meta-items descargados para un requestId.
     * @param requestId ID de la solicitud de descarga
     * @return ApiResponse con una lista paginada de objetos MetadataItem
     */
    ApiResponse<PagedList<MetadataItem>> getMetadataItems(String requestId);

    /**
     * GET /api/{apiVersion}/download-requests/{requestId}/package
     * Descarga la lista de paquetes (archivos .zip) de un requestId.
     * @param requestId ID de la solicitud de descarga
     * @return ApiResponse con una lista de FileResponse
     */
    ApiResponse<List<FileResponse>> downloadPackage(String requestId);

    /**
     * GET /api/{apiVersion}/download-requests/{requestId}/raw-request
     * Descarga el archivo crudo de solicitud SAT para un requestId.
     * @param requestId ID de la solicitud de descarga
     * @return ApiResponse con el objeto FileResponse
     */
    ApiResponse<FileResponse> downloadSatRequest(String requestId);

    /**
     * GET /api/{apiVersion}/download-requests/{requestId}/raw-response
     * Descarga la respuesta SAT para un requestId.
     * @param requestId ID de la solicitud de descarga
     * @return ApiResponse con el objeto FileResponse
     */
    ApiResponse<FileResponse> downloadSatResponse(String requestId);

    /**
     * GET /api/{apiVersion}/download-requests/search?createdAt=yyyy-MM-dd
     * Busca solicitudes de descarga creadas en una fecha específica.
     * @param createdAt Fecha de creación
     * @return ApiResponse con una lista de DownloadRequest
     */
    ApiResponse<List<DownloadRequest>> search(LocalDate createdAt);
}

