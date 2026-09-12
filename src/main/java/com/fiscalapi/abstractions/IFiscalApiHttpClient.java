package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;

import java.util.List;

public interface IFiscalApiHttpClient {
    <T> ApiResponse<T> get(String url, Class<T> responseType);
    <T> ApiResponse<T> post(String url, Object body, Class<T> responseType);
    <T> ApiResponse<T> put(String url, Object body, Class<T> responseType);
    <T> ApiResponse<T> delete(String url, Object body, Class<T> responseType);
    ApiResponse<Boolean> delete(String url);

    /**
     * GET cuya propiedad data es un arreglo JSON.
     *
     * @param url URL absoluta de la peticion
     * @param elementType Clase de cada elemento del arreglo
     * @param <T> Tipo de los elementos
     * @return ApiResponse con la lista deserializada con el tipo de elemento indicado
     */
    <T> ApiResponse<List<T>> getList(String url, Class<T> elementType);

    /**
     * POST cuya propiedad data es un arreglo JSON.
     *
     * @param url URL absoluta de la peticion
     * @param body Cuerpo de la peticion
     * @param elementType Clase de cada elemento del arreglo
     * @param <T> Tipo de los elementos
     * @return ApiResponse con la lista deserializada con el tipo de elemento indicado
     */
    <T> ApiResponse<List<T>> postList(String url, Object body, Class<T> elementType);

    /**
     * GET cuya propiedad data es una pagina de resultados.
     *
     * @param url URL absoluta de la peticion
     * @param itemType Clase de cada elemento de la pagina
     * @param <T> Tipo de los elementos
     * @return ApiResponse con la pagina cuyos items llevan el tipo indicado
     */
    <T> ApiResponse<PagedList<T>> getPagedList(String url, Class<T> itemType);
}
