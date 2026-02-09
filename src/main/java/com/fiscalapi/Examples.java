package com.fiscalapi;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.invoicing.payroll.PayrollEarningOvertime;
import com.fiscalapi.models.invoicing.payroll.PayrollEarnings;
import com.fiscalapi.models.invoicing.payroll.PayrollRetirement;
import com.fiscalapi.models.invoicing.payroll.PayrollSeverance;
import com.fiscalapi.services.FiscalApiClient;

import java.time.LocalDateTime;
import java.util.*;

//package com.fiscalapi;
//
//public class Main {
//    public static void main(String[] args) {
//        Examples examples = new Examples();
//        examples.run();
//    }
//}


public class Examples {
    public void run() {

        System.out.printf("%s\n", "Hello Fiscalapi!");

        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(true);
        settings.setApiUrl("https://test.fiscalapi.com");
        //settings.setApiKey("<api-key>");
        settings.setApiKey("sk_test_4e7ca2f5_6c02_4571_9767_212f32cebd59");
        settings.setTenant("102e5f13-e114-41dd-bea7-507fce177281");
        //settings.setTenant("<tenant-key>");



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

        // region Datos de empleador
        //Obtener datos de empleador
        //ApiResponse<EmployerData> apiResponse = client.getPersonService().getEmployerService().GetById("0e82a655-5f0c-4e07-abab-8f322e4123ef");
        //System.out.println(apiResponse);

        //Crear datos de empleador
        /*
        String personId = "bd199ed8-02ef-47c0-919c-9479dd8ecae7";

        EmployerData employerData = new EmployerData();
        employerData.setPersonId(personId);
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

        ApiResponse<EmployerData> apiResponse = client.getPersonService().getEmployerService().Create(employerData);
        System.out.println(apiResponse);
        */
        //Actualizar datos de empleador
        /*
        String personId = "bd199ed8-02ef-47c0-919c-9479dd8ecae7";

        EmployerData employerData = new EmployerData();
        employerData.setPersonId(personId);
        employerData.setEmployerRegistration("A1230768108");
        employerData.setOriginEmployerTin("ARE180429TM6");

        ApiResponse<EmployerData> apiResponse = client.getPersonService().getEmployerService().Create(employerData);
        System.out.println(apiResponse);
         */

        //Eliminar datos de empleador
        //ApiResponse<Boolean> apiResponse = client.getPersonService().getEmployerService().Delete("0e82a655-5f0c-4e07-abab-8f322e4123ef");
        //System.out.println(apiResponse);
// endregion
//region Datos de empleado
        //Datos de empleado
        //Obtener datos de empleado
        //ApiResponse<EmployeeData> apiResponse = client.getPersonService().getEmployerService().GetById("0e82a655-5f0c-4e07-abab-8f322e4123ef");
        //System.out.println(apiResponse);

        //Crear datos de empleado
        /*
        EmployeeData employeeData = new EmployeeData();

        employeeData.setEmployerPersonId("bef56254-0892-4558-95c3-f9c8729e4b0e");
        employeeData.setEmployeePersonId("54fc14ae-c88f-4afc-996b-0574d63341e2");
        employeeData.setEmployeeNumber("12345");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatTaxRegimeTypeId("02");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatPayrollStateId("JAL");
        employeeData.setSocialSecurityNumber("123456789012345");
        employeeData.setLaborRelationStartDate("2023-01-15T00:00:00");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatBankId("002");
        employeeData.setSatUnionizedStatusId("No");
        employeeData.setDepartment("Recursos Humanos");
        employeeData.setPosition("Analista de Nóminas");
        employeeData.setSeniority("7Y3M1W");
        employeeData.setBankAccount("12345678901234567890");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");

        ApiResponse<EmployeeData> apiResponse = client.getPersonService().getEmployeeService().Create(employeeData);
        System.out.println(apiResponse);
         */

        //Actualizar datos de empleado
        /*
        EmployeeData employeeData = new EmployeeData();

        employeeData.setEmployerPersonId("bef56254-0892-4558-95c3-f9c8729e4b0e");
        employeeData.setEmployeePersonId("54fc14ae-c88f-4afc-996b-0574d63341e2");
        employeeData.setEmployeeNumber("12345");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatTaxRegimeTypeId("02");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatPayrollStateId("JAL");
        employeeData.setSocialSecurityNumber("123456789012345");
        employeeData.setLaborRelationStartDate("2023-01-15T00:00:00");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatBankId("002");
        employeeData.setSatUnionizedStatusId("No");
        employeeData.setDepartment("Recursos Humanos");
        employeeData.setPosition("Analista de Nóminas");
        employeeData.setSeniority("7Y3M1W");
        employeeData.setBankAccount("12345678901234567890");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");

        ApiResponse<EmployeeData> apiResponse = client.getPersonService().getEmployeeService().Update(employeeData);
        System.out.println(apiResponse);
         */

        //Eliminar datos de empleado
        //ApiResponse<Boolean> apiResponse = client.getPersonService().getEmployeeService().Delete("54fc14ae-c88f-4afc-996b-0574d63341e2");
        //System.out.println(apiResponse);
        // endregion
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
//        product.setUnitPrice("100.75986");
//        ApiResponse<Product> apiResponse = client.getProductService().create(product);
//        System.out.printf("apiResponse: %s\n", apiResponse);


//         // ***Actualizar producto***//
//        Product product = new Product();
//        product.setId("f846e552-fcd1-489a-9674-cbae18116bdc");
//        product.setDescription("Libro de Java con Impuestos");
//        product.setUnitPrice("150.75");
//        product.setSatUnitMeasurementId("H87"); // Pieza
//        product.setSatProductCodeId("81111602"); // libros
//        product.setSatTaxObjectId("02"); // Si objeto de impuesto
//
//        // Impuestos del producto
//        List<ProductTax> taxes = new ArrayList<>();
//
//        ProductTax iva16 = new ProductTax();
//        iva16.setTaxId("002"); // IVA
//        iva16.setRate("0.160000"); // 16%
//        iva16.setTaxTypeId("Tasa"); //Tasa
//        iva16.setTaxFlagId("T"); // Traslado
//
//        ProductTax iva1067 = new ProductTax(); // Retención 2/3 partes iva
//        iva1067.setTaxId("002");
//        iva1067.setRate("0.010667");
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
        //ApiResponse<Invoice> apiResponse = client.getInvoiceService().getById("1207c05b-9c4b-42ed-aa39-1fab4e993c7b",true);
        //System.out.printf("apiResponse: %s\n", apiResponse);

//        // ***Listar facturas***//
//        ApiResponse<PagedList<Invoice>> apiResponse = client.getInvoiceService().getList(1,3);
//        System.out.printf("apiResponse: %s\n", apiResponse);



        // Sellos de KARLA FUENTE NOLASCO. Ver https://docs.fiscalapi.com/tax-files-info#codificacion-de-fiel-o-csd-en-base64
        final String base64Cer = "MIIFgDCCA2igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0NDYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTQzNTM3WhcNMjcwNTE4MTQzNTM3WjCBpzEdMBsGA1UEAxMUS0FSTEEgRlVFTlRFIE5PTEFTQ08xHTAbBgNVBCkTFEtBUkxBIEZVRU5URSBOT0xBU0NPMR0wGwYDVQQKExRLQVJMQSBGVUVOVEUgTk9MQVNDTzEWMBQGA1UELRMNRlVOSzY3MTIyOFBINjEbMBkGA1UEBRMSRlVOSzY3MTIyOE1DTE5MUjA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhNXbTSqGX6+/3Urpemyy5vVG2IdP2v7v001+c4BoMxEDFDQ32cOFdDiRxy0Fq9aR+Ojrofq8VeftvN586iyA1A6a0QnA68i7JnQKI4uJy+u0qiixuHu6u3b3BhSpoaVHcUtqFWLLlzr0yBxfVLOqVna/1/tHbQJg9hx57mp97P0JmXO1WeIqi+Zqob/mVZh2lsPGdJ8iqgjYFaFn9QVOQ1Pq74o1PTqwfzqgJSfV0zOOlESDPWggaDAYE4VNyTBisOUjlNd0x7ppcTxSi3yenrJHqkq/pqJsRLKf6VJ/s9p6bsd2bj07hSDpjlDC2lB25eEfkEkeMkXoE7ErXQ5QCwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAHwYpgbClHULXYhK4GNTgonvXh81oqfXwCSWAyDPiTYFDWVfWM9C4ApxMLyc0XvJte75Rla+bPC08oYN3OlhbbvP3twBL/w9SsfxvkbpFn2ZfGSTXZhyiq4vjmQHW1pnFvGelwgU4v3eeRE/MjoCnE7M/Q5thpuog6WGf7CbKERnWZn8QsUaJsZSEkg6Bv2jm69ye57ab5rrOUaeMlstTfdlaHAEkUgLX/NXq7RbGwv82hkHY5b2vYcXeh34tUMBL6os3OdRlooN9ZQGkVIISvxVZpSHkYC20DFNh1Bb0ovjfujlTcka81GnbUhFGZtRuoVQ1RVpMO8xtx3YKBLp4do3hPmnRCV5hCm43OIjYx9Ov2dqICV3AaNXSLV1dW39Bak/RBiIDGHzOIW2+VMPjvvypBjmPv/tmbqNHWPSAWOxTyMx6E1gFCZvi+5F+BgkdC3Lm7U0BU0NfvsXajZd8sXnIllvEMrikCLoI/yurvexNDcF1RW/FhMsoua0eerwczcNm66pGjHm05p9DR6lFeJZrtqeqZuojdxBWy4vH6ghyJaupergoX+nmdG3JYeRttCFF/ITI68TeCES5V3Y0C3psYAg1XxcGRLGd4chPo/4xwiLkijWtgt0/to5ljGBwfK7r62PHZfL1Dp+i7V3w7hmOlhbXzP+zhMZn1GCk7KY=";
        final String base64Key = "MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS9AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucRBAKNQXH8t8gVCl/ItHMI2hMJ76QOECOqEi1Y89cDpegDvh/INXyMsXbzi87tfFzgq1O+9ID6aPWGg+bNGADXyXxDVdy7Nq/SCdoXvo66MTYwq8jyJeUHDHEGMVBcmZpD44VJCvLBxDcvByuevP4Wo2NKqJCwK+ecAdZc/8Rvd947SjbMHuS8BppfQWARVUqA5BLOkTAHNv6tEk/hncC7O2YOGSShart8fM8dokgGSyewHVFe08POuQ+WDHeVpvApH/SP29rwktSoiHRoL6dK+F2YeEB5SuFW9LQgYCutjapmUP/9TC3Byro9Li6UrvQHxNmgMFGQJSYjFdqlGjLibfuguLp7pueutbROoZaSxU8HqlfYxLkpJUxUwNI1ja/1t3wcivtWknVXBd13R06iVfU1HGe8Kb4u5il4a4yP4p7VT4RE3b1SBLJeG+BxHiE8gFaaKcX/Cl6JV14RPTvk/6VnAtEQ66qHJex21KKuiJo2JoOmDXVHmvGQlWXNjYgoPx28Xd5WsofL+n7HDR2Ku8XgwJw6IXBJGuoday9qWN9v/k7DGlNGB6Sm4gdVUmycMP6EGhB1vFTiDfOGQO42ywmcpKoMETPVQ5InYKE0xAOckgcminDgxWjtUHjBDPEKifEjYudPwKmR6Cf4ZdGvUWwY/zq9pPAC9bu423KeBCnSL8AQ4r5SVsW6XG0njamwfNjpegwh/YG7sS7sDtZ8gi7r6tZYjsOqZlCYU0j7QTBpuQn81Yof2nQRCFxhRJCeydmIA8+z0nXrcElk7NDPk4kYQS0VitJ2qeQYNENzGBglROkCl2y6GlxAG80IBtReCUp/xOSdlwDR0eim+SNkdStvmQM5IcWBuDKwGZc1A4v/UoLl7niV9fpl4X6bUX8lZzY4gidJOafoJ30VoY/lYGkrkEuz3GpbbT5v8fF3iXVRlEqhlpe8JSGu7Rd2cPcJSkQ1Cuj/QRhHPhFMF2KhTEf95c9ZBKI8H7SvBi7eLXfSW2Y0ve6vXBZKyjK9whgCU9iVOsJjqRXpAccaWOKi420CjmS0+uwj/Xr2wLZhPEjBA/G6Od30+eG9mICmbp/5wAGhK/ZxCT17ZETyFmOMo49jl9pxdKocJNuzMrLpSz7/g5Jwp8+y8Ck5YP7AX0R/dVA0t37DO7nAbQT5XVSYpMVh/yvpYJ9WR+tb8Yg1h2lERLR2fbuhQRcwmisZR2W3Sr2b7hX9MCMkMQw8y2fDJrzLrqKqkHcjvnI/TdzZW2MzeQDoBBb3fmgvjYg07l4kThS73wGX992w2Y+a1A2iirSmrYEm9dSh16JmXa8boGQAONQzQkHh7vpw0IBs9cnvqO1QLB1GtbBztUBXonA4TxMKLYZkVrrd2RhrYWMsDp7MpC4M0p/DA3E/qscYwq1OpwriewNdx6XXqMZbdUNqMP2viBY2VSGmNdHtVfbN/rnaeJetFGX7XgTVYD7wDq8TW9yseCK944jcT+y/o0YiT9j3OLQ2Ts0LDTQskpJSxRmXEQGy3NBDOYFTvRkcGJEQJItuol8NivJN1H9LoLIUAlAHBZxfHpUYx66YnP4PdTdMIWH+nxyekKPFfAT7olQ=";
        final String password = "12345678a";

//        /***Crear factura por valores. Vea: https://docs.fiscalapi.com/modes-of-operation ** */
//
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setTypeCode("I");
//        invoice.setSeries("F");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setPaymentFormCode("01");
//        invoice.setPaymentMethodCode("PUE");
//        invoice.setExpeditionZipCode("42501");
//
//        // Emisor
//        InvoiceIssuer emisor = new InvoiceIssuer();
//        emisor.setLegalName("KARLA FUENTE NOLASCO");
//        emisor.setTin("FUNK671228PH6");
//        emisor.setTaxRegimeCode("621");
//
//        // Certificados emisor (sellos)
//        List<TaxCredential> sellos = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0=Certificado (.cer) | 1 Clave privada (.key)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 0=Certificado (.cer) | 1 Clave privada (.key)
//        key.setPassword(password);
//
//
//        //asignar certificado y clave privada a la lista sellos
//        sellos.add(cer);
//        sellos.add(key);
//
//        // Asignar sellos del emisor al emisor.
//        emisor.setTaxCredentials(sellos);
//
//        //Asignar el emisor a la factura
//        invoice.setIssuer(emisor);
//
//
//        // Receptor
//        InvoiceRecipient receptor = new InvoiceRecipient();
//        receptor.setLegalName("ESCUELA KEMPER URGATE"); // Razón social
//        receptor.setTin("EKU9003173C9"); // RFC
//        receptor.setZipCode("42501");
//        receptor.setTaxRegimeCode("601");
//        receptor.setCfdiUseCode("G01");
//        receptor.setEmail("someone@somewhere.com");
//
//        invoice.setRecipient(receptor);
//
//        // Productos / Servicios de la factura.
//
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//
//        item.setItemCode("01010101");
//        item.setQuantity("9.5");
//        item.setUnitOfMeasurementCode("E48");
//        item.setDescription("Invoicing software as a service.");
//        item.setUnitPrice("3587.75");
//        item.setTaxObjectCode("02");
//        item.setItemSku("7506022301697");
//        item.setDiscount("255.85");
//
//        // impuestos del producto
//
//        List<ItemTax> taxes = new ArrayList<>();
//        ItemTax iva = new ItemTax();
//        iva.setTaxCode("002"); // iva
//        iva.setTaxTypeCode("Tasa"); // Tasa
//        iva.setTaxRate("0.160000"); // 16%
//        iva.setTaxFlagCode("T"); // T = Traslado | R = Retención
//
//        //Agrega iva a los impuestos
//        taxes.add(iva);
//
//        //Agrega la lista de impuestos al producto.
//        item.setItemTaxes(taxes);
//
//        // Agrega el producto a la lista de productos.
//        items.add(item);
//
//        // Agrega la lista de productos a la factura.
//        invoice.setItems(items);
//
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);


//        // Crear factura global por valores

//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setTypeCode("I");
//        invoice.setSeries("F");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setCurrencyCode("MXN");
//        invoice.setPaymentFormCode("01");
//        invoice.setPaymentMethodCode("PUE");
//        invoice.setExpeditionZipCode("01160");
//
//        // Información global
//        GlobalInformation globalInfo = new GlobalInformation();
//        globalInfo.setPeriodicityCode("01");
//        globalInfo.setMonthCode("05");
//        globalInfo.setYear(2025);
//        invoice.setGlobalInformation(globalInfo);
//
//        // Emisor
//        InvoiceIssuer emisor = new InvoiceIssuer();
//        emisor.setLegalName("KARLA FUENTE NOLASCO");
//        emisor.setTin("FUNK671228PH6");
//        emisor.setTaxRegimeCode("621");
//
//        // Certificados emisor (sellos)
//        List<TaxCredential> sellos = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0=Certificado (.cer) | 1 Clave privada (.key)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 0=Certificado (.cer) | 1 Clave privada (.key)
//        key.setPassword(password);
//
//        // asignar certificado y clave privada a la lista sellos
//        sellos.add(cer);
//        sellos.add(key);
//
//        // Asignar sellos del emisor al emisor.
//        emisor.setTaxCredentials(sellos);
//
//        // Asignar el emisor a la factura
//        invoice.setIssuer(emisor);
//
//        // Receptor (Público en general para factura global)
//        InvoiceRecipient receptor = new InvoiceRecipient();
//        receptor.setLegalName("PUBLICO EN GENERAL");
//        receptor.setTin("XAXX010101000");
//        receptor.setZipCode("01160");
//        receptor.setTaxRegimeCode("616");
//        receptor.setCfdiUseCode("S01");
//        receptor.setEmail("someone@somewhere.com");
//
//        invoice.setRecipient(receptor);
//
//        // Ventas al publico en general
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//
//        item.setItemCode("01010101");
//        item.setQuantity("1.0");
//        item.setUnitOfMeasurementCode("ACT");
//        item.setDescription("Venta");
//        item.setUnitPrice("1230.00");
//        item.setTaxObjectCode("02");
//        item.setItemSku("venta0001");
//        item.setDiscount("255.85");
//
//        // impuestos del producto
//        List<ItemTax> taxes = new ArrayList<>();
//        ItemTax iva = new ItemTax();
//        iva.setTaxCode("002"); // IVA
//        iva.setTaxTypeCode("Tasa"); // Tasa
//        iva.setTaxRate("0.160000"); // 16%
//        iva.setTaxFlagCode("T"); // T = Traslado | R = Retención
//
//        // Agrega iva a los impuestos
//        taxes.add(iva);
//
//        // Agrega la lista de impuestos al producto
//        item.setItemTaxes(taxes);
//
//        // Agrega el producto a la lista de productos
//        items.add(item);
//
//        // Agrega la lista de productos a la factura
//        invoice.setItems(items);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);



//        // Crear factura global por referencias

//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setTypeCode("I");
//        invoice.setSeries("F");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setCurrencyCode("MXN");
//        invoice.setPaymentFormCode("01");
//        invoice.setPaymentMethodCode("PUE");
//        invoice.setExpeditionZipCode("01160");
//
//        // Información global
//        GlobalInformation globalInfo = new GlobalInformation();
//        globalInfo.setPeriodicityCode("01");
//        globalInfo.setMonthCode("05");
//        globalInfo.setYear(2025);
//        invoice.setGlobalInformation(globalInfo);
//
//        // Emisor por referencia
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setId("78d380fd-1b69-4e3c-8bc0-4f57737f7d5f");
//        invoice.setIssuer(issuer);
//
//        // Receptor por referencia
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setId("4e7ba2d7-2302-42f1-9fe4-6b75069f0fc9");
//        invoice.setRecipient(recipient);
//
//        // Ventas al publico en general
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//
//        item.setItemCode("01010101");
//        item.setQuantity("1.0");
//        item.setUnitOfMeasurementCode("ACT");
//        item.setDescription("Venta");
//        item.setUnitPrice("1230.00");
//        item.setTaxObjectCode("02");
//        item.setItemSku("venta0001");
//        item.setDiscount("255.85");
//
//        // impuestos del producto
//        List<ItemTax> taxes = new ArrayList<>();
//        ItemTax iva = new ItemTax();
//        iva.setTaxCode("002"); // IVA
//        iva.setTaxTypeCode("Tasa"); // Tasa
//        iva.setTaxRate("0.160000"); // 16%
//        iva.setTaxFlagCode("T"); // T = Traslado | R = Retención
//
//        // Agrega iva a los impuestos
//        taxes.add(iva);
//
//        // Agrega la lista de impuestos al producto
//        item.setItemTaxes(taxes);
//
//        // Agrega el producto a la lista de productos
//        items.add(item);
//
//        // Agrega la lista de productos a la factura
//        invoice.setItems(items);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);




//        //*** Generar factura con IVA excento por valores.***//
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setTypeCode("I");
//        invoice.setSeries("F");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setPaymentFormCode("01");
//        invoice.setPaymentMethodCode("PUE");
//        invoice.setExpeditionZipCode("42501");
//
//        // Emisor
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setTin("FUNK671228PH6");
//        issuer.setLegalName("KARLA FUENTE NOLASCO");
//        issuer.setTaxRegimeCode("621");
//
//        // Certificados del emisor
//        List<TaxCredential> credentials = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0 = Certificado (.cer)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 1 = Clave privada (.key)
//        key.setPassword(password);
//
//        credentials.add(cer);
//        credentials.add(key);
//
//        issuer.setTaxCredentials(credentials);
//        invoice.setIssuer(issuer);
//
//        // Receptor
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setTin("EKU9003173C9");
//        recipient.setLegalName("ESCUELA KEMPER URGATE");
//        recipient.setZipCode("42501");
//        recipient.setTaxRegimeCode("601");
//        recipient.setCfdiUseCode("G01");
//        recipient.setEmail("someone@somewhere.com");
//        invoice.setRecipient(recipient);
//
//        // Productos / Servicios
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setItemCode("01010101");
//        item.setQuantity("9.5");
//        item.setUnitOfMeasurementCode("E48");
//        item.setDescription("Invoicing software as a service");
//        item.setUnitPrice("3587.75");
//        item.setTaxObjectCode("02");
//        item.setItemSku("7506022301697");
//        item.setDiscount("255.85");
//
//        // Impuestos del producto (IVA exento)
//        List<ItemTax> taxes = new ArrayList<>();
//        ItemTax tax = new ItemTax();
//        tax.setTaxCode("002");
//        tax.setTaxTypeCode("Exento");
//        tax.setTaxFlagCode("T"); // T = Traslado | R = Retención
//        taxes.add(tax);
//        item.setItemTaxes(taxes);
//
//        items.add(item);
//        invoice.setItems(items);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);


//        // Generar factura IVA tasa cero
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setTypeCode("I");
//        invoice.setSeries("F");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setPaymentFormCode("01");
//        invoice.setPaymentMethodCode("PUE");
//        invoice.setExpeditionZipCode("42501");
//
//        // Emisor
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setTin("FUNK671228PH6");
//        issuer.setLegalName("KARLA FUENTE NOLASCO");
//        issuer.setTaxRegimeCode("621");
//
//        // Certificados del emisor
//        List<TaxCredential> credentials = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0 = Certificado (.cer)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 1 = Clave privada (.key)
//        key.setPassword(password);
//
//        credentials.add(cer);
//        credentials.add(key);
//
//        issuer.setTaxCredentials(credentials);
//        invoice.setIssuer(issuer);
//
//        // Receptor
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setTin("EKU9003173C9");
//        recipient.setLegalName("ESCUELA KEMPER URGATE");
//        recipient.setZipCode("42501");
//        recipient.setTaxRegimeCode("601");
//        recipient.setCfdiUseCode("G01");
//        recipient.setEmail("someone@somewhere.com");
//        invoice.setRecipient(recipient);
//
//        // Productos / Servicios
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setItemCode("01010101");
//        item.setQuantity("9.5");
//        item.setUnitOfMeasurementCode("E48");
//        item.setDescription("Invoicing software as a service");
//        item.setUnitPrice("3587.75");
//        item.setTaxObjectCode("02");
//        item.setItemSku("7506022301697");
//        item.setDiscount("255.85");
//
//        // Impuestos del producto (IVA tasa cero)
//        List<ItemTax> taxes = new ArrayList<>();
//        ItemTax tax = new ItemTax();
//        tax.setTaxCode("002");
//        tax.setTaxTypeCode("Tasa");
//        tax.setTaxRate("0.000000");
//        tax.setTaxFlagCode("T"); // T = Traslado | R = Retención
//        taxes.add(tax);
//        item.setItemTaxes(taxes);
//
//        items.add(item);
//        invoice.setItems(items);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);



//        // Generar factura por referencias
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("F");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setPaymentFormCode("01");
//        invoice.setCurrencyCode("MXN");
//        invoice.setTypeCode("I");
//        invoice.setExpeditionZipCode("42501");
//        invoice.setPaymentMethodCode("PUE");
//
//        // Emisor por referencia
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
//        invoice.setIssuer(issuer);
//
//        // Receptor por referencia
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setId("96b46762-d246-4a67-a562-510a25dbafa9");
//        invoice.setRecipient(recipient);
//
//        // Producto / Servicio por referencia
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setId("114a4be5-fb65-40b2-a762-ff0c55c6ebfa");
//        item.setQuantity("2.0");
//        item.setDiscount("255.85");
//        items.add(item);
//        invoice.setItems(items);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);


