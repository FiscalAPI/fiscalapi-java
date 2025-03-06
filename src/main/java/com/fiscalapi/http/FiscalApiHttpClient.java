package com.fiscalapi.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.ValidationFailure;
import okhttp3.*;

import java.io.IOException;
import java.util.Collection;

public class FiscalApiHttpClient implements IFiscalApiHttpClient {

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;
    private final FiscalApiSettings settings;

    public FiscalApiHttpClient(OkHttpClient okHttpClient, FiscalApiSettings settings) {
        this.okHttpClient = okHttpClient;
        this.objectMapper = new ObjectMapper();
        this.settings = settings;
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
    }

    @Override
    public <T> ApiResponse<T> get(String url, Class<T> responseType) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        return execute(request, responseType);
    }

    @Override
    public <T> ApiResponse<T> post(String url, Object body, Class<T> responseType) {
        RequestBody requestBody = createRequestBody(body);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return execute(request, responseType);
    }

    @Override
    public <T> ApiResponse<T> put(String url, Object body, Class<T> responseType) {
        RequestBody requestBody = createRequestBody(body);
        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .build();
        return execute(request, responseType);
    }

    @Override
    public ApiResponse<Boolean> delete(String url) {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        return execute(request, Boolean.class);
    }

    private RequestBody createRequestBody(Object body) {
        try {
            String json = objectMapper.writeValueAsString(body);
            return RequestBody.create(json, MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException("Error serializing request body", e);
        }
    }

    private <T> ApiResponse<T> execute(Request request, Class<T> responseType) {
        if (settings.getDebugMode()) {
            System.out.println("Raw Request:");
            System.out.println("Method: " + request.method());
            System.out.println("URL: " + request.url());
            if (request.body() != null) {
                try {
                    okio.Buffer buffer = new okio.Buffer();
                    request.body().writeTo(buffer);
                    String bodyString = buffer.readUtf8();
                    try {
                        Object json = objectMapper.readValue(bodyString, Object.class);
                        String prettyBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
                        System.out.println("Body: " + prettyBody);
                    } catch (Exception ex) {
                        System.out.println("Body: " + bodyString);
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el request body: " + e.getMessage());
                }
            }
        }

        try {
            // Ejecutar la llamada de forma síncrona
            try (Response response = okHttpClient.newCall(request).execute()) {

                try (ResponseBody responseBody = response.body()) {
                    String responseString = responseBody != null ? responseBody.string() : "";

                    if (settings.getDebugMode()) {
                        System.out.println("Raw Response:");
                        try {
                            Object json = objectMapper.readValue(responseString, Object.class);
                            String prettyResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
                            System.out.println(prettyResponse);
                        } catch (Exception ex) {
                            System.out.println(responseString);
                        }
                    }

                    ApiResponse<T> apiResponse = new ApiResponse<>();
                    apiResponse.setHttpStatusCode(response.code());

                    JsonNode root = objectMapper.readTree(responseString);

                    // Establecer valores básicos de la respuesta
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

                    // Manejo especial para HTTP 400: errores de validación
                    if (response.code() == 400) {
                        JsonNode dataNode = root.get("data");
                        if (dataNode != null && dataNode.isArray() && !dataNode.isEmpty()) {
                            // Comprobar si los datos son errores de validación
                            if (dataNode.get(0).has("propertyName")) {
                                try {
                                    // Convertir solo el primer error de validación
                                    ValidationFailure firstFailure = objectMapper.convertValue(
                                            dataNode.get(0), ValidationFailure.class);

                                    // Construir mensaje de error solo con el primer error
                                    String errorDetail = firstFailure.getPropertyName() + ": " +
                                            firstFailure.getErrorMessage();

                                    // Establecer los detalles del error
                                    apiResponse.setDetails(errorDetail);

                                    // No intentar deserializar errores de validación como tipo de respuesta
                                    apiResponse.setData(null);
                                    return apiResponse;
                                } catch (IllegalArgumentException e) {
                                    if (root.has("details")) {
                                        apiResponse.setDetails(root.get("details").asText());
                                    }
                                }
                            }
                        } else if (root.has("details")) {
                            apiResponse.setDetails(root.get("details").asText());
                        }
                    } else {
                        // Procesar los demás códigos de respuesta
                        if (root.has("details")) {
                            apiResponse.setDetails(root.get("details").asText());
                        } else {
                            apiResponse.setDetails("");
                        }
                    }

                    // Procesar la propiedad data para todos los casos excepto errores de validación
                    if (root.has("data") && !root.get("data").isNull()) {
                        JsonNode dataNode = root.get("data");

                        // Verificar si los datos parecen ser errores de validación
                        boolean isValidationError = dataNode.isArray() && dataNode.size() > 0 &&
                                dataNode.get(0).has("propertyName") &&
                                dataNode.get(0).has("errorMessage");

                        if (isValidationError) {
                            // Para errores de validación, ya hemos manejado esto arriba
                            apiResponse.setData(null);
                        } else {
                            try {
                                // Manejo especial para PagedList (comprobar primero)
                                boolean isPagedList = false;
                                if (responseType.getSimpleName().equals("PagedList")) {
                                    isPagedList = true;
                                } else {
                                    // También verificar si es una clase parametrizada (como ApiResponse<PagedList<T>>)
                                    if (responseType.getName().contains("PagedList")) {
                                        isPagedList = true;
                                    }
                                }

                                // Si estamos esperando un PagedList, usamos una técnica alternativa para evitar
                                // el error de propiedades desconocidas
                                if (isPagedList) {
                                    // Configurar el ObjectMapper para ignorar propiedades desconocidas al deserializar
                                    ObjectMapper tempMapper = objectMapper.copy();
                                    tempMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                                    // Usar el mapper temporal para la conversión
                                    T data = tempMapper.convertValue(dataNode, responseType);
                                    apiResponse.setData(data);
                                } else {
                                    // Handle the case where data is an array but we expect a single object
                                    if (dataNode.isArray() && !Collection.class.isAssignableFrom(responseType)) {
                                        // If it's an array with at least one element and we expect a single object,
                                        // take the first element
                                        if (dataNode.size() > 0) {
                                            T data = objectMapper.convertValue(dataNode.get(0), responseType);
                                            apiResponse.setData(data);
                                        } else {
                                            apiResponse.setData(null);
                                        }
                                    } else {
                                        // Normal case - direct conversion
                                        T data = objectMapper.convertValue(dataNode, responseType);
                                        apiResponse.setData(data);
                                    }
                                }
                            } catch (IllegalArgumentException e) {
                                throw new RuntimeException("Error converting response data. Expected type: " +
                                        responseType.getName() + ", actual JSON: " + dataNode.toString(), e);
                            }
                        }
                    } else {
                        apiResponse.setData(null);
                    }

                    return apiResponse;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error durante la ejecución de la petición HTTP", e);
        } catch (Exception ex) {
            throw new RuntimeException("Error durante el procesamiento de la respuesta", ex);
        }
    }
}