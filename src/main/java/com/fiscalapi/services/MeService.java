package com.fiscalapi.services;

import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IMeService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.MeInfo;

/**
 * Implementa la consulta de la persona de la credencial sobre "me".
 *
 * <p>"me" no es un recurso CRUD, por lo que este servicio implementa su interfaz directamente, igual que
 * {@code ManifestService}.</p>
 */
public class MeService implements IMeService {

    private final IFiscalApiHttpClient httpClient;
    private final FiscalApiSettings settings;
    private final String apiVersion;
    private final String resourcePath = "me";

    /**
     * Crea un MeService con el path "me" y la versión de API dada.
     *
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public MeService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        this.httpClient = httpClient;
        this.settings = settings;
        this.apiVersion = settings.getApiVersion();
    }

    @Override
    public ApiResponse<MeInfo> get() {
        return httpClient.get(buildEndpoint(), MeInfo.class);
    }

    private String buildEndpoint() {
        String baseUrl = settings.getApiUrl();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        return baseUrl + "/api/" + apiVersion + "/" + resourcePath;
    }
}
