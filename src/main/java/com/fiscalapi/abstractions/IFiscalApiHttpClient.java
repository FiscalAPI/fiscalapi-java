package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;

import java.util.concurrent.CompletableFuture;

public interface IFiscalApiHttpClient {
    <T> ApiResponse<T> get(String url, Class<T> responseType);
    <T> ApiResponse<T> post(String url, Object body, Class<T> responseType);
    <T> ApiResponse<T> put(String url, Object body, Class<T> responseType);
    <T> ApiResponse<T> delete(String url, Object body, Class<T> responseType);
    ApiResponse<Boolean> delete(String url);

}