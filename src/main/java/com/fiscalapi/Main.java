package com.fiscalapi;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.CatalogDto;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.*;
import com.fiscalapi.models.invoicing.*;
import com.fiscalapi.services.FiscalApiClient;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.printf("%s\n", "Hello Fiscalapi!");

        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(true);
        settings.setApiUrl("https://localhost:7173");
        settings.setApiKey("sk_development_e0e47dfa_5146_40c2_b3a3_3055909a6b88");
        settings.setTenant("e839651d-1765-4cd0-ba7f-547a4c20580f");
        FiscalApiClient client = FiscalApiClient.create(settings);

        //region Personas (emisores/clientes/empresas, receptores/clientes/empresas, usuarios)

//        // ***Listar personas: pageNumber=1, pageSize=2 ***//
//        ApiResponse<PagedList<Person>> apiResponse = client.getPersonService().getList(1,2);
//        System.out.println(apiResponse);

//        // ***Obtener persona por id ***//
//        ApiResponse<Person> apiResponse = client.getPersonService().getById("3a12e4b6-642b-4a6b-ba73-c814e4c2c873",false);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Crear persona ***//
//
//        Person person = new Person();
//        person.setLegalName("MI EMPRESA");
//        person.setCapitalRegime("S.A De C.V");
//        person.setEmail("john.doe@fiscalapi.com");
//        person.setPassword("Password123!");
//        ApiResponse<Person> apiResponse = client.getPersonService().create(person);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Actualizar persona ***//
//        Person person = new Person();
//        person.setId("ca3df64a-2ecc-47b0-899d-38c29141979e");
//        person.setLegalName("KARLA FUENTE NOLASCO"); // Razón social sin regimen de capital.
//        person.setSatCfdiUseId("G03"); // Gastos en general
//        person.setSatTaxRegimeId("601"); // General de Ley Personas Morales
//        person.setZipCode("01160"); // Código postal de la constancia de situación fiscal.
//        ApiResponse<Person> apiResponse = client.getPersonService().update(person);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Eliminar persona ***//
//        ApiResponse<Boolean> apiResponse = client.getPersonService().delete("ca3df64a-2ecc-47b0-899d-38c29141979e");
//        System.out.println(apiResponse);
        //endregion

        //region Certificados (sellos SAT)

//        // ***Listar certificados (sellos SAT): pageNumber=1, pageSize=2 ***//
//        ApiResponse<PagedList<TaxFile>> apiResponse = client.getTaxFileService().getList(1,2);
//        System.out.println(apiResponse);


//        // ***Obtener certificado por Id (sellos SAT) ***//
//        ApiResponse<TaxFile> apiResponse = client.getTaxFileService().getById("02713656-e27e-4be7-8b4b-c5e8a32794ed",false);
//        System.out.printf("apiResponse: %s\n", apiResponse);



//        // ***Obtener certificados por defecto (sellos SAT) de una persona (default values) ***//
//         ApiResponse<List<TaxFile>> apiResponse = client.getTaxFileService().getDefaultValues("3a12e4b6-642b-4a6b-ba73-c814e4c2c873");
//         System.out.printf("apiResponse: %s\n", apiResponse);

