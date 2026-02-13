// package com.fiscalapi.examples;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// import com.fiscalapi.OptUtil;
// import com.fiscalapi.common.ApiResponse;
// import com.fiscalapi.common.FiscalApiSettings;
// import com.fiscalapi.models.invoicing.Complement;
// import com.fiscalapi.models.invoicing.Invoice;
// import com.fiscalapi.models.invoicing.InvoiceIssuer;
// import com.fiscalapi.models.invoicing.InvoiceItem;
// import com.fiscalapi.models.invoicing.InvoiceRecipient;
// import com.fiscalapi.models.invoicing.ItemTax;
// import com.fiscalapi.models.invoicing.TaxCredential;
// import com.fiscalapi.models.invoicing.localTaxes.LocalTax;
// import com.fiscalapi.models.invoicing.localTaxes.LocalTaxes;
// import com.fiscalapi.services.FiscalApiClient;

// public class EjemplosImpuestosLocalesValores {
//     public static void main(String[] args) {
//         FiscalApiSettings settings = new FiscalApiSettings();
//         settings.setDebugMode(true);
//         settings.setApiUrl("https://test.fiscalapi.com");
//         settings.setApiKey("");
//         settings.setTenant("");

//         // Sellos de KARLA FUENTE NOLASCO. Ver https://docs.fiscalapi.com/tax-files-info#codificacion-de-fiel-o-csd-en-base64
//         final String base64Cer = "MIIFgDCCA2igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0NDYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTQzNTM3WhcNMjcwNTE4MTQzNTM3WjCBpzEdMBsGA1UEAxMUS0FSTEEgRlVFTlRFIE5PTEFTQ08xHTAbBgNVBCkTFEtBUkxBIEZVRU5URSBOT0xBU0NPMR0wGwYDVQQKExRLQVJMQSBGVUVOVEUgTk9MQVNDTzEWMBQGA1UELRMNRlVOSzY3MTIyOFBINjEbMBkGA1UEBRMSRlVOSzY3MTIyOE1DTE5MUjA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhNXbTSqGX6+/3Urpemyy5vVG2IdP2v7v001+c4BoMxEDFDQ32cOFdDiRxy0Fq9aR+Ojrofq8VeftvN586iyA1A6a0QnA68i7JnQKI4uJy+u0qiixuHu6u3b3BhSpoaVHcUtqFWLLlzr0yBxfVLOqVna/1/tHbQJg9hx57mp97P0JmXO1WeIqi+Zqob/mVZh2lsPGdJ8iqgjYFaFn9QVOQ1Pq74o1PTqwfzqgJSfV0zOOlESDPWggaDAYE4VNyTBisOUjlNd0x7ppcTxSi3yenrJHqkq/pqJsRLKf6VJ/s9p6bsd2bj07hSDpjlDC2lB25eEfkEkeMkXoE7ErXQ5QCwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAHwYpgbClHULXYhK4GNTgonvXh81oqfXwCSWAyDPiTYFDWVfWM9C4ApxMLyc0XvJte75Rla+bPC08oYN3OlhbbvP3twBL/w9SsfxvkbpFn2ZfGSTXZhyiq4vjmQHW1pnFvGelwgU4v3eeRE/MjoCnE7M/Q5thpuog6WGf7CbKERnWZn8QsUaJsZSEkg6Bv2jm69ye57ab5rrOUaeMlstTfdlaHAEkUgLX/NXq7RbGwv82hkHY5b2vYcXeh34tUMBL6os3OdRlooN9ZQGkVIISvxVZpSHkYC20DFNh1Bb0ovjfujlTcka81GnbUhFGZtRuoVQ1RVpMO8xtx3YKBLp4do3hPmnRCV5hCm43OIjYx9Ov2dqICV3AaNXSLV1dW39Bak/RBiIDGHzOIW2+VMPjvvypBjmPv/tmbqNHWPSAWOxTyMx6E1gFCZvi+5F+BgkdC3Lm7U0BU0NfvsXajZd8sXnIllvEMrikCLoI/yurvexNDcF1RW/FhMsoua0eerwczcNm66pGjHm05p9DR6lFeJZrtqeqZuojdxBWy4vH6ghyJaupergoX+nmdG3JYeRttCFF/ITI68TeCES5V3Y0C3psYAg1XxcGRLGd4chPo/4xwiLkijWtgt0/to5ljGBwfK7r62PHZfL1Dp+i7V3w7hmOlhbXzP+zhMZn1GCk7KY=";
//         final String base64Key = "MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS9AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucRBAKNQXH8t8gVCl/ItHMI2hMJ76QOECOqEi1Y89cDpegDvh/INXyMsXbzi87tfFzgq1O+9ID6aPWGg+bNGADXyXxDVdy7Nq/SCdoXvo66MTYwq8jyJeUHDHEGMVBcmZpD44VJCvLBxDcvByuevP4Wo2NKqJCwK+ecAdZc/8Rvd947SjbMHuS8BppfQWARVUqA5BLOkTAHNv6tEk/hncC7O2YOGSShart8fM8dokgGSyewHVFe08POuQ+WDHeVpvApH/SP29rwktSoiHRoL6dK+F2YeEB5SuFW9LQgYCutjapmUP/9TC3Byro9Li6UrvQHxNmgMFGQJSYjFdqlGjLibfuguLp7pueutbROoZaSxU8HqlfYxLkpJUxUwNI1ja/1t3wcivtWknVXBd13R06iVfU1HGe8Kb4u5il4a4yP4p7VT4RE3b1SBLJeG+BxHiE8gFaaKcX/Cl6JV14RPTvk/6VnAtEQ66qHJex21KKuiJo2JoOmDXVHmvGQlWXNjYgoPx28Xd5WsofL+n7HDR2Ku8XgwJw6IXBJGuoday9qWN9v/k7DGlNGB6Sm4gdVUmycMP6EGhB1vFTiDfOGQO42ywmcpKoMETPVQ5InYKE0xAOckgcminDgxWjtUHjBDPEKifEjYudPwKmR6Cf4ZdGvUWwY/zq9pPAC9bu423KeBCnSL8AQ4r5SVsW6XG0njamwfNjpegwh/YG7sS7sDtZ8gi7r6tZYjsOqZlCYU0j7QTBpuQn81Yof2nQRCFxhRJCeydmIA8+z0nXrcElk7NDPk4kYQS0VitJ2qeQYNENzGBglROkCl2y6GlxAG80IBtReCUp/xOSdlwDR0eim+SNkdStvmQM5IcWBuDKwGZc1A4v/UoLl7niV9fpl4X6bUX8lZzY4gidJOafoJ30VoY/lYGkrkEuz3GpbbT5v8fF3iXVRlEqhlpe8JSGu7Rd2cPcJSkQ1Cuj/QRhHPhFMF2KhTEf95c9ZBKI8H7SvBi7eLXfSW2Y0ve6vXBZKyjK9whgCU9iVOsJjqRXpAccaWOKi420CjmS0+uwj/Xr2wLZhPEjBA/G6Od30+eG9mICmbp/5wAGhK/ZxCT17ZETyFmOMo49jl9pxdKocJNuzMrLpSz7/g5Jwp8+y8Ck5YP7AX0R/dVA0t37DO7nAbQT5XVSYpMVh/yvpYJ9WR+tb8Yg1h2lERLR2fbuhQRcwmisZR2W3Sr2b7hX9MCMkMQw8y2fDJrzLrqKqkHcjvnI/TdzZW2MzeQDoBBb3fmgvjYg07l4kThS73wGX992w2Y+a1A2iirSmrYEm9dSh16JmXa8boGQAONQzQkHh7vpw0IBs9cnvqO1QLB1GtbBztUBXonA4TxMKLYZkVrrd2RhrYWMsDp7MpC4M0p/DA3E/qscYwq1OpwriewNdx6XXqMZbdUNqMP2viBY2VSGmNdHtVfbN/rnaeJetFGX7XgTVYD7wDq8TW9yseCK944jcT+y/o0YiT9j3OLQ2Ts0LDTQskpJSxRmXEQGy3NBDOYFTvRkcGJEQJItuol8NivJN1H9LoLIUAlAHBZxfHpUYx66YnP4PdTdMIWH+nxyekKPFfAT7olQ=";
//         final String password = "12345678a";

