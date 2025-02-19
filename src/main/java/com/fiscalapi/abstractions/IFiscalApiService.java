package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;

import java.util.concurrent.CompletableFuture;

public interface IFiscalApiService<T> {
    CompletableFuture<ApiResponse<PagedList<T>>> getListAsync(int pageNumber, int pageSize);
    CompletableFuture<ApiResponse<T>> getByIdAsync(String id, boolean details);
    CompletableFuture<ApiResponse<T>> createAsync(T model);
    CompletableFuture<ApiResponse<T>> updateAsync(String id, T model);
    CompletableFuture<ApiResponse<Boolean>> deleteAsync(String id);
}
