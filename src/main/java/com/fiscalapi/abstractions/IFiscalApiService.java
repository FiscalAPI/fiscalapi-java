package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;

public interface IFiscalApiService<T> extends IImmutableFiscalApiService<T> {
    ApiResponse<T> update(T model);
}