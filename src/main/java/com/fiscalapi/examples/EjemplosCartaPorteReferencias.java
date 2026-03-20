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
// import com.fiscalapi.models.invoicing.billOfLading.Autotransporte;
// import com.fiscalapi.models.invoicing.billOfLading.CantidadTransporta;
// import com.fiscalapi.models.invoicing.billOfLading.CartaPorte;
// import com.fiscalapi.models.invoicing.billOfLading.DocumentoAduanero;
// import com.fiscalapi.models.invoicing.billOfLading.Domicilio;
// import com.fiscalapi.models.invoicing.billOfLading.Mercancia;
// import com.fiscalapi.models.invoicing.billOfLading.RegimenAduanero;
// import com.fiscalapi.models.invoicing.billOfLading.Remolque;
// import com.fiscalapi.models.invoicing.billOfLading.TipoFigura;
// import com.fiscalapi.models.invoicing.billOfLading.ParteTransporte;
// import com.fiscalapi.models.invoicing.billOfLading.DetalleMercancia;
// import com.fiscalapi.models.invoicing.billOfLading.TransporteAereo;
// import com.fiscalapi.models.invoicing.billOfLading.TransporteFerroviario;
// import com.fiscalapi.models.invoicing.billOfLading.TransporteMaritimo;
// import com.fiscalapi.models.invoicing.billOfLading.Ubicacion;
// import com.fiscalapi.services.FiscalApiClient;

// public class EjemplosCartaPorteReferencias {

//     final String escuelaKemperUrgateBase64Cer = "MIIFsDCCA5igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0MTYwDQYJKoZIhvcNAQELBQAwggErMQ8wDQYDVQQDDAZBQyBVQVQxLjAsBgNVBAoMJVNFUlZJQ0lPIERFIEFETUlOSVNUUkFDSU9OIFRSSUJVVEFSSUExGjAYBgNVBAsMEVNBVC1JRVMgQXV0aG9yaXR5MSgwJgYJKoZIhvcNAQkBFhlvc2Nhci5tYXJ0aW5lekBzYXQuZ29iLm14MR0wGwYDVQQJDBQzcmEgY2VycmFkYSBkZSBjYWxpejEOMAwGA1UEEQwFMDYzNzAxCzAJBgNVBAYTAk1YMRkwFwYDVQQIDBBDSVVEQUQgREUgTUVYSUNPMREwDwYDVQQHDAhDT1lPQUNBTjERMA8GA1UELRMIMi41LjQuNDUxJTAjBgkqhkiG9w0BCQITFnJlc3BvbnNhYmxlOiBBQ0RNQS1TQVQwHhcNMjMwNTE4MTE0MzUxWhcNMjcwNTE4MTE0MzUxWjCB1zEnMCUGA1UEAxMeRVNDVUVMQSBLRU1QRVIgVVJHQVRFIFNBIERFIENWMScwJQYDVQQpEx5FU0NVRUxBIEtFTVBFUiBVUkdBVEUgU0EgREUgQ1YxJzAlBgNVBAoTHkVTQ1VFTEEgS0VNUEVSIFVSR0FURSBTQSBERSBDVjElMCMGA1UELRMcRUtVOTAwMzE3M0M5IC8gVkFEQTgwMDkyN0RKMzEeMBwGA1UEBRMVIC8gVkFEQTgwMDkyN0hTUlNSTDA1MRMwEQYDVQQLEwpTdWN1cnNhbCAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtmecO6n2GS0zL025gbHGQVxznPDICoXzR2uUngz4DqxVUC/w9cE6FxSiXm2ap8Gcjg7wmcZfm85EBaxCx/0J2u5CqnhzIoGCdhBPuhWQnIh5TLgj/X6uNquwZkKChbNe9aeFirU/JbyN7Egia9oKH9KZUsodiM/pWAH00PCtoKJ9OBcSHMq8Rqa3KKoBcfkg1ZrgueffwRLws9yOcRWLb02sDOPzGIm/jEFicVYt2Hw1qdRE5xmTZ7AGG0UHs+unkGjpCVeJ+BEBn0JPLWVvDKHZAQMj6s5Bku35+d/MyATkpOPsGT/VTnsouxekDfikJD1f7A1ZpJbqDpkJnss3vQIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQsFAAOCAgEAFaUgj5PqgvJigNMgtrdXZnbPfVBbukAbW4OGnUhNrA7SRAAfv2BSGk16PI0nBOr7qF2mItmBnjgEwk+DTv8Zr7w5qp7vleC6dIsZFNJoa6ZndrE/f7KO1CYruLXr5gwEkIyGfJ9NwyIagvHHMszzyHiSZIA850fWtbqtythpAliJ2jF35M5pNS+YTkRB+T6L/c6m00ymN3q9lT1rB03YywxrLreRSFZOSrbwWfg34EJbHfbFXpCSVYdJRfiVdvHnewN0r5fUlPtR9stQHyuqewzdkyb5jTTw02D2cUfL57vlPStBj7SEi3uOWvLrsiDnnCIxRMYJ2UA2ktDKHk+zWnsDmaeleSzonv2CHW42yXYPCvWi88oE1DJNYLNkIjua7MxAnkNZbScNw01A6zbLsZ3y8G6eEYnxSTRfwjd8EP4kdiHNJftm7Z4iRU7HOVh79/lRWB+gd171s3d/mI9kte3MRy6V8MMEMCAnMboGpaooYwgAmwclI2XZCczNWXfhaWe0ZS5PmytD/GDpXzkX0oEgY9K/uYo5V77NdZbGAjmyi8cE2B2ogvyaN2XfIInrZPgEffJ4AB7kFA2mwesdLOCh0BLD9itmCve3A1FGR4+stO2ANUoiI3w3Tv2yQSg4bjeDlJ08lXaaFCLW2peEXMXjQUk7fmpb5MNuOUTW6BE=";
//     final String escuelaKemperUrgateBase64Key = "MIIFDjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIAgEAAoIBAQACAggAMBQGCCqGSIb3DQMHBAgwggS/AgEAMASCBMh4EHl7aNSCaMDA1VlRoXCZ5UUmqErAbucoZQObOaLUEm+I+QZ7Y8Giupo+F1XWkLvAsdk/uZlJcTfKLJyJbJwsQYbSpLOCLataZ4O5MVnnmMbfG//NKJn9kSMvJQZhSwAwoGLYDm1ESGezrvZabgFJnoQv8Si1nAhVGTk9FkFBesxRzq07dmZYwFCnFSX4xt2fDHs1PMpQbeq83aL/PzLCce3kxbYSB5kQlzGtUYayiYXcu0cVRu228VwBLCD+2wTDDoCmRXtPesgrLKUR4WWWb5N2AqAU1mNDC+UEYsENAerOFXWnmwrcTAu5qyZ7GsBMTpipW4Dbou2yqQ0lpA/aB06n1kz1aL6mNqGPaJ+OqoFuc8Ugdhadd+MmjHfFzoI20SZ3b2geCsUMNCsAd6oXMsZdWm8lzjqCGWHFeol0ik/xHMQvuQkkeCsQ28PBxdnUgf7ZGer+TN+2ZLd2kvTBOk6pIVgy5yC6cZ+o1Tloql9hYGa6rT3xcMbXlW+9e5jM2MWXZliVW3ZhaPjptJFDbIfWxJPjz4QvKyJk0zok4muv13Iiwj2bCyefUTRz6psqI4cGaYm9JpscKO2RCJN8UluYGbbWmYQU+Int6LtZj/lv8p6xnVjWxYI+rBPdtkpfFYRp+MJiXjgPw5B6UGuoruv7+vHjOLHOotRo+RdjZt7NqL9dAJnl1Qb2jfW6+d7NYQSI/bAwxO0sk4taQIT6Gsu/8kfZOPC2xk9rphGqCSS/4q3Os0MMjA1bcJLyoWLp13pqhK6bmiiHw0BBXH4fbEp4xjSbpPx4tHXzbdn8oDsHKZkWh3pPC2J/nVl0k/yF1KDVowVtMDXE47k6TGVcBoqe8PDXCG9+vjRpzIidqNo5qebaUZu6riWMWzldz8x3Z/jLWXuDiM7/Yscn0Z2GIlfoeyz+GwP2eTdOw9EUedHjEQuJY32bq8LICimJ4Ht+zMJKUyhwVQyAER8byzQBwTYmYP5U0wdsyIFitphw+/IH8+v08Ia1iBLPQAeAvRfTTIFLCs8foyUrj5Zv2B/wTYIZy6ioUM+qADeXyo45uBLLqkN90Rf6kiTqDld78NxwsfyR5MxtJLVDFkmf2IMMJHTqSfhbi+7QJaC11OOUJTD0v9wo0X/oO5GvZhe0ZaGHnm9zqTopALuFEAxcaQlc4R81wjC4wrIrqWnbcl2dxiBtD73KW+wcC9ymsLf4I8BEmiN25lx/OUc1IHNyXZJYSFkEfaxCEZWKcnbiyf5sqFSSlEqZLc4lUPJFAoP6s1FHVcyO0odWqdadhRZLZC9RCzQgPlMRtji/OXy5phh7diOBZv5UYp5nb+MZ2NAB/eFXm2JLguxjvEstuvTDmZDUb6Uqv++RdhO5gvKf/AcwU38ifaHQ9uvRuDocYwVxZS2nr9rOwZ8nAh+P2o4e0tEXjxFKQGhxXYkn75H3hhfnFYjik/2qunHBBZfcdG148MaNP6DjX33M238T9Zw/GyGx00JMogr2pdP4JAErv9a5yt4YR41KGf8guSOUbOXVARw6+ybh7+meb7w4BeTlj3aZkv8tVGdfIt3lrwVnlbzhLjeQY6PplKp3/a5Kr5yM0T4wJoKQQ6v3vSNmrhpbuAtKxpMILe8CQoo=";
//     final String password = "12345678a";

//     public void main(String[] args) {
//         FiscalApiSettings settings = new FiscalApiSettings();
//         settings.setDebugMode(true);
//         settings.setApiUrl("https://test.fiscalapi.com");
//         settings.setApiKey("sk_test_b7dae706_e16f_4faf_90fb_a5d1990985a2");
//         settings.setTenant("275510ee-f64d-435a-9e92-1553d8f10a7e");

//         facturaIngresoAutoTransporteNacional(settings);
//     }

//     // Factura ingreso autotransporte nacional (sin impuestos)
//     private void facturaIngresoAutoTransporteNacional(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         LocalDateTime currentDate = OptUtil.parseLocalDateTime(LocalDateTime.now().toString());

//         // Issuer
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

//         // Recipient
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

