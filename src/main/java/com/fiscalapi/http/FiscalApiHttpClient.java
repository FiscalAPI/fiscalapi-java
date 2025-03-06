package com.fiscalapi.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class FiscalApiHttpClient implements IFiscalApiHttpClient {

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;
    private final FiscalApiSettings settings;

    public FiscalApiHttpClient(OkHttpClient okHttpClient, FiscalApiSettings settings) {
        this.okHttpClient = okHttpClient;
        this.objectMapper = new ObjectMapper();
        this.settings = settings;
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

    private <T> CompletableFuture<ApiResponse<T>> executeAsync(Request request, Class<T> responseType) {
        CompletableFuture<ApiResponse<T>> future = new CompletableFuture<>();

        // Imprime el raw request (incluyendo el body) en formato JSON indentado si el modo debug está activado
        if (settings.getDebugMode()) {
            System.out.println("Raw Request:");
            System.out.println("Method: " + request.method());
            System.out.println("URL: " + request.url());
            if (request.body() != null) {
                try {
                    okio.Buffer buffer = new okio.Buffer();
                    request.body().writeTo(buffer);
                    String bodyString = buffer.readUtf8();
                    // Se intenta parsear el body como JSON para formatearlo de forma indentada
                    try {
                        Object json = objectMapper.readValue(bodyString, Object.class);
                        String prettyBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
                        System.out.println("Body: " + prettyBody);
                    } catch (Exception ex) {
                        // Si falla el parseo, se imprime el body original
                        System.out.println("Body: " + bodyString);
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el request body: " + e.getMessage());
                }
            }
        }

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                try (ResponseBody responseBody = response.body()) {
                    String responseString = responseBody != null ? responseBody.string() : "";

                    // Imprime el raw response en formato JSON indentado si el modo debug está activado
                    if (settings.getDebugMode()) {
                        System.out.println("Raw Response:");
                        try {
                            Object json = objectMapper.readValue(responseString, Object.class);
                            String prettyResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
                            System.out.println(prettyResponse);
                        } catch (Exception ex) {
                            // Si no se puede parsear a JSON, se imprime el response original
                            System.out.println(responseString);
                        }
                    }

                    ApiResponse<T> apiResponse = new ApiResponse<>();
                    apiResponse.setHttpStatusCode(response.code());

                    JsonNode root = objectMapper.readTree(responseString);

                    if (root.has("data") && !root.get("data").isNull()) {
                        T data = objectMapper.convertValue(root.get("data"), responseType);
                        apiResponse.setData(data);
                    } else {
                        apiResponse.setData(null);
                    }

                    if (root.has("succeeded")) {
                        apiResponse.setSucceeded(root.get("succeeded").asBoolean());
                    } else {
                        apiResponse.setSucceeded(response.isSuccessful());
                    }

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

                    future.complete(apiResponse);
                } catch (Exception ex) {
                    future.completeExceptionally(ex);
                }
            }
        });

        return future;
    }


}