        // Generar factura con precios dinámicos
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("F");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setPaymentFormCode("01");
//        invoice.setCurrencyCode("MXN");
//        invoice.setTypeCode("I");
//        invoice.setExpeditionZipCode("42501");
//        invoice.setPaymentMethodCode("PUE");
//
//        // Emisor por referencia
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
//        invoice.setIssuer(issuer);
//
//        // Receptor por referencia
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setId("96b46762-d246-4a67-a562-510a25dbafa9");
//        invoice.setRecipient(recipient);
//
//        // Producto / Servicio por referencia
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setId("114a4be5-fb65-40b2-a762-ff0c55c6ebfa");
//        item.setQuantity("1.0");
//        item.setUnitPrice("200.00");
//        items.add(item);
//        invoice.setItems(items);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);



//        // Generar nota de crédito por valores
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("CN");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setPaymentFormCode("03");
//        invoice.setCurrencyCode("MXN");
//        invoice.setTypeCode("E");
//        invoice.setExpeditionZipCode("01160");
//        invoice.setPaymentMethodCode("PUE");
//
//
//        // Emisor
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setTin("FUNK671228PH6");
//        issuer.setLegalName("KARLA FUENTE NOLASCO");
//        issuer.setTaxRegimeCode("621");
//
//        // Certificados del emisor
//        List<TaxCredential> credentials = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0 = Certificado (.cer)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 1 = Clave privada (.key)
//        key.setPassword(password);
//
//        credentials.add(cer);
//        credentials.add(key);
//
//        issuer.setTaxCredentials(credentials);
//        invoice.setIssuer(issuer);
//
//        // Receptor
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setTin("EKU9003173C9");
//        recipient.setLegalName("ESCUELA KEMPER URGATE");
//        recipient.setZipCode("42501");
//        recipient.setTaxRegimeCode("601");
//        recipient.setCfdiUseCode("G01");
//        recipient.setEmail("someone@somewhere.com");
//        invoice.setRecipient(recipient);
//
//        // Facturas relacionadas
//        List<RelatedInvoice> relatedInvoices = new ArrayList<>();
//        RelatedInvoice related = new RelatedInvoice();
//        related.setUuid("5FB2822E-396D-4725-8521-CDC4BDD20CCF");
//        related.setRelationshipTypeCode("01");
//        relatedInvoices.add(related);
//        invoice.setRelatedInvoices(relatedInvoices);
//
//        // Productos / Servicios
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setItemCode("01010101");
//        item.setQuantity("0.5");
//        item.setUnitOfMeasurementCode("E48");
//        item.setDescription("Invoicing software as a service");
//        item.setUnitPrice("3587.75");
//        item.setTaxObjectCode("02");
//        item.setItemSku("7506022301697");
//
//        // Impuestos del producto
//        List<ItemTax> taxes = new ArrayList<>();
//        ItemTax tax = new ItemTax();
//        tax.setTaxCode("002");
//        tax.setTaxTypeCode("Tasa");
//        tax.setTaxRate("0.160000");
//        tax.setTaxFlagCode("T"); // T = Traslado | R = Retención
//        taxes.add(tax);
//        item.setItemTaxes(taxes);
//
//        items.add(item);
//        invoice.setItems(items);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);


//        // Generar nota de credito por referencias
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("CN");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setPaymentFormCode("03");
//        invoice.setCurrencyCode("MXN");
//        invoice.setTypeCode("E");
//        invoice.setExpeditionZipCode("01160");
//        invoice.setPaymentMethodCode("PUE");
//
//        // Emisor por referencia
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
//        invoice.setIssuer(issuer);
//
//        // Receptor por referencia
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setId("96b46762-d246-4a67-a562-510a25dbafa9");
//        invoice.setRecipient(recipient);
//
//        // Facturas relacionadas
//        List<RelatedInvoice> relatedInvoices = new ArrayList<>();
//        RelatedInvoice related = new RelatedInvoice();
//        related.setUuid("5FB2822E-396D-4725-8521-CDC4BDD20CCF");
//        related.setRelationshipTypeCode("01");
//        relatedInvoices.add(related);
//        invoice.setRelatedInvoices(relatedInvoices);
//
//        // Productos / Servicios por referencia
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setId("114a4be5-fb65-40b2-a762-ff0c55c6ebfa");
//        item.setQuantity("0.5");
//        items.add(item);
//        invoice.setItems(items);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);