//         // Items
//         InvoiceItem item = new InvoiceItem();
//         item.setItemCode("78101800");
//         item.setItemSku("UT421511");
//         item.setQuantity(new BigDecimal("1"));
//         item.setUnitOfMeasurementCode("H87");
//         item.setDescription("Transporte de carga por carretera");
//         item.setUnitPrice(new BigDecimal("100.00"));
//         item.setDiscount(new BigDecimal("0"));
//         item.setTaxObjectCode("01");
//         item.setItemTaxes(new ArrayList<>());
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(item);

//         // Ubicacion Origen
//         Domicilio domicilioOrigen = new Domicilio();
//         domicilioOrigen.setCalle("Calle1");
//         domicilioOrigen.setNumeroExterior("211");
//         domicilioOrigen.setNumeroInterior("212");
//         domicilioOrigen.setColoniaId("1957");
//         domicilioOrigen.setLocalidadId("13");
//         domicilioOrigen.setReferencia("casa blanca");
//         domicilioOrigen.setMunicipioId("011");
//         domicilioOrigen.setEstadoId("CMX");
//         domicilioOrigen.setPaisId("MEX");
//         domicilioOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("URE180429TM6");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setDomicilio(domicilioOrigen);

//         // Ubicacion Destino
//         Domicilio domicilioDestino = new Domicilio();
//         domicilioDestino.setCalle("Calle2");
//         domicilioDestino.setNumeroExterior("214");
//         domicilioDestino.setNumeroInterior("215");
//         domicilioDestino.setColoniaId("0347");
//         domicilioDestino.setLocalidadId("23");
//         domicilioDestino.setReferencia("casa negra");
//         domicilioDestino.setMunicipioId("004");
//         domicilioDestino.setEstadoId("COA");
//         domicilioDestino.setPaisId("MEX");
//         domicilioDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("URE180429TM6");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDistanciaRecorrida(new BigDecimal("1"));
//         destino.setDomicilio(domicilioDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia
//         CantidadTransporta cantidadTransporta = new CantidadTransporta();
//         cantidadTransporta.setCantidad(new BigDecimal("1"));
//         cantidadTransporta.setIdOrigen("OR101010");
//         cantidadTransporta.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(cantidadTransporta);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2003-04-02T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setFormaFarmaceuticaId("01");
//         mercancia.setCondicionesEspTranspId("01");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setFraccionArancelariaId("6309000100");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // Autotransporte
//         Remolque remolque = new Remolque();
//         remolque.setSubTipoRemId("CTR004");
//         remolque.setPlaca("VL45K98");
//         List<Remolque> remolques = new ArrayList<>();
//         remolques.add(remolque);

//         Autotransporte autotransporte = new Autotransporte();
//         autotransporte.setPermSCTId("TPAF01");
//         autotransporte.setNumPermisoSCT("NumPermisoSCT1");
//         autotransporte.setConfigVehicularId("VL");
//         autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
//         autotransporte.setPlacaVM("plac892");
//         autotransporte.setAnioModeloVM(2020);
//         autotransporte.setAseguraRespCivil("AseguraRespCivil");
//         autotransporte.setPolizaRespCivil("123456789");
//         autotransporte.setRemolques(remolques);

//         // TipoFigura
//         Domicilio domicilioFigura = new Domicilio();
//         domicilioFigura.setCalle("Calle1");
//         domicilioFigura.setNumeroExterior("NumeroExterior1");
//         domicilioFigura.setNumeroInterior("NumeroInterior1");
//         domicilioFigura.setColoniaId("Colonia1");
//         domicilioFigura.setLocalidadId("Localidad1");
//         domicilioFigura.setReferencia("Referencia1");
//         domicilioFigura.setMunicipioId("Municipio1");
//         domicilioFigura.setEstadoId("Estado1");
//         domicilioFigura.setPaisId("AFG");
//         domicilioFigura.setCodigoPostalId("CodigoPosta1");

