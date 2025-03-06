package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;

public interface IFiscalApiService<T> {
    ApiResponse<PagedList<T>> getList(int pageNumber, int pageSize);
    ApiResponse<T> getById(String id, boolean details);
    ApiResponse<T> create(T model);
    ApiResponse<T> update(String id, T model);
    ApiResponse<Boolean> delete(String id);
}