package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;

/**
 * Servicio de un recurso que se consulta, se crea y se elimina, pero no se actualiza (por ejemplo, los certificados).
 * {@link IFiscalApiService} lo extiende con {@code update()}.
 */
public interface IImmutableFiscalApiService<T> {
    ApiResponse<PagedList<T>> getList(int pageNumber, int pageSize);
    ApiResponse<T> getById(String id, boolean details);
    ApiResponse<T> create(T model);
    ApiResponse<Boolean> delete(String id);
}