//        // ***Obtener ids de los certificados por defecto (sellos SAT) de una persona (default references) ***//
//         ApiResponse<List<TaxFile>> apiResponse = client.getTaxFileService().getDefaultReferences("3a12e4b6-642b-4a6b-ba73-c814e4c2c873");
//         System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Subir certificados (sellos SAT) de una persona (KARLA FUENTE NOLASCO) se deben enviar dos peticiones, una para cada archivo***//
//
//        //Subir archivo .cer (certificado)
//        TaxFile archivoCer = new TaxFile();
//        archivoCer.setPersonId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
//        archivoCer.setTin("FUNK671228PH6");
//        archivoCer.setBase64File("MIIFgDCCA2igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0NDYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTQzNTM3WhcNMjcwNTE4MTQzNTM3WjCBpzEdMBsGA1UEAxMUS0FSTEEgRlVFTlRFIE5PTEFTQ08xHTAbBgNVBCkTFEtBUkxBIEZVRU5URSBOT0xBU0NPMR0wGwYDVQQKExRLQVJMQSBGVUVOVEUgTk9MQVNDTzEWMBQGA1UELRMNRlVOSzY3MTIyOFBINjEbMBkGA1UEBRMSRlVOSzY3MTIyOE1DTE5MUjA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhNXbTSqGX6+/3Urpemyy5vVG2IdP2v7v001+c4BoMxEDFDQ32cOFdDiRxy0Fq9aR+Ojrofq8VeftvN586iyA1A6a0QnA68i7JnQKI4uJy+u0qiixuHu6u3b3BhSpoaVHcUtqFWLLlzr0yBxfVLOqVna/1/tHbQJg9hx57mp97P0JmXO1WeIqi+Zqob/mVZh2lsPGdJ8iqgjYFaFn9QVOQ1Pq74o1PTqwfzqgJSfV0zOOlESDPWggaDAYE4VNyTBisOUjlNd0x7ppcTxSi3yenrJHqkq/pqJsRLKf6VJ/s9p6bsd2bj07hSDpjlDC2lB25eEfkEkeMkXoE7ErXQ5QCwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAHwYpgbClHULXYhK4GNTgonvXh81oqfXwCSWAyDPiTYFDWVfWM9C4ApxMLyc0XvJte75Rla+bPC08oYN3OlhbbvP3twBL/w9SsfxvkbpFn2ZfGSTXZhyiq4vjmQHW1pnFvGelwgU4v3eeRE/MjoCnE7M/Q5thpuog6WGf7CbKERnWZn8QsUaJsZSEkg6Bv2jm69ye57ab5rrOUaeMlstTfdlaHAEkUgLX/NXq7RbGwv82hkHY5b2vYcXeh34tUMBL6os3OdRlooN9ZQGkVIISvxVZpSHkYC20DFNh1Bb0ovjfujlTcka81GnbUhFGZtRuoVQ1RVpMO8xtx3YKBLp4do3hPmnRCV5hCm43OIjYx9Ov2dqICV3AaNXSLV1dW39Bak/RBiIDGHzOIW2+VMPjvvypBjmPv/tmbqNHWPSAWOxTyMx6E1gFCZvi+5F+BgkdC3Lm7U0BU0NfvsXajZd8sXnIllvEMrikCLoI/yurvexNDcF1RW/FhMsoua0eerwczcNm66pGjHm05p9DR6lFeJZrtqeqZuojdxBWy4vH6ghyJaupergoX+nmdG3JYeRttCFF/ITI68TeCES5V3Y0C3psYAg1XxcGRLGd4chPo/4xwiLkijWtgt0/to5ljGBwfK7r62PHZfL1Dp+i7V3w7hmOlhbXzP+zhMZn1GCk7KY=");
//        archivoCer.setFileType(0); // 0 para certificado
//        archivoCer.setPassword("12345678a");
//
//        ApiResponse<TaxFile> apiResponseCer = client.getTaxFileService().create(archivoCer);
//        System.out.printf("apiResponse: %s\n", apiResponseCer);
//
//
//        //Subir archivo .key (clave privada)
//        TaxFile archivoKey = new TaxFile();
//        archivoKey.setPersonId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
//        archivoKey.setTin("FUNK671228PH6");
//        archivoKey.setBase64File("MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS9AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucRBAKNQXH8t8gVCl/ItHMI2hMJ76QOECOqEi1Y89cDpegDvh/INXyMsXbzi87tfFzgq1O+9ID6aPWGg+bNGADXyXxDVdy7Nq/SCdoXvo66MTYwq8jyJeUHDHEGMVBcmZpD44VJCvLBxDcvByuevP4Wo2NKqJCwK+ecAdZc/8Rvd947SjbMHuS8BppfQWARVUqA5BLOkTAHNv6tEk/hncC7O2YOGSShart8fM8dokgGSyewHVFe08POuQ+WDHeVpvApH/SP29rwktSoiHRoL6dK+F2YeEB5SuFW9LQgYCutjapmUP/9TC3Byro9Li6UrvQHxNmgMFGQJSYjFdqlGjLibfuguLp7pueutbROoZaSxU8HqlfYxLkpJUxUwNI1ja/1t3wcivtWknVXBd13R06iVfU1HGe8Kb4u5il4a4yP4p7VT4RE3b1SBLJeG+BxHiE8gFaaKcX/Cl6JV14RPTvk/6VnAtEQ66qHJex21KKuiJo2JoOmDXVHmvGQlWXNjYgoPx28Xd5WsofL+n7HDR2Ku8XgwJw6IXBJGuoday9qWN9v/k7DGlNGB6Sm4gdVUmycMP6EGhB1vFTiDfOGQO42ywmcpKoMETPVQ5InYKE0xAOckgcminDgxWjtUHjBDPEKifEjYudPwKmR6Cf4ZdGvUWwY/zq9pPAC9bu423KeBCnSL8AQ4r5SVsW6XG0njamwfNjpegwh/YG7sS7sDtZ8gi7r6tZYjsOqZlCYU0j7QTBpuQn81Yof2nQRCFxhRJCeydmIA8+z0nXrcElk7NDPk4kYQS0VitJ2qeQYNENzGBglROkCl2y6GlxAG80IBtReCUp/xOSdlwDR0eim+SNkdStvmQM5IcWBuDKwGZc1A4v/UoLl7niV9fpl4X6bUX8lZzY4gidJOafoJ30VoY/lYGkrkEuz3GpbbT5v8fF3iXVRlEqhlpe8JSGu7Rd2cPcJSkQ1Cuj/QRhHPhFMF2KhTEf95c9ZBKI8H7SvBi7eLXfSW2Y0ve6vXBZKyjK9whgCU9iVOsJjqRXpAccaWOKi420CjmS0+uwj/Xr2wLZhPEjBA/G6Od30+eG9mICmbp/5wAGhK/ZxCT17ZETyFmOMo49jl9pxdKocJNuzMrLpSz7/g5Jwp8+y8Ck5YP7AX0R/dVA0t37DO7nAbQT5XVSYpMVh/yvpYJ9WR+tb8Yg1h2lERLR2fbuhQRcwmisZR2W3Sr2b7hX9MCMkMQw8y2fDJrzLrqKqkHcjvnI/TdzZW2MzeQDoBBb3fmgvjYg07l4kThS73wGX992w2Y+a1A2iirSmrYEm9dSh16JmXa8boGQAONQzQkHh7vpw0IBs9cnvqO1QLB1GtbBztUBXonA4TxMKLYZkVrrd2RhrYWMsDp7MpC4M0p/DA3E/qscYwq1OpwriewNdx6XXqMZbdUNqMP2viBY2VSGmNdHtVfbN/rnaeJetFGX7XgTVYD7wDq8TW9yseCK944jcT+y/o0YiT9j3OLQ2Ts0LDTQskpJSxRmXEQGy3NBDOYFTvRkcGJEQJItuol8NivJN1H9LoLIUAlAHBZxfHpUYx66YnP4PdTdMIWH+nxyekKPFfAT7olQ=");
//        archivoKey.setFileType(1); // 1 para llave privada
//        archivoKey.setPassword("12345678a");
//
//        ApiResponse<TaxFile> apiResponseKey = client.getTaxFileService().create(archivoKey);
//        System.out.printf("apiResponse: %s\n", apiResponseKey);


