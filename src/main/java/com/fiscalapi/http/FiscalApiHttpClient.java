package com.fiscalapi.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.common.ValidationFailure;
import okhttp3.*;
import okio.Buffer;
import java.io.IOException;
import java.util.List;

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
        return execute(buildGet(url), simpleType(responseType));
    }

    @Override
    public <T> ApiResponse<T> post(String url, Object body, Class<T> responseType) {
        return execute(buildPost(url, body), simpleType(responseType));
    }

    @Override
    public <T> ApiResponse<T> put(String url, Object body, Class<T> responseType) {
        Request request = new Request.Builder()
                .url(url)
                .put(createRequestBody(body))
                .build();
        return execute(request, simpleType(responseType));
    }

    @Override
    public ApiResponse<Boolean> delete(String url) {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        return execute(request, simpleType(Boolean.class));
    }

    @Override
    public <T> ApiResponse<T> delete(String url, Object body, Class<T> responseType) {
        Request request = new Request.Builder()
                .url(url)
                .delete(createRequestBody(body))
                .build();
        return execute(request, simpleType(responseType));
    }

    @Override
    public <T> ApiResponse<List<T>> getList(String url, Class<T> elementType) {
        return execute(buildGet(url), listType(elementType));
    }

    @Override
    public <T> ApiResponse<List<T>> postList(String url, Object body, Class<T> elementType) {
        return execute(buildPost(url, body), listType(elementType));
    }

    @Override
    public <T> ApiResponse<PagedList<T>> getPagedList(String url, Class<T> itemType) {
        return execute(buildGet(url), pagedListType(itemType));
    }

    private Request buildGet(String url) {
        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }

    private Request buildPost(String url, Object body) {
        return new Request.Builder()
                .url(url)
                .post(createRequestBody(body))
                .build();
    }

    // La forma esperada de 'data' viaja como JavaType: objeto suelto, arreglo o pagina.
    // Jackson la necesita explicita porque el borrado de tipos de Java pierde el parametro generico.
    private JavaType simpleType(Class<?> responseType) {
        return objectMapper.getTypeFactory().constructType(responseType);
    }

    private JavaType listType(Class<?> elementType) {
        return objectMapper.getTypeFactory().constructCollectionType(List.class, elementType);
    }

    private JavaType pagedListType(Class<?> itemType) {
        return objectMapper.getTypeFactory().constructParametricType(PagedList.class, itemType);
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
    private <T> ApiResponse<T> execute(Request request, JavaType responseType) {
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
    private <T> ApiResponse<T> parseApiResponse(String responseString, int statusCode, JavaType responseType) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setHttpStatusCode(statusCode);

        try {
            JsonNode root = objectMapper.readTree(responseString);

            // Asigna el flag 'succeeded'
            boolean succeeded = root.has("succeeded") ? root.get("succeeded").asBoolean() : (statusCode >= 200 && statusCode < 300);
            apiResponse.setSucceeded(succeeded);

            // Asigna el 'message'
            apiResponse.setMessage(root.has("message") ? root.get("message").asText() : "");

            // El identificador de rastreo solo viaja en las respuestas de error, que es donde se necesita,
            // por eso se lee antes de la rama que atiende el HTTP 400.
            if (root.has("traceIdentifier") && !root.get("traceIdentifier").isNull()) {
                apiResponse.setTraceIdentifier(root.get("traceIdentifier").asText());
            }

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

    // Deserializa la propiedad 'data' con la forma que espera quien hizo la llamada
    private <T> T deserializeData(JsonNode dataNode, JavaType responseType) {
        // Si 'data' es un arreglo y se espera un objeto único (no una colección)
        if (dataNode.isArray() && !responseType.isCollectionLikeType()) {
            return (!dataNode.isEmpty()) ? objectMapper.convertValue(dataNode.get(0), responseType) : null;
        }
        return objectMapper.convertValue(dataNode, responseType);
    }
}