//         LocalDateTime currentDate = OptUtil.parseLocalDateTime(LocalDateTime.now().toString());
//         FiscalApiClient client = FiscalApiClient.create(settings);

//         // //Ingreso Impuestos locales
//         // // Emisor
//         // InvoiceIssuer issuer = new InvoiceIssuer();
//         // issuer.setTin("FUNK671228PH6");
//         // issuer.setLegalName("KARLA FUENTE NOLASCO");
//         // issuer.setTaxRegimeCode("621");
        
//         // // Tax credentials
//         // List<TaxCredential> taxCredentials = new ArrayList<>();
        
//         // TaxCredential cer = new TaxCredential();
//         // cer.setBase64File(base64Cer);
//         // cer.setFileType(0); // 0=Certificate (.cer) | 1=Private key (.key)
//         // cer.setPassword(password);
        
//         // TaxCredential key = new TaxCredential();
//         // key.setBase64File(base64Key);
//         // key.setFileType(1); // 0=Certificate (.cer) | 1=Private key (.key)
//         // key.setPassword(password);
        
//         // taxCredentials.add(cer);
//         // taxCredentials.add(key);
        
//         // issuer.setTaxCredentials(taxCredentials);

//         // // Receptor
//         // InvoiceRecipient recipient = new InvoiceRecipient();
//         // recipient.setTin("EKU9003173C9");
//         // recipient.setLegalName("ESCUELA KEMPER URGATE");
//         // recipient.setZipCode("42501");
//         // recipient.setTaxRegimeCode("601");
//         // recipient.setCfdiUseCode("G01");
//         // recipient.setEmail("someone@somewhere.com");