        // Generar nota de crédito con precios dinámicos
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("CN");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setPaymentFormCode("03");
//        invoice.setCurrencyCode("MXN");
//        invoice.setTypeCode("E");
//        invoice.setExpeditionZipCode("01160");
//        invoice.setPaymentMethodCode("PUE");
//
//        // Emisor por referencia
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
//        invoice.setIssuer(issuer);
//
//        // Receptor por referencia
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setId("96b46762-d246-4a67-a562-510a25dbafa9");
//        invoice.setRecipient(recipient);
//
//        // Facturas relacionadas
//        List<RelatedInvoice> relatedInvoices = new ArrayList<>();
//        RelatedInvoice related = new RelatedInvoice();
//        related.setUuid("5FB2822E-396D-4725-8521-CDC4BDD20CCF");
//        related.setRelationshipTypeCode("01");
//        relatedInvoices.add(related);
//        invoice.setRelatedInvoices(relatedInvoices);
//
//        // Productos / Servicios por referencia
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setId("114a4be5-fb65-40b2-a762-ff0c55c6ebfa");
//        item.setQuantity("0.5");
//        item.setUnitPrice("150.0");
//        items.add(item);
//        invoice.setItems(items);

//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);







//        // Genera complemento de pago por valores
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("CP");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setCurrencyCode("XXX");
//        invoice.setTypeCode("P");
//        invoice.setExpeditionZipCode("01160");
//
//        // Emisor
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setTin("FUNK671228PH6");
//        issuer.setLegalName("KARLA FUENTE NOLASCO");
//        issuer.setTaxRegimeCode("621");
//
//        // Certificados del emisor
//        List<TaxCredential> credentials = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0 = Certificado (.cer)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 1 = Clave privada (.key)
//        key.setPassword(password);
//
//        credentials.add(cer);
//        credentials.add(key);
//
//        issuer.setTaxCredentials(credentials);
//        invoice.setIssuer(issuer);
//
//        // Receptor
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setTin("EKU9003173C9");
//        recipient.setLegalName("ESCUELA KEMPER URGATE");
//        recipient.setZipCode("42501");
//        recipient.setTaxRegimeCode("601");
//        recipient.setCfdiUseCode("CP01");
//        recipient.setEmail("someone@somewhere.com");
//        invoice.setRecipient(recipient);
//
//        // Ítem (Complemento de pago, se utiliza un ítem para reflejar el pago)
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setItemCode("84111506");
//        item.setQuantity("1.0");
//        item.setUnitOfMeasurementCode("ACT");
//        item.setDescription("Pago");
//        item.setUnitPrice("0.0");
//        item.setTaxObjectCode("01");
//        items.add(item);
//        invoice.setItems(items);
//
//        // Pagos
//        List<InvoicePayment> payments = new ArrayList<>();
//        InvoicePayment payment = new InvoicePayment();
//        payment.setPaymentDate("2026-02-09T10:00:00");
//        payment.setPaymentFormCode("28");
//        payment.setCurrencyCode("MXN");
//        payment.setAmount("11600.00");
//        payment.setSourceBankTin("BSM970519DU8");
//        payment.setSourceBankAccount("1234567891012131");
//        payment.setTargetBankTin("BBA830831LJ2");
//        payment.setTargetBankAccount("1234567890");
//
//        // Facturas pagadas en este pago
//        List<PaidInvoice> paidInvoices = new ArrayList<>();
//        PaidInvoice paidInvoice = new PaidInvoice();
//        paidInvoice.setUuid("5C7B0622-01B4-4EB8-96D0-E0DEBD89FF0F");
//        paidInvoice.setSeries("F");
//        paidInvoice.setNumber("1501");
//        paidInvoice.setCurrencyCode("MXN");
//        paidInvoice.setPartialityNumber(1);
//        paidInvoice.setSubTotal("10000.0");
//        paidInvoice.setPreviousBalance("11600.00");
//        paidInvoice.setPaymentAmount("11600.00");
//        paidInvoice.setRemainingBalance("0.0");
//        paidInvoice.setTaxObjectCode("02");
//
//        // Impuestos de la factura pagada
//        List<PaidInvoiceTax> paidInvoiceTaxes = new ArrayList<>();
//        PaidInvoiceTax paidTax = new PaidInvoiceTax();
//        paidTax.setTaxCode("002");
//        paidTax.setTaxTypeCode("Tasa");
//        paidTax.setTaxRate("0.160000");
//        paidTax.setTaxFlagCode("T"); // T = Traslado | R = Retención
//        paidInvoiceTaxes.add(paidTax);
//
//        paidInvoice.setPaidInvoiceTaxes(paidInvoiceTaxes);
//        paidInvoices.add(paidInvoice);
//        payment.setPaidInvoices(paidInvoices);
//
//        payments.add(payment);
//        invoice.setPayments(payments);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);


//        // Generar complemento de pago por referencias
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("CP");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setCurrencyCode("XXX");
//        invoice.setTypeCode("P");
//        invoice.setExpeditionZipCode("01160");
//
//
//        // Emisor por referencia
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
//        invoice.setIssuer(issuer);
//
//        // Receptor por referencia
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setId("96b46762-d246-4a67-a562-510a25dbafa9");
//        invoice.setRecipient(recipient);
//
//        // Pagos
//        List<InvoicePayment> payments = new ArrayList<>();
//        InvoicePayment payment = new InvoicePayment();
//        payment.setPaymentDate("2024-06-03T14:44:56");
//        payment.setPaymentFormCode("28");
//        payment.setCurrencyCode("MXN");
//        payment.setAmount("11600.00");
//        payment.setSourceBankTin("BSM970519DU8");
//        payment.setSourceBankAccount("1234567891012131");
//        payment.setTargetBankTin("BBA830831LJ2");
//        payment.setTargetBankAccount("1234567890");
//
//        // Facturas pagadas en este pago
//        List<PaidInvoice> paidInvoices = new ArrayList<>();
//        PaidInvoice paidInvoice = new PaidInvoice();
//        paidInvoice.setUuid("5C7B0622-01B4-4EB8-96D0-E0DEBD89FF0F");
//        paidInvoice.setSeries("F");
//        paidInvoice.setNumber("1501");
//        paidInvoice.setCurrencyCode("MXN");
//        paidInvoice.setPartialityNumber(1);
//        paidInvoice.setSubTotal("10000.0");
//        paidInvoice.setPreviousBalance("11600.00");
//        paidInvoice.setPaymentAmount("11600.00");
//        paidInvoice.setRemainingBalance("0.0");
//        paidInvoice.setTaxObjectCode("02");
//
//        // Impuestos de la factura pagada
//        List<PaidInvoiceTax> paidInvoiceTaxes = new ArrayList<>();
//        PaidInvoiceTax paidTax = new PaidInvoiceTax();
//        paidTax.setTaxCode("002");
//        paidTax.setTaxTypeCode("Tasa");
//        paidTax.setTaxRate("0.160000");
//        paidTax.setTaxFlagCode("T");
//        paidInvoiceTaxes.add(paidTax);
//
//        paidInvoice.setPaidInvoiceTaxes(paidInvoiceTaxes);
//        paidInvoices.add(paidInvoice);
//        payment.setPaidInvoices(paidInvoices);
//
//        payments.add(payment);
//        invoice.setPayments(payments);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);


//        // Genera complemento de pago, factura en MXN y el pago en USD
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("usd-mxn");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setCurrencyCode("XXX");
//        invoice.setTypeCode("P");
//        invoice.setExpeditionZipCode("01160");
//
//        // Emisor
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setTin("FUNK671228PH6");
//        issuer.setLegalName("KARLA FUENTE NOLASCO");
//        issuer.setTaxRegimeCode("621");
//
//        // Certificados del emisor
//        List<TaxCredential> credentials = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0 = Certificado (.cer)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 1 = Clave privada (.key)
//        key.setPassword(password);
//
//        credentials.add(cer);
//        credentials.add(key);
//
//        issuer.setTaxCredentials(credentials);
//        invoice.setIssuer(issuer);
//
//        // Receptor
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setTin("EKU9003173C9");
//        recipient.setLegalName("ESCUELA KEMPER URGATE");
//        recipient.setZipCode("42501");
//        recipient.setTaxRegimeCode("601");
//        recipient.setCfdiUseCode("CP01");
//        recipient.setEmail("someone@somewhere.com");
//        invoice.setRecipient(recipient);
//
//        // Ítem (Complemento de pago)
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setItemCode("84111506");
//        item.setQuantity("1.0");
//        item.setUnitOfMeasurementCode("ACT");
//        item.setDescription("Pago");
//        item.setUnitPrice("0.0");
//        item.setTaxObjectCode("01");
//        items.add(item);
//        invoice.setItems(items);
//
//        // Pagos
//        List<InvoicePayment> payments = new ArrayList<>();
//        InvoicePayment payment = new InvoicePayment();
//        payment.setPaymentDate("2024-06-03T14:44:56");
//        payment.setPaymentFormCode("28");
//        payment.setCurrencyCode("USD");
//        payment.setExchangeRate("20.64");
//        payment.setAmount("5.62");
//        payment.setSourceBankTin("BSM970519DU8");
//        payment.setSourceBankAccount("1234567891012131");
//        payment.setTargetBankTin("BBA830831LJ2");
//        payment.setTargetBankAccount("1234567890");
//
//        // Facturas pagadas en este pago
//        List<PaidInvoice> paidInvoices = new ArrayList<>();
//        PaidInvoice paidInvoice = new PaidInvoice();
//        paidInvoice.setUuid("4a5d025b-813a-4acf-9f32-8fb61f4918ac");
//        paidInvoice.setSeries("F");
//        paidInvoice.setNumber("2");
//        paidInvoice.setCurrencyCode("MXN");
//        paidInvoice.setEquivalence("20.64");
//        paidInvoice.setPartialityNumber(1);
//        paidInvoice.setSubTotal("100.00");
//        paidInvoice.setPreviousBalance("116.00");
//        paidInvoice.setPaymentAmount("116.00");
//        paidInvoice.setRemainingBalance("0.0");
//        paidInvoice.setTaxObjectCode("02");
//
//        // Impuestos de la factura pagada
//        List<PaidInvoiceTax> paidInvoiceTaxes = new ArrayList<>();
//
//        PaidInvoiceTax tax1 = new PaidInvoiceTax();
//        tax1.setTaxCode("002");
//        tax1.setTaxTypeCode("Tasa");
//        tax1.setTaxRate("0.160000");
//        tax1.setTaxFlagCode("T");
//        paidInvoiceTaxes.add(tax1);
//
//        PaidInvoiceTax tax2 = new PaidInvoiceTax();
//        tax2.setTaxCode("002");
//        tax2.setTaxTypeCode("Tasa");
//        tax2.setTaxRate("0.106667");
//        tax2.setTaxFlagCode("R");
//        paidInvoiceTaxes.add(tax2);
//
//        PaidInvoiceTax tax3 = new PaidInvoiceTax();
//        tax3.setTaxCode("001");
//        tax3.setTaxTypeCode("Tasa");
//        tax3.setTaxRate("0.100000");
//        tax3.setTaxFlagCode("R");
//        paidInvoiceTaxes.add(tax3);
//
//        paidInvoice.setPaidInvoiceTaxes(paidInvoiceTaxes);
//        paidInvoices.add(paidInvoice);
//        payment.setPaidInvoices(paidInvoices);
//
//        payments.add(payment);
//        invoice.setPayments(payments);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);



//        // Genera complemento de pago, factura en USD y el pago en MXN
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("MXN-USD");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setCurrencyCode("XXX");
//        invoice.setTypeCode("P");
//        invoice.setExpeditionZipCode("01160");
//
//        // Emisor
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setTin("FUNK671228PH6");
//        issuer.setLegalName("KARLA FUENTE NOLASCO");
//        issuer.setTaxRegimeCode("621");
//
//        // Certificados del emisor
//        List<TaxCredential> credentials = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0 = Certificado (.cer)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 1 = Clave privada (.key)
//        key.setPassword(password);
//
//        credentials.add(cer);
//        credentials.add(key);
//
//        issuer.setTaxCredentials(credentials);
//        invoice.setIssuer(issuer);
//
//        // Receptor
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setTin("EKU9003173C9");
//        recipient.setLegalName("ESCUELA KEMPER URGATE");
//        recipient.setZipCode("42501");
//        recipient.setTaxRegimeCode("601");
//        recipient.setCfdiUseCode("CP01");
//        recipient.setEmail("someone@somewhere.com");
//        invoice.setRecipient(recipient);
//
//        // Ítem (Complemento de pago)
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setItemCode("84111506");
//        item.setQuantity("1.0");
//        item.setUnitOfMeasurementCode("ACT");
//        item.setDescription("Pago");
//        item.setUnitPrice("0.0");
//        item.setTaxObjectCode("01");
//        items.add(item);
//        invoice.setItems(items);
//
//        // Pagos
//        List<InvoicePayment> payments = new ArrayList<>();
//        InvoicePayment payment = new InvoicePayment();
//        payment.setPaymentDate("2024-06-03T14:44:56");
//        payment.setPaymentFormCode("28");
//        payment.setCurrencyCode("MXN");
//        payment.setAmount("921.23");
//        payment.setSourceBankTin("BSM970519DU8");
//        payment.setSourceBankAccount("1234567891012131");
//        payment.setTargetBankTin("BBA830831LJ2");
//        payment.setTargetBankAccount("1234567890");
//
//        // Facturas pagadas en este pago
//        List<PaidInvoice> paidInvoices = new ArrayList<>();
//        PaidInvoice paidInvoice = new PaidInvoice();
//        paidInvoice.setUuid("4a5d025b-813a-4acf-9f32-8fb61f4918ac");
//        paidInvoice.setSeries("F");
//        paidInvoice.setNumber("2");
//        paidInvoice.setCurrencyCode("USD");
//        paidInvoice.setEquivalence("0.045331");
//        paidInvoice.setPartialityNumber(1);
//        paidInvoice.setSubTotal("36.000");
//        paidInvoice.setPreviousBalance("41.76");
//        paidInvoice.setPaymentAmount("41.76");
//        paidInvoice.setRemainingBalance("0.0");
//        paidInvoice.setTaxObjectCode("02");
//
//        // Impuestos de la factura pagada
//        List<PaidInvoiceTax> paidInvoiceTaxes = new ArrayList<>();
//
//        PaidInvoiceTax tax1 = new PaidInvoiceTax();
//        tax1.setTaxCode("002");
//        tax1.setTaxTypeCode("Tasa");
//        tax1.setTaxRate("0.160000");
//        tax1.setTaxFlagCode("T");
//        paidInvoiceTaxes.add(tax1);
//
//        PaidInvoiceTax tax2 = new PaidInvoiceTax();
//        tax2.setTaxCode("002");
//        tax2.setTaxTypeCode("Tasa");
//        tax2.setTaxRate("0.106667");
//        tax2.setTaxFlagCode("R");
//        paidInvoiceTaxes.add(tax2);
//
//        PaidInvoiceTax tax3 = new PaidInvoiceTax();
//        tax3.setTaxCode("001");
//        tax3.setTaxTypeCode("Tasa");
//        tax3.setTaxRate("0.100000");
//        tax3.setTaxFlagCode("R");
//        paidInvoiceTaxes.add(tax3);
//
//        paidInvoice.setPaidInvoiceTaxes(paidInvoiceTaxes);
//        paidInvoices.add(paidInvoice);
//        payment.setPaidInvoices(paidInvoices);
//
//        payments.add(payment);
//        invoice.setPayments(payments);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);



        // Genera complemento de pago, factura en USD y el pago en EUR
//        Invoice invoice = new Invoice();
//        invoice.setVersionCode("4.0");
//        invoice.setSeries("MXN-USD");
//        invoice.setDate("2026-02-09T10:00:00");
//        invoice.setCurrencyCode("XXX");
//        invoice.setTypeCode("P");
//        invoice.setExpeditionZipCode("01160");
//
//
//        // Emisor
//        InvoiceIssuer issuer = new InvoiceIssuer();
//        issuer.setTin("FUNK671228PH6");
//        issuer.setLegalName("KARLA FUENTE NOLASCO");
//        issuer.setTaxRegimeCode("621");
//
//        // Certificados del emisor
//        List<TaxCredential> credentials = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0 = Certificado (.cer)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 1 = Clave privada (.key)
//        key.setPassword(password);
//
//        credentials.add(cer);
//        credentials.add(key);
//
//        issuer.setTaxCredentials(credentials);
//        invoice.setIssuer(issuer);
//
//        // Receptor
//        InvoiceRecipient recipient = new InvoiceRecipient();
//        recipient.setTin("EKU9003173C9");
//        recipient.setLegalName("ESCUELA KEMPER URGATE");
//        recipient.setZipCode("42501");
//        recipient.setTaxRegimeCode("601");
//        recipient.setCfdiUseCode("CP01");
//        recipient.setEmail("someone@somewhere.com");
//        invoice.setRecipient(recipient);
//
//        // Ítem (Complemento de pago)
//        List<InvoiceItem> items = new ArrayList<>();
//        InvoiceItem item = new InvoiceItem();
//        item.setItemCode("84111506");
//        item.setQuantity("1.0");
//        item.setUnitOfMeasurementCode("ACT");
//        item.setDescription("Pago");
//        item.setUnitPrice("0.0");
//        item.setTaxObjectCode("01");
//        items.add(item);
//        invoice.setItems(items);
//
//        // Pagos
//        List<InvoicePayment> payments = new ArrayList<>();
//        InvoicePayment payment = new InvoicePayment();
//        payment.setPaymentDate("2024-06-03T14:44:56");
//        payment.setPaymentFormCode("28");
//        payment.setCurrencyCode("EUR");
//        payment.setExchangeRate("25.00");
//        payment.setAmount("100.00");
//        payment.setSourceBankTin("BSM970519DU8");
//        payment.setSourceBankAccount("1234567891012131");
//        payment.setTargetBankTin("BBA830831LJ2");
//        payment.setTargetBankAccount("1234567890");
//
//        // Facturas pagadas en este pago
//        List<PaidInvoice> paidInvoices = new ArrayList<>();
//        PaidInvoice paidInvoice = new PaidInvoice();
//        paidInvoice.setUuid("4a5d025b-813a-4acf-9f32-8fb61f4918ac");
//        paidInvoice.setSeries("F");
//        paidInvoice.setNumber("2");
//        paidInvoice.setCurrencyCode("USD");
//        paidInvoice.setEquivalence("1.160");
//        paidInvoice.setPartialityNumber(1);
//        paidInvoice.setSubTotal("100.0");
//        paidInvoice.setPreviousBalance("116.00");
//        paidInvoice.setPaymentAmount("116.00");
//        paidInvoice.setRemainingBalance("0.0");
//        paidInvoice.setTaxObjectCode("02");
//
//        // Impuestos de la factura pagada
//        List<PaidInvoiceTax> paidInvoiceTaxes = new ArrayList<>();
//
//        PaidInvoiceTax tax1 = new PaidInvoiceTax();
//        tax1.setTaxCode("002");
//        tax1.setTaxTypeCode("Tasa");
//        tax1.setTaxRate("0.160000");
//        tax1.setTaxFlagCode("T");
//        paidInvoiceTaxes.add(tax1);
//
//        PaidInvoiceTax tax2 = new PaidInvoiceTax();
//        tax2.setTaxCode("002");
//        tax2.setTaxTypeCode("Tasa");
//        tax2.setTaxRate("0.106667");
//        tax2.setTaxFlagCode("R");
//        paidInvoiceTaxes.add(tax2);
//
//        PaidInvoiceTax tax3 = new PaidInvoiceTax();
//        tax3.setTaxCode("001");
//        tax3.setTaxTypeCode("Tasa");
//        tax3.setTaxRate("0.100000");
//        tax3.setTaxFlagCode("R");
//        paidInvoiceTaxes.add(tax3);
//
//        paidInvoice.setPaidInvoiceTaxes(paidInvoiceTaxes);
//        paidInvoices.add(paidInvoice);
//        payment.setPaidInvoices(paidInvoices);
//
//        payments.add(payment);
//        invoice.setPayments(payments);
//
//        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//        System.out.println(apiResponse);


//        // Cancelación de factura por valores. Vea https://docs.fiscalapi.com/catalogs-info#catalogo-de-motivos-de-cancelacion-de-cfdi
//        InvoiceCancellationRequest request = new InvoiceCancellationRequest();
//        request.setInvoiceUuid("ca0758bf-16f6-43c4-b317-8b51fa201d7c");
//        request.setTin("FUNK671228PH6");
//        request.setCancellationReasonCode("01");
//        request.setReplacementUuid("de841944-bd4f-4bb8-adfe-2a2282787c62");
//
//        List<TaxCredential> credentials = new ArrayList<>();
//
//        TaxCredential cer = new TaxCredential();
//        cer.setBase64File(base64Cer);
//        cer.setFileType(0); // 0 = Certificado (.cer)
//        cer.setPassword(password);
//
//        TaxCredential key = new TaxCredential();
//        key.setBase64File(base64Key);
//        key.setFileType(1); // 1 = Clave privada (.key)
//        key.setPassword(password);
//
//        credentials.add(cer);
//        credentials.add(key);
//
//        request.setTaxCredentials(credentials);
//
//        ApiResponse<InvoiceCancellationResponse> apiResponse = client.getInvoiceService().cancel(request);
//        System.out.println(apiResponse);


//        // Cancelación de facturas por valores. Vea https://docs.fiscalapi.com/catalogs-info#catalogo-de-motivos-de-cancelacion-de-cfdi
//        InvoiceCancellationRequest request = new InvoiceCancellationRequest();
//        request.setId("29abb222-5a15-4f6c-876e-cf27be104886");
//        request.setCancellationReasonCode("02");
//        //request.setReplacementUuid("de841944-bd4f-4bb8-adfe-2a2282787c62"); //Obligatorio cuando el motivo de cancelación es 01
//
//        ApiResponse<InvoiceCancellationResponse> apiResponse = client.getInvoiceService().cancel(request);
//        System.out.println(apiResponse);


//        // Consultar situación (status) de una factura por valores
//        InvoiceStatusRequest request = new InvoiceStatusRequest();
//        request.setIssuerTin("POPJ450924HD6");
//        request.setRecipientTin("MEJJ940824C61");
//        request.setInvoiceTotal("430.00");
//        request.setInvoiceUuid("8e0fdc23-e148-4cf5-b3ce-4459f31c9c45");
//        request.setLast8DigitsIssuerSignature("oxPKRg==");
//
//        ApiResponse<InvoiceStatusResponse> apiResponse = client.getInvoiceService().status(request);
//        System.out.println(apiResponse);



//        // Consultar situación (status) de una factura por referencias
//        InvoiceStatusRequest request = new InvoiceStatusRequest();
//        request.setId("b984ce17-05c0-431c-98de-7e28a378d909");
//
//        ApiResponse<InvoiceStatusResponse> apiResponse = client.getInvoiceService().status(request);
//        System.out.println(apiResponse);


//        // Genera PDF de una factura por valores
//        PdfRequest request = new PdfRequest();
//        request.setInvoiceId("96d93ff4-95c6-4381-858a-6551259d17ad");
//        request.setBandColor("#FFA500");
//        request.setFontColor("#FFFFFF");
//        request.setBase64Logo("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");
//
//        ApiResponse<PdfResponse> apiResponse = client.getInvoiceService().getPdf(request);
//        System.out.println(apiResponse);


//        // Genera PDF de una factura por referencias.
//        PdfRequest request = new PdfRequest();
//        request.setInvoiceId("96d93ff4-95c6-4381-858a-6551259d17ad");
//        ApiResponse<PdfResponse> apiResponse = client.getInvoiceService().getPdf(request);
//        System.out.println(apiResponse);



//        // Enviar factura al correo por valores
//        InvoiceEmailRequest request = new InvoiceEmailRequest();
//        request.setInvoiceId("96d93ff4-95c6-4381-858a-6551259d17ad");
//        request.setBandColor("#FFA500");
//        request.setFontColor("#FFFFFF");
//        request.setToEmail("email@domain.com");
//        request.setBase64Logo("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");
//
//        ApiResponse<Boolean> apiResponse = client.getInvoiceService().send(request);
//        System.out.println(apiResponse);


//        // Enviar factura al correo por referencias
//        InvoiceEmailRequest request = new InvoiceEmailRequest("96d93ff4-95c6-4381-858a-6551259d17ad", "soporte@fiscalapi.com");
//
//        ApiResponse<Boolean> apiResponse = client.getInvoiceService().send(request);
//        System.out.println(apiResponse);


//        // Recuperar XML de una factura por id.
//        ApiResponse<XmlResponse> response = client.getInvoiceService().getXml("b984ce17-05c0-431c-98de-7e28a378d909");
//        System.out.println(response);


