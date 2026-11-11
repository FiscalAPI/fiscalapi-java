package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IProductService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.Product;
import com.fiscalapi.models.ProductListFilters;

public class ProductService extends BaseFiscalApiService<Product> implements IProductService {

    public ProductService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "products", settings.getApiVersion());
    }

    @Override
    protected Class<Product> getTypeParameterClass() {
        return Product.class;
    }

    @Override
    public ApiResponse<PagedList<Product>> getList(ProductListFilters filters) {
        return httpClient.getPagedList(toQuery(filters).appendTo(buildEndpoint("", null)), Product.class);
    }

    @Override
    public ApiResponse<Integer> getProductStock(String productId) {
        // Ejemplo: GET -> "api/v4/products/{productId}/stock"
        String endpoint = buildEndpoint(productId + "/stock", null);
        return httpClient.get(endpoint, Integer.class);
    }

    // Los filtros asignados; los null no se envían.
    private static ListQuery toQuery(ProductListFilters filters) {
        ListQuery query = new ListQuery();
        if (filters == null) {
            return query;
        }
        return query
                .add("search", filters.getSearch())
                .add("pageNumber", filters.getPageNumber())
                .add("pageSize", filters.getPageSize());
    }
}