package com.fiscalapi.services;


import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IProductService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.Product;

import java.util.concurrent.CompletableFuture;

public class ProductService extends BaseFiscalApiService<Product> implements IProductService {

    public ProductService(IFiscalApiHttpClient httpClient, String apiVersion) {
        super(httpClient, "products", apiVersion);
    }

    @Override
    protected Class<Product> getTypeParameterClass() {
        return Product.class;
    }

    @Override
    public CompletableFuture<ApiResponse<Integer>> getProductStock(String productId) {
        // Ejemplo: GET -> "api/v4/products/{productId}/stock"
        String endpoint = buildEndpoint(productId + "/stock", null);
        return httpClient.getAsync(endpoint, Integer.class);
    }
}