        //endregion


        // Obtener todos los catálogos de descarga masiva disponibles
        // ApiResponse<List<String>> apiResponse = client.getDownloadCatalogService().getList();
        // System.out.println(apiResponse);


        // Listar los registros del catálogo 'SatInvoiceStatuses' de descarga masiva.
        // ApiResponse<List<CatalogDto>> apiResponse = client.getDownloadCatalogService().listCatalog("SatInvoiceStatuses");
        // System.out.println(apiResponse);


        // Obtener lista paginada de reglas de descarga masiva
        // Send request (pageNumber=1, pageSize=2)
        // ApiResponse<PagedList<DownloadRule>> apiResponse = client.getDownloadRuleService().getList(1, 2);
        // System.out.println(apiResponse);


        // Obtener regla de descarga por ID
        // Send request
        // ApiResponse<DownloadRule> apiResponse = client.getDownloadRuleService().getById("3d5dd474-c025-4183-8ef8-b5a0d863b42c", false);
        // System.out.println(apiResponse);



        // Crear regla de descarga masiva
        // Regla para descargar CFDI recibidos y vigentes
        // DownloadRule request = new DownloadRule();
        // request.setPersonId("b0c1cf6c-153a-464e-99df-5741f45d6695"); // Persona que recibió los CFDI
        // request.setDescription("Regla descarga demo ...");
        // request.setSatQueryTypeId("CFDI");
        // request.setDownloadTypeId("Recibidos");
        //   request.setSatInvoiceStatusId("Vigente");

        // ApiResponse<DownloadRule> apiResponse = client.getDownloadRuleService().create(request);
        // System.out.println(apiResponse);



        // Crear regla de descarga de prueba
        // Send request
        // ApiResponse<DownloadRequest> apiResponse = client.getDownloadRuleService().createTestRule();
        // System.out.println(apiResponse);



        // Actualizar regla de descarga masiva
        // Actualizar descripción
        // DownloadRule request = new DownloadRule();
        // request.setId("");
        // request.setDescription("Regla descarga actualizada");

        // Send request
        // ApiResponse<DownloadRule> apiResponse = client.getDownloadRuleService().update(request);
        // System.out.println(apiResponse);


        // Eliminar regla de descarga masiva
        // Send request
        // ApiResponse<Boolean> apiResponse = client.getDownloadRuleService().delete("ac1ae13b-74e3-4774-90eb-3a050c9841d8");
        // System.out.println(apiResponse);

        // ---------------Solicitudes de descarga masiva -----------------------

        // Obtener lista paginada de solicitudes de descarga masiva
        // Send request (pageNumber=1, pageSize=2)
        // ApiResponse<PagedList<DownloadRequest>> apiResponse = client.getDownloadRequestService().getList(1, 2);
        // System.out.println(apiResponse);



        // Obtener solicitud de descarga por ID
        // ApiResponse<DownloadRequest> apiResponse = client.getDownloadRequestService().getById("1ac351f3-e411-43e9-92bd-e0516516ee2b", true);
        // System.out.println(apiResponse);



        // Listar XMLs por solicitud Id
        // Obtener lista paginada de Xmls descargados asociados a una solicitud de descarga
        // ApiResponse<PagedList<Xml>> apiResponse = client.getDownloadRequestService().getXmls("d97cc2bc-4d7a-43e4-9c6f-1771bcf1d239");
        // System.out.println(apiResponse);



        // Listar meta-items por solicitudId
        // Obtener lista paginada de metadatos descargados asociados a una solicitud de descarga
        // ApiResponse<PagedList<MetadataItem>> apiResponse = client.getDownloadRequestService().getMetadataItems("d97cc2bc-4d7a-43e4-9c6f-1771bcf1d239");
        // System.out.println(apiResponse);



        // Descargar paquete por solicitud ID
        // Descargar paquete (.zip file) de una solicitud de descarga masiva
        // ApiResponse<List<FileResponse>> apiResponse = client.getDownloadRequestService().downloadPackage("d97cc2bc-4d7a-43e4-9c6f-1771bcf1d239");
        // System.out.println(apiResponse);


        // Obtener SAT request por solicitud ID
        // Descargar SAT request (.xml file) de una solicitud de descarga masiva (debug/testing)
        // ApiResponse<FileResponse> apiResponse = client.getDownloadRequestService().downloadSatRequest("d97cc2bc-4d7a-43e4-9c6f-1771bcf1d239");
        // System.out.println(apiResponse);


        // Obtener SAT response por solicitud ID
        // Descargar SAT response (.xml file) de una solicitud de descarga masiva (debug/testing)
        // ApiResponse<FileResponse> apiResponse = client.getDownloadRequestService().downloadSatResponse("d97cc2bc-4d7a-43e4-9c6f-1771bcf1d239");
        // System.out.println(apiResponse);


        // Crear solicitud de descarga masiva
        // Crear solicitud para descargar facturas de los últimos 5 días
        // DownloadRequest request = new DownloadRequest();
        // request.setDownloadRuleId("a339a292-37fe-422e-a28a-f93e6025c72f");
        // request.setDownloadRequestTypeId("Manual");
        // request.setStartDate("2026-02-09T10:00:00");
        // request.setEndDate("2026-02-09T10:00:00");

        // ApiResponse<DownloadRequest> apiResponse = client.getDownloadRequestService().create(request);
        // System.out.println(apiResponse);


        // Eliminar solicitud de descarga masiva
        // ApiResponse<Boolean> apiResponse = client.getDownloadRequestService().delete("097e1674-09bc-433b-829b-19f9661420d3");
        // System.out.println(apiResponse);

        // Buscar solicitud de descarga masiva por fecha de creación
        // ApiResponse<List<DownloadRequest>> apiResponse = client.getDownloadRequestService().search("2026-02-09T10:00:00");
        // System.out.println(apiResponse);

        // region Complemento de nómina
        // Complemento de Nómina

