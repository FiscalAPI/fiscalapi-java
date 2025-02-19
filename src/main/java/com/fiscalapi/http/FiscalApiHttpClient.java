package com.fiscalapi.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class FiscalApiHttpClient implements IFiscalApiHttpClient {

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    public FiscalApiHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public <T> CompletableFuture<ApiResponse<T>> getAsync(String url, Class<T> responseType) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        return executeAsync(request, responseType);
    }

    @Override
    public <T> CompletableFuture<ApiResponse<T>> postAsync(String url, Object body, Class<T> responseType) {
        RequestBody requestBody = createRequestBody(body);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        return executeAsync(request, responseType);
    }

    @Override
    public <T> CompletableFuture<ApiResponse<T>> putAsync(String url, Object body, Class<T> responseType) {
        RequestBody requestBody = createRequestBody(body);
        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .build();

        return executeAsync(request, responseType);
    }

    @Override
    public CompletableFuture<ApiResponse<Boolean>> deleteAsync(String url) {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        return executeAsync(request, Boolean.class);
    }

    private RequestBody createRequestBody(Object body) {
        try {
            String json = objectMapper.writeValueAsString(body);
            return RequestBody.create(json, MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException("Error serializing request body", e);
        }
    }

    /**
     * Método genérico para ejecutar la petición de manera asíncrona.
     */
    private <T> CompletableFuture<ApiResponse<T>> executeAsync(Request request, Class<T> responseType) {
        CompletableFuture<ApiResponse<T>> future = new CompletableFuture<>();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Manejo de error: completar con excepción
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                ApiResponse<T> apiResponse = new ApiResponse<>();
                try (ResponseBody responseBody = response.body()) {
                    apiResponse.setHttpStatusCode(response.code());
                    // Leemos el response como string
                    String responseString = responseBody != null ? responseBody.string() : "";

                    if (!response.isSuccessful()) {
                        // Llenar mensaje de error
                        apiResponse.setSucceeded(false);
                        apiResponse.setMessage("HTTP Error: " + response.code());
                        apiResponse.setDetails(responseString);
                        future.complete(apiResponse);
                        return;
                    }

                    // Parsear JSON a ApiResponse<T> o T
                    // -- Suponiendo que el servidor retorna un objeto con la estructura ApiResponse<T>:
                    //    Option A: parsear directamente a ApiResponse<T>.
                    // -- O si la API retorna T directamente, se debe armar la ApiResponse manualmente.

                    // Ejemplo: si la API RETORNA un "ApiResponse<T>" en JSON
                    ApiResponse<T> fromServer = objectMapper.readValue(responseString,
                            objectMapper.getTypeFactory()
                                    .constructParametricType(ApiResponse.class, responseType));

                    future.complete(fromServer);

                } catch (Exception ex) {
                    future.completeExceptionally(ex);
                }
            }
        });
        return future;
    }
}
