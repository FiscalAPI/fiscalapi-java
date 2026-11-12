package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.Product;
import com.fiscalapi.models.ProductListFilters;

/**
 * Define el contrato específico para operaciones con "Product".
 * Hereda las operaciones básicas (CRUD) de IFiscalApiService&lt;Product&gt;.
 */
public interface IProductService extends IFiscalApiService<Product> {

    /**
     * Lista los productos del tenant con los filtros asignados (null o sin filtros: la lista de siempre, primera
     * página). GET /api/{apiVersion}/products
     *
     * @param filters Filtros de la consulta
     * @return ApiResponse con la página de productos
     */
    ApiResponse<PagedList<Product>> getList(ProductListFilters filters);

    /**
     * Ejemplo: un método adicional para obtener el inventario
     * o información específica de un producto.
     * @param productId El identificador único del producto
     * @return ApiResponse con el número de unidades en inventario
     */
    ApiResponse<Integer> getProductStock(String productId);
}