        // Crear nómina ordinaria por valores
        // Emisor
        /*
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("FUNK671228PH6");
        issuer.setLegalName("KARLA FUENTE NOLASCO");
        issuer.setTaxRegimeCode("621");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");

        // Certificados del emisor
        List<TaxCredential> credentials = new ArrayList<>();

        TaxCredential cer = new TaxCredential();
        cer.setBase64File(base64Cer);
        cer.setFileType(0); // 0 = Certificado (.cer)
        cer.setPassword(password);

        TaxCredential key = new TaxCredential();
        key.setBase64File(base64Key);
        key.setFileType(1); // 1 = Clave privada (.key)
        key.setPassword(password);

        credentials.add(cer);
        credentials.add(key);

        issuer.setTaxCredentials(credentials);

        // Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("EKU9003173C9");
        recipient.setLegalName("ESCUELA KEMPER URGATE");
        recipient.setZipCode("42501");
        recipient.setTaxRegimeCode("601");
        recipient.setCfdiUseCode("CP01");
        recipient.setEmail("someone@somewhere.com");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101MNEXXXA8");
        employeeData.setSocialSecurityNumber("04078873454");
        employeeData.setLaborRelationStartDate("2024-08-18");
        employeeData.setSeniority("P54W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatTaxRegimeTypeId("02");
        employeeData.setEmployeeNumber("123456789");
        employeeData.setDepartment("GenAI");
        employeeData.setPosition("Sr Software Engineer");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("05");
        employeeData.setSatBankId("012");
        employeeData.setBaseSalaryForContributions("282.50");
        employeeData.setIntegratedDailySalary("2626.23");
        employeeData.setSatPayrollStateId("JAL");

        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2025-08-30");
        payroll.setInitialPaymentDate("2025-07-31");
        payroll.setFinalPaymentDate("2025-08-30");
        payroll.setDaysPaid(30);
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("1003");
        e1.setConcept("Sueldo nominal");
        e1.setTaxedAmount(95030);
        e1.setExemptAmount(0);

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("005");
        e2.setCode("5913");
        e2.setConcept("Fondo de Ahorro Aportación Patrón");
        e2.setTaxedAmount(0);
        e2.setExemptAmount(0);

        PayrollEarning e3 = new PayrollEarning();
        e3.setEarningTypeCode("038");
        e3.setCode("1885");
        e3.setConcept("Bono Ingles");
        e3.setTaxedAmount("14254.50");
        e3.setExemptAmount(0);

        PayrollEarning e4 = new PayrollEarning();
        e4.setEarningTypeCode("029");
        e4.setCode("1941");
        e4.setConcept("Vales Despensa");
        e4.setTaxedAmount(0);
        e4.setExemptAmount(3439);

        PayrollEarning e5 = new PayrollEarning();
        e5.setEarningTypeCode("038");
        e5.setCode("1824");
        e5.setConcept("Herramientas Teletrabajo (telecom y prop. electri)");
        e5.setTaxedAmount(273);
        e5.setExemptAmount(0);

        PayrollEarning e6 = new PayrollEarning();
        e6.setEarningTypeCode("002");
        e6.setCode("5050");
        e6.setConcept("Exceso de subsidio al empleo");
        e6.setTaxedAmount(0);
        e6.setExemptAmount(0);

        earnings.add(e1);
        earnings.add(e2);
        earnings.add(e3);
        earnings.add(e4);
        earnings.add(e5);
        earnings.add(e6);

        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();
        PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
        op1.setOtherPaymentCode("002");
        op1.setCode("5050");
        op1.setConcept("exceso de subsidio al empleo");
        op1.setAmount(0);
        op1.setSubsidyCaused(0);

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("002");
        d1.setCode("5003");
        d1.setConcept("ISR Causado");
        d1.setAmount(27645);

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("004");
        d2.setCode("5910");
        d2.setConcept("Fondo de ahorro Empleado Inversión");
        d2.setAmount("4412.46");

        PayrollDeduction d3 = new PayrollDeduction();
        d3.setDeductionTypeCode("004");
        d3.setCode("5914");
        d3.setConcept("Fondo de Ahorro Patrón Inversión");
        d3.setAmount("4412.46");

        PayrollDeduction d4 = new PayrollDeduction();
        d4.setDeductionTypeCode("004");
        d4.setCode("1966");
        d4.setConcept("Contribución póliza exceso GMM");
        d4.setAmount("519.91");

        PayrollDeduction d5 = new PayrollDeduction();
        d5.setDeductionTypeCode("004");
        d5.setCode("1934");
        d5.setConcept("Descuento Vales Despensa");
        d5.setAmount(1);

        PayrollDeduction d6 = new PayrollDeduction();
        d6.setDeductionTypeCode("004");
        d6.setCode("1942");
        d6.setConcept("Vales Despensa Electrónico");
        d6.setAmount(3439);

        PayrollDeduction d7 = new PayrollDeduction();
        d7.setDeductionTypeCode("001");
        d7.setCode("1895");
        d7.setConcept("IMSS");
        d7.setAmount("2391.13");

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);
        payrollDeductions.add(d3);
        payrollDeductions.add(d4);
        payrollDeductions.add(d5);
        payrollDeductions.add(d6);
        payrollDeductions.add(d7);

        payroll.setDeductions(payrollDeductions);

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setDate("2026-02-09T10:00:00");
        invoice.setPaymentMethodCode("PUE");
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
        System.out.println(apiResponse);

        // Nómina ordinaria por referencias
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

        List<TaxCredential> credentials = new ArrayList<>();

        TaxCredential cer = new TaxCredential();
        cer.setBase64File(base64Cer);
        cer.setFileType(0);
        cer.setPassword(password);

        TaxCredential key = new TaxCredential();
        key.setBase64File(base64Key);
        key.setFileType(1);
        key.setPassword(password);

        credentials.add(cer);
        credentials.add(key);

        issuer.setTaxCredentials(credentials);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("da71df0c-f328-45ee-9bd9-3096ed02c164");

        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2025-08-30T00:00:00");
        payroll.setInitialPaymentDate("2025-07-31T00:00:00");
        payroll.setFinalPaymentDate("2025-08-30T00:00:00");
        payroll.setDaysPaid(30);
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("1003");
        e1.setConcept("Sueldo nominal");
        e1.setTaxedAmount("95030");
        e1.setExemptAmount("0");

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("005");
        e2.setCode("5913");
        e2.setConcept("Fondo de Ahorro Aportación Patrón");
        e2.setTaxedAmount("0");
        e2.setExemptAmount("4412.46");

        PayrollEarning e3 = new PayrollEarning();
        e3.setEarningTypeCode("038");
        e3.setCode("1885");
        e3.setConcept("Bono Ingles");
        e3.setTaxedAmount("14254.50");
        e3.setExemptAmount("0");

        PayrollEarning e4 = new PayrollEarning();
        e4.setEarningTypeCode("029");
        e4.setCode("1941");
        e4.setConcept("Vales Despensa");
        e4.setTaxedAmount("0");
        e4.setExemptAmount("3439");

        PayrollEarning e5 = new PayrollEarning();
        e5.setEarningTypeCode("038");
        e5.setCode("1824");
        e5.setConcept("Herramientas Teletrabajo (telecom y prop. electri)");
        e5.setTaxedAmount("273");
        e5.setExemptAmount("0");

        earnings.add(e1);
        earnings.add(e2);
        earnings.add(e3);
        earnings.add(e4);
        earnings.add(e5);

        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();
        PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
        op1.setOtherPaymentTypeCode("002");
        op1.setCode("5050");
        op1.setConcept("exceso de subsidio al empleo");
        op1.setAmount("0");
        op1.setSubsidyCaused("0");
        otherPayments.add(op1);

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);
        payroll.setEarnings(payrollEarnings);

        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("002");
        d1.setCode("5003");
        d1.setConcept("ISR Causado");
        d1.setAmount("27645.00");

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("004");
        d2.setCode("5910");
        d2.setConcept("Fondo de ahorro Empleado Inversión");
        d2.setAmount("4412.46");

        PayrollDeduction d3 = new PayrollDeduction();
        d3.setDeductionTypeCode("004");
        d3.setCode("5914");
        d3.setConcept("Fondo de Ahorro Patrón Inversión");
        d3.setAmount("4412.46");

        PayrollDeduction d4 = new PayrollDeduction();
        d4.setDeductionTypeCode("004");
        d4.setCode("1966");
        d4.setConcept("Contribución póliza exceso GMM");
        d4.setAmount("519.91");

        PayrollDeduction d5 = new PayrollDeduction();
        d5.setDeductionTypeCode("004");
        d5.setCode("1934");
        d5.setConcept("Descuento Vales Despensa");
        d5.setAmount("1.00");

        PayrollDeduction d6 = new PayrollDeduction();
        d6.setDeductionTypeCode("004");
        d6.setCode("1942");
        d6.setConcept("Vales Despensa Electrónico");
        d6.setAmount("3439.00");

        PayrollDeduction d7 = new PayrollDeduction();
        d7.setDeductionTypeCode("001");
        d7.setCode("1895");
        d7.setConcept("IMSS");
        d7.setAmount("2391.13");

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);
        payrollDeductions.add(d3);
        payrollDeductions.add(d4);
        payrollDeductions.add(d5);
        payrollDeductions.add(d6);
        payrollDeductions.add(d7);

        payroll.setDeductions(payrollDeductions);
        Complement complement = new Complement();
        complement.setPayroll(payroll);

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00");
        invoice.setTypeCode("N");
        invoice.setExpeditionZipCode("20000");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setDate("2026-02-09T10:00:00");
        invoice.setPaymentMethodCode("PUE");
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
        System.out.println(apiResponse);

        // Nómina asimilados por valores
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setOriginEmployerTin("EKU9003173C9");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("CACX7605101P8");
        recipient.setLegalName("XOCHILT CASAS CHAVEZ");
        recipient.setZipCode("36257");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSatContractTypeId("09");
        employeeData.setSatUnionizedStatusId("No");
        employeeData.setSatTaxRegimeTypeId("09");
        employeeData.setEmployeeNumber("00002");
        employeeData.setDepartment("ADMINISTRACION");
        employeeData.setPosition("DIRECTOR DE ADMINISTRACION");
        employeeData.setSatPaymentPeriodicityId("99");
        employeeData.setSatBankId("012");
        employeeData.setBankAccount("1111111111");
        employeeData.setSatPayrollStateId("CMX");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("E");
        payroll.setPaymentDate("2023-06-02T00:00:00");
        payroll.setInitialPaymentDate("2023-06-01T00:00:00");
        payroll.setFinalPaymentDate("2023-06-02T00:00:00");
        payroll.setDaysPaid(1);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("046");
        e1.setCode("010046");
        e1.setConcept("INGRESOS ASIMILADOS A SALARIOS");
        e1.setTaxedAmount("111197.73");
        e1.setExemptAmount("0.00");

        earnings.add(e1);

        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("002");
        d1.setCode("020002");
        d1.setConcept("ISR");
        d1.setAmount("36197.73");

        payrollDeductions.add(d1);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("06880");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina asimilados por referencias
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

        List<TaxCredential> credentials = new ArrayList<>();

        TaxCredential cer = new TaxCredential();
        cer.setBase64File(base64Cer);
        cer.setFileType(0);
        cer.setPassword(password);

        TaxCredential key = new TaxCredential();
        key.setBase64File(base64Key);
        key.setFileType(1);
        key.setPassword(password);

        credentials.add(cer);
        credentials.add(key);

        issuer.setTaxCredentials(credentials);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("da71df0c-f328-45ee-9bd9-3096ed02c164");

        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("E");
        payroll.setPaymentDate("2023-06-02T00:00:00");
        payroll.setInitialPaymentDate("2023-06-01T00:00:00");
        payroll.setFinalPaymentDate("2023-06-02T00:00:00");
        payroll.setDaysPaid(1);

        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("046");
        e1.setCode("010046");
        e1.setConcept("INGRESOS ASIMILADOS A SALARIOS");
        e1.setTaxedAmount("111197.73");
        e1.setExemptAmount("0.00");

        earnings.add(e1);

        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("002");
        d1.setCode("020002");
        d1.setConcept("ISR");
        d1.setAmount("36197.73");

        payrollDeductions.add(d1);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

        Complement complement = new Complement();
        complement.setPayroll(payroll);

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00");
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("06880");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        //Nómina con bonos fondo de ahorro y deducciones
        // Emisor
        /*
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("Z0000001234");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101MNEXXXA8");
        employeeData.setSocialSecurityNumber("0000000000");
        employeeData.setLaborRelationStartDate("2022-03-02T00:00:00");
        employeeData.setSeniority("P66W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatUnionizedStatusId("No");
        employeeData.setSatTaxRegimeTypeId("02");
        employeeData.setEmployeeNumber("111111");
        employeeData.setSatJobRiskId("4");
        employeeData.setSatPaymentPeriodicityId("02");
        employeeData.setIntegratedDailySalary("180.96");
        employeeData.setSatPayrollStateId("GUA");

// Items
        List<InvoiceItem> items = new ArrayList<>();

        InvoiceItem item1 = new InvoiceItem();
        item1.setItemCode("84111505");
        item1.setItemSku("84111505");
        item1.setQuantity(1);
        item1.setUnitOfMeasurementCode("ACT");
        item1.setDescription("Pago de nómina");
        item1.setUnitPrice("1842.82");
        item1.setDiscount("608.71");
        item1.setTaxObjectCode("01");

        items.add(item1);

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-06-11T00:00:00");
        payroll.setInitialPaymentDate("2023-06-05T00:00:00");
        payroll.setFinalPaymentDate("2023-06-11T00:00:00");
        payroll.setDaysPaid(7);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("SP01");
        e1.setConcept("SUELDO");
        e1.setTaxedAmount("1210.30");
        e1.setExemptAmount("0.00");

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("010");
        e2.setCode("SP02");
        e2.setConcept("PREMIO PUNTUALIDAD");
        e2.setTaxedAmount("121.03");
        e2.setExemptAmount("0.00");

        PayrollEarning e3 = new PayrollEarning();
        e3.setEarningTypeCode("029");
        e3.setCode("SP03");
        e3.setConcept("MONEDERO ELECTRONICO");
        e3.setTaxedAmount("0.00");
        e3.setExemptAmount("269.43");

        PayrollEarning e4 = new PayrollEarning();
        e4.setEarningTypeCode("010");
        e4.setCode("SP04");
        e4.setConcept("PREMIO DE ASISTENCIA");
        e4.setTaxedAmount("121.03");
        e4.setExemptAmount("0.00");

        PayrollEarning e5 = new PayrollEarning();
        e5.setEarningTypeCode("005");
        e5.setCode("SP54");
        e5.setConcept("APORTACION FONDO AHORRO");
        e5.setTaxedAmount("0.00");
        e5.setExemptAmount("121.03");

        earnings.add(e1);
        earnings.add(e2);
        earnings.add(e3);
        earnings.add(e4);
        earnings.add(e5);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
        op1.setOtherPaymentTypeCode("002");
        op1.setCode("ISRSUB");
        op1.setConcept("Subsidio ISR para empleo");
        op1.setAmount("0.0");
        op1.setSubsidyCaused("0.0");

        BalanceCompensation balanceCompensation = new BalanceCompensation();
        balanceCompensation.setFavorableBalance("0.0");
        balanceCompensation.setYear(2022);
        balanceCompensation.setRemainingFavorableBalance("0.0");

        op1.setBalanceCompensation(balanceCompensation);

        otherPayments.add(op1);

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("004");
        d1.setCode("ZA09");
        d1.setConcept("APORTACION FONDO AHORRO");
        d1.setAmount("121.03");

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("002");
        d2.setCode("ISR");
        d2.setConcept("ISR");
        d2.setAmount("36.57");

        PayrollDeduction d3 = new PayrollDeduction();
        d3.setDeductionTypeCode("001");
        d3.setCode("IMSS");
        d3.setConcept("Cuota de Seguridad Social EE");
        d3.setAmount("30.08");

        PayrollDeduction d4 = new PayrollDeduction();
        d4.setDeductionTypeCode("004");
        d4.setCode("ZA68");
        d4.setConcept("DEDUCCION FDO AHORRO PAT");
        d4.setAmount("121.03");

        PayrollDeduction d5 = new PayrollDeduction();
        d5.setDeductionTypeCode("018");
        d5.setCode("ZA11");
        d5.setConcept("APORTACION CAJA AHORRO");
        d5.setAmount("300.00");

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);
        payrollDeductions.add(d3);
        payrollDeductions.add(d4);
        payrollDeductions.add(d5);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setItems(items);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina con horas extra por referencias
        // Emisor
        /*
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

        List<TaxCredential> credentials = new ArrayList<>();

        TaxCredential cer = new TaxCredential();
        cer.setBase64File(base64Cer);
        cer.setFileType(0);
        cer.setPassword(password);

        TaxCredential key = new TaxCredential();
        key.setBase64File(base64Key);
        key.setFileType(1);
        key.setPassword(password);

        credentials.add(cer);
        credentials.add(key);

        issuer.setTaxCredentials(credentials);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("da71df0c-f328-45ee-9bd9-3096ed02c164");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01");
        employeeData.setSeniority("P437W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("019");
        e2.setCode("00100");
        e2.setConcept("Horas Extra");
        e2.setTaxedAmount("50.00");
        e2.setExemptAmount("50.00");

        List<PayrollEarningOvertime> overtimeList = new ArrayList<>();
        PayrollEarningOvertime overtime1 = new PayrollEarningOvertime();
        overtime1.setDays(1);
        overtime1.setHoursTypeCode("01");
        overtime1.setExtraHours(2);
        overtime1.setAmountPaid("100.00");
        overtimeList.add(overtime1);

        e2.setOvertime(overtimeList);

        earnings.add(e1);
        earnings.add(e2);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("001");
        d1.setCode("00301");
        d1.setConcept("Seguridad Social");
        d1.setAmount(200);

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("002");
        d2.setCode("00302");
        d2.setConcept("ISR");
        d2.setAmount(100);

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        //Nómina con horas extra
        // Emisor
        /*
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01");
        employeeData.setSeniority("P437W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("019");
        e2.setCode("00100");
        e2.setConcept("Horas Extra");
        e2.setTaxedAmount("50.00");
        e2.setExemptAmount("50.00");

        List<PayrollEarningOvertime> overtimeList = new ArrayList<>();
        PayrollEarningOvertime overtime1 = new PayrollEarningOvertime();
        overtime1.setDays(1);
        overtime1.setHoursTypeCode("01");
        overtime1.setExtraHours(2);
        overtime1.setAmountPaid("100.00");
        overtimeList.add(overtime1);

        e2.setOvertime(overtimeList);

        earnings.add(e1);
        earnings.add(e2);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("001");
        d1.setCode("00301");
        d1.setConcept("Seguridad Social");
        d1.setAmount(200);

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("002");
        d2.setCode("00302");
        d2.setConcept("ISR");
        d2.setAmount(100);

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);


        // Nómina con incapacidades
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
        employeeData.setSeniority("P437W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("001");
        d1.setCode("00301");
        d1.setConcept("Seguridad Social");
        d1.setAmount(200);

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("002");
        d2.setCode("00302");
        d2.setConcept("ISR");
        d2.setAmount(100);

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);

// Disabilities
        List<PayrollDisability> disabilities = new ArrayList<>();

        PayrollDisability disability1 = new PayrollDisability();
        disability1.setDisabilityDays(1);
        disability1.setDisabilityTypeCode("01");

        disabilities.add(disability1);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);
        payroll.setDisabilities(disabilities);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        //Nómina con incapacidades por referencias
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("bef56254-0892-4558-95c3-f9c8729e4b0e");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("54fc14ae-c88f-4afc-996b-0574d63341e2");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("001");
        d1.setCode("00301");
        d1.setConcept("Seguridad Social");
        d1.setAmount("200.00");

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("002");
        d2.setCode("00302");
        d2.setConcept("ISR");
        d2.setAmount("100.00");

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);

// Disabilities
        List<PayrollDisability> disabilities = new ArrayList<>();

        PayrollDisability disability1 = new PayrollDisability();
        disability1.setDisabilityDays(1);
        disability1.setDisabilityTypeCode("01");

        disabilities.add(disability1);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);
        payroll.setDisabilities(disabilities);

        Complement complement = new Complement();
        complement.setPayroll(payroll);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        //Nómina con SNCF
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("OÑO120726RX3");
        issuer.setLegalName("ORGANICOS ÑAVEZ OSORIO");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("27112029");
        employerData.setSatFundSourceId("IP");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("CACX7605101P8");
        recipient.setLegalName("XOCHILT CASAS CHAVEZ");
        recipient.setZipCode("36257");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("80997742673");
        employeeData.setLaborRelationStartDate("2021-09-01");
        employeeData.setSeniority("P88W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatTaxRegimeTypeId("02");
        employeeData.setEmployeeNumber("273");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setIntegratedDailySalary("221.48");
        employeeData.setSatPayrollStateId("GRO");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-16T00:00:00");
        payroll.setInitialPaymentDate("2023-05-01T00:00:00");
        payroll.setFinalPaymentDate("2023-05-16T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("P001");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("3322.20");
        e1.setExemptAmount("0.0");

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("038");
        e2.setCode("P540");
        e2.setConcept("Compensacion");
        e2.setTaxedAmount("100.0");
        e2.setExemptAmount("0.0");

        PayrollEarning e3 = new PayrollEarning();
        e3.setEarningTypeCode("038");
        e3.setCode("P550");
        e3.setConcept("Compensación Garantizada Extraordinaria");
        e3.setTaxedAmount("2200.0");
        e3.setExemptAmount("0.0");

        PayrollEarning e4 = new PayrollEarning();
        e4.setEarningTypeCode("038");
        e4.setCode("P530");
        e4.setConcept("Servicio Extraordinario");
        e4.setTaxedAmount("200.0");
        e4.setExemptAmount("0.0");

        PayrollEarning e5 = new PayrollEarning();
        e5.setEarningTypeCode("001");
        e5.setCode("P506");
        e5.setConcept("Otras Prestaciones");
        e5.setTaxedAmount("1500.0");
        e5.setExemptAmount("0.0");

        PayrollEarning e6 = new PayrollEarning();
        e6.setEarningTypeCode("001");
        e6.setCode("P505");
        e6.setConcept("Remuneración al Desempeño Legislativo");
        e6.setTaxedAmount("17500.0");
        e6.setExemptAmount("0.0");

        earnings.add(e1);
        earnings.add(e2);
        earnings.add(e3);
        earnings.add(e4);
        earnings.add(e5);
        earnings.add(e6);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
        op1.setOtherPaymentTypeCode("002");
        op1.setCode("o002");
        op1.setConcept("Subsidio para el empleo efectivamente entregado al trabajador");
        op1.setAmount("0.0");
        op1.setSubsidyCaused("0.0");

        otherPayments.add(op1);

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("002");
        d1.setCode("D002");
        d1.setConcept("ISR");
        d1.setAmount("4716.61");

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("004");
        d2.setCode("D525");
        d2.setConcept("Redondeo");
        d2.setAmount("0.81");

        PayrollDeduction d3 = new PayrollDeduction();
        d3.setDeductionTypeCode("001");
        d3.setCode("D510");
        d3.setConcept("Cuota Trabajador ISSSTE");
        d3.setAmount("126.78");

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);
        payrollDeductions.add(d3);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("39074");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        //Nómina con SNCF por referencias
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("ab7ec306-6f81-4f9f-b55f-bbbb1ab2f153");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("acf43966-4672-48b6-a01a-d04cac6c3d64");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-16T00:00:00");
        payroll.setInitialPaymentDate("2023-05-01T00:00:00");
        payroll.setFinalPaymentDate("2023-05-16T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("P001");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("3322.20");
        e1.setExemptAmount("0");

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("038");
        e2.setCode("P540");
        e2.setConcept("Compensacion");
        e2.setTaxedAmount("100.00");
        e2.setExemptAmount("0");

        PayrollEarning e3 = new PayrollEarning();
        e3.setEarningTypeCode("038");
        e3.setCode("P550");
        e3.setConcept("Compensación Garantizada Extraordinaria");
        e3.setTaxedAmount("2200.00");
        e3.setExemptAmount("0");

        PayrollEarning e4 = new PayrollEarning();
        e4.setEarningTypeCode("038");
        e4.setCode("P530");
        e4.setConcept("Servicio Extraordinario");
        e4.setTaxedAmount("200.00");
        e4.setExemptAmount("0");

        PayrollEarning e5 = new PayrollEarning();
        e5.setEarningTypeCode("001");
        e5.setCode("P506");
        e5.setConcept("Otras Prestaciones");
        e5.setTaxedAmount("1500.00");
        e5.setExemptAmount("0");

        PayrollEarning e6 = new PayrollEarning();
        e6.setEarningTypeCode("001");
        e6.setCode("P505");
        e6.setConcept("Remuneración al Desempeño Legislativo");
        e6.setTaxedAmount("17500.00");
        e6.setExemptAmount("0");

        earnings.add(e1);
        earnings.add(e2);
        earnings.add(e3);
        earnings.add(e4);
        earnings.add(e5);
        earnings.add(e6);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
        op1.setOtherPaymentTypeCode("002");
        op1.setCode("002");
        op1.setConcept("Subsidio para el empleo efectivamente entregado al trabajador");
        op1.setAmount("0");
        op1.setSubsidyCaused("0");

        otherPayments.add(op1);

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("002");
        d1.setCode("D002");
        d1.setConcept("ISR");
        d1.setAmount("4716.61");

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("004");
        d2.setCode("D525");
        d2.setConcept("Redondeo");
        d2.setAmount("0.81");

        PayrollDeduction d3 = new PayrollDeduction();
        d3.setDeductionTypeCode("001");
        d3.setCode("D510");
        d3.setConcept("Cuota Trabajador ISSSTE");
        d3.setAmount("126.78");

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);
        payrollDeductions.add(d3);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

        Complement complement = new Complement();
        complement.setPayroll(payroll);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("39074");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina extraordinaria
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01");
        employeeData.setSeniority("P439W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("99");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("E");
        payroll.setPaymentDate("2023-06-04T00:00:00");
        payroll.setInitialPaymentDate("2023-06-04T00:00:00");
        payroll.setFinalPaymentDate("2023-06-04T00:00:00");
        payroll.setDaysPaid(30);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("002");
        e1.setCode("00500");
        e1.setConcept("Gratificación Anual (Aguinaldo)");
        e1.setTaxedAmount("0.00");
        e1.setExemptAmount("10000.00");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions (empty list)
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        Nómina extraordinaria por referencias
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("bef56254-0892-4558-95c3-f9c8729e4b0e");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("54fc14ae-c88f-4afc-996b-0574d63341e2");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("E");
        payroll.setPaymentDate("2023-06-04T00:00:00");
        payroll.setInitialPaymentDate("2023-06-04T00:00:00");
        payroll.setFinalPaymentDate("2023-06-04T00:00:00");
        payroll.setDaysPaid(30);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("002");
        e1.setCode("00500");
        e1.setConcept("Gratificación Anual (Aguinaldo)");
        e1.setTaxedAmount("0.00");
        e1.setExemptAmount("10000.00");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions (empty list)
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

        Complement complement = new Complement();
        complement.setPayroll(payroll);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina separacion indemnización
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01");
        employeeData.setSeniority("P439W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("99");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("E");
        payroll.setPaymentDate("2023-06-04T00:00:00");
        payroll.setInitialPaymentDate("2023-05-05T00:00:00");
        payroll.setFinalPaymentDate("2023-06-04T00:00:00");
        payroll.setDaysPaid(30);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("023");
        e1.setCode("00500");
        e1.setConcept("Pagos por separación");
        e1.setTaxedAmount("0.00");
        e1.setExemptAmount("10000.00");

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("025");
        e2.setCode("00900");
        e2.setConcept("Indemnizaciones");
        e2.setTaxedAmount("0.00");
        e2.setExemptAmount("500.00");

        earnings.add(e1);
        earnings.add(e2);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

// Severance
        PayrollSeverance severance = new PayrollSeverance();
        severance.setTotalPaid("10500.00");
        severance.setYearsOfService(1);
        severance.setLastMonthlySalary("10000.00");
        severance.setAccumulableIncome("10000.00");
        severance.setNonAccumulableIncome("0.00");

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);
        payrollEarnings.setSeverance(severance);

// Deductions (empty list)
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        // Nómina separacion indemnización por referencias
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

        // Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("aa2ad8c3-6ec5-4601-91be-d827d9a865bc");
        

        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("E");
        payroll.setPaymentDate("2023-06-04T00:00:00");
        payroll.setInitialPaymentDate("2023-06-04T00:00:00");
        payroll.setFinalPaymentDate("2023-06-04T00:00:00");
        payroll.setDaysPaid(30);
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("023");
        e1.setCode("00500");
        e1.setConcept("Pagos por separación");
        e1.setTaxedAmount("0");
        e1.setExemptAmount("10000.0");

        PayrollEarning e2 = new PayrollEarning();
        e2.setEarningTypeCode("025");
        e2.setCode("00900");
        e2.setConcept("Indemnizaciones");
        e2.setTaxedAmount("0");
        e2.setExemptAmount("500.0");

        earnings.add(e1);
        earnings.add(e2);

        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();
        PayrollSeverance severance = new PayrollSeverance();
        severance.setTotalPaid("10500.00");
        severance.setYearsOfService(1);
        severance.setLastMonthlySalary("10000.00");
        severance.setAccumulableIncome("10000.00");
        severance.setNonAccumulableIncome("0");

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);
        payrollEarnings.setSeverance(severance);
        payroll.setEarnings(payrollEarnings);

        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        payroll.setDeductions(payrollDeductions);
        Complement complement = new Complement();
        complement.setPayroll(payroll);

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00");
        invoice.setTypeCode("N");
        invoice.setExpeditionZipCode("20000");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setDate("2026-02-09T10:00:00");
        invoice.setPaymentMethodCode("PUE");
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
        System.out.println(apiResponse);

        // Nómina jubilación
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01");
        employeeData.setSeniority("P439W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("99");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("E");
        payroll.setPaymentDate("2023-05-05T00:00:00");
        payroll.setInitialPaymentDate("2023-06-04T00:00:00");
        payroll.setFinalPaymentDate("2023-06-04T00:00:00");
        payroll.setDaysPaid(30);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("039");
        e1.setCode("00500");
        e1.setConcept("Jubilaciones, pensiones o haberes de retiro");
        e1.setTaxedAmount("0.00");
        e1.setExemptAmount("10000.00");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

// Retirement
        PayrollRetirement retirement = new PayrollRetirement();
        retirement.setTotalOneTime("10000.00");
        retirement.setAccumulableIncome("10000.00");
        retirement.setNonAccumulableIncome("0.00");

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);
        payrollEarnings.setRetirement(retirement);

// Deductions (empty list)
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina jubilación por referencias
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("bef56254-0892-4558-95c3-f9c8729e4b0e");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("54fc14ae-c88f-4afc-996b-0574d63341e2");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("E");
        payroll.setPaymentDate("2023-05-05T00:00:00");
        payroll.setInitialPaymentDate("2023-06-04T00:00:00");
        payroll.setFinalPaymentDate("2023-06-04T00:00:00");
        payroll.setDaysPaid(30);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("039");
        e1.setCode("00500");
        e1.setConcept("Jubilaciones, pensiones o haberes de retiro");
        e1.setTaxedAmount("0.00");
        e1.setExemptAmount("10000.00");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

// Retirement
        PayrollRetirement retirement = new PayrollRetirement();
        retirement.setTotalOneTime("10000.00");
        retirement.setAccumulableIncome("10000.00");
        retirement.setNonAccumulableIncome("0.00");

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);
        payrollEarnings.setRetirement(retirement);

// Deductions (empty list)
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

        Complement complement = new Complement();
        complement.setPayroll(payroll);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina sin deducciones
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01");
        employeeData.setSeniority("P437W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions (empty list)
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        //Nómina sin deducciones por referencias
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("bef56254-0892-4558-95c3-f9c8729e4b0e");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("54fc14ae-c88f-4afc-996b-0574d63341e2");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions (empty list)
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

        Complement complement = new Complement();
        complement.setPayroll(payroll);
// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina viáticos
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
        employeeData.setSeniority("P438W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-09-26T00:00:00");
        payroll.setInitialPaymentDate("2023-09-11T00:00:00");
        payroll.setFinalPaymentDate("2023-09-26T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("050");
        e1.setCode("050");
        e1.setConcept("Viaticos");
        e1.setTaxedAmount(0);
        e1.setExemptAmount(3000);

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("081");
        d1.setCode("081");
        d1.setConcept("Ajuste en viaticos entregados al trabajador");
        d1.setAmount(3000);

        payrollDeductions.add(d1);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina viáticos por referencias
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("54fc14ae-c88f-4afc-996b-0574d63341e2");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-09-26T00:00:00");
        payroll.setInitialPaymentDate("2023-09-11T00:00:00");
        payroll.setFinalPaymentDate("2023-09-26T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("050");
        e1.setCode("050");
        e1.setConcept("Viaticos");
        e1.setTaxedAmount("0");
        e1.setExemptAmount("3000");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("081");
        d1.setCode("081");
        d1.setConcept("Ajuste en viaticos entregados al trabajador");
        d1.setAmount("3000.00");

        payrollDeductions.add(d1);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

        Complement complement = new Complement();
        complement.setPayroll(payroll);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina subsidio causado al empleo
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
        employeeData.setSeniority("P437W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("0aa2ad8c3-6ec5-4601-91be-d827d9a865bc2");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
        op1.setOtherPaymentTypeCode("007");
        op1.setCode("0002");
        op1.setConcept("ISR ajustado por subsidio");
        op1.setAmount("145.80");
        op1.setSubsidyCaused("0.0");

        otherPayments.add(op1);

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("107");
        d1.setCode("D002");
        d1.setConcept("Ajuste al Subsidio Causado");
        d1.setAmount("160.35");

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("002");
        d2.setCode("D002");
        d2.setConcept("ISR");
        d2.setAmount("145.80");

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        //Nómina subsidio causado al empleo por referencias
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("bef56254-0892-4558-95c3-f9c8729e4b0e");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId("54fc14ae-c88f-4afc-996b-0574d63341e2");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
        op1.setOtherPaymentTypeCode("007");
        op1.setCode("0002");
        op1.setConcept("ISR ajustado por subsidio");
        op1.setAmount("145.80");
        op1.setSubsidyCaused("0.0");

        otherPayments.add(op1);

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("107");
        d1.setCode("D002");
        d1.setConcept("Ajuste al Subsidio Causado");
        d1.setAmount("160.35");

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("002");
        d2.setCode("D002");
        d2.setConcept("ISR");
        d2.setAmount("145.80");

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

        Complement complement = new Complement();
        complement.setPayroll(payroll);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);

        // Nómina
        // Emisor
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

        EmployerData employerData = new EmployerData();
        employerData.setEmployerRegistration("B5510768108");
        employerData.setOriginEmployerTin("URE180429TM6");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XOJI740919U48");
        recipient.setLegalName("INGRID XODAR JIMENEZ");
        recipient.setZipCode("76028");
        recipient.setTaxRegimeCode("605");
        recipient.setCfdiUseCode("CN01");

        EmployeeData employeeData = new EmployeeData();
        employeeData.setCurp("XEXX010101HNEXXXA4");
        employeeData.setSocialSecurityNumber("000000");
        employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
        employeeData.setSeniority("P437W");
        employeeData.setSatContractTypeId("01");
        employeeData.setSatWorkdayTypeId("01");
        employeeData.setSatTaxRegimeTypeId("03");
        employeeData.setEmployeeNumber("120");
        employeeData.setDepartment("Desarrollo");
        employeeData.setPosition("Ingeniero de Software");
        employeeData.setSatJobRiskId("1");
        employeeData.setSatPaymentPeriodicityId("04");
        employeeData.setSatBankId("002");
        employeeData.setBankAccount("1111111111");
        employeeData.setBaseSalaryForContributions("490.22");
        employeeData.setIntegratedDailySalary("146.47");
        employeeData.setSatPayrollStateId("JAL");

// Payroll
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setPaymentDate("2023-05-24T00:00:00");
        payroll.setInitialPaymentDate("2023-05-09T00:00:00");
        payroll.setFinalPaymentDate("2023-05-24T00:00:00");
        payroll.setDaysPaid(15);

// Earnings
        PayrollEarnings payrollEarnings = new PayrollEarnings();
        List<PayrollEarning> earnings = new ArrayList<>();

        PayrollEarning e1 = new PayrollEarning();
        e1.setEarningTypeCode("001");
        e1.setCode("00500");
        e1.setConcept("Sueldos, Salarios Rayas y Jornales");
        e1.setTaxedAmount("2808.8");
        e1.setExemptAmount("2191.2");

        earnings.add(e1);

// Other Payments
        List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

        payrollEarnings.setEarnings(earnings);
        payrollEarnings.setOtherPayments(otherPayments);

// Deductions
        List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        PayrollDeduction d1 = new PayrollDeduction();
        d1.setDeductionTypeCode("001");
        d1.setCode("00301");
        d1.setConcept("Seguridad Social");
        d1.setAmount(200);

        PayrollDeduction d2 = new PayrollDeduction();
        d2.setDeductionTypeCode("002");
        d2.setCode("00302");
        d2.setConcept("ISR");
        d2.setAmount(100);

        payrollDeductions.add(d1);
        payrollDeductions.add(d2);

        payroll.setEarnings(payrollEarnings);
        payroll.setDeductions(payrollDeductions);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setTypeCode("N");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setExpeditionZipCode("20000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setComplement(invoice.getComplement());

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);
         */

