package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.Product;

import java.util.concurrent.CompletableFuture;

/**
 * Define el contrato específico para operaciones con "Product".
 * Hereda las operaciones básicas (CRUD) de IFiscalApiService<Product>.
 */
public interface IProductService extends IFiscalApiService<Product> {

    /**
     * Ejemplo: un método adicional para obtener el inventario
     * o información específica de un producto.
     */
    CompletableFuture<ApiResponse<Integer>> getProductStock(String productId);
}
