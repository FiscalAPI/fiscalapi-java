package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.downloading.DownloadRequest;
import com.fiscalapi.models.downloading.DownloadRule;

/**
 * Interfaz para el servicio de reglas de descarga.
 */
public interface IDownloadRuleService extends IFiscalApiService<DownloadRule> {

    /**
     * POST /api/{apiVersion}/download-rules/test
     * Crea una regla de descarga de prueba.
     * @return ApiResponse con el DownloadRequest creado
     */
    ApiResponse<DownloadRequest> createTestRule();
}