        //Complemento Impuestos locales
        //Ingreso Impuestos locales
        // Emisor
        /*
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("EKU9003173C9");
        recipient.setLegalName("ESCUELA KEMPER URGATE");
        recipient.setZipCode("42501");
        recipient.setTaxRegimeCode("601");
        recipient.setCfdiUseCode("G01");
        recipient.setEmail("someone@somewhere.com");

// Items
        List<InvoiceItem> items = new ArrayList<>();

// Item 1
        InvoiceItem item1 = new InvoiceItem();
        item1.setItemCode("01010101");
        item1.setQuantity("9.5");
        item1.setUnitOfMeasurementCode("E48");
        item1.setUnitOfMeasurement("Unidad de servicio");
        item1.setDescription("Invoicing software as a service");
        item1.setUnitPrice("3587.75");
        item1.setTaxObjectCode("02");
        item1.setItemSku("7506022301697");
        item1.setDiscount("255.85");

        List<ItemTax> taxes1 = new ArrayList<>();
        ItemTax tax1 = new ItemTax();
        tax1.setTaxCode("002");
        tax1.setTaxTypeCode("Tasa");
        tax1.setTaxRate("0.160000");
        tax1.setTaxFlagCode("T");
        taxes1.add(tax1);

        item1.setItemTaxes(taxes1);

// Item 2
        InvoiceItem item2 = new InvoiceItem();
        item2.setItemCode("01010101");
        item2.setQuantity("8.0");
        item2.setUnitOfMeasurementCode("E48");
        item2.setUnitOfMeasurement("Unidad de servicio2");
        item2.setDescription("Software Consultant");
        item2.setUnitPrice("250.85");
        item2.setTaxObjectCode("02");
        item2.setItemSku("7506022301698");
        item2.setDiscount("255.85");

        List<ItemTax> taxes2 = new ArrayList<>();
        ItemTax tax2 = new ItemTax();
        tax2.setTaxCode("002");
        tax2.setTaxTypeCode("Tasa");
        tax2.setTaxRate("0.160000");
        tax2.setTaxFlagCode("T");
        taxes2.add(tax2);

        item2.setItemTaxes(taxes2);

// Item 3
        InvoiceItem item3 = new InvoiceItem();
        item3.setItemCode("01010101");
        item3.setQuantity("6.0");
        item3.setUnitOfMeasurementCode("E48");
        item3.setUnitOfMeasurement("Unidad de servicio3");
        item3.setDescription("Computer software");
        item3.setUnitPrice("1250.75");
        item3.setTaxObjectCode("02");
        item3.setItemSku("7506022301699");

        List<ItemTax> taxes3 = new ArrayList<>();
        ItemTax tax3a = new ItemTax();
        tax3a.setTaxCode("002");
        tax3a.setTaxTypeCode("Tasa");
        tax3a.setTaxRate("0.160000");
        tax3a.setTaxFlagCode("T");
        taxes3.add(tax3a);

        ItemTax tax3b = new ItemTax();
        tax3b.setTaxCode("002");
        tax3b.setTaxTypeCode("Tasa");
        tax3b.setTaxRate("0.106666");
        tax3b.setTaxFlagCode("R");
        taxes3.add(tax3b);

        item3.setItemTaxes(taxes3);

        items.add(item1);
        items.add(item2);
        items.add(item3);

// Local Taxes Complement
        LocalTaxes localTaxes = new LocalTaxes();
        List<LocalTax> localTaxList = new ArrayList<>();

        LocalTax localTax1 = new LocalTax();
        localTax1.setTaxName("CEDULAR");
        localTax1.setTaxRate("3.00");
        localTax1.setTaxAmount("6.00");
        localTax1.setTaxFlagCode("R");

        LocalTax localTax2 = new LocalTax();
        localTax2.setTaxName("ISH");
        localTax2.setTaxRate("8.00");
        localTax2.setTaxAmount("16.00");
        localTax2.setTaxFlagCode("R");

        localTaxList.add(localTax1);
        localTaxList.add(localTax2);

        localTaxes.setTaxes(localTaxList);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setPaymentFormCode("01");
        invoice.setPaymentConditions("Contado");
        invoice.setCurrencyCode("MXN");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setPaymentMethodCode("PUE");
        invoice.setExchangeRate("1.0");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setItems(items);

// Set complement with local taxes
        Complement complement = new Complement();
        complement.setLocalTaxes(localTaxes);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);
         */

        //Ingreso impuestos locales CEDULAR
        // Emisor
        /*
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("EKU9003173C9");
        recipient.setLegalName("ESCUELA KEMPER URGATE");
        recipient.setZipCode("42501");
        recipient.setTaxRegimeCode("601");
        recipient.setCfdiUseCode("G01");
        recipient.setEmail("someone@somewhere.com");

// Items
        List<InvoiceItem> items = new ArrayList<>();

// Item 1
        InvoiceItem item1 = new InvoiceItem();
        item1.setItemCode("01010101");
        item1.setQuantity("9.5");
        item1.setUnitOfMeasurementCode("E48");
        item1.setUnitOfMeasurement("Unidad de servicio");
        item1.setDescription("Invoicing software as a service");
        item1.setUnitPrice("3587.75");
        item1.setTaxObjectCode("02");
        item1.setItemSku("7506022301697");
        item1.setDiscount("255.85");

        List<ItemTax> taxes1 = new ArrayList<>();
        ItemTax tax1 = new ItemTax();
        tax1.setTaxCode("002");
        tax1.setTaxTypeCode("Tasa");
        tax1.setTaxRate("0.160000");
        tax1.setTaxFlagCode("T");
        taxes1.add(tax1);

        item1.setItemTaxes(taxes1);

// Item 2
        InvoiceItem item2 = new InvoiceItem();
        item2.setItemCode("01010101");
        item2.setQuantity("8.0");
        item2.setUnitOfMeasurementCode("E48");
        item2.setUnitOfMeasurement("Unidad de servicio2");
        item2.setDescription("Software Consultant");
        item2.setUnitPrice("250.85");
        item2.setTaxObjectCode("02");
        item2.setItemSku("7506022301698");
        item2.setDiscount("255.85");

        List<ItemTax> taxes2 = new ArrayList<>();
        ItemTax tax2 = new ItemTax();
        tax2.setTaxCode("002");
        tax2.setTaxTypeCode("Tasa");
        tax2.setTaxRate("0.160000");
        tax2.setTaxFlagCode("T");
        taxes2.add(tax2);

        item2.setItemTaxes(taxes2);

// Item 3
        InvoiceItem item3 = new InvoiceItem();
        item3.setItemCode("01010101");
        item3.setQuantity("6.0");
        item3.setUnitOfMeasurementCode("E48");
        item3.setUnitOfMeasurement("Unidad de servicio3");
        item3.setDescription("Computer software");
        item3.setUnitPrice("1250.75");
        item3.setTaxObjectCode("02");
        item3.setItemSku("7506022301699");

        List<ItemTax> taxes3 = new ArrayList<>();
        ItemTax tax3a = new ItemTax();
        tax3a.setTaxCode("002");
        tax3a.setTaxTypeCode("Tasa");
        tax3a.setTaxRate("0.160000");
        tax3a.setTaxFlagCode("T");
        taxes3.add(tax3a);

        ItemTax tax3b = new ItemTax();
        tax3b.setTaxCode("002");
        tax3b.setTaxTypeCode("Tasa");
        tax3b.setTaxRate("0.106666");
        tax3b.setTaxFlagCode("R");
        taxes3.add(tax3b);

        item3.setItemTaxes(taxes3);

        items.add(item1);
        items.add(item2);
        items.add(item3);

// Local Taxes Complement - CEDULAR only
        LocalTaxes localTaxes = new LocalTaxes();
        List<LocalTax> localTaxList = new ArrayList<>();

        LocalTax cedularTax = new LocalTax();
        cedularTax.setTaxName("CEDULAR");
        cedularTax.setTaxRate("3.00");
        cedularTax.setTaxAmount("6.00");
        cedularTax.setTaxFlagCode("R");

        localTaxList.add(cedularTax);

        localTaxes.setTaxes(localTaxList);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setPaymentFormCode("01");
        invoice.setPaymentConditions("Contado");
        invoice.setCurrencyCode("MXN");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setPaymentMethodCode("PUE");
        invoice.setExchangeRate("1.0");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setItems(items);

// Set complement with local taxes
        Complement complement = new Complement();
        complement.setLocalTaxes(localTaxes);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);
         */

