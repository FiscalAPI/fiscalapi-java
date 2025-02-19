package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;

import java.util.concurrent.CompletableFuture;

public interface IFiscalApiHttpClient {
    <T> CompletableFuture<ApiResponse<T>> getAsync(String url, Class<T> responseType);
    <T> CompletableFuture<ApiResponse<T>> postAsync(String url, Object body, Class<T> responseType);
    <T> CompletableFuture<ApiResponse<T>> putAsync(String url, Object body, Class<T> responseType);
    CompletableFuture<ApiResponse<Boolean>> deleteAsync(String url);
}