//         TipoFigura tipoFigura = new TipoFigura();
//         tipoFigura.setTipoFiguraId("01");
//         tipoFigura.setRfcFigura("URE180429TM6");
//         tipoFigura.setNumLicencia("NumLicencia1");
//         tipoFigura.setNombreFigura("NombreFigura1");
//         tipoFigura.setDomicilio(domicilioFigura);
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(tipoFigura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setTotalDistRec(new BigDecimal("1"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setLogisticaInversaRecoleccionDevolucionId("Sí");
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setAutotransporte(autotransporte);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setPaymentFormCode("01");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setTypeCode("I");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("SerieCCP31");
//         invoice.setDate(currentDate);
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso autotransporte nacional con impuestos
//     private void facturaIngresoAutoTransporteNacionalConImpuestos(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         LocalDateTime currentDate = OptUtil.parseLocalDateTime(LocalDateTime.now().toString());

//         // Issuer
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

//         // Recipient
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

//         // Items
//         List<ItemTax> itemTaxes = new ArrayList<>();
//         ItemTax ivaTraslado = new ItemTax();
//         ivaTraslado.setTaxCode("002");
//         ivaTraslado.setTaxTypeCode("Tasa");
//         ivaTraslado.setTaxRate(new BigDecimal("0.160000"));
//         ivaTraslado.setTaxFlagCode("T");
//         itemTaxes.add(ivaTraslado);
//         ItemTax ivaRetencion = new ItemTax();
//         ivaRetencion.setTaxCode("002");
//         ivaRetencion.setTaxTypeCode("Tasa");
//         ivaRetencion.setTaxRate(new BigDecimal("0.040000"));
//         ivaRetencion.setTaxFlagCode("R");
//         itemTaxes.add(ivaRetencion);

//         InvoiceItem item = new InvoiceItem();
//         item.setItemCode("78101800");
//         item.setItemSku("UT421511");
//         item.setQuantity(new BigDecimal("1"));
//         item.setUnitOfMeasurementCode("H87");
//         item.setDescription("Transporte de carga por carretera");
//         item.setUnitPrice(new BigDecimal("26232.75"));
//         item.setDiscount(new BigDecimal("0"));
//         item.setTaxObjectCode("02");
//         item.setItemTaxes(itemTaxes);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(item);

//         // Ubicacion Origen
//         Domicilio domicilioOrigen = new Domicilio();
//         domicilioOrigen.setCalle("Calle1");
//         domicilioOrigen.setNumeroExterior("211");
//         domicilioOrigen.setNumeroInterior("212");
//         domicilioOrigen.setColoniaId("1957");
//         domicilioOrigen.setLocalidadId("13");
//         domicilioOrigen.setReferencia("casa blanca");
//         domicilioOrigen.setMunicipioId("011");
//         domicilioOrigen.setEstadoId("CMX");
//         domicilioOrigen.setPaisId("MEX");
//         domicilioOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("URE180429TM6");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setDomicilio(domicilioOrigen);

//         // Ubicacion Destino
//         Domicilio domicilioDestino = new Domicilio();
//         domicilioDestino.setCalle("Calle2");
//         domicilioDestino.setNumeroExterior("214");
//         domicilioDestino.setNumeroInterior("215");
//         domicilioDestino.setColoniaId("0347");
//         domicilioDestino.setLocalidadId("23");
//         domicilioDestino.setReferencia("casa negra");
//         domicilioDestino.setMunicipioId("004");
//         domicilioDestino.setEstadoId("COA");
//         domicilioDestino.setPaisId("MEX");
//         domicilioDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("URE180429TM6");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDistanciaRecorrida(new BigDecimal("1"));
//         destino.setDomicilio(domicilioDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia
//         CantidadTransporta cantidadTransporta = new CantidadTransporta();
//         cantidadTransporta.setCantidad(new BigDecimal("1"));
//         cantidadTransporta.setIdOrigen("OR101010");
//         cantidadTransporta.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(cantidadTransporta);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2003-04-02T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setFormaFarmaceuticaId("01");
//         mercancia.setCondicionesEspTranspId("01");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setFraccionArancelariaId("6309000100");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // Autotransporte
//         Remolque remolque = new Remolque();
//         remolque.setSubTipoRemId("CTR004");
//         remolque.setPlaca("VL45K98");
//         List<Remolque> remolques = new ArrayList<>();
//         remolques.add(remolque);

//         Autotransporte autotransporte = new Autotransporte();
//         autotransporte.setPermSCTId("TPAF01");
//         autotransporte.setNumPermisoSCT("NumPermisoSCT1");
//         autotransporte.setConfigVehicularId("VL");
//         autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
//         autotransporte.setPlacaVM("plac892");
//         autotransporte.setAnioModeloVM(2020);
//         autotransporte.setAseguraRespCivil("AseguraRespCivil");
//         autotransporte.setPolizaRespCivil("123456789");
//         autotransporte.setRemolques(remolques);

//         // TipoFigura
//         Domicilio domicilioFigura = new Domicilio();
//         domicilioFigura.setCalle("Calle1");
//         domicilioFigura.setNumeroExterior("NumeroExterior1");
//         domicilioFigura.setNumeroInterior("NumeroInterior1");
//         domicilioFigura.setColoniaId("Colonia1");
//         domicilioFigura.setLocalidadId("Localidad1");
//         domicilioFigura.setReferencia("Referencia1");
//         domicilioFigura.setMunicipioId("Municipio1");
//         domicilioFigura.setEstadoId("Estado1");
//         domicilioFigura.setPaisId("AFG");
//         domicilioFigura.setCodigoPostalId("CodigoPosta1");

//         TipoFigura tipoFigura = new TipoFigura();
//         tipoFigura.setTipoFiguraId("01");
//         tipoFigura.setRfcFigura("URE180429TM6");
//         tipoFigura.setNumLicencia("NumLicencia1");
//         tipoFigura.setNombreFigura("NombreFigura1");
//         tipoFigura.setDomicilio(domicilioFigura);
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(tipoFigura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setTotalDistRec(new BigDecimal("1"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setLogisticaInversaRecoleccionDevolucionId("Sí");
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setAutotransporte(autotransporte);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setPaymentFormCode("01");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setTypeCode("I");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("SerieCCP31");
//         invoice.setDate(currentDate);
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso autotransporte extranjero (salida)
//     private void facturaIngresoAutoTransporteExtranjero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         LocalDateTime currentDate = OptUtil.parseLocalDateTime(LocalDateTime.now().toString());

//         // Issuer
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

//         // Recipient
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

//         // Items
//         InvoiceItem item = new InvoiceItem();
//         item.setItemCode("78101800");
//         item.setItemSku("UT421511");
//         item.setQuantity(new BigDecimal("1"));
//         item.setUnitOfMeasurementCode("H87");
//         item.setDescription("Transporte de carga por carretera");
//         item.setUnitPrice(new BigDecimal("100.00"));
//         item.setDiscount(new BigDecimal("0"));
//         item.setTaxObjectCode("01");
//         item.setItemTaxes(new ArrayList<>());
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(item);

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("EXD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (extranjero)
//         Domicilio domicilioOrigen = new Domicilio();
//         domicilioOrigen.setCalle("ST");
//         domicilioOrigen.setNumeroExterior("214");
//         domicilioOrigen.setColoniaId("N/A");
//         domicilioOrigen.setReferencia("WHITE HOUSE");
//         domicilioOrigen.setMunicipioId("N/A");
//         domicilioOrigen.setEstadoId("TX");
//         domicilioOrigen.setPaisId("USA");
//         domicilioOrigen.setCodigoPostalId("N/A");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("XEXX010101000");
//         origen.setNumRegIdTrib("01010101");
//         origen.setResidenciaFiscalId("USA");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         origen.setDomicilio(domicilioOrigen);

//         // Ubicacion Destino (extranjero)
//         Domicilio domicilioDestino = new Domicilio();
//         domicilioDestino.setCalle("ST");
//         domicilioDestino.setNumeroExterior("214");
//         domicilioDestino.setColoniaId("N/A");
//         domicilioDestino.setReferencia("WHITE HOUSE");
//         domicilioDestino.setMunicipioId("N/A");
//         domicilioDestino.setEstadoId("TX");
//         domicilioDestino.setPaisId("USA");
//         domicilioDestino.setCodigoPostalId("N/A");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("XEXX010101000");
//         destino.setNumRegIdTrib("01010101");
//         destino.setResidenciaFiscalId("USA");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDistanciaRecorrida(new BigDecimal("1"));
//         destino.setDomicilio(domicilioDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia
//         CantidadTransporta cantidadTransporta = new CantidadTransporta();
//         cantidadTransporta.setCantidad(new BigDecimal("1"));
//         cantidadTransporta.setIdOrigen("OR101010");
//         cantidadTransporta.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(cantidadTransporta);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2003-04-02T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setFormaFarmaceuticaId("01");
//         mercancia.setCondicionesEspTranspId("01");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setFraccionArancelariaId("6309000100");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // Autotransporte
//         Remolque remolque = new Remolque();
//         remolque.setSubTipoRemId("CTR004");
//         remolque.setPlaca("VL45K98");
//         List<Remolque> remolques = new ArrayList<>();
//         remolques.add(remolque);

//         Autotransporte autotransporte = new Autotransporte();
//         autotransporte.setPermSCTId("TPAF01");
//         autotransporte.setNumPermisoSCT("NumPermisoSCT1");
//         autotransporte.setConfigVehicularId("VL");
//         autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
//         autotransporte.setPlacaVM("plac892");
//         autotransporte.setAnioModeloVM(2020);
//         autotransporte.setAseguraRespCivil("AseguraRespCivil");
//         autotransporte.setPolizaRespCivil("123456789");
//         autotransporte.setRemolques(remolques);

//         // TipoFigura
//         Domicilio domicilioFigura = new Domicilio();
//         domicilioFigura.setCalle("ST");
//         domicilioFigura.setNumeroExterior("214");
//         domicilioFigura.setColoniaId("N/A");
//         domicilioFigura.setReferencia("WHITE HOUSE");
//         domicilioFigura.setMunicipioId("N/A");
//         domicilioFigura.setEstadoId("TX");
//         domicilioFigura.setPaisId("USA");
//         domicilioFigura.setCodigoPostalId("N/A");

//         TipoFigura tipoFigura = new TipoFigura();
//         tipoFigura.setTipoFiguraId("01");
//         tipoFigura.setRfcFigura("EKU9003173C9");
//         tipoFigura.setNumLicencia("NumLicencia1");
//         tipoFigura.setNombreFigura("NombreFigura1");
//         tipoFigura.setDomicilio(domicilioFigura);
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(tipoFigura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Salida");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("01");
//         cartaPorte.setTotalDistRec(new BigDecimal("1"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setLogisticaInversaRecoleccionDevolucionId("Sí");
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setAutotransporte(autotransporte);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setPaymentFormCode("01");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setTypeCode("I");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("SerieCCP31");
//         invoice.setDate(currentDate);
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso autotransporte internacional aduanero (entrada con pedimento)
//     private void facturaIngresoAutoTransporteInternacionalAduanero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         LocalDateTime currentDate = OptUtil.parseLocalDateTime(LocalDateTime.now().toString());

//         // Issuer
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

//         // Recipient
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");

//         // Items
//         InvoiceItem item = new InvoiceItem();
//         item.setItemCode("78101800");
//         item.setItemSku("UT421511");
//         item.setQuantity(new BigDecimal("1"));
//         item.setUnitOfMeasurementCode("H87");
//         item.setDescription("Transporte de carga por carretera");
//         item.setUnitPrice(new BigDecimal("100.00"));
//         item.setDiscount(new BigDecimal("0"));
//         item.setTaxObjectCode("01");
//         item.setItemTaxes(new ArrayList<>());
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(item);

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("IMD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (extranjero)
//         Domicilio domicilioOrigen = new Domicilio();
//         domicilioOrigen.setCalle("ST");
//         domicilioOrigen.setNumeroExterior("214");
//         domicilioOrigen.setColoniaId("N/A");
//         domicilioOrigen.setReferencia("WHITE HOUSE");
//         domicilioOrigen.setMunicipioId("N/A");
//         domicilioOrigen.setEstadoId("TX");
//         domicilioOrigen.setPaisId("USA");
//         domicilioOrigen.setCodigoPostalId("N/A");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("XEXX010101000");
//         origen.setNumRegIdTrib("01010101");
//         origen.setResidenciaFiscalId("USA");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         origen.setDomicilio(domicilioOrigen);

//         // Ubicacion Destino (extranjero)
//         Domicilio domicilioDestino = new Domicilio();
//         domicilioDestino.setCalle("ST");
//         domicilioDestino.setNumeroExterior("214");
//         domicilioDestino.setColoniaId("N/A");
//         domicilioDestino.setReferencia("WHITE HOUSE");
//         domicilioDestino.setMunicipioId("N/A");
//         domicilioDestino.setEstadoId("TX");
//         domicilioDestino.setPaisId("USA");
//         domicilioDestino.setCodigoPostalId("N/A");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("XEXX010101000");
//         destino.setNumRegIdTrib("01010101");
//         destino.setResidenciaFiscalId("USA");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDistanciaRecorrida(new BigDecimal("1"));
//         destino.setDomicilio(domicilioDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia con documentacion aduanera
//         DocumentoAduanero documentoAduanero = new DocumentoAduanero();
//         documentoAduanero.setTipoDocumentoId("01");
//         documentoAduanero.setNumPedimento("23  43  0472  8000448");
//         documentoAduanero.setRfcImpo("EKU9003173C9");
//         List<DocumentoAduanero> documentosAduaneros = new ArrayList<>();
//         documentosAduaneros.add(documentoAduanero);

//         CantidadTransporta cantidadTransporta = new CantidadTransporta();
//         cantidadTransporta.setCantidad(new BigDecimal("1"));
//         cantidadTransporta.setIdOrigen("OR101010");
//         cantidadTransporta.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(cantidadTransporta);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2003-04-02T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setFormaFarmaceuticaId("01");
//         mercancia.setCondicionesEspTranspId("01");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setFraccionArancelariaId("6309000100");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setDocumentacionAduanera(documentosAduaneros);
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // Autotransporte
//         Remolque remolque = new Remolque();
//         remolque.setSubTipoRemId("CTR004");
//         remolque.setPlaca("VL45K98");
//         List<Remolque> remolques = new ArrayList<>();
//         remolques.add(remolque);

//         Autotransporte autotransporte = new Autotransporte();
//         autotransporte.setPermSCTId("TPAF01");
//         autotransporte.setNumPermisoSCT("NumPermisoSCT1");
//         autotransporte.setConfigVehicularId("VL");
//         autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
//         autotransporte.setPlacaVM("plac892");
//         autotransporte.setAnioModeloVM(2020);
//         autotransporte.setAseguraRespCivil("AseguraRespCivil");
//         autotransporte.setPolizaRespCivil("123456789");
//         autotransporte.setRemolques(remolques);

//         // TipoFigura
//         Domicilio domicilioFigura = new Domicilio();
//         domicilioFigura.setCalle("ST");
//         domicilioFigura.setNumeroExterior("214");
//         domicilioFigura.setColoniaId("N/A");
//         domicilioFigura.setReferencia("WHITE HOUSE");
//         domicilioFigura.setMunicipioId("N/A");
//         domicilioFigura.setEstadoId("TX");
//         domicilioFigura.setPaisId("USA");
//         domicilioFigura.setCodigoPostalId("N/A");

//         TipoFigura tipoFigura = new TipoFigura();
//         tipoFigura.setTipoFiguraId("01");
//         tipoFigura.setRfcFigura("EKU9003173C9");
//         tipoFigura.setNumLicencia("NumLicencia1");
//         tipoFigura.setNombreFigura("NombreFigura1");
//         tipoFigura.setDomicilio(domicilioFigura);
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(tipoFigura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Entrada");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("01");
//         cartaPorte.setTotalDistRec(new BigDecimal("1"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setLogisticaInversaRecoleccionDevolucionId("Sí");
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setAutotransporte(autotransporte);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setPaymentFormCode("01");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setTypeCode("I");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("SerieCCP31");
//         invoice.setDate(currentDate);
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte ferroviario nacional
//     private void facturaIngresoTransporteFerroviarioNacional(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Ubicaciones: comunes + destino 5 (JM047/HUEHUETOCA, tipoEstacion "03", COA)
//         List<Ubicacion> ubicaciones = buildUbicacionesFerroviarioComunes();
//         Domicilio domDest5 = new Domicilio();
//         domDest5.setCalle("Calle2");
//         domDest5.setNumeroExterior("214");
//         domDest5.setNumeroInterior("215");
//         domDest5.setColoniaId("0347");
//         domDest5.setLocalidadId("23");
//         domDest5.setReferencia("casa negra");
//         domDest5.setMunicipioId("004");
//         domDest5.setEstadoId("COA");
//         domDest5.setPaisId("MEX");
//         domDest5.setCodigoPostalId("25350");

//         Ubicacion dest5 = new Ubicacion();
//         dest5.setTipoUbicacion("Destino");
//         dest5.setIdUbicacion("DE202025");
//         dest5.setRfcRemitenteDestinatario("EKU9003173C9");
//         dest5.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest5.setNumEstacionId("JM047");
//         dest5.setNombreEstacion("HUEHUETOCA");
//         dest5.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T05:00:01"));
//         dest5.setTipoEstacionId("03");
//         dest5.setDistanciaRecorrida(new BigDecimal("100.00"));
//         dest5.setDomicilio(domDest5);
//         ubicaciones.add(dest5);

//         // Mercancia
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202025");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setTotalDistRec(new BigDecimal("500"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteFerroviario(buildTransporteFerroviario());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(
//                 buildInvoice(buildIssuerEKU(), buildRecipientEKU(), items, complement));
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte ferroviario extranjero
//     private void facturaIngresoTransporteFerroviarioExtranjero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("EXD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicaciones: comunes + destino 5 (XEXX010101000, USA address)
//         List<Ubicacion> ubicaciones = buildUbicacionesFerroviarioComunes();
//         Domicilio domDest5 = new Domicilio();
//         domDest5.setCalle("ST");
//         domDest5.setNumeroExterior("1234");
//         domDest5.setColoniaId("1234");
//         domDest5.setReferencia("WHITE HOUSE");
//         domDest5.setMunicipioId("1234");
//         domDest5.setEstadoId("TX");
//         domDest5.setPaisId("USA");
//         domDest5.setCodigoPostalId("12345");

//         Ubicacion dest5 = new Ubicacion();
//         dest5.setTipoUbicacion("Destino");
//         dest5.setIdUbicacion("DE202025");
//         dest5.setRfcRemitenteDestinatario("XEXX010101000");
//         dest5.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest5.setNumRegIdTrib("01010101");
//         dest5.setResidenciaFiscalId("USA");
//         dest5.setNumEstacionId("EF0001");
//         dest5.setNombreEstacion("NombreEstacion");
//         dest5.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T05:00:01"));
//         dest5.setDistanciaRecorrida(new BigDecimal("100.00"));
//         dest5.setDomicilio(domDest5);
//         ubicaciones.add(dest5);

//         // Mercancia (with tipoMateria)
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202025");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Salida");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("04");
//         cartaPorte.setTotalDistRec(new BigDecimal("500"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteFerroviario(buildTransporteFerroviario());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(
//                 buildInvoice(buildIssuerEKU(), buildRecipientEKU(), items, complement));
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte ferroviario internacional aduanero (entrada, IMD)
//     private void facturaIngresoTransporteFerroviarioInternacionalAduanero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("IMD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicaciones: comunes + destino 5 (JM047/HUEHUETOCA, tipoEstacion "03", COA)
//         List<Ubicacion> ubicaciones = buildUbicacionesFerroviarioComunes();
//         Domicilio domDest5 = new Domicilio();
//         domDest5.setCalle("Calle2");
//         domDest5.setNumeroExterior("214");
//         domDest5.setNumeroInterior("215");
//         domDest5.setColoniaId("0347");
//         domDest5.setLocalidadId("23");
//         domDest5.setReferencia("casa negra");
//         domDest5.setMunicipioId("004");
//         domDest5.setEstadoId("COA");
//         domDest5.setPaisId("MEX");
//         domDest5.setCodigoPostalId("25350");

//         Ubicacion dest5 = new Ubicacion();
//         dest5.setTipoUbicacion("Destino");
//         dest5.setIdUbicacion("DE202025");
//         dest5.setRfcRemitenteDestinatario("EKU9003173C9");
//         dest5.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest5.setNumEstacionId("JM047");
//         dest5.setNombreEstacion("HUEHUETOCA");
//         dest5.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T05:00:01"));
//         dest5.setTipoEstacionId("03");
//         dest5.setDistanciaRecorrida(new BigDecimal("100.00"));
//         dest5.setDomicilio(domDest5);
//         ubicaciones.add(dest5);

//         // Mercancia con documentacion aduanera
//         DocumentoAduanero doc = new DocumentoAduanero();
//         doc.setTipoDocumentoId("01");
//         doc.setNumPedimento("23  43  0472  8000448");
//         doc.setRfcImpo("EKU9003173C9");
//         List<DocumentoAduanero> docs = new ArrayList<>();
//         docs.add(doc);

//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202025");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setDocumentacionAduanera(docs);
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Entrada");
//         cartaPorte.setPaisOrigenDestinoId("AFG");
//         cartaPorte.setViaEntradaSalidaId("04");
//         cartaPorte.setTotalDistRec(new BigDecimal("500"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteFerroviario(buildTransporteFerroviario());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(
//                 buildInvoice(buildIssuerEKU(), buildRecipientEKU(), items, complement));
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte aereo nacional
//     private void facturaIngresoTransporteAereoNacional(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Origen (aeropuerto EA0417, Loreto)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("EA0417");
//         origen.setNombreEstacion("Loreto");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Destino (aeropuerto EA0418, Los Cabos)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumEstacionId("EA0418");
//         destino.setNombreEstacion("Los Cabos");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setTipoEstacionId("03");
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia (with valorMercancia and monedaId)
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // TransporteAereo
//         TransporteAereo transporteAereo = new TransporteAereo();
//         transporteAereo.setPermSCTId("TPAF01");
//         transporteAereo.setNumPermisoSCT("Demo");
//         transporteAereo.setMatriculaAeronave("61E5-WZ");
//         transporteAereo.setNombreAseg("NombreAseg");
//         transporteAereo.setNumPolizaSeguro("NumPolizaSeguro");
//         transporteAereo.setNumeroGuia("acUbYlBVTmlzx");
//         transporteAereo.setLugarContrato("LugarContrato");
//         transporteAereo.setCodigoTransportistaId("CA001");
//         transporteAereo.setRfcEmbarcador("EKU9003173C9");
//         transporteAereo.setNombreEmbarcador("Embarcador");

//         // TipoFigura (tipoFiguraId "01", numLicencia, no partesTransporte)
//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("a234567890");
//         figura.setNombreFigura("NombreFigura");
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteAereo(transporteAereo);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(
//                 buildInvoice(buildIssuerEKU(), buildRecipientEKU(), items, complement));
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte aereo extranjero (salida)
//     private void facturaIngresoTransporteAereoExtranjero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("EXD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (EA0417 / Loreto, COA/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle2");
//         domOrigen.setNumeroExterior("214");
//         domOrigen.setNumeroInterior("215");
//         domOrigen.setColoniaId("0347");
//         domOrigen.setLocalidadId("23");
//         domOrigen.setReferencia("casa negra");
//         domOrigen.setMunicipioId("004");
//         domOrigen.setEstadoId("COA");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("25350");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("EA0417");
//         origen.setNombreEstacion("Loreto");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (EA0143 / Phoenix-Mesa Gateway, USA/TX — foreign)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("ST");
//         domDestino.setNumeroExterior("12344");
//         domDestino.setColoniaId("N/A");
//         domDestino.setReferencia("WHITE HOUSE");
//         domDestino.setMunicipioId("N/A");
//         domDestino.setEstadoId("TX");
//         domDestino.setPaisId("USA");
//         domDestino.setCodigoPostalId("12345");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("XEXX010101000");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario");
//         destino.setNumRegIdTrib("01010101");
//         destino.setResidenciaFiscalId("USA");
//         destino.setNumEstacionId("EA0143");
//         destino.setNombreEstacion("Phoenix-Mesa Gateway");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // TipoFigura (operador, licencia)
//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("a234567890");
//         figura.setNombreFigura("NombreFigura");
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Salida");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("03");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteAereo(buildTransporteAereoCP());
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(
//                 buildInvoice(buildIssuerEKU(), buildRecipientEKU(), items, complement));
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte aereo internacional aduanero (entrada, IMD)
//     private void facturaIngresoTransporteAereoInternacionalAduanero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("IMD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (EA0417 / Loreto, CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("EA0417");
//         origen.setNombreEstacion("Loreto");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (EA0418 / Los Cabos, COA/MEX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumEstacionId("EA0418");
//         destino.setNombreEstacion("Los Cabos");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setTipoEstacionId("03");
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia con documentacion aduanera
//         DocumentoAduanero doc = new DocumentoAduanero();
//         doc.setTipoDocumentoId("01");
//         doc.setNumPedimento("23  43  0472  8000448");
//         doc.setRfcImpo("EKU9003173C9");
//         List<DocumentoAduanero> docs = new ArrayList<>();
//         docs.add(doc);

//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setDocumentacionAduanera(docs);
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // TipoFigura (operador, licencia)
//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("a234567890");
//         figura.setNombreFigura("NombreFigura");
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Entrada");
//         cartaPorte.setPaisOrigenDestinoId("AFG");
//         cartaPorte.setViaEntradaSalidaId("03");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteAereo(buildTransporteAereoCP());
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(
//                 buildInvoice(buildIssuerEKU(), buildRecipientEKU(), items, complement));
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte maritimo nacional
//     private void facturaIngresoTransporteMaritimoNacional(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Ubicacion Origen (PM001 / Rosarito, CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("PM001");
//         origen.setNombreEstacion("Rosarito");
//         origen.setNavegacionTraficoId("Altura");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (PM001 / Rosarito, COA/MEX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumEstacionId("PM001");
//         destino.setNombreEstacion("Rosarito");
//         destino.setNavegacionTraficoId("Altura");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setTipoEstacionId("03");
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia with detalleMercancia
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         DetalleMercancia detalle = new DetalleMercancia();
//         detalle.setUnidadPesoMercId("Tu");
//         detalle.setPesoBruto(new BigDecimal("1"));
//         detalle.setPesoNeto(new BigDecimal("1"));
//         detalle.setPesoTara(new BigDecimal("0.001"));
//         detalle.setNumPiezas(1);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setCantidadTransporta(cantTransList);
//         mercancia.setDetalleMercancia(detalle);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("1"));
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteMaritimo(buildTransporteMaritimo());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(
//                 buildInvoice(buildIssuerEKU(), buildRecipientEKU(), items, complement));
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte maritimo extranjero (salida)
//     private void facturaIngresoTransporteMaritimoExtranjero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("EXD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (PM001 / Rosarito, CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("PM001");
//         origen.setNombreEstacion("Rosarito");
//         origen.setNavegacionTraficoId("Altura");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (PM120 / NombreEstacion, USA/TX — foreign)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("ST");
//         domDestino.setNumeroExterior("12345");
//         domDestino.setColoniaId("N/A");
//         domDestino.setReferencia("N/A");
//         domDestino.setMunicipioId("N/A");
//         domDestino.setEstadoId("TX");
//         domDestino.setPaisId("USA");
//         domDestino.setCodigoPostalId("12345");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("XEXX010101000");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumRegIdTrib("01010101");
//         destino.setResidenciaFiscalId("USA");
//         destino.setNumEstacionId("PM120");
//         destino.setNombreEstacion("NombreEstacion");
//         destino.setNavegacionTraficoId("Altura");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia with detalleMercancia and tipoMateria
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         DetalleMercancia detalle = new DetalleMercancia();
//         detalle.setUnidadPesoMercId("Tu");
//         detalle.setPesoBruto(new BigDecimal("1"));
//         detalle.setPesoNeto(new BigDecimal("1"));
//         detalle.setPesoTara(new BigDecimal("0.001"));
//         detalle.setNumPiezas(1);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setCantidadTransporta(cantTransList);
//         mercancia.setDetalleMercancia(detalle);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Salida");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("02");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("1"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteMaritimo(buildTransporteMaritimo());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(
//                 buildInvoice(buildIssuerEKU(), buildRecipientEKU(), items, complement));
//         System.out.println(apiResponse);
//     }

//     // Factura ingreso transporte maritimo internacional aduanero (entrada, IMD x2)
//     private void facturaIngresoTransporteMaritimoInternacionalAduanero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero (two IMD entries)
//         RegimenAduanero regimenAduanero1 = new RegimenAduanero();
//         regimenAduanero1.setRegimenAduaneroId("IMD");
//         RegimenAduanero regimenAduanero2 = new RegimenAduanero();
//         regimenAduanero2.setRegimenAduaneroId("IMD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero1);
//         regimenAduaneros.add(regimenAduanero2);

//         // Ubicacion Origen (EA0417 / Loreto, navegacionTrafico "Altura", CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("EA0417");
//         origen.setNombreEstacion("Loreto");
//         origen.setNavegacionTraficoId("Altura");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (PM001 / Rosarito, navegacionTrafico "Altura", COA/MEX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumEstacionId("PM001");
//         destino.setNombreEstacion("Rosarito");
//         destino.setNavegacionTraficoId("Altura");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T04:00:01"));
//         destino.setTipoEstacionId("02");
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia with documentacionAduanera, detalleMercancia, tipoMateria, cvesTransporteId
//         DocumentoAduanero doc = new DocumentoAduanero();
//         doc.setTipoDocumentoId("01");
//         doc.setNumPedimento("23  43  0472  8000448");
//         doc.setRfcImpo("EKU9003173C9");
//         List<DocumentoAduanero> docs = new ArrayList<>();
//         docs.add(doc);

//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         ct.setCvesTransporteId("02");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         DetalleMercancia detalle = new DetalleMercancia();
//         detalle.setUnidadPesoMercId("X1A");
//         detalle.setPesoBruto(new BigDecimal("1.50"));
//         detalle.setPesoNeto(new BigDecimal("1.00"));
//         detalle.setPesoTara(new BigDecimal("0.50"));

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2003-04-02T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setFormaFarmaceuticaId("01");
//         mercancia.setCondicionesEspTranspId("01");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1.50"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setFraccionArancelariaId("6309000100");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setDocumentacionAduanera(docs);
//         mercancia.setCantidadTransporta(cantTransList);
//         mercancia.setDetalleMercancia(detalle);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // TipoFigura (tipoFiguraId "01", numLicencia, AFG domicilio)
//         Domicilio domFigura = new Domicilio();
//         domFigura.setCalle("Calle1");
//         domFigura.setNumeroExterior("NumeroExterior1");
//         domFigura.setNumeroInterior("NumeroInterior1");
//         domFigura.setColoniaId("Colonia1");
//         domFigura.setLocalidadId("Localidad1");
//         domFigura.setReferencia("Referencia1");
//         domFigura.setMunicipioId("Municipio1");
//         domFigura.setEstadoId("Estado1");
//         domFigura.setPaisId("AFG");
//         domFigura.setCodigoPostalId("CodigoPosta1");

//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("NumLicencia1");
//         figura.setNombreFigura("NombreFigura1");
//         figura.setDomicilio(domFigura);
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Entrada");
//         cartaPorte.setPaisOrigenDestinoId("AFG");
//         cartaPorte.setViaEntradaSalidaId("01");
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("1"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteMaritimo(buildTransporteMaritimo());
//         cartaPorte.setTransporteAereo(buildTransporteAereoCP());
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setPaymentFormCode("01");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setTypeCode("I");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("CP3.1");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);
//     }

//     // Factura traslado autotransporte nacional
//     private void facturaTrasladoAutoTransporteNacional(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Ubicacion Origen (no station, CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (no station, COA/MEX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDistanciaRecorrida(new BigDecimal("1"));
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia (simplified, fechaCaducidad 2028-01-01, no formaFarmaceutica/condiciones/fraccion)
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // Autotransporte
//         Remolque remolque = new Remolque();
//         remolque.setSubTipoRemId("CTR004");
//         remolque.setPlaca("VL45K98");
//         List<Remolque> remolques = new ArrayList<>();
//         remolques.add(remolque);

//         Autotransporte autotransporte = new Autotransporte();
//         autotransporte.setPermSCTId("TPAF01");
//         autotransporte.setNumPermisoSCT("NumPermisoSCT1");
//         autotransporte.setConfigVehicularId("VL");
//         autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
//         autotransporte.setPlacaVM("plac892");
//         autotransporte.setAnioModeloVM(2020);
//         autotransporte.setAseguraRespCivil("AseguraRespCivil");
//         autotransporte.setPolizaRespCivil("123456789");
//         autotransporte.setRemolques(remolques);

//         // TipoFigura (no domicilio)
//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("a234567890");
//         figura.setNombreFigura("NombreFigura");
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setTotalDistRec(new BigDecimal("1"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setLogisticaInversaRecoleccionDevolucionId("Sí");
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setAutotransporte(autotransporte);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);
//     }

//     // Factura traslado autotransporte extranjero (salida, EXD)
//     private void facturaTrasladoAutoTransporteExtranjero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("EXD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (foreign USA/TX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("ST");
//         domOrigen.setNumeroExterior("214");
//         domOrigen.setColoniaId("N/A");
//         domOrigen.setReferencia("WHITE HOUSE");
//         domOrigen.setMunicipioId("N/A");
//         domOrigen.setEstadoId("TX");
//         domOrigen.setPaisId("USA");
//         domOrigen.setCodigoPostalId("N/A");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("XEXX010101000");
//         origen.setNumRegIdTrib("01010101");
//         origen.setResidenciaFiscalId("USA");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (foreign USA/TX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("ST");
//         domDestino.setNumeroExterior("214");
//         domDestino.setColoniaId("N/A");
//         domDestino.setReferencia("WHITE HOUSE");
//         domDestino.setMunicipioId("N/A");
//         domDestino.setEstadoId("TX");
//         domDestino.setPaisId("USA");
//         domDestino.setCodigoPostalId("N/A");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("XEXX010101000");
//         destino.setNumRegIdTrib("01010101");
//         destino.setResidenciaFiscalId("USA");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDistanciaRecorrida(new BigDecimal("1"));
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia (tipoMateria, fraccionArancelaria, no detalleMercancia, no documentacionAduanera)
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2003-04-02T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setFormaFarmaceuticaId("01");
//         mercancia.setCondicionesEspTranspId("01");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setFraccionArancelariaId("6309000100");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // Autotransporte
//         Remolque remolque = new Remolque();
//         remolque.setSubTipoRemId("CTR004");
//         remolque.setPlaca("VL45K98");
//         List<Remolque> remolques = new ArrayList<>();
//         remolques.add(remolque);

//         Autotransporte autotransporte = new Autotransporte();
//         autotransporte.setPermSCTId("TPAF01");
//         autotransporte.setNumPermisoSCT("NumPermisoSCT1");
//         autotransporte.setConfigVehicularId("VL");
//         autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
//         autotransporte.setPlacaVM("plac892");
//         autotransporte.setAnioModeloVM(2020);
//         autotransporte.setAseguraRespCivil("AseguraRespCivil");
//         autotransporte.setPolizaRespCivil("123456789");
//         autotransporte.setRemolques(remolques);

//         // TipoFigura with USA domicilio
//         Domicilio domFigura = new Domicilio();
//         domFigura.setCalle("ST");
//         domFigura.setNumeroExterior("214");
//         domFigura.setColoniaId("N/A");
//         domFigura.setReferencia("WHITE HOUSE");
//         domFigura.setMunicipioId("N/A");
//         domFigura.setEstadoId("TX");
//         domFigura.setPaisId("USA");
//         domFigura.setCodigoPostalId("N/A");

//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("NumLicencia1");
//         figura.setNombreFigura("NombreFigura1");
//         figura.setDomicilio(domFigura);
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Salida");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("01");
//         cartaPorte.setTotalDistRec(new BigDecimal("1"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setLogisticaInversaRecoleccionDevolucionId("Sí");
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setAutotransporte(autotransporte);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("SerieCCP31");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);
//     }

//     // Factura traslado autotransporte internacional aduanero (entrada, IMD)
//     private void facturaTrasladoAutoTransporteInternacionalAduanero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("IMD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (foreign USA/TX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("ST");
//         domOrigen.setNumeroExterior("214");
//         domOrigen.setColoniaId("N/A");
//         domOrigen.setReferencia("WHITE HOUSE");
//         domOrigen.setMunicipioId("N/A");
//         domOrigen.setEstadoId("TX");
//         domOrigen.setPaisId("USA");
//         domOrigen.setCodigoPostalId("N/A");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("XEXX010101000");
//         origen.setNumRegIdTrib("01010101");
//         origen.setResidenciaFiscalId("USA");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (foreign USA/TX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("ST");
//         domDestino.setNumeroExterior("214");
//         domDestino.setColoniaId("N/A");
//         domDestino.setReferencia("WHITE HOUSE");
//         domDestino.setMunicipioId("N/A");
//         domDestino.setEstadoId("TX");
//         domDestino.setPaisId("USA");
//         domDestino.setCodigoPostalId("N/A");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("XEXX010101000");
//         destino.setNumRegIdTrib("01010101");
//         destino.setResidenciaFiscalId("USA");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDistanciaRecorrida(new BigDecimal("1"));
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia with documentacionAduanera, tipoMateria, fraccionArancelaria
//         DocumentoAduanero doc = new DocumentoAduanero();
//         doc.setTipoDocumentoId("01");
//         doc.setNumPedimento("23  43  0472  8000448");
//         doc.setRfcImpo("EKU9003173C9");
//         List<DocumentoAduanero> docs = new ArrayList<>();
//         docs.add(doc);

//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2003-04-02T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setFormaFarmaceuticaId("01");
//         mercancia.setCondicionesEspTranspId("01");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setFraccionArancelariaId("6309000100");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setDocumentacionAduanera(docs);
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // Autotransporte
//         Remolque remolque = new Remolque();
//         remolque.setSubTipoRemId("CTR004");
//         remolque.setPlaca("VL45K98");
//         List<Remolque> remolques = new ArrayList<>();
//         remolques.add(remolque);

//         Autotransporte autotransporte = new Autotransporte();
//         autotransporte.setPermSCTId("TPAF01");
//         autotransporte.setNumPermisoSCT("NumPermisoSCT1");
//         autotransporte.setConfigVehicularId("VL");
//         autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
//         autotransporte.setPlacaVM("plac892");
//         autotransporte.setAnioModeloVM(2020);
//         autotransporte.setAseguraRespCivil("AseguraRespCivil");
//         autotransporte.setPolizaRespCivil("123456789");
//         autotransporte.setRemolques(remolques);

//         // TipoFigura with USA domicilio
//         Domicilio domFigura = new Domicilio();
//         domFigura.setCalle("ST");
//         domFigura.setNumeroExterior("214");
//         domFigura.setColoniaId("N/A");
//         domFigura.setReferencia("WHITE HOUSE");
//         domFigura.setMunicipioId("N/A");
//         domFigura.setEstadoId("TX");
//         domFigura.setPaisId("USA");
//         domFigura.setCodigoPostalId("N/A");

//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("NumLicencia1");
//         figura.setNombreFigura("NombreFigura1");
//         figura.setDomicilio(domFigura);
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Entrada");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("01");
//         cartaPorte.setTotalDistRec(new BigDecimal("1"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setLogisticaInversaRecoleccionDevolucionId("Sí");
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setAutotransporte(autotransporte);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("SerieCCP31");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse);
//     }

//     // Ejemplo 17: Factura traslado transporte ferroviario nacional
//     private void facturaTrasladoTransporteFerroviarioNacional(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Ubicaciones: comunes + destino 5 (JM047/HUEHUETOCA, tipoEstacion "03", COA)
//         List<Ubicacion> ubicaciones = buildUbicacionesFerroviarioComunes();
//         Domicilio domDest5 = new Domicilio();
//         domDest5.setCalle("Calle2");
//         domDest5.setNumeroExterior("214");
//         domDest5.setNumeroInterior("215");
//         domDest5.setColoniaId("0347");
//         domDest5.setLocalidadId("23");
//         domDest5.setReferencia("casa negra");
//         domDest5.setMunicipioId("004");
//         domDest5.setEstadoId("COA");
//         domDest5.setPaisId("MEX");
//         domDest5.setCodigoPostalId("25350");

//         Ubicacion dest5 = new Ubicacion();
//         dest5.setTipoUbicacion("Destino");
//         dest5.setIdUbicacion("DE202025");
//         dest5.setRfcRemitenteDestinatario("EKU9003173C9");
//         dest5.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest5.setNumEstacionId("JM047");
//         dest5.setNombreEstacion("HUEHUETOCA");
//         dest5.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T05:00:01"));
//         dest5.setTipoEstacionId("03");
//         dest5.setDistanciaRecorrida(new BigDecimal("100.00"));
//         dest5.setDomicilio(domDest5);
//         ubicaciones.add(dest5);

//         // Mercancia
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202025");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setTotalDistRec(new BigDecimal("500"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteFerroviario(buildTransporteFerroviario());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse17 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse17);
//     }

//     // Ejemplo 18: Factura traslado transporte ferroviario extranjero
//     private void facturaTrasladoTransporteFerroviarioExtranjero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("EXD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicaciones: comunes + destino 5 (XEXX010101000, USA address)
//         List<Ubicacion> ubicaciones = buildUbicacionesFerroviarioComunes();
//         Domicilio domDest5 = new Domicilio();
//         domDest5.setCalle("ST");
//         domDest5.setNumeroExterior("1234");
//         domDest5.setColoniaId("1234");
//         domDest5.setReferencia("WHITE HOUSE");
//         domDest5.setMunicipioId("1234");
//         domDest5.setEstadoId("TX");
//         domDest5.setPaisId("USA");
//         domDest5.setCodigoPostalId("12345");

//         Ubicacion dest5 = new Ubicacion();
//         dest5.setTipoUbicacion("Destino");
//         dest5.setIdUbicacion("DE202025");
//         dest5.setRfcRemitenteDestinatario("XEXX010101000");
//         dest5.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest5.setNumRegIdTrib("01010101");
//         dest5.setResidenciaFiscalId("USA");
//         dest5.setNumEstacionId("EF0001");
//         dest5.setNombreEstacion("NombreEstacion");
//         dest5.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T05:00:01"));
//         dest5.setDistanciaRecorrida(new BigDecimal("100.00"));
//         dest5.setDomicilio(domDest5);
//         ubicaciones.add(dest5);

//         // Mercancia (with tipoMateria)
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202025");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Salida");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("04");
//         cartaPorte.setTotalDistRec(new BigDecimal("500"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteFerroviario(buildTransporteFerroviario());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse18 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse18);
//     }

//     // Ejemplo 19: Factura traslado transporte ferroviario internacional aduanero (entrada, IMD)
//     private void facturaTrasladoTransporteFerroviarioInternacionalAduanero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("IMD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicaciones: comunes + destino 5 (JM047/HUEHUETOCA, tipoEstacion "03", COA)
//         List<Ubicacion> ubicaciones = buildUbicacionesFerroviarioComunes();
//         Domicilio domDest5 = new Domicilio();
//         domDest5.setCalle("Calle2");
//         domDest5.setNumeroExterior("214");
//         domDest5.setNumeroInterior("215");
//         domDest5.setColoniaId("0347");
//         domDest5.setLocalidadId("23");
//         domDest5.setReferencia("casa negra");
//         domDest5.setMunicipioId("004");
//         domDest5.setEstadoId("COA");
//         domDest5.setPaisId("MEX");
//         domDest5.setCodigoPostalId("25350");

//         Ubicacion dest5 = new Ubicacion();
//         dest5.setTipoUbicacion("Destino");
//         dest5.setIdUbicacion("DE202025");
//         dest5.setRfcRemitenteDestinatario("EKU9003173C9");
//         dest5.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest5.setNumEstacionId("JM047");
//         dest5.setNombreEstacion("HUEHUETOCA");
//         dest5.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T05:00:01"));
//         dest5.setTipoEstacionId("03");
//         dest5.setDistanciaRecorrida(new BigDecimal("100.00"));
//         dest5.setDomicilio(domDest5);
//         ubicaciones.add(dest5);

//         // Mercancia con documentacion aduanera y tipoMateria
//         DocumentoAduanero doc = new DocumentoAduanero();
//         doc.setTipoDocumentoId("01");
//         doc.setNumPedimento("23  43  0472  8000448");
//         doc.setRfcImpo("EKU9003173C9");
//         List<DocumentoAduanero> docs = new ArrayList<>();
//         docs.add(doc);

//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202025");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setDocumentacionAduanera(docs);
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Entrada");
//         cartaPorte.setPaisOrigenDestinoId("AFG");
//         cartaPorte.setViaEntradaSalidaId("04");
//         cartaPorte.setTotalDistRec(new BigDecimal("500"));
//         cartaPorte.setRegistroISTMOId("Sí");
//         cartaPorte.setUbicacionPoloOrigenId("01");
//         cartaPorte.setUbicacionPoloDestinoId("01");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteFerroviario(buildTransporteFerroviario());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse19 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse19);
//     }

//     // Ejemplo 20: Factura traslado transporte aereo nacional
//     private void facturaTrasladoTransporteAereoNacional(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Origen (aeropuerto EA0417, Loreto)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("EA0417");
//         origen.setNombreEstacion("Loreto");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Destino (aeropuerto EA0418, Los Cabos)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumEstacionId("EA0418");
//         destino.setNombreEstacion("Los Cabos");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setTipoEstacionId("03");
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia (with valorMercancia and monedaId)
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // TransporteAereo
//         TransporteAereo transporteAereo = new TransporteAereo();
//         transporteAereo.setPermSCTId("TPAF01");
//         transporteAereo.setNumPermisoSCT("Demo");
//         transporteAereo.setMatriculaAeronave("61E5-WZ");
//         transporteAereo.setNombreAseg("NombreAseg");
//         transporteAereo.setNumPolizaSeguro("NumPolizaSeguro");
//         transporteAereo.setNumeroGuia("acUbYlBVTmlzx");
//         transporteAereo.setLugarContrato("LugarContrato");
//         transporteAereo.setCodigoTransportistaId("CA001");
//         transporteAereo.setRfcEmbarcador("EKU9003173C9");
//         transporteAereo.setNombreEmbarcador("Embarcador");

//         // TipoFigura (tipoFiguraId "01", numLicencia, no partesTransporte)
//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("a234567890");
//         figura.setNombreFigura("NombreFigura");
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteAereo(transporteAereo);
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse20 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse20);
//     }

//     // Ejemplo 21: Factura traslado transporte aereo extranjero (salida, EXD)
//     private void facturaTrasladoTransporteAereoExtranjero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("EXD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (EA0417 / Loreto, COA/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle2");
//         domOrigen.setNumeroExterior("214");
//         domOrigen.setNumeroInterior("215");
//         domOrigen.setColoniaId("0347");
//         domOrigen.setLocalidadId("23");
//         domOrigen.setReferencia("casa negra");
//         domOrigen.setMunicipioId("004");
//         domOrigen.setEstadoId("COA");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("25350");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("EA0417");
//         origen.setNombreEstacion("Loreto");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (EA0143 / Phoenix-Mesa Gateway, USA/TX — foreign)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("ST");
//         domDestino.setNumeroExterior("12344");
//         domDestino.setColoniaId("N/A");
//         domDestino.setReferencia("WHITE HOUSE");
//         domDestino.setMunicipioId("N/A");
//         domDestino.setEstadoId("TX");
//         domDestino.setPaisId("USA");
//         domDestino.setCodigoPostalId("12345");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("XEXX010101000");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario");
//         destino.setNumRegIdTrib("01010101");
//         destino.setResidenciaFiscalId("USA");
//         destino.setNumEstacionId("EA0143");
//         destino.setNombreEstacion("Phoenix-Mesa Gateway");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // TipoFigura (operador, licencia, no partesTransporte, no domicilio)
//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("a234567890");
//         figura.setNombreFigura("NombreFigura");
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Salida");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("03");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteAereo(buildTransporteAereoCP());
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse21 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse21);
//     }

//     // Ejemplo 22: Factura traslado transporte aereo internacional aduanero (entrada, IMD)
//     private void facturaTrasladoTransporteAereoInternacionalAduanero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("IMD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (EA0417 / Loreto, CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("EA0417");
//         origen.setNombreEstacion("Loreto");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (EA0418 / Los Cabos, COA/MEX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumEstacionId("EA0418");
//         destino.setNombreEstacion("Los Cabos");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setTipoEstacionId("03");
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia con documentacion aduanera y tipoMateria
//         DocumentoAduanero doc = new DocumentoAduanero();
//         doc.setTipoDocumentoId("01");
//         doc.setNumPedimento("23  43  0472  8000448");
//         doc.setRfcImpo("EKU9003173C9");
//         List<DocumentoAduanero> docs = new ArrayList<>();
//         docs.add(doc);

//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setDocumentacionAduanera(docs);
//         mercancia.setCantidadTransporta(cantTransList);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // TipoFigura (operador, licencia, no partesTransporte, no domicilio)
//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("01");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNumLicencia("a234567890");
//         figura.setNombreFigura("NombreFigura");
//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Entrada");
//         cartaPorte.setPaisOrigenDestinoId("AFG");
//         cartaPorte.setViaEntradaSalidaId("03");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("10"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteAereo(buildTransporteAereoCP());
//         cartaPorte.setTiposFigura(tiposFigura);

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse22 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse22);
//     }

//     // Ejemplo 23: Factura traslado transporte maritimo nacional
//     private void facturaTrasladoTransporteMaritimoNacional(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Ubicacion Origen (PM001 / Rosarito, CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("PM001");
//         origen.setNombreEstacion("Rosarito");
//         origen.setNavegacionTraficoId("Altura");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (PM001 / Rosarito, COA/MEX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumEstacionId("PM001");
//         destino.setNombreEstacion("Rosarito");
//         destino.setNavegacionTraficoId("Altura");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setTipoEstacionId("03");
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia with detalleMercancia
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         DetalleMercancia detalle = new DetalleMercancia();
//         detalle.setUnidadPesoMercId("Tu");
//         detalle.setPesoBruto(new BigDecimal("1"));
//         detalle.setPesoNeto(new BigDecimal("1"));
//         detalle.setPesoTara(new BigDecimal("0.001"));
//         detalle.setNumPiezas(1);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setCantidadTransporta(cantTransList);
//         mercancia.setDetalleMercancia(detalle);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("No");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("1"));
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteMaritimo(buildTransporteMaritimo());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse23 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse23);
//     }

//     // Ejemplo 24: Factura traslado transporte maritimo extranjero (salida, EXD)
//     private void facturaTrasladoTransporteMaritimoExtranjero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero
//         RegimenAduanero regimenAduanero = new RegimenAduanero();
//         regimenAduanero.setRegimenAduaneroId("EXD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero);

//         // Ubicacion Origen (PM001 / Rosarito, CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("PM001");
//         origen.setNombreEstacion("Rosarito");
//         origen.setNavegacionTraficoId("Altura");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (PM120 / NombreEstacion, USA/TX — foreign)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("ST");
//         domDestino.setNumeroExterior("12345");
//         domDestino.setColoniaId("N/A");
//         domDestino.setReferencia("N/A");
//         domDestino.setMunicipioId("N/A");
//         domDestino.setEstadoId("TX");
//         domDestino.setPaisId("USA");
//         domDestino.setCodigoPostalId("12345");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("XEXX010101000");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumRegIdTrib("01010101");
//         destino.setResidenciaFiscalId("USA");
//         destino.setNumEstacionId("PM120");
//         destino.setNombreEstacion("NombreEstacion");
//         destino.setNavegacionTraficoId("Altura");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia with detalleMercancia and tipoMateria
//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         DetalleMercancia detalle = new DetalleMercancia();
//         detalle.setUnidadPesoMercId("Tu");
//         detalle.setPesoBruto(new BigDecimal("1"));
//         detalle.setPesoNeto(new BigDecimal("1"));
//         detalle.setPesoTara(new BigDecimal("0.001"));
//         detalle.setNumPiezas(1);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setCantidadTransporta(cantTransList);
//         mercancia.setDetalleMercancia(detalle);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Salida");
//         cartaPorte.setPaisOrigenDestinoId("USA");
//         cartaPorte.setViaEntradaSalidaId("02");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("1"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteMaritimo(buildTransporteMaritimo());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse24 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse24);
//     }

//     // Ejemplo 25: Factura traslado transporte maritimo internacional aduanero (entrada, IMD x2)
//     private void facturaTrasladoTransporteMaritimoInternacionalAduanero(FiscalApiSettings settings) {
//         FiscalApiClient client = FiscalApiClient.create(settings);
//         List<InvoiceItem> items = new ArrayList<>();
//         items.add(buildStandardItem());

//         // Regimen aduanero (two IMD entries)
//         RegimenAduanero regimenAduanero1 = new RegimenAduanero();
//         regimenAduanero1.setRegimenAduaneroId("IMD");
//         RegimenAduanero regimenAduanero2 = new RegimenAduanero();
//         regimenAduanero2.setRegimenAduaneroId("IMD");
//         List<RegimenAduanero> regimenAduaneros = new ArrayList<>();
//         regimenAduaneros.add(regimenAduanero1);
//         regimenAduaneros.add(regimenAduanero2);

//         // Ubicacion Origen (PM001 / Rosarito, CMX/MEX)
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("PM001");
//         origen.setNombreEstacion("Rosarito");
//         origen.setNavegacionTraficoId("Altura");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         // Ubicacion Destino (PM001 / Rosarito, COA/MEX)
//         Domicilio domDestino = new Domicilio();
//         domDestino.setCalle("Calle2");
//         domDestino.setNumeroExterior("214");
//         domDestino.setNumeroInterior("215");
//         domDestino.setColoniaId("0347");
//         domDestino.setLocalidadId("23");
//         domDestino.setReferencia("casa negra");
//         domDestino.setMunicipioId("004");
//         domDestino.setEstadoId("COA");
//         domDestino.setPaisId("MEX");
//         domDestino.setCodigoPostalId("25350");

//         Ubicacion destino = new Ubicacion();
//         destino.setTipoUbicacion("Destino");
//         destino.setIdUbicacion("DE202020");
//         destino.setRfcRemitenteDestinatario("EKU9003173C9");
//         destino.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         destino.setNumEstacionId("PM001");
//         destino.setNombreEstacion("Rosarito");
//         destino.setNavegacionTraficoId("Altura");
//         destino.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:01"));
//         destino.setTipoEstacionId("03");
//         destino.setDomicilio(domDestino);

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(destino);

//         // Mercancia with documentacionAduanera, detalleMercancia, and tipoMateria
//         DocumentoAduanero doc = new DocumentoAduanero();
//         doc.setTipoDocumentoId("01");
//         doc.setNumPedimento("23  43  0472  8000448");
//         doc.setRfcImpo("EKU9003173C9");
//         List<DocumentoAduanero> docs = new ArrayList<>();
//         docs.add(doc);

//         CantidadTransporta ct = new CantidadTransporta();
//         ct.setCantidad(new BigDecimal("1"));
//         ct.setIdOrigen("OR101010");
//         ct.setIdDestino("DE202020");
//         List<CantidadTransporta> cantTransList = new ArrayList<>();
//         cantTransList.add(ct);

//         DetalleMercancia detalle = new DetalleMercancia();
//         detalle.setUnidadPesoMercId("Tu");
//         detalle.setPesoBruto(new BigDecimal("1"));
//         detalle.setPesoNeto(new BigDecimal("1"));
//         detalle.setPesoTara(new BigDecimal("0.001"));
//         detalle.setNumPiezas(1);

//         Mercancia mercancia = new Mercancia();
//         mercancia.setBienesTranspId("11121900");
//         mercancia.setDescripcion("Accesorios de equipo de telefonía");
//         mercancia.setCantidad(new BigDecimal("1.0"));
//         mercancia.setClaveUnidadId("XBX");
//         mercancia.setMaterialPeligrosoId("No");
//         mercancia.setDenominacionGenericaProd("DenominacionGenericaProd1");
//         mercancia.setDenominacionDistintivaProd("DenominacionDistintivaProd1");
//         mercancia.setFabricante("Fabricante1");
//         mercancia.setFechaCaducidad(LocalDateTime.parse("2028-01-01T00:00:00"));
//         mercancia.setLoteMedicamento("LoteMedic1");
//         mercancia.setRegistroSanitarioFolioAutorizacion("RegistroSanita1");
//         mercancia.setPesoEnKg(new BigDecimal("1"));
//         mercancia.setValorMercancia(new BigDecimal("100"));
//         mercancia.setMonedaId("MXN");
//         mercancia.setTipoMateriaId("05");
//         mercancia.setDescripcionMateria("otramateria");
//         mercancia.setDocumentacionAduanera(docs);
//         mercancia.setCantidadTransporta(cantTransList);
//         mercancia.setDetalleMercancia(detalle);
//         List<Mercancia> mercancias = new ArrayList<>();
//         mercancias.add(mercancia);

//         // CartaPorte
//         CartaPorte cartaPorte = new CartaPorte();
//         cartaPorte.setTranspInternacId("Sí");
//         cartaPorte.setEntradaSalidaMercId("Entrada");
//         cartaPorte.setPaisOrigenDestinoId("AFG");
//         cartaPorte.setViaEntradaSalidaId("02");
//         cartaPorte.setUnidadPesoId("XBX");
//         cartaPorte.setPesoNetoTotal(new BigDecimal("1"));
//         cartaPorte.setRegimenAduaneros(regimenAduaneros);
//         cartaPorte.setUbicaciones(ubicaciones);
//         cartaPorte.setMercancias(mercancias);
//         cartaPorte.setTransporteMaritimo(buildTransporteMaritimo());
//         cartaPorte.setTiposFigura(buildTiposFiguraFerroviario());

//         Complement complement = new Complement();
//         complement.setCartaPorte(cartaPorte);

//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setCurrencyCode("XXX");
//         invoice.setTypeCode("T");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(buildIssuerEKU());
//         invoice.setRecipient(buildRecipientEKU());
//         invoice.setItems(items);
//         invoice.setComplement(complement);

//         ApiResponse<Invoice> apiResponse25 = client.getInvoiceService().create(invoice);
//         System.out.println(apiResponse25);
//     }

//     // ── Helper methods ──────────────────────────────────────────────────────────

//     private List<TaxCredential> buildTaxCredentials() {
//         TaxCredential cer = new TaxCredential();
//         cer.setBase64File(escuelaKemperUrgateBase64Cer);
//         cer.setFileType(0);
//         cer.setPassword(password);
//         TaxCredential key = new TaxCredential();
//         key.setBase64File(escuelaKemperUrgateBase64Key);
//         key.setFileType(1);
//         key.setPassword(password);
//         List<TaxCredential> credentials = new ArrayList<>();
//         credentials.add(cer);
//         credentials.add(key);
//         return credentials;
//     }

//     private InvoiceIssuer buildIssuerEKU() {
//         InvoiceIssuer issuer = new InvoiceIssuer();
//         issuer.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");
//         return issuer;
//     }

//     private InvoiceRecipient buildRecipientEKU() {
//         InvoiceRecipient recipient = new InvoiceRecipient();
//         recipient.setId("0e82a655-5f0c-4e07-abab-8f322e4123ef");
//         return recipient;
//     }

//     private InvoiceItem buildStandardItem() {
//         InvoiceItem item = new InvoiceItem();
//         item.setItemCode("78101800");
//         item.setItemSku("UT421511");
//         item.setQuantity(new BigDecimal("1"));
//         item.setUnitOfMeasurementCode("H87");
//         item.setDescription("Transporte de carga por carretera");
//         item.setUnitPrice(new BigDecimal("100.00"));
//         item.setDiscount(new BigDecimal("0"));
//         item.setTaxObjectCode("01");
//         item.setItemTaxes(new ArrayList<>());
//         return item;
//     }

//     private Invoice buildInvoice(InvoiceIssuer issuer, InvoiceRecipient recipient,
//                                  List<InvoiceItem> items, Complement complement) {
//         Invoice invoice = new Invoice();
//         invoice.setVersionCode("4.0");
//         invoice.setPaymentFormCode("01");
//         invoice.setPaymentMethodCode("PUE");
//         invoice.setCurrencyCode("MXN");
//         invoice.setTypeCode("I");
//         invoice.setExpeditionZipCode("42501");
//         invoice.setSeries("Serie");
//         invoice.setDate(OptUtil.parseLocalDateTime(LocalDateTime.now().toString()));
//         invoice.setExchangeRate(new BigDecimal("1"));
//         invoice.setExportCode("01");
//         invoice.setIssuer(issuer);
//         invoice.setRecipient(recipient);
//         invoice.setItems(items);
//         invoice.setComplement(complement);
//         return invoice;
//     }

//     private TransporteAereo buildTransporteAereoCP() {
//         TransporteAereo transporteAereo = new TransporteAereo();
//         transporteAereo.setPermSCTId("TPAF01");
//         transporteAereo.setNumPermisoSCT("Demo");
//         transporteAereo.setMatriculaAeronave("61E5-WZ");
//         transporteAereo.setNombreAseg("NombreAseg");
//         transporteAereo.setNumPolizaSeguro("NumPolizaSeguro");
//         transporteAereo.setNumeroGuia("acUbYlBVTmlzx");
//         transporteAereo.setLugarContrato("LugarContrato");
//         transporteAereo.setCodigoTransportistaId("CA001");
//         transporteAereo.setRfcEmbarcador("EKU9003173C9");
//         transporteAereo.setNombreEmbarcador("Embarcador");
//         return transporteAereo;
//     }

//     private TransporteMaritimo buildTransporteMaritimo() {
//         TransporteMaritimo.RemolqueCCP remolqueCCP = new TransporteMaritimo.RemolqueCCP();
//         remolqueCCP.setSubTipoRemCCPId("CTR001");
//         remolqueCCP.setPlacaCCP("JNG7636");
//         List<TransporteMaritimo.RemolqueCCP> remolquesCCP = new ArrayList<>();
//         remolquesCCP.add(remolqueCCP);

//         TransporteMaritimo.ContenedorMaritimo contenedor = new TransporteMaritimo.ContenedorMaritimo();
//         contenedor.setTipoContenedorId("CM011");
//         contenedor.setIdCCPRelacionado("CCCBCD94-870A-4332-A52A-A52AA52AA52A");
//         contenedor.setPlacaVMCCP("JNG7683");
//         contenedor.setFechaCertificacionCCP("2024-06-20T11:11:00");
//         contenedor.setRemolquesCCP(remolquesCCP);
//         List<TransporteMaritimo.ContenedorMaritimo> contenedores = new ArrayList<>();
//         contenedores.add(contenedor);

//         TransporteMaritimo maritimo = new TransporteMaritimo();
//         maritimo.setPermSCTId("TPAF01");
//         maritimo.setNumPermisoSCT("NumPermisoSCT1");
//         maritimo.setNombreAseg("NombreAseg1");
//         maritimo.setNumPolizaSeguro("NumPolizaSeguro1");
//         maritimo.setTipoEmbarcacionId("B01");
//         maritimo.setMatricula("Matricula1");
//         maritimo.setNumeroOMI("IMO1234567");
//         maritimo.setAnioEmbarcacion(2003);
//         maritimo.setNombreEmbarc("NombreEmbarc1");
//         maritimo.setNacionalidadEmbarcId("AFG");
//         maritimo.setUnidadesDeArqBruto(new BigDecimal("0.001"));
//         maritimo.setTipoCargaId("CGS");
//         maritimo.setEslora(new BigDecimal("0.01"));
//         maritimo.setManga(new BigDecimal("0.01"));
//         maritimo.setCalado(new BigDecimal("0.01"));
//         maritimo.setPuntal(new BigDecimal("0.01"));
//         maritimo.setLineaNaviera("LineaNaviera1");
//         maritimo.setNombreAgenteNaviero("NombreAgenteNaviero1");
//         maritimo.setNumAutorizacionNavieroId("ANC001/2022");
//         maritimo.setNumViaje("NumViaje1");
//         maritimo.setNumConocEmbarc("NumConocEmbarc1");
//         maritimo.setPermisoTempNavegacion("PermisoTempNavegac1");
//         maritimo.setContenedores(contenedores);
//         return maritimo;
//     }

//     private TransporteFerroviario buildTransporteFerroviario() {
//         TransporteFerroviario.DerechoDePaso derecho = new TransporteFerroviario.DerechoDePaso();
//         derecho.setTipoDerechoDePasoId("CDP114");
//         derecho.setKilometrajePagado(new BigDecimal("100"));
//         List<TransporteFerroviario.DerechoDePaso> derechos = new ArrayList<>();
//         derechos.add(derecho);

//         TransporteFerroviario.Carro carro = new TransporteFerroviario.Carro();
//         carro.setTipoCarroId("TC08");
//         carro.setMatriculaCarro("A00012");
//         carro.setGuiaCarro("123ASD");
//         carro.setToneladasNetasCarro(new BigDecimal("10"));
//         List<TransporteFerroviario.Carro> carros = new ArrayList<>();
//         carros.add(carro);

//         TransporteFerroviario transporte = new TransporteFerroviario();
//         transporte.setTipoDeServicioId("TS01");
//         transporte.setTipoDeTraficoId("TT01");
//         transporte.setDerechosDePaso(derechos);
//         transporte.setCarros(carros);
//         return transporte;
//     }

//     private List<TipoFigura> buildTiposFiguraFerroviario() {
//         ParteTransporte parte = new ParteTransporte();
//         parte.setParteTransporteId("PT02");
//         List<ParteTransporte> partes = new ArrayList<>();
//         partes.add(parte);

//         Domicilio domicilio = new Domicilio();
//         domicilio.setCalle("calle");
//         domicilio.setNumeroExterior("211");
//         domicilio.setColoniaId("0814");
//         domicilio.setLocalidadId("01");
//         domicilio.setReferencia("casa blanca");
//         domicilio.setMunicipioId("010");
//         domicilio.setEstadoId("ZAC");
//         domicilio.setPaisId("MEX");
//         domicilio.setCodigoPostalId("99080");

//         TipoFigura figura = new TipoFigura();
//         figura.setTipoFiguraId("02");
//         figura.setRfcFigura("EKU9003173C9");
//         figura.setNombreFigura("NombreFigura");
//         figura.setPartesTransporte(partes);
//         figura.setDomicilio(domicilio);

//         List<TipoFigura> tiposFigura = new ArrayList<>();
//         tiposFigura.add(figura);
//         return tiposFigura;
//     }

//     private List<Ubicacion> buildUbicacionesFerroviarioComunes() {
//         Domicilio domOrigen = new Domicilio();
//         domOrigen.setCalle("Calle1");
//         domOrigen.setNumeroExterior("211");
//         domOrigen.setNumeroInterior("212");
//         domOrigen.setColoniaId("1957");
//         domOrigen.setLocalidadId("13");
//         domOrigen.setReferencia("casa blanca");
//         domOrigen.setMunicipioId("011");
//         domOrigen.setEstadoId("CMX");
//         domOrigen.setPaisId("MEX");
//         domOrigen.setCodigoPostalId("13250");

//         Ubicacion origen = new Ubicacion();
//         origen.setTipoUbicacion("Origen");
//         origen.setIdUbicacion("OR101010");
//         origen.setRfcRemitenteDestinatario("EKU9003173C9");
//         origen.setNombreRemitenteDestinatario("NombreRemitenteDestinatario1");
//         origen.setNumEstacionId("Q0736");
//         origen.setNombreEstacion("SANTO NINO");
//         origen.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T00:00:00"));
//         origen.setTipoEstacionId("01");
//         origen.setDomicilio(domOrigen);

//         Ubicacion dest1 = new Ubicacion();
//         dest1.setTipoUbicacion("Destino");
//         dest1.setIdUbicacion("DE202021");
//         dest1.setRfcRemitenteDestinatario("EKU9003173C9");
//         dest1.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest1.setNumEstacionId("SC283");
//         dest1.setNombreEstacion("HUAXTITLA");
//         dest1.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T01:00:01"));
//         dest1.setTipoEstacionId("02");
//         dest1.setDistanciaRecorrida(new BigDecimal("100.00"));

//         Ubicacion dest2 = new Ubicacion();
//         dest2.setTipoUbicacion("Destino");
//         dest2.setIdUbicacion("DE202022");
//         dest2.setRfcRemitenteDestinatario("EKU9003173C9");
//         dest2.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest2.setNumEstacionId("TG0");
//         dest2.setNombreEstacion("NAVOJOA");
//         dest2.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T02:00:01"));
//         dest2.setTipoEstacionId("02");
//         dest2.setDistanciaRecorrida(new BigDecimal("100.00"));

//         Ubicacion dest3 = new Ubicacion();
//         dest3.setTipoUbicacion("Destino");
//         dest3.setIdUbicacion("DE202023");
//         dest3.setRfcRemitenteDestinatario("EKU9003173C9");
//         dest3.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest3.setNumEstacionId("E0029");
//         dest3.setNombreEstacion("TRES JAGUEYES");
//         dest3.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T03:00:01"));
//         dest3.setTipoEstacionId("02");
//         dest3.setDistanciaRecorrida(new BigDecimal("100.00"));

//         Ubicacion dest4 = new Ubicacion();
//         dest4.setTipoUbicacion("Destino");
//         dest4.setIdUbicacion("DE202024");
//         dest4.setRfcRemitenteDestinatario("EKU9003173C9");
//         dest4.setNombreRemitenteDestinatario("NombreRemitenteDestinatario2");
//         dest4.setNumEstacionId("TI032");
//         dest4.setNombreEstacion("NAVOLATO");
//         dest4.setFechaHoraSalidaLlegada(LocalDateTime.parse("2023-08-01T04:00:01"));
//         dest4.setTipoEstacionId("02");
//         dest4.setDistanciaRecorrida(new BigDecimal("100.00"));

//         List<Ubicacion> ubicaciones = new ArrayList<>();
//         ubicaciones.add(origen);
//         ubicaciones.add(dest1);
//         ubicaciones.add(dest2);
//         ubicaciones.add(dest3);
//         ubicaciones.add(dest4);
//         return ubicaciones;
//     }
// }