        // Factura ingreso impuestos locales ISH
        // Emisor
        /*
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setLegalName("ESCUELA KEMPER URGATE");
        issuer.setTaxRegimeCode("601");

// Receptor
        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("EKU9003173C9");
        recipient.setLegalName("ESCUELA KEMPER URGATE");
        recipient.setZipCode("42501");
        recipient.setTaxRegimeCode("601");
        recipient.setCfdiUseCode("G01");
        recipient.setEmail("someone@somewhere.com");

// Items
        List<InvoiceItem> items = new ArrayList<>();

// Item 1
        InvoiceItem item1 = new InvoiceItem();
        item1.setItemCode("01010101");
        item1.setQuantity("9.5");
        item1.setUnitOfMeasurementCode("E48");
        item1.setUnitOfMeasurement("Unidad de servicio");
        item1.setDescription("Invoicing software as a service");
        item1.setUnitPrice("3587.75");
        item1.setTaxObjectCode("02");
        item1.setItemSku("7506022301697");
        item1.setDiscount("255.85");

        List<ItemTax> taxes1 = new ArrayList<>();
        ItemTax tax1 = new ItemTax();
        tax1.setTaxCode("002");
        tax1.setTaxTypeCode("Tasa");
        tax1.setTaxRate("0.160000");
        tax1.setTaxFlagCode("T");
        taxes1.add(tax1);

        item1.setItemTaxes(taxes1);

// Item 2
        InvoiceItem item2 = new InvoiceItem();
        item2.setItemCode("01010101");
        item2.setQuantity("8.0");
        item2.setUnitOfMeasurementCode("E48");
        item2.setUnitOfMeasurement("Unidad de servicio2");
        item2.setDescription("Software Consultant");
        item2.setUnitPrice("250.85");
        item2.setTaxObjectCode("02");
        item2.setItemSku("7506022301698");
        item2.setDiscount("255.85");

        List<ItemTax> taxes2 = new ArrayList<>();
        ItemTax tax2 = new ItemTax();
        tax2.setTaxCode("002");
        tax2.setTaxTypeCode("Tasa");
        tax2.setTaxRate("0.160000");
        tax2.setTaxFlagCode("T");
        taxes2.add(tax2);

        item2.setItemTaxes(taxes2);

// Item 3
        InvoiceItem item3 = new InvoiceItem();
        item3.setItemCode("01010101");
        item3.setQuantity("6.0");
        item3.setUnitOfMeasurementCode("E48");
        item3.setUnitOfMeasurement("Unidad de servicio3");
        item3.setDescription("Computer software");
        item3.setUnitPrice("1250.75");
        item3.setTaxObjectCode("02");
        item3.setItemSku("7506022301699");

        List<ItemTax> taxes3 = new ArrayList<>();
        ItemTax tax3a = new ItemTax();
        tax3a.setTaxCode("002");
        tax3a.setTaxTypeCode("Tasa");
        tax3a.setTaxRate("0.160000");
        tax3a.setTaxFlagCode("T");
        taxes3.add(tax3a);

        ItemTax tax3b = new ItemTax();
        tax3b.setTaxCode("002");
        tax3b.setTaxTypeCode("Tasa");
        tax3b.setTaxRate("0.106666");
        tax3b.setTaxFlagCode("R");
        taxes3.add(tax3b);

        item3.setItemTaxes(taxes3);

        items.add(item1);
        items.add(item2);
        items.add(item3);

// Local Taxes Complement - ISH only
        LocalTaxes localTaxes = new LocalTaxes();
        List<LocalTax> localTaxList = new ArrayList<>();

        LocalTax ishTax = new LocalTax();
        ishTax.setTaxName("ISH");
        ishTax.setTaxRate("8.00");
        ishTax.setTaxAmount("16.00");
        ishTax.setTaxFlagCode("R");

        localTaxList.add(ishTax);

        localTaxes.setTaxes(localTaxList);

// Invoice
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
        invoice.setPaymentFormCode("01");
        invoice.setPaymentConditions("Contado");
        invoice.setCurrencyCode("MXN");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setPaymentMethodCode("PUE");
        invoice.setExchangeRate("1.0");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setItems(items);

// Set complement with local taxes
        Complement complement = new Complement();
        complement.setLocalTaxes(localTaxes);
        invoice.setComplement(complement);

        ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

        System.out.println(apiResponse);
         */


//      Nómina por valores
//         Nómina Ordinaria
        // InvoiceIssuer issuer = new InvoiceIssuer();
        // issuer.setTin("EKU9003173C9");
        // issuer.setLegalName("ESCUELA KEMPER URGATE");
        // issuer.setTaxRegimeCode("601");

        // EmployerData employerData = new EmployerData();
        // employerData.setEmployerRegistration("B5510768108");
        // issuer.setEmployerData(employerData);

        // // Certificados del emisor
        // List<TaxCredential> credentials = new ArrayList<>();

        // TaxCredential cer = new TaxCredential();
        // cer.setBase64File(base64Cer);
        // cer.setFileType(0); // 0 = Certificado (.cer)
        // cer.setPassword(password);

        // TaxCredential key = new TaxCredential();
        // key.setBase64File(base64Key);
        // key.setFileType(1); // 1 = Clave privada (.key)
        // key.setPassword(password);

        // credentials.add(cer);
        // credentials.add(key);

        // issuer.setTaxCredentials(credentials);

        // // Receptor
        // InvoiceRecipient recipient = new InvoiceRecipient();
        // recipient.setTin("FUNK671228PH6");
        // recipient.setLegalName("KARLA FUENTE NOLASCO");
        // recipient.setZipCode("01160");
        // recipient.setTaxRegimeCode("605");
        // recipient.setCfdiUseCode("CN01");
        // recipient.setEmail("someone@somewhere.com");

        // EmployeeData employeeData = new EmployeeData();
        // employeeData.setCurp("XEXX010101MNEXXXA8");
        // employeeData.setSocialSecurityNumber("04078873454");
        // employeeData.setLaborRelationStartDate("2024-08-18T00:00:00");
        // employeeData.setSeniority("P54W");
        // employeeData.setSatContractTypeId("01");
        // employeeData.setSatTaxRegimeTypeId("02");
        // employeeData.setEmployeeNumber("123456789");
        // employeeData.setDepartment("GenAI");
        // employeeData.setPosition("Sr Software Engineer");
        // employeeData.setSatJobRiskId("1");
        // employeeData.setSatPaymentPeriodicityId("05");
        // employeeData.setSatBankId("012");
        // employeeData.setBaseSalaryForContributions("282.50");
        // employeeData.setIntegratedDailySalary("2626.23");
        // employeeData.setSatPayrollStateId("JAL");
        // recipient.setEmployeeData(employeeData);

        // Payroll payroll = new Payroll();
        // payroll.setVersion("1.2");
        // payroll.setPayrollTypeCode("O");
        // payroll.setPaymentDate("2025-08-30T00:00:00");
        // payroll.setInitialPaymentDate("2025-07-31T00:00:00");
        // payroll.setFinalPaymentDate("2025-08-30T00:00:00");
        // payroll.setDaysPaid(30);
        // PayrollEarnings payrollEarnings = new PayrollEarnings();
        // List<PayrollEarning> earnings = new ArrayList<>();

        // PayrollEarning e1 = new PayrollEarning();
        // e1.setEarningTypeCode("001");
        // e1.setCode("1003");
        // e1.setConcept("Sueldo nominal");
        // e1.setTaxedAmount("95030");
        // e1.setExemptAmount("0");

        // PayrollEarning e2 = new PayrollEarning();
        // e2.setEarningTypeCode("005");
        // e2.setCode("5913");
        // e2.setConcept("Fondo de Ahorro Aportación Patrón");
        // e2.setTaxedAmount("0");
        // e2.setExemptAmount("4412.46");

        // PayrollEarning e3 = new PayrollEarning();
        // e3.setEarningTypeCode("038");
        // e3.setCode("1885");
        // e3.setConcept("Bono Ingles");
        // e3.setTaxedAmount("14254.50");
        // e3.setExemptAmount("0");

        // PayrollEarning e4 = new PayrollEarning();
        // e4.setEarningTypeCode("029");
        // e4.setCode("1941");
        // e4.setConcept("Vales Despensa");
        // e4.setTaxedAmount("0");
        // e4.setExemptAmount("3439");

        // PayrollEarning e5 = new PayrollEarning();
        // e5.setEarningTypeCode("038");
        // e5.setCode("1824");
        // e5.setConcept("Herramientas Teletrabajo (telecom y prop. electri)");
        // e5.setTaxedAmount("273");
        // e5.setExemptAmount("0");

        // earnings.add(e1);
        // earnings.add(e2);
        // earnings.add(e3);
        // earnings.add(e4);
        // earnings.add(e5);

        // List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();
        // PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
        // op1.setOtherPaymentTypeCode("002");
        // op1.setCode("5050");
        // op1.setConcept("exceso de subsidio al empleo");
        // op1.setAmount("0");
        // op1.setSubsidyCaused("0");
        // otherPayments.add(op1);

        // payrollEarnings.setEarnings(earnings);
        // payrollEarnings.setOtherPayments(otherPayments);
        // payroll.setEarnings(payrollEarnings);

        // List<PayrollDeduction> payrollDeductions = new ArrayList<>();

        // PayrollDeduction d1 = new PayrollDeduction();
        // d1.setDeductionTypeCode("002");
        // d1.setCode("5003");
        // d1.setConcept("ISR Causado");
        // d1.setAmount("27645.00");

        // PayrollDeduction d2 = new PayrollDeduction();
        // d2.setDeductionTypeCode("004");
        // d2.setCode("5910");
        // d2.setConcept("Fondo de ahorro Empleado Inversión");
        // d2.setAmount("4412.46");

        // PayrollDeduction d3 = new PayrollDeduction();
        // d3.setDeductionTypeCode("004");
        // d3.setCode("5914");
        // d3.setConcept("Fondo de Ahorro Patrón Inversión");
        // d3.setAmount("4412.46");

        // PayrollDeduction d4 = new PayrollDeduction();
        // d4.setDeductionTypeCode("004");
        // d4.setCode("1966");
        // d4.setConcept("Contribución póliza exceso GMM");
        // d4.setAmount("519.91");

        // PayrollDeduction d5 = new PayrollDeduction();
        // d5.setDeductionTypeCode("004");
        // d5.setCode("1934");
        // d5.setConcept("Descuento Vales Despensa");
        // d5.setAmount("1.00");

        // PayrollDeduction d6 = new PayrollDeduction();
        // d6.setDeductionTypeCode("004");
        // d6.setCode("1942");
        // d6.setConcept("Vales Despensa Electrónico");
        // d6.setAmount("3439.00");

        // PayrollDeduction d7 = new PayrollDeduction();
        // d7.setDeductionTypeCode("001");
        // d7.setCode("1895");
        // d7.setConcept("IMSS");
        // d7.setAmount("2391.13");

        // payrollDeductions.add(d1);
        // payrollDeductions.add(d2);
        // payrollDeductions.add(d3);
        // payrollDeductions.add(d4);
        // payrollDeductions.add(d5);
        // payrollDeductions.add(d6);
        // payrollDeductions.add(d7);

        // payroll.setDeductions(payrollDeductions);
        // Complement complement = new Complement();
        // complement.setPayroll(payroll);

        // Invoice invoice = new Invoice();
        // invoice.setVersionCode("4.0");
        // invoice.setSeries("F");
        // invoice.setDate("2026-02-09T10:00:00");
        // invoice.setTypeCode("N");
        // invoice.setExpeditionZipCode("20000");
        // invoice.setIssuer(issuer);
        // invoice.setRecipient(recipient);
        // invoice.setDate("2026-02-09T10:00:00");
        // invoice.setPaymentMethodCode("PUE");
        // invoice.setComplement(complement);

        // ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
        // System.out.println(apiResponse);

//         // Nómina asimilados
//         // Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setOriginEmployerTin("EKU9003173C9");

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("CACX7605101P8");
//         recipient.setLegalName("XOCHILT CASAS CHAVEZ");
//         recipient.setZipCode("36257");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSatContractTypeId("09");
//         employeeData.setSatUnionizedStatusId("No");
//         employeeData.setSatTaxRegimeTypeId("09");
//         employeeData.setEmployeeNumber("00002");
//         employeeData.setDepartment("ADMINISTRACION");
//         employeeData.setPosition("DIRECTOR DE ADMINISTRACION");
//         employeeData.setSatPaymentPeriodicityId("99");
//         employeeData.setSatBankId("012");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setSatPayrollStateId("CMX");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("E");
//         payroll.setPaymentDate("2023-06-02T00:00:00");
//         payroll.setInitialPaymentDate("2023-06-01T00:00:00");
//         payroll.setFinalPaymentDate("2023-06-02T00:00:00");
//         payroll.setDaysPaid(1);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("046");
//         e1.setCode("010046");
//         e1.setConcept("INGRESOS ASIMILADOS A SALARIOS");
//         e1.setTaxedAmount("111197.73");
//         e1.setExemptAmount("0.00");

//         earnings.add(e1);

//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         PayrollDeduction d1 = new PayrollDeduction();
//         d1.setDeductionTypeCode("002");
//         d1.setCode("020002");
//         d1.setConcept("ISR");
//         d1.setAmount("36197.73");

//         payrollDeductions.add(d1);

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("06880");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

        //Nómina con bonos, fondo de ahorrro y deducciones
        // Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("Z0000001234");
//         issuer.setEmployerData(employerData);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101MNEXXXA8");
//         employeeData.setSocialSecurityNumber("0000000000");
//         employeeData.setLaborRelationStartDate("2022-03-02T00:00:00");
//         employeeData.setSeniority("P66W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatUnionizedStatusId("No");
//         employeeData.setSatTaxRegimeTypeId("02");
//         employeeData.setEmployeeNumber("111111");
//         employeeData.setSatJobRiskId("4");
//         employeeData.setSatPaymentPeriodicityId("02");
//         employeeData.setIntegratedDailySalary("180.96");
//         employeeData.setSatPayrollStateId("GUA");
//         recipient.setEmployeeData(employeeData);

// // Items
//         List<InvoiceItem> items = new ArrayList<>();

//         InvoiceItem item1 = new InvoiceItem();
//         item1.setItemCode("84111505");
//         item1.setItemSku("84111505");
//         item1.setQuantity("1.0");
//         item1.setUnitOfMeasurementCode("ACT");
//         item1.setDescription("Pago de nómina");
//         item1.setUnitPrice("1842.82");
//         item1.setDiscount("608.71");
//         item1.setTaxObjectCode("01");

//         items.add(item1);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("O");
//         payroll.setPaymentDate("2023-06-11T00:00:00");
//         payroll.setInitialPaymentDate("2023-06-05T00:00:00");
//         payroll.setFinalPaymentDate("2023-06-11T00:00:00");
//         payroll.setDaysPaid(7);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("001");
//         e1.setCode("SP01");
//         e1.setConcept("SUELDO");
//         e1.setTaxedAmount("1210.30");
//         e1.setExemptAmount("0.00");

//         PayrollEarning e2 = new PayrollEarning();
//         e2.setEarningTypeCode("010");
//         e2.setCode("SP02");
//         e2.setConcept("PREMIO PUNTUALIDAD");
//         e2.setTaxedAmount("121.03");
//         e2.setExemptAmount("0.00");

//         PayrollEarning e3 = new PayrollEarning();
//         e3.setEarningTypeCode("029");
//         e3.setCode("SP03");
//         e3.setConcept("MONEDERO ELECTRONICO");
//         e3.setTaxedAmount("0.00");
//         e3.setExemptAmount("269.43");

//         PayrollEarning e4 = new PayrollEarning();
//         e4.setEarningTypeCode("010");
//         e4.setCode("SP04");
//         e4.setConcept("PREMIO DE ASISTENCIA");
//         e4.setTaxedAmount("121.03");
//         e4.setExemptAmount("0.00");

//         PayrollEarning e5 = new PayrollEarning();
//         e5.setEarningTypeCode("005");
//         e5.setCode("SP54");
//         e5.setConcept("APORTACION FONDO AHORRO");
//         e5.setTaxedAmount("0.00");
//         e5.setExemptAmount("121.03");

//         earnings.add(e1);
//         earnings.add(e2);
//         earnings.add(e3);
//         earnings.add(e4);
//         earnings.add(e5);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//         op1.setOtherPaymentTypeCode("002");
//         op1.setCode("ISRSUB");
//         op1.setConcept("Subsidio ISR para empleo");
//         op1.setAmount("0.0");
//         op1.setSubsidyCaused("0.0");

//         BalanceCompensation balanceCompensation = new BalanceCompensation();
//         balanceCompensation.setFavorableBalance("0.0");
//         balanceCompensation.setYear(2022);
//         balanceCompensation.setRemainingFavorableBalance("0.0");

//         op1.setBalanceCompensation(balanceCompensation);

//         otherPayments.add(op1);

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         PayrollDeduction d1 = new PayrollDeduction();
//         d1.setDeductionTypeCode("004");
//         d1.setCode("ZA09");
//         d1.setConcept("APORTACION FONDO AHORRO");
//         d1.setAmount("121.03");

//         PayrollDeduction d2 = new PayrollDeduction();
//         d2.setDeductionTypeCode("002");
//         d2.setCode("ISR");
//         d2.setConcept("ISR");
//         d2.setAmount("36.57");

//         PayrollDeduction d3 = new PayrollDeduction();
//         d3.setDeductionTypeCode("001");
//         d3.setCode("IMSS");
//         d3.setConcept("Cuota de Seguridad Social EE");
//         d3.setAmount("30.08");

//         PayrollDeduction d4 = new PayrollDeduction();
//         d4.setDeductionTypeCode("004");
//         d4.setCode("ZA68");
//         d4.setConcept("DEDUCCION FDO AHORRO PAT");
//         d4.setAmount("121.03");

//         PayrollDeduction d5 = new PayrollDeduction();
//         d5.setDeductionTypeCode("018");
//         d5.setCode("ZA11");
//         d5.setConcept("APORTACION CAJA AHORRO");
//         d5.setAmount("300.00");

//         payrollDeductions.add(d1);
//         payrollDeductions.add(d2);
//         payrollDeductions.add(d3);
//         payrollDeductions.add(d4);
//         payrollDeductions.add(d5);

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