//         // // Items
//         // List<InvoiceItem> items = new ArrayList<>();

//         // // Item 1
//         // InvoiceItem item1 = new InvoiceItem();
//         // item1.setItemCode("01010101");
//         // item1.setQuantity(new BigDecimal("9.5"));
//         // item1.setUnitOfMeasurementCode("E48");
//         // item1.setUnitOfMeasurement("Unidad de servicio");
//         // item1.setDescription("Invoicing software as a service");
//         // item1.setUnitPrice(new BigDecimal("3587.75"));
//         // item1.setTaxObjectCode("02");
//         // item1.setItemSku("7506022301697");
//         // item1.setDiscount(new BigDecimal("255.85"));

//         // List<ItemTax> taxes1 = new ArrayList<>();
//         // ItemTax tax1 = new ItemTax();
//         // tax1.setTaxCode("002");
//         // tax1.setTaxTypeCode("Tasa");
//         // tax1.setTaxRate(new BigDecimal("0.160000"));
//         // tax1.setTaxFlagCode("T");
//         // taxes1.add(tax1);

//         // item1.setItemTaxes(taxes1);

//         // // Item 2
//         // InvoiceItem item2 = new InvoiceItem();
//         // item2.setItemCode("01010101");
//         // item2.setQuantity(new BigDecimal("8.0"));
//         // item2.setUnitOfMeasurementCode("E48");
//         // item2.setUnitOfMeasurement("Unidad de servicio2");
//         // item2.setDescription("Software Consultant");
//         // item2.setUnitPrice(new BigDecimal("250.85"));
//         // item2.setTaxObjectCode("02");
//         // item2.setItemSku("7506022301698");
//         // item2.setDiscount(new BigDecimal("255.85"));

//         // List<ItemTax> taxes2 = new ArrayList<>();
//         // ItemTax tax2 = new ItemTax();
//         // tax2.setTaxCode("002");
//         // tax2.setTaxTypeCode("Tasa");
//         // tax2.setTaxRate(new BigDecimal("0.160000"));
//         // tax2.setTaxFlagCode("T");
//         // taxes2.add(tax2);

//         // item2.setItemTaxes(taxes2);

