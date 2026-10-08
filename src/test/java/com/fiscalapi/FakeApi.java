package com.fiscalapi;

import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.http.FiscalApiHttpClient;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * API simulada: un interceptor de OkHttp responde a cada peticion con el cuerpo configurado, asi
 * que el SDK recorre su camino real (servicio -> FiscalApiHttpClient -> Jackson) sin red.
 */
final class FakeApi {

    static final String BASE_URL = "https://sdk-tests.fiscalapi.invalid";

    private final List<String> requestedUrls = new ArrayList<>();
    private final List<RecordedRequest> requests = new ArrayList<>();
    private final FiscalApiSettings settings = new FiscalApiSettings();
    private final FiscalApiHttpClient httpClient;
    private String body = "";
    private int status = 200;

    FakeApi() {
        settings.setApiUrl(BASE_URL);
        settings.setApiKey("sk_test_sdk");
        settings.setTenant("tenant-sdk");
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    requestedUrls.add(chain.request().url().toString());
                    requests.add(RecordedRequest.of(chain.request()));
                    return new Response.Builder()
                            .request(chain.request())
                            .protocol(Protocol.HTTP_1_1)
                            .code(status)
                            .message(status == 200 ? "OK" : "Error")
                            .body(ResponseBody.create(body, MediaType.get("application/json")))
                            .build();
                })
                .build();
        httpClient = new FiscalApiHttpClient(okHttpClient, settings);
    }

    static String readFixture(String name) {
        try (InputStream stream = FakeApi.class.getResourceAsStream("/fixtures/" + name)) {
            if (stream == null) {
                throw new IllegalArgumentException("No existe la fixture " + name);
            }
            try (Scanner scanner = new Scanner(stream, StandardCharsets.UTF_8.name())) {
                return scanner.useDelimiter("\\A").next();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    void respondWith(String body) {
        respondWith(body, 200);
    }

    void respondWith(String body, int status) {
        this.body = body;
        this.status = status;
    }

    List<String> requestedUrls() {
        return Collections.unmodifiableList(requestedUrls);
    }

    /** Peticiones recibidas: metodo, URL y cuerpo tal como lo serializo el SDK (null si no lleva). */
    List<RecordedRequest> requests() {
        return Collections.unmodifiableList(requests);
    }

    FiscalApiSettings settings() {
        return settings;
    }

    FiscalApiHttpClient httpClient() {
        return httpClient;
    }

    static final class RecordedRequest {
        final String method;
        final String url;
        final String body;

        private RecordedRequest(String method, String url, String body) {
            this.method = method;
            this.url = url;
            this.body = body;
        }

        static RecordedRequest of(Request request) throws IOException {
            RequestBody requestBody = request.body();
            String body = null;
            if (requestBody != null) {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                body = buffer.readUtf8();
            }
            return new RecordedRequest(request.method(), request.url().toString(), body);
        }
    }
}
