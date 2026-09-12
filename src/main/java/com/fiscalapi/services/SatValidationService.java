package com.fiscalapi.services;

import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.ISatValidationService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.satValidations.SatValidationRequest;
import com.fiscalapi.models.satValidations.SatValidationResult;
import com.fiscalapi.models.satValidations.SatValidationType;
import com.fiscalapi.models.satValidations.SatValidationTypeStatus;

import java.util.List;

/**
 * Implementa el servicio de validaciones SAT sobre el recurso "sat-validations".
 *
 * <p>Las reglas de la operación de validar (xml y tin excluyentes, qué tipos admite cada entrada,
 * duplicados y cobro de créditos) las resuelve la API; aquí solo se validan los argumentos nulos
 * o vacíos.</p>
 */
public class SatValidationService implements ISatValidationService {

    private final IFiscalApiHttpClient httpClient;
    private final FiscalApiSettings settings;
    private final String apiVersion;
    private final String resourcePath = "sat-validations";

    /**
     * Crea un SatValidationService con el path "sat-validations" y la versión de API dada.
     *
     * @param httpClient Cliente HTTP utilizado para realizar las peticiones a la API
     * @param settings Configuración con los parámetros de conexión a la API
     */
    public SatValidationService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        this.httpClient = httpClient;
        this.settings = settings;
        this.apiVersion = settings.getApiVersion();
    }

    @Override
    public ApiResponse<List<SatValidationType>> getTypes() {
        return httpClient.getList(buildEndpoint(null), SatValidationType.class);
    }

    @Override
    public ApiResponse<SatValidationType> getTypeById(String id) {
        validateId(id);
        return httpClient.get(buildEndpoint(id), SatValidationType.class);
    }

    @Override
    public ApiResponse<List<SatValidationTypeStatus>> getStatuses(String id) {
        validateId(id);
        return httpClient.getList(buildEndpoint(id + "/statuses"), SatValidationTypeStatus.class);
    }

    @Override
    public ApiResponse<List<SatValidationResult>> validate(SatValidationRequest requestModel) {
        if (requestModel == null) {
            throw new IllegalArgumentException("No se acepta una solicitud de validación nula");
        }

        return httpClient.postList(buildEndpoint(null), requestModel, SatValidationResult.class);
    }

    /**
     * Arma la URL del recurso. El id del tipo lleva puntos y se interpola tal cual: la API lo
     * espera sin codificar y sin recortar.
     */
    private String buildEndpoint(String path) {
        String baseUrl = settings.getApiUrl();
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        StringBuilder fullUrl = new StringBuilder(baseUrl)
                .append("/api/")
                .append(apiVersion)
                .append("/")
                .append(resourcePath);

        if (path != null && !path.isEmpty()) {
            fullUrl.append("/").append(path);
        }

        return fullUrl.toString();
    }

    private void validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Se requiere el id del tipo de validación, por ejemplo sat.cfdi.status");
        }
    }
}