//         // // Item 3
//         // InvoiceItem item3 = new InvoiceItem();
//         // item3.setItemCode("01010101");
//         // item3.setQuantity(new BigDecimal("6.0"));
//         // item3.setUnitOfMeasurementCode("E48");
//         // item3.setUnitOfMeasurement("Unidad de servicio3");
//         // item3.setDescription("Computer software");
//         // item3.setUnitPrice(new BigDecimal("1250.75"));
//         // item3.setTaxObjectCode("02");
//         // item3.setItemSku("7506022301699");

//         // List<ItemTax> taxes3 = new ArrayList<>();
//         // ItemTax tax3a = new ItemTax();
//         // tax3a.setTaxCode("002");
//         // tax3a.setTaxTypeCode("Tasa");
//         // tax3a.setTaxRate(new BigDecimal("0.160000"));
//         // tax3a.setTaxFlagCode("T");
//         // taxes3.add(tax3a);

//         // ItemTax tax3b = new ItemTax();
//         // tax3b.setTaxCode("002");
//         // tax3b.setTaxTypeCode("Tasa");
//         // tax3b.setTaxRate(new BigDecimal("0.106666"));
//         // tax3b.setTaxFlagCode("R");
//         // taxes3.add(tax3b);

//         // item3.setItemTaxes(taxes3);

//         // items.add(item1);
//         // items.add(item2);
//         // items.add(item3);

//         // // Local Taxes Complement
//         // LocalTaxes localTaxes = new LocalTaxes();
//         // List<LocalTax> localTaxList = new ArrayList<>();

//         // LocalTax localTax1 = new LocalTax();
//         // localTax1.setTaxName("CEDULAR");
//         // localTax1.setTaxRate(new BigDecimal("3.00"));
//         // localTax1.setTaxAmount(new BigDecimal("6.00"));
//         // localTax1.setTaxFlagCode("R");

//         // LocalTax localTax2 = new LocalTax();
//         // localTax2.setTaxName("ISH");
//         // localTax2.setTaxRate(new BigDecimal("8.00"));
//         // localTax2.setTaxAmount(new BigDecimal("16.00"));
//         // localTax2.setTaxFlagCode("R");

//         // localTaxList.add(localTax1);
//         // localTaxList.add(localTax2);

//         // localTaxes.setTaxes(localTaxList);

//         // // Invoice
//         // Invoice invoice = new Invoice();
//         // invoice.setVersionCode("4.0");
//         // invoice.setSeries("F");
//         // invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//         // invoice.setPaymentFormCode("01");
//         // invoice.setPaymentConditions("Contado");
//         // invoice.setCurrencyCode("MXN");
//         // invoice.setTypeCode("I");
//         // invoice.setExpeditionZipCode("42501");
//         // invoice.setPaymentMethodCode("PUE");
//         // invoice.setExchangeRate(new BigDecimal("1.0"));
//         // invoice.setExportCode("01");
//         // invoice.setIssuer(issuer);
//         // invoice.setRecipient(recipient);
//         // invoice.setItems(items);

//         // // Set complement with local taxes
//         // Complement complement = new Complement();
//         // complement.setLocalTaxes(localTaxes);
//         // invoice.setComplement(complement);

//         // ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         // System.out.println(apiResponse);

//         // //Ingreso impuestos locales CEDULAR
//         // // Emisor
//         // InvoiceIssuer issuer = new InvoiceIssuer();
//         // issuer.setTin("FUNK671228PH6");
//         // issuer.setLegalName("KARLA FUENTE NOLASCO");
//         // issuer.setTaxRegimeCode("621");
        
//         // // Tax credentials
//         // List<TaxCredential> taxCredentials = new ArrayList<>();
        
//         // TaxCredential cer = new TaxCredential();
//         // cer.setBase64File(base64Cer);
//         // cer.setFileType(0); // 0=Certificate (.cer) | 1=Private key (.key)
//         // cer.setPassword(password);
        
//         // TaxCredential key = new TaxCredential();
//         // key.setBase64File(base64Key);
//         // key.setFileType(1); // 0=Certificate (.cer) | 1=Private key (.key)
//         // key.setPassword(password);
        