//        // ***Eliminar certificado o clave privada (Sellos) se deben enviar dos peticiones, una para cada archivo***//
//        ApiResponse<Boolean> apiResponseCer = client.getTaxFileService().delete("1cf1c0e3-af58-47fb-8e51-78afdecf53f2");
//        System.out.println(apiResponseCer);
//
//
//        ApiResponse<Boolean> apiResponseKey = client.getTaxFileService().delete("d3e5e24e-f198-4c95-aebe-4d93aac22b27");
//        System.out.println(apiResponseKey);

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

        //region Catálogos del SAT

//        // ***Obtener catálogos disponibles: https://docs.fiscalapi.com/catalogs#equivalencia-entre-catalogos-del-sat-y-fiscalapi ***//
//        ApiResponse<List<String>> apiResponse = client.getCatalogService().getList();
//        System.out.printf("apiResponse: %s\n", apiResponse);

//        // ***Obtener un registro por Id de un catálogo específico ***//
//        ApiResponse<CatalogDto> apiResponse = client.getCatalogService().getRecordById("SatProductCodes","84111500");
//        System.out.printf("apiResponse: %s\n", apiResponse);


//        // ***Buscar un catálogo específico por criterio de búsqueda ***//

//        //Busca todos los registros que contengan 'Serv' en el catálogo 'SatProductCodes', inicia en la página 1 y con tamaño de página de 10 registros.
//        ApiResponse<PagedList<CatalogDto>> apiResponse = client.getCatalogService().searchCatalog("SatProductCodes", "Serv", 1, 10);
//        System.out.printf("apiResponse: %s\n", apiResponse);


        //endregion

        //region Facturas