        // Nómina con horas extra
        // Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P437W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("03");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("04");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setBaseSalaryForContributions("490.22");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("O");
//         payroll.setPaymentDate("2023-05-24T00:00:00");
//         payroll.setInitialPaymentDate("2023-05-09T00:00:00");
//         payroll.setFinalPaymentDate("2023-05-24T00:00:00");
//         payroll.setDaysPaid(15);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("001");
//         e1.setCode("00500");
//         e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//         e1.setTaxedAmount("2808.8");
//         e1.setExemptAmount("2191.2");

//         PayrollEarning e2 = new PayrollEarning();
//         e2.setEarningTypeCode("019");
//         e2.setCode("00100");
//         e2.setConcept("Horas Extra");
//         e2.setTaxedAmount("50.00");
//         e2.setExemptAmount("50.00");

//         List<PayrollEarningOvertime> overtimeList = new ArrayList<>();
//         PayrollEarningOvertime overtime1 = new PayrollEarningOvertime();
//         overtime1.setDays(1);
//         overtime1.setHoursTypeCode("01");
//         overtime1.setExtraHours(2);
//         overtime1.setAmountPaid("100.00");
//         overtimeList.add(overtime1);

//         e2.setOvertime(overtimeList);

//         earnings.add(e1);
//         earnings.add(e2);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         PayrollDeduction d1 = new PayrollDeduction();
//         d1.setDeductionTypeCode("001");
//         d1.setCode("00301");
//         d1.setConcept("Seguridad Social");
//         d1.setAmount("200.00");

//         PayrollDeduction d2 = new PayrollDeduction();
//         d2.setDeductionTypeCode("002");
//         d2.setCode("00302");
//         d2.setConcept("ISR");
//         d2.setAmount("100.00");

//         payrollDeductions.add(d1);
//         payrollDeductions.add(d2);
//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

        // Nómina con incapacidades
        // Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P437W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("03");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("04");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setBaseSalaryForContributions("490.22");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("O");
//         payroll.setPaymentDate("2023-05-24T00:00:00");
//         payroll.setInitialPaymentDate("2023-05-09T00:00:00");
//         payroll.setFinalPaymentDate("2023-05-24T00:00:00");
//         payroll.setDaysPaid(15);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("001");
//         e1.setCode("00500");
//         e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//         e1.setTaxedAmount("2808.8");
//         e1.setExemptAmount("2191.2");

//         earnings.add(e1);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         PayrollDeduction d1 = new PayrollDeduction();
//         d1.setDeductionTypeCode("001");
//         d1.setCode("00301");
//         d1.setConcept("Seguridad Social");
//         d1.setAmount("200.00");

//         PayrollDeduction d2 = new PayrollDeduction();
//         d2.setDeductionTypeCode("002");
//         d2.setCode("00302");
//         d2.setConcept("ISR");
//         d2.setAmount("100.00");

//         payrollDeductions.add(d1);
//         payrollDeductions.add(d2);

// // Disabilities
//         List<PayrollDisability> disabilities = new ArrayList<>();

//         PayrollDisability disability1 = new PayrollDisability();
//         disability1.setDisabilityDays(1);
//         disability1.setDisabilityTypeCode("01");

//         disabilities.add(disability1);

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);
//         payroll.setDisabilities(disabilities);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

//       Nómina con SNCF
// Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("OÑO120726RX3");
//         issuer.setLegalName("ORGANICOS ÑAVEZ OSORIO");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("27112029");
//         employerData.setSatFundSourceId("IP");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("CACX7605101P8");
//         recipient.setLegalName("XOCHILT CASAS CHAVEZ");
//         recipient.setZipCode("36257");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("80997742673");
//         employeeData.setLaborRelationStartDate("2021-09-01T00:00:00");
//         employeeData.setSeniority("P88W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("02");
//         employeeData.setEmployeeNumber("273");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("04");
//         employeeData.setIntegratedDailySalary("221.48");
//         employeeData.setSatPayrollStateId("GRO");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("O");
//         payroll.setPaymentDate("2023-05-16T00:00:00");
//         payroll.setInitialPaymentDate("2023-05-01T00:00:00");
//         payroll.setFinalPaymentDate("2023-05-16T00:00:00");
//         payroll.setDaysPaid(15);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("001");
//         e1.setCode("P001");
//         e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//         e1.setTaxedAmount("3322.20");
//         e1.setExemptAmount("0");

//         PayrollEarning e2 = new PayrollEarning();
//         e2.setEarningTypeCode("038");
//         e2.setCode("P540");
//         e2.setConcept("Compensacion");
//         e2.setTaxedAmount("100.00");
//         e2.setExemptAmount("0");

//         PayrollEarning e3 = new PayrollEarning();
//         e3.setEarningTypeCode("038");
//         e3.setCode("P550");
//         e3.setConcept("Compensación Garantizada Extraordinaria");
//         e3.setTaxedAmount("2200.00");
//         e3.setExemptAmount("0");

//         PayrollEarning e4 = new PayrollEarning();
//         e4.setEarningTypeCode("038");
//         e4.setCode("P530");
//         e4.setConcept("Servicio Extraordinario");
//         e4.setTaxedAmount("200.00");
//         e4.setExemptAmount("0");

//         PayrollEarning e5 = new PayrollEarning();
//         e5.setEarningTypeCode("001");
//         e5.setCode("P506");
//         e5.setConcept("Otras Prestaciones");
//         e5.setTaxedAmount("1500.00");
//         e5.setExemptAmount("0");

//         PayrollEarning e6 = new PayrollEarning();
//         e6.setEarningTypeCode("001");
//         e6.setCode("P505");
//         e6.setConcept("Remuneración al Desempeño Legislativo");
//         e6.setTaxedAmount("17500.00");
//         e6.setExemptAmount("0");

//         earnings.add(e1);
//         earnings.add(e2);
//         earnings.add(e3);
//         earnings.add(e4);
//         earnings.add(e5);
//         earnings.add(e6);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//         op1.setOtherPaymentTypeCode("002");
//         op1.setCode("002");
//         op1.setConcept("Subsidio para el empleo efectivamente entregado al trabajador");
//         op1.setAmount("0");
//         op1.setSubsidyCaused("0");

//         otherPayments.add(op1);

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         PayrollDeduction d1 = new PayrollDeduction();
//         d1.setDeductionTypeCode("002");
//         d1.setCode("D002");
//         d1.setConcept("ISR");
//         d1.setAmount("4716.61");

//         PayrollDeduction d2 = new PayrollDeduction();
//         d2.setDeductionTypeCode("004");
//         d2.setCode("D525");
//         d2.setConcept("Redondeo");
//         d2.setAmount("0.81");

//         PayrollDeduction d3 = new PayrollDeduction();
//         d3.setDeductionTypeCode("001");
//         d3.setCode("D510");
//         d3.setConcept("Cuota Trabajador ISSSTE");
//         d3.setAmount("126.78");

//         payrollDeductions.add(d1);
//         payrollDeductions.add(d2);
//         payrollDeductions.add(d3);

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("39074");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

//       Nómina extraordinaria
// Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P439W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("03");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("99");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("E");
//         payroll.setPaymentDate("2023-06-04T00:00:00");
//         payroll.setInitialPaymentDate("2023-06-04T00:00:00");
//         payroll.setFinalPaymentDate("2023-06-04T00:00:00");
//         payroll.setDaysPaid(30);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("002");
//         e1.setCode("00500");
//         e1.setConcept("Gratificación Anual (Aguinaldo)");
//         e1.setTaxedAmount("0.00");
//         e1.setExemptAmount("10000.00");

//         earnings.add(e1);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions (empty list)
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

//       Nómina separación
//  InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

//         // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P439W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("03");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("99");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("E");
//         payroll.setPaymentDate("2023-06-04T00:00:00");
//         payroll.setInitialPaymentDate("2023-06-04T00:00:00");
//         payroll.setFinalPaymentDate("2023-06-04T00:00:00");
//         payroll.setDaysPaid(30);
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("023");
//         e1.setCode("00500");
//         e1.setConcept("Pagos por separación");
//         e1.setTaxedAmount("0");
//         e1.setExemptAmount("10000.0");

//         PayrollEarning e2 = new PayrollEarning();
//         e2.setEarningTypeCode("025");
//         e2.setCode("00900");
//         e2.setConcept("Indemnizaciones");
//         e2.setTaxedAmount("0");
//         e2.setExemptAmount("500.0");

//         earnings.add(e1);
//         earnings.add(e2);

//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();
//         PayrollSeverance severance = new PayrollSeverance();
//         severance.setTotalPaid("10500.00");
//         severance.setYearsOfService(1);
//         severance.setLastMonthlySalary("10000.00");
//         severance.setAccumulableIncome("10000.00");
//         severance.setNonAccumulableIncome("0");

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);
//         payrollEarnings.setSeverance(severance);
//         payroll.setEarnings(payrollEarnings);

//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         payroll.setDeductions(payrollDeductions);
//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00");
//         invoice.setTypeCode("N");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setDate("2026-02-09T10:00:00");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);

//       Nómina jubilación
// Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P439W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("03");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("99");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("E");
//         payroll.setPaymentDate("2023-05-05T00:00:00");
//         payroll.setInitialPaymentDate("2023-06-04T00:00:00");
//         payroll.setFinalPaymentDate("2023-06-04T00:00:00");
//         payroll.setDaysPaid(30);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("039");
//         e1.setCode("00500");
//         e1.setConcept("Jubilaciones, pensiones o haberes de retiro");
//         e1.setTaxedAmount("0.00");
//         e1.setExemptAmount("10000.00");

//         earnings.add(e1);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

// // Retirement
//         PayrollRetirement retirement = new PayrollRetirement();
//         retirement.setTotalOneTime("10000.00");
//         retirement.setAccumulableIncome("10000.00");
//         retirement.setNonAccumulableIncome("0.00");

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);
//         payrollEarnings.setRetirement(retirement);

// // Deductions (empty list)
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

//       Nómina sin deducciones
// Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P437W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("03");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("04");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setBaseSalaryForContributions("490.22");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("O");
//         payroll.setPaymentDate("2023-05-24T00:00:00");
//         payroll.setInitialPaymentDate("2023-05-09T00:00:00");
//         payroll.setFinalPaymentDate("2023-05-24T00:00:00");
//         payroll.setDaysPaid(15);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("001");
//         e1.setCode("00500");
//         e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//         e1.setTaxedAmount("2808.8");
//         e1.setExemptAmount("2191.2");

//         earnings.add(e1);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions (empty list)
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);
// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

//       Nómina viáticos
// Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P438W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("03");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("04");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setBaseSalaryForContributions("490.22");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("O");
//         payroll.setPaymentDate("2023-09-26T00:00:00");
//         payroll.setInitialPaymentDate("2023-09-11T00:00:00");
//         payroll.setFinalPaymentDate("2023-09-26T00:00:00");
//         payroll.setDaysPaid(15);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("050");
//         e1.setCode("050");
//         e1.setConcept("Viaticos");
//         e1.setTaxedAmount("0");
//         e1.setExemptAmount("3000");

//         earnings.add(e1);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         PayrollDeduction d1 = new PayrollDeduction();
//         d1.setDeductionTypeCode("081");
//         d1.setCode("081");
//         d1.setConcept("Ajuste en viaticos entregados al trabajador");
//         d1.setAmount("3000.00");

//         payrollDeductions.add(d1);

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

// Nómina subsidio causado al empleo
// Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P437W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("0aa2ad8c3-6ec5-4601-91be-d827d9a865bc2");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("04");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setBaseSalaryForContributions("490.22");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("O");
//         payroll.setPaymentDate("2023-05-24T00:00:00");
//         payroll.setInitialPaymentDate("2023-05-09T00:00:00");
//         payroll.setFinalPaymentDate("2023-05-24T00:00:00");
//         payroll.setDaysPaid(15);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("001");
//         e1.setCode("00500");
//         e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//         e1.setTaxedAmount("2808.8");
//         e1.setExemptAmount("2191.2");

//         earnings.add(e1);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//         op1.setOtherPaymentTypeCode("007");
//         op1.setCode("0002");
//         op1.setConcept("ISR ajustado por subsidio");
//         op1.setAmount("145.80");
//         op1.setSubsidyCaused("0.0");

//         otherPayments.add(op1);

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         PayrollDeduction d1 = new PayrollDeduction();
//         d1.setDeductionTypeCode("107");
//         d1.setCode("D002");
//         d1.setConcept("Ajuste al Subsidio Causado");
//         d1.setAmount("160.35");

//         PayrollDeduction d2 = new PayrollDeduction();
//         d2.setDeductionTypeCode("002");
//         d2.setCode("D002");
//         d2.setConcept("ISR");
//         d2.setAmount("145.80");

//         payrollDeductions.add(d1);
//         payrollDeductions.add(d2);

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);

//      Nómina 
// Emisor
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setTin("EKU9003173C9");
//         issuer.setLegalName("ESCUELA KEMPER URGATE");
//         issuer.setTaxRegimeCode("601");

//         EmployerData employerData = new EmployerData();
//         employerData.setEmployerRegistration("B5510768108");
//         employerData.setOriginEmployerTin("URE180429TM6");
//         issuer.setEmployerData(employerData);

//         // Certificados del emisor
//         // Certificados del emisor
//         List<TaxCredential> credentials = new ArrayList<>();

//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(base64Cer);
//         cer.setFileType(0); // 0 = Certificado (.cer)
//         cer.setPassword(password);

//         TaxCredential key = new TaxCredential();
//         key.setBase64File(base64Key);
//         key.setFileType(1); // 1 = Clave privada (.key)
//         key.setPassword(password);

//         credentials.add(cer);
//         credentials.add(key);

//         issuer.setTaxCredentials(credentials);

// // Receptor
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setTin("XOJI740919U48");
//         recipient.setLegalName("INGRID XODAR JIMENEZ");
//         recipient.setZipCode("76028");
//         recipient.setTaxRegimeCode("605");
//         recipient.setCfdiUseCode("CN01");

//         EmployeeData employeeData = new EmployeeData();
//         employeeData.setCurp("XEXX010101HNEXXXA4");
//         employeeData.setSocialSecurityNumber("000000");
//         employeeData.setLaborRelationStartDate("2015-01-01T00:00:00");
//         employeeData.setSeniority("P437W");
//         employeeData.setSatContractTypeId("01");
//         employeeData.setSatWorkdayTypeId("01");
//         employeeData.setSatTaxRegimeTypeId("03");
//         employeeData.setEmployeeNumber("120");
//         employeeData.setDepartment("Desarrollo");
//         employeeData.setPosition("Ingeniero de Software");
//         employeeData.setSatJobRiskId("1");
//         employeeData.setSatPaymentPeriodicityId("04");
//         employeeData.setSatBankId("002");
//         employeeData.setBankAccount("1111111111");
//         employeeData.setBaseSalaryForContributions("490.22");
//         employeeData.setIntegratedDailySalary("146.47");
//         employeeData.setSatPayrollStateId("JAL");
//         recipient.setEmployeeData(employeeData);

// // Payroll
//         Payroll payroll = new Payroll();
//         payroll.setVersion("1.2");
//         payroll.setPayrollTypeCode("O");
//         payroll.setPaymentDate("2023-05-24T00:00:00");
//         payroll.setInitialPaymentDate("2023-05-09T00:00:00");
//         payroll.setFinalPaymentDate("2023-05-24T00:00:00");
//         payroll.setDaysPaid(15);

// // Earnings
//         PayrollEarnings payrollEarnings = new PayrollEarnings();
//         List<PayrollEarning> earnings = new ArrayList<>();

//         PayrollEarning e1 = new PayrollEarning();
//         e1.setEarningTypeCode("001");
//         e1.setCode("00500");
//         e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//         e1.setTaxedAmount("2808.8");
//         e1.setExemptAmount("2191.2");

//         earnings.add(e1);

// // Other Payments
//         List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//         payrollEarnings.setEarnings(earnings);
//         payrollEarnings.setOtherPayments(otherPayments);

// // Deductions
//         List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//         PayrollDeduction d1 = new PayrollDeduction();
//         d1.setDeductionTypeCode("001");
//         d1.setCode("00301");
//         d1.setConcept("Seguridad Social");
//         d1.setAmount("200.00");

//         PayrollDeduction d2 = new PayrollDeduction();
//         d2.setDeductionTypeCode("002");
//         d2.setCode("00302");
//         d2.setConcept("ISR");
//         d2.setAmount("100.00");

//         payrollDeductions.add(d1);
//         payrollDeductions.add(d2);

//         payroll.setEarnings(payrollEarnings);
//         payroll.setDeductions(payrollDeductions);

//         Complement complement = new Complement();
//         complement.setPayroll(payroll);

// // Invoice
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setSeries("F");
//         invoice.setDate("2026-02-09T10:00:00"); // Or use {{currentDate}} placeholder
//         invoice.setTypeCode("N");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setExpeditionZipCode("20000");
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         System.out.println(apiResponse);
//         endregion
//region timbres
//       Listar movimientos
//         ApiResponse<PagedList<StampTransaction>> apiResponse = client.getStampService().getList(1, 10);
//         System.out.println(apiResponse);

//      Obtener movimiento por ID
//                ApiResponse<StampTransaction> transactionResponse = client.getStampService().getById("77678d6d-94b1-4635-aa91-15cdd7423aab", false);
//                System.out.println(transactionResponse);        
//      Transferir timbres 
        //  StampTransactionParams transParams = new StampTransactionParams();
        //  transParams.setFromPersonId("1");
        //  transParams.setToPersonId("bef56254-0892-4558-95c3-f9c8729e4b0e");
        //  transParams.setAmount(1);
        //  transParams.setComments("venta de timbres");
        //  ApiResponse<Boolean> apiResponse = client.getStampService().transferStamps(transParams);
        //  System.out.println(apiResponse);

        //  //Retirar timbres
        //  StampTransactionParams transParams = new StampTransactionParams();
        //  transParams.setFromPersonId("bef56254-0892-4558-95c3-f9c8729e4b0e");
        //  transParams.setToPersonId("1");
        //  transParams.setAmount(1);
        //  transParams.setComments("prestamo");
        //  ApiResponse<Boolean> apiResponse = client.getStampService().withdrawStamps(transParams);
        //  System.out.println(apiResponse); 
//end region
        System.out.printf("%s\n", "End Fiscalapi!");
    }
}