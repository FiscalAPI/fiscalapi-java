package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IDownloadRequestService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.downloading.DownloadRequest;
import com.fiscalapi.models.downloading.MetadataItem;
import com.fiscalapi.models.downloading.Xml;
import com.fiscalapi.models.invoicing.FileResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Servicio para manejar solicitudes de descarga masiva.
 * Permite obtener información sobre las solicitudes de descarga y sus archivos asociados.
 */
public class DownloadRequestService extends BaseFiscalApiService<DownloadRequest> implements IDownloadRequestService {

    /**
     * Crea un DownloadRequestService con el path "download-requests" y la versión de API dada.
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public DownloadRequestService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "download-requests", settings.getApiVersion());
    }

    @Override
    protected Class<DownloadRequest> getTypeParameterClass() {
        return DownloadRequest.class;
    }

    /**
     * Debido al type erasure, se utiliza este método para retornar la clase base de PagedList.
     * @return La clase de PagedList&lt;Xml&gt; para manejar la deserialización
     */
    @SuppressWarnings("unchecked")
    protected Class<PagedList<Xml>> getXmlPagedListTypeParameterClass() {
        return (Class<PagedList<Xml>>) (Class) PagedList.class;
    }

    /**
     * Debido al type erasure, se utiliza este método para retornar la clase base de PagedList.
     * @return La clase de PagedList&lt; MetadataItem&gt; para manejar la deserialización
     */
    @SuppressWarnings("unchecked")
    protected Class<PagedList<MetadataItem>> getMetadataItemPagedListTypeParameterClass() {
        return (Class<PagedList<MetadataItem>>) (Class) PagedList.class;
    }

    /**
     * Debido al type erasure, se utiliza este método para retornar la clase base de List.
     * @return La clase de List&lt; FileResponse&gt; para manejar la deserialización
     */
    @SuppressWarnings("unchecked")
    protected Class<List<FileResponse>> getFileResponseListTypeParameterClass() {
        return (Class<List<FileResponse>>) (Class) List.class;
    }

    /**
     * Debido al type erasure, se utiliza este método para retornar la clase base de List.
     * @return La clase de List&lt; DownloadRequest&gt; para manejar la deserialización
     */
    @SuppressWarnings("unchecked")
    protected Class<List<DownloadRequest>> getDownloadRequestListTypeParameterClass() {
        return (Class<List<DownloadRequest>>) (Class) List.class;
    }

    /**
     * Lista los XMLs descargados para un requestId.
     * GET /api/{apiVersion}/download-requests/{requestId}/xmls
     * @param requestId ID de la solicitud de descarga
     * @return Lista paginada de objetos Xml
     */
    @Override
    public ApiResponse<PagedList<Xml>> getXmls(String requestId) {
        String path = requestId + "/xmls";
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, getXmlPagedListTypeParameterClass());
    }

    /**
     * Lista los meta-items descargados para un requestId.
     * GET /api/{apiVersion}/download-requests/{requestId}/meta-items
     * @param requestId ID de la solicitud de descarga
     * @return Lista paginada de objetos MetadataItem
     */
    @Override
    public ApiResponse<PagedList<MetadataItem>> getMetadataItems(String requestId) {
        String path = requestId + "/meta-items";
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, getMetadataItemPagedListTypeParameterClass());
    }

    /**
     * Descarga la lista de paquetes (archivos .zip) de un requestId.
     * GET /api/{apiVersion}/download-requests/{requestId}/package
     * @param requestId ID de la solicitud de descarga
     * @return Lista de FileResponse
     */
    @Override
    public ApiResponse<List<FileResponse>> downloadPackage(String requestId) {
        String path = requestId + "/package";
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, getFileResponseListTypeParameterClass());
    }

    /**
     * Descarga el archivo crudo de solicitud SAT para un requestId.
     * GET /api/{apiVersion}/download-requests/{requestId}/raw-request
     * @param requestId ID de la solicitud de descarga
     * @return Objeto FileResponse
     */
    @Override
    public ApiResponse<FileResponse> downloadSatRequest(String requestId) {
        String path = requestId + "/raw-request";
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, FileResponse.class);
    }

    /**
     * Descarga la respuesta SAT para un requestId.
     * GET /api/{apiVersion}/download-requests/{requestId}/raw-response
     * @param requestId ID de la solicitud de descarga
     * @return Objeto FileResponse
     */
    @Override
    public ApiResponse<FileResponse> downloadSatResponse(String requestId) {
        String path = requestId + "/raw-response";
        String endpoint = buildEndpoint(path, null);
        return httpClient.get(endpoint, FileResponse.class);
    }

    /**
     * Busca solicitudes de descarga creadas en una fecha específica.
     * GET /api/{apiVersion}/download-requests/search?createdAt=yyyy-MM-dd
     * @param createdAt Fecha de creación
     * @return Lista de DownloadRequest
     */
    @Override
    public ApiResponse<List<DownloadRequest>> search(LocalDate createdAt) {
        String path = "search";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("createdAt", createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        String endpoint = buildEndpoint(path, queryParams);
        return httpClient.get(endpoint, getDownloadRequestListTypeParameterClass());
    }
}