//         // taxCredentials.add(cer);
//         // taxCredentials.add(key);
        
//         // issuer.setTaxCredentials(taxCredentials);

//         // // Receptor
//         // InvoiceRecipient recipient = new InvoiceRecipient();
//         // recipient.setTin("EKU9003173C9");
//         // recipient.setLegalName("ESCUELA KEMPER URGATE");
//         // recipient.setZipCode("42501");
//         // recipient.setTaxRegimeCode("601");
//         // recipient.setCfdiUseCode("G01");
//         // recipient.setEmail("someone@somewhere.com");

//         // // Items
//         // List<InvoiceItem> items = new ArrayList<>();

//         // // Item 1
//         // InvoiceItem item1 = new InvoiceItem();
//         // item1.setItemCode("01010101");
//         // item1.setQuantity(new BigDecimal("9.5"));
//         // item1.setUnitOfMeasurementCode("E48");
//         // item1.setUnitOfMeasurement("Unidad de servicio");
//         // item1.setDescription("Invoicing software as a service");
//         // item1.setUnitPrice(new BigDecimal("3587.75"));
//         // item1.setTaxObjectCode("02");
//         // item1.setItemSku("7506022301697");
//         // item1.setDiscount(new BigDecimal("255.85"));

//         // List<ItemTax> taxes1 = new ArrayList<>();
//         // ItemTax tax1 = new ItemTax();
//         // tax1.setTaxCode("002");
//         // tax1.setTaxTypeCode("Tasa");
//         // tax1.setTaxRate(new BigDecimal("0.160000"));
//         // tax1.setTaxFlagCode("T");
//         // taxes1.add(tax1);

//         // item1.setItemTaxes(taxes1);

//         // // Item 2
//         // InvoiceItem item2 = new InvoiceItem();
//         // item2.setItemCode("01010101");
//         // item2.setQuantity(new BigDecimal("8.0"));
//         // item2.setUnitOfMeasurementCode("E48");
//         // item2.setUnitOfMeasurement("Unidad de servicio2");
//         // item2.setDescription("Software Consultant");
//         // item2.setUnitPrice(new BigDecimal("250.85"));
//         // item2.setTaxObjectCode("02");
//         // item2.setItemSku("7506022301698");
//         // item2.setDiscount(new BigDecimal("255.85"));

//         // List<ItemTax> taxes2 = new ArrayList<>();
//         // ItemTax tax2 = new ItemTax();
//         // tax2.setTaxCode("002");
//         // tax2.setTaxTypeCode("Tasa");
//         // tax2.setTaxRate(new BigDecimal("0.160000"));
//         // tax2.setTaxFlagCode("T");
//         // taxes2.add(tax2);

//         // item2.setItemTaxes(taxes2);

//         // // Item 3
//         // InvoiceItem item3 = new InvoiceItem();
//         // item3.setItemCode("01010101");
//         // item3.setQuantity(new BigDecimal("6.0"));
//         // item3.setUnitOfMeasurementCode("E48");
//         // item3.setUnitOfMeasurement("Unidad de servicio3");
//         // item3.setDescription("Computer software");
//         // item3.setUnitPrice(new BigDecimal("1250.75"));
//         // item3.setTaxObjectCode("02");
//         // item3.setItemSku("7506022301699");

//         // List<ItemTax> taxes3 = new ArrayList<>();
//         // ItemTax tax3a = new ItemTax();
//         // tax3a.setTaxCode("002");
//         // tax3a.setTaxTypeCode("Tasa");
//         // tax3a.setTaxRate(new BigDecimal("0.160000"));
//         // tax3a.setTaxFlagCode("T");
//         // taxes3.add(tax3a);

//         // ItemTax tax3b = new ItemTax();
//         // tax3b.setTaxCode("002");
//         // tax3b.setTaxTypeCode("Tasa");
//         // tax3b.setTaxRate(new BigDecimal("0.106666"));
//         // tax3b.setTaxFlagCode("R");
//         // taxes3.add(tax3b);

//         // item3.setItemTaxes(taxes3);

