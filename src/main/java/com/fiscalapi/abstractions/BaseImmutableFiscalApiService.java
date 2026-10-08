package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementación base de un servicio cuyo recurso se consulta, se crea y se elimina, pero no se actualiza
 * (por ejemplo, los certificados). {@link BaseFiscalApiService} la extiende con {@code update()}.
 */
public abstract class BaseImmutableFiscalApiService<T extends BaseDto> implements IImmutableFiscalApiService<T> {

    protected final IFiscalApiHttpClient httpClient;
    protected final FiscalApiSettings settings;
    protected final String resourcePath;
    protected final String apiVersion;

    protected BaseImmutableFiscalApiService(
            IFiscalApiHttpClient httpClient,
            FiscalApiSettings settings,
            String resourcePath,
            String apiVersion
    ) {
        this.httpClient = httpClient;
        this.settings = settings;
        this.resourcePath = resourcePath;
        this.apiVersion = apiVersion;
    }


protected String buildEndpoint(String path, Map<String, String> queryParams) {
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

    // Manejo de query params
    if (queryParams != null && !queryParams.isEmpty()) {
        fullUrl.append("?");
        boolean first = true;
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            try {
                if (!first) {
                    fullUrl.append("&");
                }
                fullUrl.append(encode(entry.getKey()))
                        .append("=")
                        .append(encode(entry.getValue()));
                first = false;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Error al codificar parámetros URL", e);
            }
        }
    }

    return fullUrl.toString();
}



    private String encode(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
    }

    @Override
    public ApiResponse<PagedList<T>> getList(int pageNumber, int pageSize) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("PageNumber", String.valueOf(pageNumber));
        queryParams.put("PageSize", String.valueOf(pageSize));

        String endpoint = buildEndpoint("", queryParams);
        return httpClient.getPagedList(endpoint, getTypeParameterClass());
    }

    @Override
    public ApiResponse<T> getById(String id, boolean details) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("details", String.valueOf(details));
        String endpoint = buildEndpoint(id, queryParams);
        return httpClient.get(endpoint, getTypeParameterClass());
    }

    @Override
    public ApiResponse<T> create(T model) {
        String endpoint = buildEndpoint("", null);
        return httpClient.post(endpoint, model, getTypeParameterClass());
    }

    @Override
    public ApiResponse<Boolean> delete(String id) {
        String endpoint = buildEndpoint(id, null);
        return httpClient.delete(endpoint);
    }

    /**
     * Truco para obtener la clase en tiempo de ejecución.
     *
     * Se puede usar reflection o sobrescribir este método en subclases
     * para devolver el Class&lt;T&gt; correspondiente.
     *
     * @return La clase del tipo paramétrico T usado en este servicio
     */
    protected abstract Class<T> getTypeParameterClass();
}