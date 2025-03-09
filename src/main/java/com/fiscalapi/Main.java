package com.fiscalapi;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.ApiKey;
import com.fiscalapi.models.Product;
import com.fiscalapi.models.ProductTax;
import com.fiscalapi.services.FiscalApiClient;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Product: %s\n", "Hello Fiscalapi!");

        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(false);
        settings.setApiUrl("https://localhost:7173");
        settings.setApiKey("sk_development_e0e47dfa_5146_40c2_b3a3_3055909a6b88");
        settings.setTenant("e839651d-1765-4cd0-ba7f-547a4c20580f");
        FiscalApiClient client = FiscalApiClient.create(settings);

        //region Personas (emisores/clientes/empresas, receptores/clientes/empresas, usuarios)

        //endregion




        //region Api-Keys

//        // ***Crear api-key***//
//        ApiKey apiKey = new ApiKey();
//        apiKey.setPersonId("3a12e4b6-642b-4a6b-ba73-c814e4c2c873");
//        apiKey.setDescription("api-key para cliente abc...");
//        ApiResponse<ApiKey> apiResponse = client.getApiKeyService().create(apiKey);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Actualizar/revokar api-key***//
//        ApiKey apiKey = new ApiKey();
//        apiKey.setId("1fe0fcdc-6634-4a74-86df-2e5e134bff9f");
//        apiKey.setDescription("api-key para cliente xwz...");
//        apiKey.setApiKeyStatus(1); // 0=inactiva | 1=activa
//        ApiResponse<ApiKey> apiResponse = client.getApiKeyService().update(apiKey);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Eliminar api-key***//
//        ApiResponse<Boolean> apiResponse = client.getApiKeyService().delete("1fe0fcdc-6634-4a74-86df-2e5e134bff9f");
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Obtener api-key por id***//
//        ApiResponse<ApiKey> apiResponse = client.getApiKeyService().getById("1fe0fcdc-6634-4a74-86df-2e5e134bff9f",false);
//        System.out.printf("apiResponse: %s\n", apiResponse);

//        // ***Listar api-keys***//
//        ApiResponse<PagedList<ApiKey>> apiResponse = client.getApiKeyService().getList(1,2);
//        System.out.printf("apiResponse: %s\n", apiResponse);



        //endregion

        //region Productos

//        // ***Crear producto***//
//        Product product = new Product();
//        product.setDescription("Libro de Java sin impuestos");
//        product.setUnitPrice(100.75986);
//        ApiResponse<Product> apiResponse = client.getProductService().create(product);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//         // ***Actualizar producto***//
//        Product product = new Product();
//        product.setId("f846e552-fcd1-489a-9674-cbae18116bdc");
//        product.setDescription("Libro de Java con Impuestos");
//        product.setUnitPrice(150.75);
//        product.setSatUnitMeasurementId("H87"); // Pieza
//        product.setSatProductCodeId("81111602"); // libros
//        product.setSatTaxObjectId("02"); // Si objeto de impuesto
//
//        // Impuestos del producto
//        List<ProductTax> taxes = new ArrayList<>();
//
//        ProductTax iva16 = new ProductTax();
//        iva16.setTaxId("002"); // IVA
//        iva16.setRate(0.160000); // 16%
//        iva16.setTaxTypeId("Tasa"); //Tasa
//        iva16.setTaxFlagId("T"); // Traslado
//
//        ProductTax iva1067 = new ProductTax(); // Retención 2/3 partes iva
//        iva1067.setTaxId("002");
//        iva1067.setRate(0.010667);
//        iva1067.setTaxTypeId("Tasa");
//        iva1067.setTaxFlagId("T");
//
//        taxes.add(iva16);
//        taxes.add(iva1067);
//
//        product.setProductTaxes(taxes); // actualizar impuestos del producto
//
//        ApiResponse<Product> apiResponse = client.getProductService().update(product);
//        System.out.printf("apiResponse: %s\n", apiResponse);



//        // ***Obtener producto por id***//
//        ApiResponse<Product> apiResponse = client.getProductService().getById("114a4be5-fb65-40b2-a762-ff0c55c6ebfa", false);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Listar productos***//
//        ApiResponse<PagedList<Product>> apiResponse = client.getProductService().getList(1,2);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Eliminar producto por Id***//
//        ApiResponse<Boolean> apiResponse = client.getProductService().delete("c29b091c-8b26-4bf5-8d34-436d0acefe4e");
//        System.out.printf("apiResponse: %s\n", apiResponse);

        //endregion

        System.out.printf("Product: %s\n", "End Fiscalapi!");
    }
}