//         // items.add(item1);
//         // items.add(item2);
//         // items.add(item3);

//         // // Local Taxes Complement - CEDULAR only
//         // LocalTaxes localTaxes = new LocalTaxes();
//         // List<LocalTax> localTaxList = new ArrayList<>();

//         // LocalTax cedularTax = new LocalTax();
//         // cedularTax.setTaxName("CEDULAR");
//         // cedularTax.setTaxRate(new BigDecimal("3.00"));
//         // cedularTax.setTaxAmount(new BigDecimal("6.00"));
//         // cedularTax.setTaxFlagCode("R");

//         // localTaxList.add(cedularTax);

//         // localTaxes.setTaxes(localTaxList);

//         // // Invoice
//         // Invoice invoice = new Invoice();
//         // invoice.setVersionCode("4.0");
//         // invoice.setSeries("F");
//         // invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//         // invoice.setPaymentFormCode("01");
//         // invoice.setPaymentConditions("Contado");
//         // invoice.setCurrencyCode("MXN");
//         // invoice.setTypeCode("I");
//         // invoice.setExpeditionZipCode("42501");
//         // invoice.setPaymentMethodCode("PUE");
//         // invoice.setExchangeRate(new BigDecimal("1.0"));
//         // invoice.setExportCode("01");
//         // invoice.setIssuer(issuer);
//         // invoice.setRecipient(recipient);
//         // invoice.setItems(items);

//         // // Set complement with local taxes
//         // Complement complement = new Complement();
//         // complement.setLocalTaxes(localTaxes);
//         // invoice.setComplement(complement);

//         // ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         // System.out.println(apiResponse);

//         // // Factura ingreso impuestos locales ISH
//         // // Emisor
//         // InvoiceIssuer issuer = new InvoiceIssuer();
//         // issuer.setTin("FUNK671228PH6");
//         // issuer.setLegalName("KARLA FUENTE NOLASCO");
//         // issuer.setTaxRegimeCode("621");
        
//         // // Tax credentials
//         // List<TaxCredential> taxCredentials = new ArrayList<>();
        
//         // TaxCredential cer = new TaxCredential();
//         // cer.setBase64File(base64Cer);
//         // cer.setFileType(0); // 0=Certificate (.cer) | 1=Private key (.key)
//         // cer.setPassword(password);
        
//         // TaxCredential key = new TaxCredential();
//         // key.setBase64File(base64Key);
//         // key.setFileType(1); // 0=Certificate (.cer) | 1=Private key (.key)
//         // key.setPassword(password);
        
//         // taxCredentials.add(cer);
//         // taxCredentials.add(key);
        
//         // issuer.setTaxCredentials(taxCredentials);

//         // // Receptor
//         // InvoiceRecipient recipient = new InvoiceRecipient();
//         // recipient.setTin("EKU9003173C9");
//         // recipient.setLegalName("ESCUELA KEMPER URGATE");
//         // recipient.setZipCode("42501");
//         // recipient.setTaxRegimeCode("601");
//         // recipient.setCfdiUseCode("G01");
//         // recipient.setEmail("someone@somewhere.com");

//         // // Items
//         // List<InvoiceItem> items = new ArrayList<>();

//         // // Item 1
//         // InvoiceItem item1 = new InvoiceItem();
//         // item1.setItemCode("01010101");
//         // item1.setQuantity(new BigDecimal("9.5"));
//         // item1.setUnitOfMeasurementCode("E48");
//         // item1.setUnitOfMeasurement("Unidad de servicio");
//         // item1.setDescription("Invoicing software as a service");
//         // item1.setUnitPrice(new BigDecimal("3587.75"));
//         // item1.setTaxObjectCode("02");
//         // item1.setItemSku("7506022301697");
//         // item1.setDiscount(new BigDecimal("255.85"));

//         // List<ItemTax> taxes1 = new ArrayList<>();
//         // ItemTax tax1 = new ItemTax();
//         // tax1.setTaxCode("002");
//         // tax1.setTaxTypeCode("Tasa");
//         // tax1.setTaxRate(new BigDecimal("0.160000"));
//         // tax1.setTaxFlagCode("T");
//         // taxes1.add(tax1);

