package com.fiscalapi.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
        // Se añade soporte para las fechas/hora de Java 8
        objectMapper.registerModule(new JavaTimeModule());
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
     * Ejecuta la petición de forma asíncrona, asegurando que en TODOS los casos se retorne
     * un CompletableFuture<ApiResponse<T>> con la estructura original de la respuesta del API.
     * Se parsea el JSON de respuesta (independientemente del código HTTP) para extraer
     * los campos originales: data, succeeded, message, details, httpStatusCode y traceIdentifier.
     */
    private <T> CompletableFuture<ApiResponse<T>> executeAsync(Request request, Class<T> responseType) {
        CompletableFuture<ApiResponse<T>> future = new CompletableFuture<>();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                try (ResponseBody responseBody = response.body()) {
                    String responseString = responseBody != null ? responseBody.string() : "";
                    ApiResponse<T> apiResponse = new ApiResponse<>();

                    // Se asigna el código HTTP real
                    apiResponse.setHttpStatusCode(response.code());

                    // Se parsea la respuesta a un árbol JSON
                    JsonNode root = objectMapper.readTree(responseString);

                    // Se extrae el campo "data" convirtiéndolo a T si existe y no es nulo
                    if (root.has("data") && !root.get("data").isNull()) {
                        T data = objectMapper.convertValue(root.get("data"), responseType);
                        apiResponse.setData(data);
                    } else {
                        apiResponse.setData(null);
                    }

                    // Se extrae el campo "succeeded". Si no viene, se asume el valor de response.isSuccessful()
                    if (root.has("succeeded")) {
                        apiResponse.setSucceeded(root.get("succeeded").asBoolean());
                    } else {
                        apiResponse.setSucceeded(response.isSuccessful());
                    }

                    // Se asignan los campos "message" y "details" tal como vienen en la respuesta original
                    if (root.has("message")) {
                        apiResponse.setMessage(root.get("message").asText());
                    } else {
                        apiResponse.setMessage("");
                    }

                    if (root.has("details")) {
                        apiResponse.setDetails(root.get("details").asText());
                    } else {
                        apiResponse.setDetails("");
                    }

                    // Si el API incluye "traceIdentifier" y ApiResponse lo tuviera, se podría asignar aquí

                    future.complete(apiResponse);
                } catch (Exception ex) {
                    future.completeExceptionally(ex);
                }
            }
        });

        return future;
    }
}
