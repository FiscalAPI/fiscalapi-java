package com.fiscalapi.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.ValidationFailure;
import okhttp3.*;
import okio.Buffer;
import java.io.IOException;
import java.util.Collection;

public class FiscalApiHttpClient implements IFiscalApiHttpClient {

    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final FiscalApiSettings settings;

    public FiscalApiHttpClient(OkHttpClient httpClient, FiscalApiSettings settings) {
        this.httpClient = httpClient;
        this.settings = settings;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.objectMapper.enable(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
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

    // Método auxiliar para serializar el body de la solicitud
    private RequestBody createRequestBody(Object body) {
        try {
            String json = objectMapper.writeValueAsString(body);
            return RequestBody.create(json, MediaType.parse("application/json"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializando el cuerpo de la solicitud", e);
        }
    }

    // Método central de ejecución de la petición HTTP
    private <T> ApiResponse<T> execute(Request request, Class<T> responseType) {
        if (settings.getDebugMode()) {
            logRequest(request);
        }
        try (Response response = httpClient.newCall(request).execute()) {
            String responseString = extractResponseString(response);
            if (settings.getDebugMode()) {
                logResponse(responseString);
            }
            return parseApiResponse(responseString, response.code(), responseType);
        } catch (IOException e) {
            throw new RuntimeException("Error durante la ejecución de la petición HTTP", e);
        }
    }

    // Extrae el contenido de la respuesta HTTP
    private String extractResponseString(Response response) throws IOException {
        ResponseBody body = response.body();
        return (body != null) ? body.string() : "";
    }

    // Registra los detalles de la solicitud HTTP
    private void logRequest(Request request) {
        System.out.println("#######################################################################");
        System.out.println("Raw Request: Method: " + request.method() + ", URL: " + request.url());
        if (request.body() != null) {
            try {
                Buffer buffer = new Buffer();
                request.body().writeTo(buffer);
                String bodyString = buffer.readUtf8();
                Object json = objectMapper.readValue(bodyString, Object.class);
                String prettyBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
                System.out.println("Request Body: " + prettyBody);
                System.out.println("#######################################################################");
            } catch (IOException | RuntimeException e) {
                System.out.println("Request Body: Error al leer el request body");
                System.out.println("#######################################################################");
            }
        }
    }

    // Registra la respuesta HTTP recibida
    private void logResponse(String responseString) {
        try {
            Object json = objectMapper.readValue(responseString, Object.class);
            String prettyResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            System.out.println("#######################################################################");
            System.out.println("Raw Response: " + prettyResponse);
            System.out.println("#######################################################################");
        } catch (Exception e) {
            System.out.println("Raw Response: " + responseString);
            System.out.println("#######################################################################");
        }
    }

    // Parsea el JSON de respuesta y construye el ApiResponse<T>
    private <T> ApiResponse<T> parseApiResponse(String responseString, int statusCode, Class<T> responseType) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setHttpStatusCode(statusCode);

        try {
            JsonNode root = objectMapper.readTree(responseString);

            // Asigna el flag 'succeeded'
            boolean succeeded = root.has("succeeded") ? root.get("succeeded").asBoolean() : (statusCode >= 200 && statusCode < 300);
            apiResponse.setSucceeded(succeeded);

            // Asigna el 'message'
            apiResponse.setMessage(root.has("message") ? root.get("message").asText() : "");

            // Manejo especial de errores de validación (HTTP 400)
            if (statusCode == 400) {
                handleValidationErrors(root, apiResponse);
                return apiResponse;
            } else {
                apiResponse.setDetails(root.has("details") ? root.get("details").asText() : "");
            }

            // Procesa la propiedad 'data' en otros casos
            if (root.has("data") && !root.get("data").isNull()) {
                JsonNode dataNode = root.get("data");
                if (isValidationFailureArray(dataNode)) {
                    // En caso de ser un arreglo de errores de validación, se retorna null
                    apiResponse.setData(null);
                } else {
                    T data = deserializeData(dataNode, responseType);
                    apiResponse.setData(data);
                }
            } else {
                apiResponse.setData(null);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error durante el procesamiento de la respuesta", e);
        }
        return apiResponse;
    }

    // Maneja el caso específico de errores de validación (HTTP 400)
    private void handleValidationErrors(JsonNode root, ApiResponse<?> apiResponse) {
        JsonNode dataNode = root.get("data");
        if (dataNode != null && dataNode.isArray() && !dataNode.isEmpty() && dataNode.get(0).has("propertyName")) {
            try {
                ValidationFailure firstFailure = objectMapper.convertValue(dataNode.get(0), ValidationFailure.class);
                String errorDetail = firstFailure.getPropertyName() + ": " + firstFailure.getErrorMessage();
                apiResponse.setDetails(errorDetail);
            } catch (IllegalArgumentException e) {
                if (root.has("details")) {
                    apiResponse.setDetails(root.get("details").asText());
                }
            }
        } else if (root.has("details")) {
            apiResponse.setDetails(root.get("details").asText());
        }
        apiResponse.setData(null);
    }

    // Verifica si el nodo 'data' representa un arreglo de errores de validación
    private boolean isValidationFailureArray(JsonNode dataNode) {
        return dataNode.isArray() && !dataNode.isEmpty() &&
                dataNode.get(0).has("propertyName") && dataNode.get(0).has("errorMessage");
    }

    // Deserializa la propiedad 'data' considerando casos especiales como PagedList y arreglos
    private <T> T deserializeData(JsonNode dataNode, Class<T> responseType) {
        // Manejo especial para PagedList: ignorar propiedades desconocidas
        if (isPagedList(responseType)) {
            ObjectMapper tempMapper = objectMapper.copy();
            tempMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return tempMapper.convertValue(dataNode, responseType);
        }
        // Si 'data' es un arreglo y se espera un objeto único (no una colección)
        if (dataNode.isArray() && !Collection.class.isAssignableFrom(responseType)) {
            return (!dataNode.isEmpty()) ? objectMapper.convertValue(dataNode.get(0), responseType) : null;
        }
        return objectMapper.convertValue(dataNode, responseType);
    }

    // Determina si se espera un objeto de tipo PagedList
    private boolean isPagedList(Class<?> responseType) {
        return "PagedList".equals(responseType.getSimpleName()) || responseType.getName().contains("PagedList");
    }
}