//         // item1.setItemTaxes(taxes1);

//         // // Item 2
//         // InvoiceItem item2 = new InvoiceItem();
//         // item2.setItemCode("01010101");
//         // item2.setQuantity(new BigDecimal("8.0"));
//         // item2.setUnitOfMeasurementCode("E48");
//         // item2.setUnitOfMeasurement("Unidad de servicio2");
//         // item2.setDescription("Software Consultant");
//         // item2.setUnitPrice(new BigDecimal("250.85"));
//         // item2.setTaxObjectCode("02");
//         // item2.setItemSku("7506022301698");
//         // item2.setDiscount(new BigDecimal("255.85"));

//         // List<ItemTax> taxes2 = new ArrayList<>();
//         // ItemTax tax2 = new ItemTax();
//         // tax2.setTaxCode("002");
//         // tax2.setTaxTypeCode("Tasa");
//         // tax2.setTaxRate(new BigDecimal("0.160000"));
//         // tax2.setTaxFlagCode("T");
//         // taxes2.add(tax2);

//         // item2.setItemTaxes(taxes2);

//         // // Item 3
//         // InvoiceItem item3 = new InvoiceItem();
//         // item3.setItemCode("01010101");
//         // item3.setQuantity(new BigDecimal("6.0"));
//         // item3.setUnitOfMeasurementCode("E48");
//         // item3.setUnitOfMeasurement("Unidad de servicio3");
//         // item3.setDescription("Computer software");
//         // item3.setUnitPrice(new BigDecimal("1250.75"));
//         // item3.setTaxObjectCode("02");
//         // item3.setItemSku("7506022301699");

//         // List<ItemTax> taxes3 = new ArrayList<>();
//         // ItemTax tax3a = new ItemTax();
//         // tax3a.setTaxCode("002");
//         // tax3a.setTaxTypeCode("Tasa");
//         // tax3a.setTaxRate(new BigDecimal("0.160000"));
//         // tax3a.setTaxFlagCode("T");
//         // taxes3.add(tax3a);

//         // ItemTax tax3b = new ItemTax();
//         // tax3b.setTaxCode("002");
//         // tax3b.setTaxTypeCode("Tasa");
//         // tax3b.setTaxRate(new BigDecimal("0.106666"));
//         // tax3b.setTaxFlagCode("R");
//         // taxes3.add(tax3b);

//         // item3.setItemTaxes(taxes3);

//         // items.add(item1);
//         // items.add(item2);
//         // items.add(item3);

//         // // Local Taxes Complement - ISH only
//         // LocalTaxes localTaxes = new LocalTaxes();
//         // List<LocalTax> localTaxList = new ArrayList<>();

//         // LocalTax ishTax = new LocalTax();
//         // ishTax.setTaxName("ISH");
//         // ishTax.setTaxRate(new BigDecimal("8.00"));
//         // ishTax.setTaxAmount(new BigDecimal("16.00"));
//         // ishTax.setTaxFlagCode("R");

//         // localTaxList.add(ishTax);

//         // localTaxes.setTaxes(localTaxList);

//         // // Invoice
//         // Invoice invoice = new Invoice();
//         // invoice.setVersionCode("4.0");
//         // invoice.setSeries("F");
//         // invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//         // invoice.setPaymentFormCode("01");
//         // invoice.setPaymentConditions("Contado");
//         // invoice.setCurrencyCode("MXN");
//         // invoice.setTypeCode("I");
//         // invoice.setExpeditionZipCode("42501");
//         // invoice.setPaymentMethodCode("PUE");
//         // invoice.setExchangeRate(new BigDecimal("1.0"));
//         // invoice.setExportCode("01");
//         // invoice.setIssuer(issuer);
//         // invoice.setRecipient(recipient);
//         // invoice.setItems(items);

//         // // Set complement with local taxes
//         // Complement complement = new Complement();
//         // complement.setLocalTaxes(localTaxes);
//         // invoice.setComplement(complement);

//         // ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//         // System.out.println(apiResponse);
//     }
// }
