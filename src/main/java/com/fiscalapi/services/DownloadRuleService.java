package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IDownloadRuleService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.downloading.DownloadRequest;
import com.fiscalapi.models.downloading.DownloadRule;

/**
 * Servicio para manejar reglas de descarga masiva.
 * Permite crear y gestionar reglas para descarga de CFDI desde el SAT.
 */
public class DownloadRuleService extends BaseFiscalApiService<DownloadRule> implements IDownloadRuleService {

    /**
     * Crea un DownloadRuleService con el path "download-rules" y la versión de API dada.
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public DownloadRuleService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "download-rules", settings.getApiVersion());
    }

    @Override
    protected Class<DownloadRule> getTypeParameterClass() {
        return DownloadRule.class;
    }

    /**
     * Crea una regla de descarga de prueba.
     * POST /api/{apiVersion}/download-rules/test
     * @return ApiResponse con el DownloadRequest creado
     */
    @Override
    public ApiResponse<DownloadRequest> createTestRule() {
        String path = "test";
        String endpoint = buildEndpoint(path, null);
        return httpClient.post(endpoint, null, DownloadRequest.class);
    }
}
