package com.fiscalapi.http;

import com.fiscalapi.common.FiscalApiSettings;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class OkHttpClientFactory {

    private static final Map<String, OkHttpClient> CLIENT_CACHE = new ConcurrentHashMap<>();

    public static OkHttpClient createClient(FiscalApiSettings settings) {
        // Se utiliza la combinación de parámetros como clave
        String clientKey = String.format("%s:%s:%s",
                settings.getApiKey(),
                settings.getTenant(),
                settings.getApiUrl());

        // Si ya existe un cliente con la misma config, lo retornamos.
        return CLIENT_CACHE.computeIfAbsent(clientKey, key -> buildNewClient(settings));
    }

    private static OkHttpClient buildNewClient(FiscalApiSettings settings) {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    // Interceptor para añadir cabeceras
                    Request original = chain.request();
                    Request.Builder builder = original.newBuilder()
                            .addHeader("X-API-KEY", settings.getApiKey())
                            .addHeader("X-TENANT-KEY", settings.getTenant())
                            .addHeader("X-API-VERSION", settings.getApiVersion())
                            .addHeader("X-TIMEZONE", settings.getTimeZone())
                            .addHeader("Accept", "application/json");

                    return chain.proceed(builder.build());
                })
                .build();
    }
}
