package com.fiscalapi;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.Product;
import com.fiscalapi.services.FiscalApiClient;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Product: %s\n", "Hello Fiscalapi!");

        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(true);
        settings.setApiUrl("https://localhost:7173");
        settings.setApiKey("sk_development_71a2d1ff_25c6_4063_aee8_a5da7d0b9967");
        settings.setTenant("e839651d-1765-4cd0-ba7f-547a4c20580f");
        FiscalApiClient client = FiscalApiClient.create(settings);


//        //crear un producto
//        Product product = new Product();
//        product.setDescription("Libro de Java");
//        product.setUnitPrice(100.75986);
//
//        ApiResponse<Product> apiResponse = client.getProductService().create(product);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//         //obtener un producto por Id (versión síncrona)
//        ApiResponse<Product> getResponse = client.getProductService().getById("114a4be5-fb65-40b2-a762-ff0c55c6ebfa", false);
//        System.out.printf("apiResponse: %s\n", getResponse);



        // obtener una lista paginada

        ApiResponse<PagedList<Product>> apiResponse = client.getProductService().getList(1,2);
        System.out.printf("apiResponse: %s\n", apiResponse);




        System.out.printf("Product: %s\n", "End Fiscalapi!");
    }
}