//        // ***Obtener una factura por Id***//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().getById("bda0b31d-e1e0-4644-91ea-c6f0e90fb57c",true);
//        System.out.printf("apiResponse: %s\n", apiResponse);

//        // ***Listar facturas***//
//        ApiResponse<PagedList<Invoice>> apiResponse = client.getInvoiceService().getList(1,3);
//        System.out.printf("apiResponse: %s\n", apiResponse);

        // ***Crear factura por valores. Vea: https://docs.fiscalapi.com/modes-of-operation ***//

        /*
        * {
                  "versionCode": "4.0",
                  "series": "F",
                  "date": "2025-02-25T20:28:40",
                  "paymentFormCode": "01",
                  "paymentMethodCode": "PUE",
                  "currencyCode": "MXN",
                  "typeCode": "I",
                  "expeditionZipCode": "42501",
                  "exchangeRate": 1,
                  "exportCode": "01",
                  "issuer": {
                    "tin": "FUNK671228PH6",
                    "legalName": "KARLA FUENTE NOLASCO",
                    "taxRegimeCode": "621",
                    "taxCredentials": [
                      {
                        "base64File": "MIIFgDCCA2igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0NDYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTQzNTM3WhcNMjcwNTE4MTQzNTM3WjCBpzEdMBsGA1UEAxMUS0FSTEEgRlVFTlRFIE5PTEFTQ08xHTAbBgNVBCkTFEtBUkxBIEZVRU5URSBOT0xBU0NPMR0wGwYDVQQKExRLQVJMQSBGVUVOVEUgTk9MQVNDTzEWMBQGA1UELRMNRlVOSzY3MTIyOFBINjEbMBkGA1UEBRMSRlVOSzY3MTIyOE1DTE5MUjA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhNXbTSqGX6+/3Urpemyy5vVG2IdP2v7v001+c4BoMxEDFDQ32cOFdDiRxy0Fq9aR+Ojrofq8VeftvN586iyA1A6a0QnA68i7JnQKI4uJy+u0qiixuHu6u3b3BhSpoaVHcUtqFWLLlzr0yBxfVLOqVna/1/tHbQJg9hx57mp97P0JmXO1WeIqi+Zqob/mVZh2lsPGdJ8iqgjYFaFn9QVOQ1Pq74o1PTqwfzqgJSfV0zOOlESDPWggaDAYE4VNyTBisOUjlNd0x7ppcTxSi3yenrJHqkq/pqJsRLKf6VJ/s9p6bsd2bj07hSDpjlDC2lB25eEfkEkeMkXoE7ErXQ5QCwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAHwYpgbClHULXYhK4GNTgonvXh81oqfXwCSWAyDPiTYFDWVfWM9C4ApxMLyc0XvJte75Rla+bPC08oYN3OlhbbvP3twBL/w9SsfxvkbpFn2ZfGSTXZhyiq4vjmQHW1pnFvGelwgU4v3eeRE/MjoCnE7M/Q5thpuog6WGf7CbKERnWZn8QsUaJsZSEkg6Bv2jm69ye57ab5rrOUaeMlstTfdlaHAEkUgLX/NXq7RbGwv82hkHY5b2vYcXeh34tUMBL6os3OdRlooN9ZQGkVIISvxVZpSHkYC20DFNh1Bb0ovjfujlTcka81GnbUhFGZtRuoVQ1RVpMO8xtx3YKBLp4do3hPmnRCV5hCm43OIjYx9Ov2dqICV3AaNXSLV1dW39Bak/RBiIDGHzOIW2+VMPjvvypBjmPv/tmbqNHWPSAWOxTyMx6E1gFCZvi+5F+BgkdC3Lm7U0BU0NfvsXajZd8sXnIllvEMrikCLoI/yurvexNDcF1RW/FhMsoua0eerwczcNm66pGjHm05p9DR6lFeJZrtqeqZuojdxBWy4vH6ghyJaupergoX+nmdG3JYeRttCFF/ITI68TeCES5V3Y0C3psYAg1XxcGRLGd4chPo/4xwiLkijWtgt0/to5ljGBwfK7r62PHZfL1Dp+i7V3w7hmOlhbXzP+zhMZn1GCk7KY=",
                        "fileType": 0,
                        "password": "12345678a"
                      },
                      {
                        "base64File": "MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS9AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucRBAKNQXH8t8gVCl/ItHMI2hMJ76QOECOqEi1Y89cDpegDvh/INXyMsXbzi87tfFzgq1O+9ID6aPWGg+bNGADXyXxDVdy7Nq/SCdoXvo66MTYwq8jyJeUHDHEGMVBcmZpD44VJCvLBxDcvByuevP4Wo2NKqJCwK+ecAdZc/8Rvd947SjbMHuS8BppfQWARVUqA5BLOkTAHNv6tEk/hncC7O2YOGSShart8fM8dokgGSyewHVFe08POuQ+WDHeVpvApH/SP29rwktSoiHRoL6dK+F2YeEB5SuFW9LQgYCutjapmUP/9TC3Byro9Li6UrvQHxNmgMFGQJSYjFdqlGjLibfuguLp7pueutbROoZaSxU8HqlfYxLkpJUxUwNI1ja/1t3wcivtWknVXBd13R06iVfU1HGe8Kb4u5il4a4yP4p7VT4RE3b1SBLJeG+BxHiE8gFaaKcX/Cl6JV14RPTvk/6VnAtEQ66qHJex21KKuiJo2JoOmDXVHmvGQlWXNjYgoPx28Xd5WsofL+n7HDR2Ku8XgwJw6IXBJGuoday9qWN9v/k7DGlNGB6Sm4gdVUmycMP6EGhB1vFTiDfOGQO42ywmcpKoMETPVQ5InYKE0xAOckgcminDgxWjtUHjBDPEKifEjYudPwKmR6Cf4ZdGvUWwY/zq9pPAC9bu423KeBCnSL8AQ4r5SVsW6XG0njamwfNjpegwh/YG7sS7sDtZ8gi7r6tZYjsOqZlCYU0j7QTBpuQn81Yof2nQRCFxhRJCeydmIA8+z0nXrcElk7NDPk4kYQS0VitJ2qeQYNENzGBglROkCl2y6GlxAG80IBtReCUp/xOSdlwDR0eim+SNkdStvmQM5IcWBuDKwGZc1A4v/UoLl7niV9fpl4X6bUX8lZzY4gidJOafoJ30VoY/lYGkrkEuz3GpbbT5v8fF3iXVRlEqhlpe8JSGu7Rd2cPcJSkQ1Cuj/QRhHPhFMF2KhTEf95c9ZBKI8H7SvBi7eLXfSW2Y0ve6vXBZKyjK9whgCU9iVOsJjqRXpAccaWOKi420CjmS0+uwj/Xr2wLZhPEjBA/G6Od30+eG9mICmbp/5wAGhK/ZxCT17ZETyFmOMo49jl9pxdKocJNuzMrLpSz7/g5Jwp8+y8Ck5YP7AX0R/dVA0t37DO7nAbQT5XVSYpMVh/yvpYJ9WR+tb8Yg1h2lERLR2fbuhQRcwmisZR2W3Sr2b7hX9MCMkMQw8y2fDJrzLrqKqkHcjvnI/TdzZW2MzeQDoBBb3fmgvjYg07l4kThS73wGX992w2Y+a1A2iirSmrYEm9dSh16JmXa8boGQAONQzQkHh7vpw0IBs9cnvqO1QLB1GtbBztUBXonA4TxMKLYZkVrrd2RhrYWMsDp7MpC4M0p/DA3E/qscYwq1OpwriewNdx6XXqMZbdUNqMP2viBY2VSGmNdHtVfbN/rnaeJetFGX7XgTVYD7wDq8TW9yseCK944jcT+y/o0YiT9j3OLQ2Ts0LDTQskpJSxRmXEQGy3NBDOYFTvRkcGJEQJItuol8NivJN1H9LoLIUAlAHBZxfHpUYx66YnP4PdTdMIWH+nxyekKPFfAT7olQ=",
                        "fileType": 1,
                        "password": "12345678a"
                      }
                    ]
                  },
                  "recipient": {
                    "tin": "EKU9003173C9",
                    "legalName": "ESCUELA KEMPER URGATE",
                    "zipCode": "42501",
                    "taxRegimeCode": "601",
                    "cfdiUseCode": "G01",
                    "email": "someone@somewhere.com"
                  },
                  "items": [
                    {
                      "itemCode": "01010101",
                      "quantity": 9.5,
                      "unitOfMeasurementCode": "E48",
                      "unitOfMeasurement": "Unidad de servicio",
                      "description": "Invoicing software as a service",
                      "unitPrice": 3587.75,
                      "taxObjectCode": "02",
                      "itemSku": "7506022301697",
                      "discount": 255.85,
                      "itemTaxes": [
                        {
                          "taxCode": "002",
                          "taxTypeCode": "Tasa",
                          "taxRate": 0.160000,
                          "TaxFlagCode": "T"
                        }
                      ]
                    }
                  ]
                }
        * */


        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setTypeCode("I");
        invoice.setSeries("F");
        invoice.setDate(LocalDateTime.now());
        invoice.setPaymentFormCode("01");
        invoice.setPaymentMethodCode("PUE");
        invoice.setExpeditionZipCode("42501");

        // Emisor
        InvoiceIssuer emisor = new InvoiceIssuer();
        emisor.setLegalName("KARLA FUENTE NOLASCO");
        emisor.setTin("FUNK671228PH6");
        emisor.setTaxRegimeCode("621");

        // Certificados emisor (sellos)
        List<TaxCredential> sellos = new ArrayList<>();

        TaxCredential cer = new TaxCredential();
        cer.setBase64File("MIIFgDCCA2igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0NDYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTQzNTM3WhcNMjcwNTE4MTQzNTM3WjCBpzEdMBsGA1UEAxMUS0FSTEEgRlVFTlRFIE5PTEFTQ08xHTAbBgNVBCkTFEtBUkxBIEZVRU5URSBOT0xBU0NPMR0wGwYDVQQKExRLQVJMQSBGVUVOVEUgTk9MQVNDTzEWMBQGA1UELRMNRlVOSzY3MTIyOFBINjEbMBkGA1UEBRMSRlVOSzY3MTIyOE1DTE5MUjA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhNXbTSqGX6+/3Urpemyy5vVG2IdP2v7v001+c4BoMxEDFDQ32cOFdDiRxy0Fq9aR+Ojrofq8VeftvN586iyA1A6a0QnA68i7JnQKI4uJy+u0qiixuHu6u3b3BhSpoaVHcUtqFWLLlzr0yBxfVLOqVna/1/tHbQJg9hx57mp97P0JmXO1WeIqi+Zqob/mVZh2lsPGdJ8iqgjYFaFn9QVOQ1Pq74o1PTqwfzqgJSfV0zOOlESDPWggaDAYE4VNyTBisOUjlNd0x7ppcTxSi3yenrJHqkq/pqJsRLKf6VJ/s9p6bsd2bj07hSDpjlDC2lB25eEfkEkeMkXoE7ErXQ5QCwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAHwYpgbClHULXYhK4GNTgonvXh81oqfXwCSWAyDPiTYFDWVfWM9C4ApxMLyc0XvJte75Rla+bPC08oYN3OlhbbvP3twBL/w9SsfxvkbpFn2ZfGSTXZhyiq4vjmQHW1pnFvGelwgU4v3eeRE/MjoCnE7M/Q5thpuog6WGf7CbKERnWZn8QsUaJsZSEkg6Bv2jm69ye57ab5rrOUaeMlstTfdlaHAEkUgLX/NXq7RbGwv82hkHY5b2vYcXeh34tUMBL6os3OdRlooN9ZQGkVIISvxVZpSHkYC20DFNh1Bb0ovjfujlTcka81GnbUhFGZtRuoVQ1RVpMO8xtx3YKBLp4do3hPmnRCV5hCm43OIjYx9Ov2dqICV3AaNXSLV1dW39Bak/RBiIDGHzOIW2+VMPjvvypBjmPv/tmbqNHWPSAWOxTyMx6E1gFCZvi+5F+BgkdC3Lm7U0BU0NfvsXajZd8sXnIllvEMrikCLoI/yurvexNDcF1RW/FhMsoua0eerwczcNm66pGjHm05p9DR6lFeJZrtqeqZuojdxBWy4vH6ghyJaupergoX+nmdG3JYeRttCFF/ITI68TeCES5V3Y0C3psYAg1XxcGRLGd4chPo/4xwiLkijWtgt0/to5ljGBwfK7r62PHZfL1Dp+i7V3w7hmOlhbXzP+zhMZn1GCk7KY=");
        cer.setFileType(0); // 0=Certificado (.cer) | 1 Clave privada (.key)
        cer.setPassword("12345678a");

        TaxCredential key = new TaxCredential();
        key.setBase64File("MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS9AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucRBAKNQXH8t8gVCl/ItHMI2hMJ76QOECOqEi1Y89cDpegDvh/INXyMsXbzi87tfFzgq1O+9ID6aPWGg+bNGADXyXxDVdy7Nq/SCdoXvo66MTYwq8jyJeUHDHEGMVBcmZpD44VJCvLBxDcvByuevP4Wo2NKqJCwK+ecAdZc/8Rvd947SjbMHuS8BppfQWARVUqA5BLOkTAHNv6tEk/hncC7O2YOGSShart8fM8dokgGSyewHVFe08POuQ+WDHeVpvApH/SP29rwktSoiHRoL6dK+F2YeEB5SuFW9LQgYCutjapmUP/9TC3Byro9Li6UrvQHxNmgMFGQJSYjFdqlGjLibfuguLp7pueutbROoZaSxU8HqlfYxLkpJUxUwNI1ja/1t3wcivtWknVXBd13R06iVfU1HGe8Kb4u5il4a4yP4p7VT4RE3b1SBLJeG+BxHiE8gFaaKcX/Cl6JV14RPTvk/6VnAtEQ66qHJex21KKuiJo2JoOmDXVHmvGQlWXNjYgoPx28Xd5WsofL+n7HDR2Ku8XgwJw6IXBJGuoday9qWN9v/k7DGlNGB6Sm4gdVUmycMP6EGhB1vFTiDfOGQO42ywmcpKoMETPVQ5InYKE0xAOckgcminDgxWjtUHjBDPEKifEjYudPwKmR6Cf4ZdGvUWwY/zq9pPAC9bu423KeBCnSL8AQ4r5SVsW6XG0njamwfNjpegwh/YG7sS7sDtZ8gi7r6tZYjsOqZlCYU0j7QTBpuQn81Yof2nQRCFxhRJCeydmIA8+z0nXrcElk7NDPk4kYQS0VitJ2qeQYNENzGBglROkCl2y6GlxAG80IBtReCUp/xOSdlwDR0eim+SNkdStvmQM5IcWBuDKwGZc1A4v/UoLl7niV9fpl4X6bUX8lZzY4gidJOafoJ30VoY/lYGkrkEuz3GpbbT5v8fF3iXVRlEqhlpe8JSGu7Rd2cPcJSkQ1Cuj/QRhHPhFMF2KhTEf95c9ZBKI8H7SvBi7eLXfSW2Y0ve6vXBZKyjK9whgCU9iVOsJjqRXpAccaWOKi420CjmS0+uwj/Xr2wLZhPEjBA/G6Od30+eG9mICmbp/5wAGhK/ZxCT17ZETyFmOMo49jl9pxdKocJNuzMrLpSz7/g5Jwp8+y8Ck5YP7AX0R/dVA0t37DO7nAbQT5XVSYpMVh/yvpYJ9WR+tb8Yg1h2lERLR2fbuhQRcwmisZR2W3Sr2b7hX9MCMkMQw8y2fDJrzLrqKqkHcjvnI/TdzZW2MzeQDoBBb3fmgvjYg07l4kThS73wGX992w2Y+a1A2iirSmrYEm9dSh16JmXa8boGQAONQzQkHh7vpw0IBs9cnvqO1QLB1GtbBztUBXonA4TxMKLYZkVrrd2RhrYWMsDp7MpC4M0p/DA3E/qscYwq1OpwriewNdx6XXqMZbdUNqMP2viBY2VSGmNdHtVfbN/rnaeJetFGX7XgTVYD7wDq8TW9yseCK944jcT+y/o0YiT9j3OLQ2Ts0LDTQskpJSxRmXEQGy3NBDOYFTvRkcGJEQJItuol8NivJN1H9LoLIUAlAHBZxfHpUYx66YnP4PdTdMIWH+nxyekKPFfAT7olQ=");
        key.setFileType(1); // 0=Certificado (.cer) | 1 Clave privada (.key)
        key.setPassword("12345678a");


        //asignar certificado y clave privada a la lista sellos
        sellos.add(cer);
        sellos.add(key);

        // Asignar sellos del emisor al emisor.
        emisor.setTaxCredentials(sellos);

        //Asignar el emisor a la factura
        invoice.setIssuer(emisor);


        // Receptor
        InvoiceRecipient receptor = new InvoiceRecipient();
        receptor.setLegalName("ESCUELA KEMPER URGATE"); // Razón social
        receptor.setTin("EKU9003173C9"); // RFC
        receptor.setZipCode("42501");
        receptor.setTaxRegimeCode("601");
        receptor.setCfdiUseCode("G01");
        receptor.setEmail("someone@somewhere.com");

        invoice.setRecipient(receptor);

        // Productos / Servicios de la factura.

        List<InvoiceItem> items = new ArrayList<>();
        InvoiceItem item = new InvoiceItem();

        item.setItemCode("01010101");
        item.setQuantity(9.5);
        item.setUnitOfMeasurementCode("E48");
        item.setDescription("Invoicing software as a service.");
        item.setUnitPrice(3587.75);
        item.setTaxObjectCode("02");
        item.setItemSku("7506022301697");
        item.setDiscount(255.85);

        // impuestos del producto

        List<ItemTax> taxes = new ArrayList<>();
        ItemTax iva = new ItemTax();
        iva.setTaxCode("002"); // iva
        iva.setTaxTypeCode("Tasa"); // Tasa
        iva.setTaxRate("0.160000"); // 16%
        iva.setTaxFlagCode("T"); // T = Traslado | R = Retención

        //Agrega iva a los impuestos
        taxes.add(iva);

        //Agrega la lista de impuestos al producto.
        item.setItemTaxes(taxes);

        // Agrega el producto a la lista de productos.
        items.add(item);

        // Agrega la lista de productos a la factura.
        invoice.setItems(items);


        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
        System.out.println(apiResponse);


        //endregion

        System.out.printf("%s\n", "End Fiscalapi!");
    }
}