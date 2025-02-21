package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class BaseFiscalApiService<T> implements IFiscalApiService<T> {

    protected final IFiscalApiHttpClient httpClient;
    protected final FiscalApiSettings settings;
    protected final String resourcePath;
    protected final String apiVersion;

    protected BaseFiscalApiService(
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
            // ...
        }

        return fullUrl.toString();
    }

    private String encode(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
    }

    @Override
    public CompletableFuture<ApiResponse<PagedList<T>>> getListAsync(int pageNumber, int pageSize) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("PageNumber", String.valueOf(pageNumber));
        queryParams.put("PageSize", String.valueOf(pageSize));

        String endpoint = buildEndpoint("", queryParams);
        return httpClient.getAsync(endpoint,
                (Class<PagedList<T>>)(Class)PagedList.class // cast paramétrico
        );
    }

    @Override
    public CompletableFuture<ApiResponse<T>> getByIdAsync(String id, boolean details) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("details", String.valueOf(details));
        String endpoint = buildEndpoint(id, queryParams);
        return httpClient.getAsync(endpoint, getTypeParameterClass());
    }

    @Override
    public CompletableFuture<ApiResponse<T>> createAsync(T model) {
        String endpoint = buildEndpoint("", null);
        return httpClient.postAsync(endpoint, model, getTypeParameterClass());
    }

    @Override
    public CompletableFuture<ApiResponse<T>> updateAsync(String id, T model) {
        String endpoint = buildEndpoint(id, null);
        return httpClient.putAsync(endpoint, model, getTypeParameterClass());
    }

    @Override
    public CompletableFuture<ApiResponse<Boolean>> deleteAsync(String id) {
        String endpoint = buildEndpoint(id, null);
        return httpClient.deleteAsync(endpoint);
    }

    /**
     * Truco para obtener la clase en tiempo de ejecución.
     *
     * Se puede usar reflection o sobrescribir este método en subclases
     * para devolver el Class<T> correspondiente.
     */
    protected abstract Class<T> getTypeParameterClass();
}
