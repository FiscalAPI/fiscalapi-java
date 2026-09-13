package com.fiscalapi.services;

import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IManifestService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.invoicing.FileResponse;
import com.fiscalapi.models.manifests.SignManifestRequest;

/**
 * Implementa la firma de carta manifiesto sobre el recurso "manifests".
 *
 * <p>"manifests" no es un recurso CRUD, por lo que este servicio implementa su interfaz
 * directamente en lugar de extender {@code BaseFiscalApiService}, igual que
 * {@code SatValidationService}.</p>
 *
 * <p>La vigencia de la FIEL y la existencia del RFC en el tenant las valida la API; aquí solo
 * se comprueba que la solicitud no sea nula.</p>
 */
public class ManifestService implements IManifestService {

    private final IFiscalApiHttpClient httpClient;
    private final FiscalApiSettings settings;
    private final String apiVersion;
    private final String resourcePath = "manifests";

    /**
     * Crea un ManifestService con el path "manifests" y la versión de API dada.
     *
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public ManifestService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        this.httpClient = httpClient;
        this.settings = settings;
        this.apiVersion = settings.getApiVersion();
    }

    @Override
    public ApiResponse<FileResponse> sign(SignManifestRequest requestModel) {
        if (requestModel == null) {
            throw new IllegalArgumentException("No se acepta una solicitud de firma nula");
        }

        return httpClient.post(buildEndpoint(), requestModel, FileResponse.class);
    }

    private String buildEndpoint() {
        String baseUrl = settings.getApiUrl();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        return baseUrl + "/api/" + apiVersion + "/" + resourcePath;
    }
}
