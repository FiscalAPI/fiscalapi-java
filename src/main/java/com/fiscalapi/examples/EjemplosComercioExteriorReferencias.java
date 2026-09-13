package com.fiscalapi.examples;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fiscalapi.OptUtil;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.invoicing.Complement;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.models.invoicing.InvoiceIssuer;
import com.fiscalapi.models.invoicing.InvoiceItem;
import com.fiscalapi.models.invoicing.InvoiceRecipient;
import com.fiscalapi.models.invoicing.ItemTax;
import com.fiscalapi.models.invoicing.billOfLading.Autotransporte;
import com.fiscalapi.models.invoicing.billOfLading.CartaPorte;
import com.fiscalapi.models.invoicing.billOfLading.Mercancia;
import com.fiscalapi.models.invoicing.billOfLading.RegimenAduanero;
import com.fiscalapi.models.invoicing.billOfLading.TipoFigura;
import com.fiscalapi.models.invoicing.billOfLading.Ubicacion;
import com.fiscalapi.models.invoicing.billOfLading.UbicacionDomicilio;
import com.fiscalapi.models.invoicing.foreignTrade.ComercioExterior;
import com.fiscalapi.models.invoicing.foreignTrade.ComercioExteriorDestinatario;
import com.fiscalapi.models.invoicing.foreignTrade.ComercioExteriorDestinatarioDomicilio;
import com.fiscalapi.models.invoicing.foreignTrade.ComercioExteriorEmisor;
import com.fiscalapi.models.invoicing.foreignTrade.ComercioExteriorEmisorDomicilio;
import com.fiscalapi.models.invoicing.foreignTrade.ComercioExteriorMercancia;
import com.fiscalapi.models.invoicing.foreignTrade.ComercioExteriorReceptor;
import com.fiscalapi.models.invoicing.foreignTrade.ComercioExteriorReceptorDomicilio;
import com.fiscalapi.services.FiscalApiClient;

/**
 * Ejemplos del complemento Comercio Exterior 2.0 en modo "por referencias": el emisor y el
 * receptor se envian solo con su id y la API resuelve el resto desde el catalogo de personas.
 *
 * <p>Para un receptor extranjero, la persona referida debe tener {@code countryId} y
 * {@code foreignTin} capturados: de ahi salen la residencia fiscal y el NumRegIdTrib del CFDI.</p>
 *
 * <p>Los importes sensibles al SAT se construyen con {@code new BigDecimal("...")} y no con
 * literales numericos: la escala forma parte del dato. Enviar {@code 120} en lugar de
 * {@code 120.00} hace que el PAC rechace el comprobante con CCE122 (TotalUSD), y enviar
 * {@code 0.16} en lugar de {@code 0.160000} lo rechaza con CFDI40179 (TasaOCuota).</p>
 */
public class EjemplosComercioExteriorReferencias {

    // Ids de las personas dadas de alta en el tenant.
    private static final String ISSUER_ID = "<ISSUER_ID>";

    // Receptor extranjero: debe tener countryId y foreignTin capturados.
    private static final String RECIPIENT_EXTRANJERO_ID = "<RECIPIENT_EXTRANJERO_ID>";

    private static final String RECIPIENT_NACIONAL_ID = "<RECIPIENT_NACIONAL_ID>";

    // Tipo de cambio del dolar publicado en el DOF para la fecha del comprobante. El SAT lo valida
    // (CCE121), asi que hay que actualizarlo al valor del dia en que se ejecute el ejemplo.
    private static final BigDecimal TIPO_CAMBIO_USD = new BigDecimal("16.9722");

    // El complemento solo admite comprobantes emitidos dentro de las ultimas 72 horas (CCE121).
    private static final LocalDateTime FECHA = LocalDateTime.now();

    public static void main(String[] args) {
        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(false);
        settings.setApiUrl("https://test.fiscalapi.com");
        settings.setApiKey("<API_KEY>");
        settings.setTenant("<TENANT_KEY>");

        FiscalApiClient client = FiscalApiClient.create(settings);

        facturaCeIngresoConCartaPorte31(client);
        facturaCeIngresoDiferentesMonedas(client);
        facturaCeKitParte(client);
        facturaCeReceptorExtranjero(client);
        facturaCeReceptorNacional(client);
        facturaCeTrasladoConCartaPorte31(client);
        facturaCeTrasladoTrasladoMercanciaPropia(client);
        facturaCeTrasladoTraslado(client);
        facturaCeUnidadesDeMedidaNoEquivalentes(client);
    }

    /**
     * Factura CE Ingreso Con Carta Porte 31.
     */
    private static void facturaCeIngresoConCartaPorte31(FiscalApiClient client) {
        System.out.println("\n===== 1. Factura CE Ingreso Con Carta Porte 31 =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setPaymentFormCode("99");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("USD");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setPaymentConditions("CondicionesDePago");
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(RECIPIENT_EXTRANJERO_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item1 = new InvoiceItem();
        item1.setItemCode("78101800");
        item1.setItemSku("SERV02");
        item1.setQuantity(new BigDecimal("1.000000"));
        item1.setUnitOfMeasurementCode("HUR");
        item1.setDescription("FLETE");
        item1.setUnitPrice(new BigDecimal("2300.000000"));
        item1.setDiscount(new BigDecimal("0"));
        item1.setTaxObjectCode("02");
        List<ItemTax> itemTaxes = new ArrayList<ItemTax>();
        ItemTax itemTax1 = new ItemTax();
        itemTax1.setTaxCode("002");
        itemTax1.setTaxTypeCode("Tasa");
        itemTax1.setTaxRate(new BigDecimal("0.160000"));
        itemTax1.setTaxFlagCode("T");
        itemTaxes.add(itemTax1);

        ItemTax itemTax2 = new ItemTax();
        itemTax2.setTaxCode("003");
        itemTax2.setTaxTypeCode("Tasa");
        itemTax2.setTaxRate(new BigDecimal("0.300000"));
        itemTax2.setTaxFlagCode("R");
        itemTaxes.add(itemTax2);

        item1.setItemTaxes(itemTaxes);

        items.add(item1);

        InvoiceItem item2 = new InvoiceItem();
        item2.setItemCode("50161509");
        item2.setItemSku("A0001");
        item2.setQuantity(new BigDecimal("1.000000"));
        item2.setUnitOfMeasurementCode("H87");
        item2.setDescription("Gomitas");
        item2.setUnitPrice(new BigDecimal("120.000000"));
        item2.setDiscount(new BigDecimal("0"));
        item2.setTaxObjectCode("02");
        List<ItemTax> item2ItemTaxes = new ArrayList<ItemTax>();
        ItemTax itemTax = new ItemTax();
        itemTax.setTaxCode("002");
        itemTax.setTaxTypeCode("Tasa");
        itemTax.setTaxRate(new BigDecimal("0.160000"));
        itemTax.setTaxFlagCode("T");
        item2ItemTaxes.add(itemTax);

        item2.setItemTaxes(item2ItemTaxes);

        items.add(item2);

        InvoiceItem item3 = new InvoiceItem();
        item3.setItemCode("50307037");
        item3.setItemSku("A0002");
        item3.setQuantity(new BigDecimal("1.000000"));
        item3.setUnitOfMeasurementCode("H87");
        item3.setDescription("Pulparindo");
        item3.setUnitPrice(new BigDecimal("100.000000"));
        item3.setDiscount(new BigDecimal("0"));
        item3.setTaxObjectCode("02");
        List<ItemTax> item3ItemTaxes = new ArrayList<ItemTax>();
        ItemTax item3ItemTaxesItemTax = new ItemTax();
        item3ItemTaxesItemTax.setTaxCode("002");
        item3ItemTaxesItemTax.setTaxTypeCode("Tasa");
        item3ItemTaxesItemTax.setTaxRate(new BigDecimal("0.160000"));
        item3ItemTaxesItemTax.setTaxFlagCode("T");
        item3ItemTaxes.add(item3ItemTaxesItemTax);

        item3.setItemTaxes(item3ItemTaxes);

        items.add(item3);

        invoice.setItems(items);

        Complement complement = new Complement();
        CartaPorte cartaPorte = new CartaPorte();
        cartaPorte.setTranspInternacId("Sí");
        cartaPorte.setEntradaSalidaMercId("Salida");
        cartaPorte.setPaisOrigenDestinoId("ALB");
        cartaPorte.setViaEntradaSalidaId("01");
        cartaPorte.setTotalDistRec(new BigDecimal("120.00"));
        cartaPorte.setUnidadPesoId("KGM");
        List<RegimenAduanero> regimenAduaneros = new ArrayList<RegimenAduanero>();
        RegimenAduanero regimenAduanero = new RegimenAduanero();
        regimenAduanero.setRegimenAduaneroId("EXD");
        regimenAduaneros.add(regimenAduanero);

        cartaPorte.setRegimenAduaneros(regimenAduaneros);

        List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
        Ubicacion ubicacion1 = new Ubicacion();
        ubicacion1.setTipoUbicacion("Origen");
        ubicacion1.setIdUbicacion("OR000001");
        ubicacion1.setRfcRemitenteDestinatario("XAXX010101000");
        ubicacion1.setNombreRemitenteDestinatario("Origen Nacional");
        ubicacion1.setFechaHoraSalidaLlegada(OptUtil.parseLocalDateTime("2026-04-27T08:00:00"));
        UbicacionDomicilio domicilio = new UbicacionDomicilio();
        domicilio.setCalle("xola");
        domicilio.setNumeroExterior("531");
        domicilio.setColoniaId("0496");
        domicilio.setLocalidadId("03");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("CMX");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("03100");
        ubicacion1.setDomicilio(domicilio);

        ubicaciones.add(ubicacion1);

        Ubicacion ubicacion2 = new Ubicacion();
        ubicacion2.setTipoUbicacion("Destino");
        ubicacion2.setIdUbicacion("DE000001");
        ubicacion2.setRfcRemitenteDestinatario("XAXX010101000");
        ubicacion2.setNombreRemitenteDestinatario("Destino Nacional");
        ubicacion2.setFechaHoraSalidaLlegada(OptUtil.parseLocalDateTime("2026-04-27T20:00:00"));
        ubicacion2.setDistanciaRecorrida(new BigDecimal("120.00"));
        UbicacionDomicilio ubicacion2Domicilio = new UbicacionDomicilio();
        ubicacion2Domicilio.setCalle("Av Coyoacan");
        ubicacion2Domicilio.setNumeroExterior("120");
        ubicacion2Domicilio.setColoniaId("2624");
        ubicacion2Domicilio.setLocalidadId("03");
        ubicacion2Domicilio.setMunicipioId("014");
        ubicacion2Domicilio.setEstadoId("CMX");
        ubicacion2Domicilio.setPaisId("MEX");
        ubicacion2Domicilio.setCodigoPostalId("03100");
        ubicacion2.setDomicilio(ubicacion2Domicilio);

        ubicaciones.add(ubicacion2);

        cartaPorte.setUbicaciones(ubicaciones);

        List<Mercancia> mercancias = new ArrayList<Mercancia>();
        Mercancia mercancia1 = new Mercancia();
        mercancia1.setBienesTranspId("50433238");
        mercancia1.setDescripcion("Gomitas");
        mercancia1.setCantidad(new BigDecimal("1"));
        mercancia1.setClaveUnidadId("XPK");
        mercancia1.setPesoEnKg(new BigDecimal("10.000"));
        mercancia1.setValorMercancia(new BigDecimal("1200.00"));
        mercancia1.setMonedaId("USD");
        mercancia1.setFraccionArancelariaId("2005800100");
        mercancia1.setTipoMateriaId("04");
        mercancias.add(mercancia1);

        Mercancia mercancia2 = new Mercancia();
        mercancia2.setBienesTranspId("50433238");
        mercancia2.setDescripcion("Pulparindo");
        mercancia2.setCantidad(new BigDecimal("1"));
        mercancia2.setClaveUnidadId("XPK");
        mercancia2.setPesoEnKg(new BigDecimal("10.000"));
        mercancia2.setValorMercancia(new BigDecimal("1000.00"));
        mercancia2.setMonedaId("USD");
        mercancia2.setFraccionArancelariaId("2005800100");
        mercancia2.setTipoMateriaId("04");
        mercancias.add(mercancia2);

        cartaPorte.setMercancias(mercancias);

        Autotransporte autotransporte = new Autotransporte();
        autotransporte.setPermSCTId("TPAF02");
        autotransporte.setNumPermisoSCT("123456");
        autotransporte.setConfigVehicularId("C2");
        autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
        autotransporte.setPlacaVM("555TTT");
        autotransporte.setAnioModeloVM(2023);
        autotransporte.setAseguraRespCivil("ODISEA");
        autotransporte.setPolizaRespCivil("3456YUHNB234RT");
        cartaPorte.setAutotransporte(autotransporte);

        List<TipoFigura> tiposFigura = new ArrayList<TipoFigura>();
        TipoFigura tipoFigura = new TipoFigura();
        tipoFigura.setTipoFiguraId("01");
        tipoFigura.setRfcFigura("KAHO641101B39");
        tipoFigura.setNumLicencia("D0908240");
        tipoFigura.setNombreFigura("OSCAR KALA HAAK");
        tiposFigura.add(tipoFigura);

        cartaPorte.setTiposFigura(tiposFigura);

        complement.setCartaPorte(cartaPorte);

        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("CIF");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio emisorDomicilio = new ComercioExteriorEmisorDomicilio();
        emisorDomicilio.setCalle("Av Siempre viva");
        emisorDomicilio.setNumeroExterior("123");
        emisorDomicilio.setColoniaId("0001");
        emisorDomicilio.setLocalidadId("06");
        emisorDomicilio.setMunicipioId("025");
        emisorDomicilio.setEstadoId("COA");
        emisorDomicilio.setPaisId("MEX");
        emisorDomicilio.setCodigoPostalId("26015");
        emisor.setDomicilio(emisorDomicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("Clinton ST");
        receptorDomicilio.setNumeroExterior("10002");
        receptorDomicilio.setEstado("NY");
        receptorDomicilio.setPaisId("USA");
        receptorDomicilio.setCodigoPostal("10002-0000");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorMercancia> comercioExteriorMercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia comercioExteriorMercanciasMercancia1 = new ComercioExteriorMercancia();
        comercioExteriorMercanciasMercancia1.setNoIdentificacion("A0001");
        comercioExteriorMercanciasMercancia1.setFraccionArancelariaId("4011101099");
        comercioExteriorMercanciasMercancia1.setCantidadAduana(new BigDecimal("1.000"));
        comercioExteriorMercanciasMercancia1.setUnidadAduanaId("06");
        comercioExteriorMercanciasMercancia1.setValorUnitarioAduana(new BigDecimal("120.00"));
        comercioExteriorMercanciasMercancia1.setValorDolares(new BigDecimal("120.00"));
        comercioExteriorMercancias.add(comercioExteriorMercanciasMercancia1);

        ComercioExteriorMercancia comercioExteriorMercanciasMercancia2 = new ComercioExteriorMercancia();
        comercioExteriorMercanciasMercancia2.setNoIdentificacion("A0002");
        comercioExteriorMercanciasMercancia2.setFraccionArancelariaId("8407210299");
        comercioExteriorMercanciasMercancia2.setCantidadAduana(new BigDecimal("1.000"));
        comercioExteriorMercanciasMercancia2.setUnidadAduanaId("06");
        comercioExteriorMercanciasMercancia2.setValorUnitarioAduana(new BigDecimal("100.00"));
        comercioExteriorMercanciasMercancia2.setValorDolares(new BigDecimal("100.00"));
        comercioExteriorMercancias.add(comercioExteriorMercanciasMercancia2);

        comercioExterior.setMercancias(comercioExteriorMercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Factura CE Ingreso Diferentes Monedas.
     */
    private static void facturaCeIngresoDiferentesMonedas(FiscalApiClient client) {
        System.out.println("\n===== 2. Factura CE Ingreso Diferentes Monedas =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setPaymentFormCode("99");
        invoice.setPaymentMethodCode("PPD");
        invoice.setCurrencyCode("MXN");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setPaymentConditions("CondicionesDePago");
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(RECIPIENT_EXTRANJERO_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item = new InvoiceItem();
        item.setItemCode("50211503");
        item.setItemSku("131494-1055");
        item.setQuantity(new BigDecimal("2"));
        item.setUnitOfMeasurementCode("H87");
        item.setDescription("Cigarros");
        item.setUnitPrice(new BigDecimal("200.00"));
        item.setDiscount(new BigDecimal("0"));
        item.setTaxObjectCode("02");
        List<ItemTax> itemTaxes = new ArrayList<ItemTax>();
        ItemTax itemTax1 = new ItemTax();
        itemTax1.setTaxCode("002");
        itemTax1.setTaxTypeCode("Tasa");
        itemTax1.setTaxRate(new BigDecimal("0.160000"));
        itemTax1.setTaxFlagCode("T");
        itemTaxes.add(itemTax1);

        ItemTax itemTax2 = new ItemTax();
        itemTax2.setTaxCode("001");
        itemTax2.setTaxTypeCode("Tasa");
        itemTax2.setTaxRate(new BigDecimal("0.100000"));
        itemTax2.setTaxFlagCode("R");
        itemTaxes.add(itemTax2);

        ItemTax itemTax3 = new ItemTax();
        itemTax3.setTaxCode("002");
        itemTax3.setTaxTypeCode("Tasa");
        itemTax3.setTaxRate(new BigDecimal("0.106666"));
        itemTax3.setTaxFlagCode("R");
        itemTaxes.add(itemTax3);

        item.setItemTaxes(itemTaxes);

        items.add(item);

        invoice.setItems(items);

        Complement complement = new Complement();
        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("FOB");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio domicilio = new ComercioExteriorEmisorDomicilio();
        domicilio.setCalle("CALLE DEL PAPEL");
        domicilio.setColoniaId("0214");
        domicilio.setLocalidadId("01");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("QUE");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("76199");
        emisor.setDomicilio(domicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        receptor.setNumRegIdTrib("123456789");
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("ST. A");
        receptorDomicilio.setEstado("TX");
        receptorDomicilio.setPaisId("USA");
        receptorDomicilio.setCodigoPostal("00000");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorMercancia> mercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia mercancia = new ComercioExteriorMercancia();
        mercancia.setNoIdentificacion("131494-1055");
        mercancia.setFraccionArancelariaId("2402200100");
        mercancia.setCantidadAduana(new BigDecimal("2.00"));
        mercancia.setUnidadAduanaId("01");
        mercancia.setValorUnitarioAduana(new BigDecimal("11.74"));
        mercancia.setValorDolares(new BigDecimal("23.47"));
        mercancias.add(mercancia);

        comercioExterior.setMercancias(mercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Factura CE Kit Parte.
     */
    private static void facturaCeKitParte(FiscalApiClient client) {
        System.out.println("\n===== 3. Factura CE Kit Parte =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setPaymentFormCode("01");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setPaymentConditions("CondicionesDePago");
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(RECIPIENT_EXTRANJERO_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item1 = new InvoiceItem();
        item1.setItemCode("51241200");
        item1.setItemSku("131494-1055");
        item1.setQuantity(new BigDecimal("1.0"));
        item1.setUnitOfMeasurementCode("H87");
        item1.setDescription("FORMULA MAGISTRAL");
        item1.setUnitPrice(new BigDecimal("200.00"));
        item1.setDiscount(new BigDecimal("0"));
        item1.setTaxObjectCode("01");
        items.add(item1);

        InvoiceItem item2 = new InvoiceItem();
        item2.setItemCode("51241200");
        item2.setItemSku("131494-1055");
        item2.setQuantity(new BigDecimal("1.0"));
        item2.setUnitOfMeasurementCode("H87");
        item2.setDescription("FORMULA MAGISTRAL");
        item2.setUnitPrice(new BigDecimal("200.00"));
        item2.setDiscount(new BigDecimal("0"));
        item2.setTaxObjectCode("01");
        items.add(item2);

        invoice.setItems(items);

        Complement complement = new Complement();
        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("FOB");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio domicilio = new ComercioExteriorEmisorDomicilio();
        domicilio.setCalle("CALLE DEL PAPEL");
        domicilio.setColoniaId("0214");
        domicilio.setLocalidadId("01");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("QUE");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("76199");
        emisor.setDomicilio(domicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("ST. A");
        receptorDomicilio.setEstado("TX");
        receptorDomicilio.setPaisId("USA");
        receptorDomicilio.setCodigoPostal("00000");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorMercancia> mercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia mercancia = new ComercioExteriorMercancia();
        mercancia.setNoIdentificacion("131494-1055");
        mercancia.setFraccionArancelariaId("2402200100");
        mercancia.setCantidadAduana(new BigDecimal("2"));
        mercancia.setUnidadAduanaId("01");
        mercancia.setValorUnitarioAduana(new BigDecimal("10.00"));
        mercancia.setValorDolares(new BigDecimal("20.00"));
        mercancias.add(mercancia);

        comercioExterior.setMercancias(mercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Factura CE Receptor Extranjero.
     */
    private static void facturaCeReceptorExtranjero(FiscalApiClient client) {
        System.out.println("\n===== 4. Factura CE Receptor Extranjero =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setPaymentFormCode("99");
        invoice.setPaymentMethodCode("PPD");
        invoice.setCurrencyCode("USD");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setPaymentConditions("CondicionesDePago");
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(RECIPIENT_EXTRANJERO_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item = new InvoiceItem();
        item.setItemCode("50211503");
        item.setItemSku("131494-1055");
        item.setQuantity(new BigDecimal("2"));
        item.setUnitOfMeasurementCode("H87");
        item.setDescription("Cigarros");
        item.setUnitPrice(new BigDecimal("200.00"));
        item.setDiscount(new BigDecimal("0"));
        item.setTaxObjectCode("02");
        List<ItemTax> itemTaxes = new ArrayList<ItemTax>();
        ItemTax itemTax1 = new ItemTax();
        itemTax1.setTaxCode("002");
        itemTax1.setTaxTypeCode("Tasa");
        itemTax1.setTaxRate(new BigDecimal("0.160000"));
        itemTax1.setTaxFlagCode("T");
        itemTaxes.add(itemTax1);

        ItemTax itemTax2 = new ItemTax();
        itemTax2.setTaxCode("001");
        itemTax2.setTaxTypeCode("Tasa");
        itemTax2.setTaxRate(new BigDecimal("0.100000"));
        itemTax2.setTaxFlagCode("R");
        itemTaxes.add(itemTax2);

        item.setItemTaxes(itemTaxes);

        items.add(item);

        invoice.setItems(items);

        Complement complement = new Complement();
        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("FOB");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio domicilio = new ComercioExteriorEmisorDomicilio();
        domicilio.setCalle("CALLE DEL PAPEL");
        domicilio.setColoniaId("0214");
        domicilio.setLocalidadId("01");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("QUE");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("76199");
        emisor.setDomicilio(domicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        receptor.setNumRegIdTrib("123456789");
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("ST. A");
        receptorDomicilio.setEstado("TX");
        receptorDomicilio.setPaisId("USA");
        receptorDomicilio.setCodigoPostal("00000");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorMercancia> mercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia mercancia = new ComercioExteriorMercancia();
        mercancia.setNoIdentificacion("131494-1055");
        mercancia.setFraccionArancelariaId("2402200100");
        mercancia.setCantidadAduana(new BigDecimal("117.64"));
        mercancia.setUnidadAduanaId("01");
        mercancia.setValorUnitarioAduana(new BigDecimal("3.40"));
        mercancia.setValorDolares(new BigDecimal("400.00"));
        mercancias.add(mercancia);

        comercioExterior.setMercancias(mercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Factura CE Receptor Nacional.
     */
    private static void facturaCeReceptorNacional(FiscalApiClient client) {
        System.out.println("\n===== 5. Factura CE Receptor Nacional =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setPaymentFormCode("99");
        invoice.setPaymentMethodCode("PPD");
        invoice.setCurrencyCode("USD");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setPaymentConditions("CondicionesDePago");
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(RECIPIENT_NACIONAL_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item = new InvoiceItem();
        item.setItemCode("50211503");
        item.setItemSku("131494-1055");
        item.setQuantity(new BigDecimal("2"));
        item.setUnitOfMeasurementCode("H87");
        item.setDescription("Cigarros");
        item.setUnitPrice(new BigDecimal("200.00"));
        item.setDiscount(new BigDecimal("0"));
        item.setTaxObjectCode("02");
        List<ItemTax> itemTaxes = new ArrayList<ItemTax>();
        ItemTax itemTax1 = new ItemTax();
        itemTax1.setTaxCode("002");
        itemTax1.setTaxTypeCode("Tasa");
        itemTax1.setTaxRate(new BigDecimal("0.160000"));
        itemTax1.setTaxFlagCode("T");
        itemTaxes.add(itemTax1);

        ItemTax itemTax2 = new ItemTax();
        itemTax2.setTaxCode("001");
        itemTax2.setTaxTypeCode("Tasa");
        itemTax2.setTaxRate(new BigDecimal("0.100000"));
        itemTax2.setTaxFlagCode("R");
        itemTaxes.add(itemTax2);

        ItemTax itemTax3 = new ItemTax();
        itemTax3.setTaxCode("002");
        itemTax3.setTaxTypeCode("Tasa");
        itemTax3.setTaxRate(new BigDecimal("0.106666"));
        itemTax3.setTaxFlagCode("R");
        itemTaxes.add(itemTax3);

        item.setItemTaxes(itemTaxes);

        items.add(item);

        invoice.setItems(items);

        Complement complement = new Complement();
        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("FOB");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio domicilio = new ComercioExteriorEmisorDomicilio();
        domicilio.setCalle("CALLE DEL PAPEL");
        domicilio.setColoniaId("0214");
        domicilio.setLocalidadId("01");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("QUE");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("76199");
        emisor.setDomicilio(domicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("CALLE DEL PAPEL");
        receptorDomicilio.setColonia("0214");
        receptorDomicilio.setLocalidad("01");
        receptorDomicilio.setMunicipio("014");
        receptorDomicilio.setEstado("QUE");
        receptorDomicilio.setPaisId("MEX");
        receptorDomicilio.setCodigoPostal("76199");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorMercancia> mercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia mercancia = new ComercioExteriorMercancia();
        mercancia.setNoIdentificacion("131494-1055");
        mercancia.setFraccionArancelariaId("2402200100");
        mercancia.setCantidadAduana(new BigDecimal("117.64"));
        mercancia.setUnidadAduanaId("01");
        mercancia.setValorUnitarioAduana(new BigDecimal("3.40"));
        mercancia.setValorDolares(new BigDecimal("400.00"));
        mercancias.add(mercancia);

        comercioExterior.setMercancias(mercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Factura CE Traslado Con Carta Porte 31.
     */
    private static void facturaCeTrasladoConCartaPorte31(FiscalApiClient client) {
        System.out.println("\n===== 6. Factura CE Traslado Con Carta Porte 31 =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setCurrencyCode("XXX");
        invoice.setTypeCode("T");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(ISSUER_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item1 = new InvoiceItem();
        item1.setItemCode("78101800");
        item1.setItemSku("TR01");
        item1.setQuantity(new BigDecimal("1.0"));
        item1.setUnitOfMeasurementCode("H87");
        item1.setDescription("TRANSPORTE DE CARGA");
        item1.setUnitPrice(new BigDecimal("0.00"));
        item1.setDiscount(new BigDecimal("0"));
        item1.setTaxObjectCode("01");
        items.add(item1);

        InvoiceItem item2 = new InvoiceItem();
        item2.setItemCode("32101622");
        item2.setItemSku("UT421511");
        item2.setQuantity(new BigDecimal("100.00"));
        item2.setUnitOfMeasurementCode("XBX");
        item2.setDescription("MEMORIA FLASH");
        item2.setUnitPrice(new BigDecimal("0.00"));
        item2.setDiscount(new BigDecimal("0"));
        item2.setTaxObjectCode("01");
        items.add(item2);

        invoice.setItems(items);

        Complement complement = new Complement();
        CartaPorte cartaPorte = new CartaPorte();
        cartaPorte.setTranspInternacId("Sí");
        cartaPorte.setEntradaSalidaMercId("Salida");
        cartaPorte.setPaisOrigenDestinoId("ALB");
        cartaPorte.setViaEntradaSalidaId("01");
        cartaPorte.setTotalDistRec(new BigDecimal("120.00"));
        cartaPorte.setUnidadPesoId("KGM");
        List<RegimenAduanero> regimenAduaneros = new ArrayList<RegimenAduanero>();
        RegimenAduanero regimenAduanero = new RegimenAduanero();
        regimenAduanero.setRegimenAduaneroId("EXD");
        regimenAduaneros.add(regimenAduanero);

        cartaPorte.setRegimenAduaneros(regimenAduaneros);

        List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
        Ubicacion ubicacion1 = new Ubicacion();
        ubicacion1.setTipoUbicacion("Origen");
        ubicacion1.setIdUbicacion("OR000001");
        ubicacion1.setRfcRemitenteDestinatario("XAXX010101000");
        ubicacion1.setNombreRemitenteDestinatario("Origen Nacional");
        ubicacion1.setFechaHoraSalidaLlegada(OptUtil.parseLocalDateTime("2026-04-27T08:00:00"));
        UbicacionDomicilio domicilio = new UbicacionDomicilio();
        domicilio.setCalle("xola");
        domicilio.setNumeroExterior("531");
        domicilio.setColoniaId("0496");
        domicilio.setLocalidadId("03");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("CMX");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("03100");
        ubicacion1.setDomicilio(domicilio);

        ubicaciones.add(ubicacion1);

        Ubicacion ubicacion2 = new Ubicacion();
        ubicacion2.setTipoUbicacion("Destino");
        ubicacion2.setIdUbicacion("DE000001");
        ubicacion2.setRfcRemitenteDestinatario("XAXX010101000");
        ubicacion2.setNombreRemitenteDestinatario("Destino Nacional");
        ubicacion2.setFechaHoraSalidaLlegada(OptUtil.parseLocalDateTime("2026-04-27T20:00:00"));
        ubicacion2.setDistanciaRecorrida(new BigDecimal("120.00"));
        UbicacionDomicilio ubicacion2Domicilio = new UbicacionDomicilio();
        ubicacion2Domicilio.setCalle("Av Coyoacan");
        ubicacion2Domicilio.setNumeroExterior("120");
        ubicacion2Domicilio.setColoniaId("2624");
        ubicacion2Domicilio.setLocalidadId("03");
        ubicacion2Domicilio.setMunicipioId("014");
        ubicacion2Domicilio.setEstadoId("CMX");
        ubicacion2Domicilio.setPaisId("MEX");
        ubicacion2Domicilio.setCodigoPostalId("03100");
        ubicacion2.setDomicilio(ubicacion2Domicilio);

        ubicaciones.add(ubicacion2);

        cartaPorte.setUbicaciones(ubicaciones);

        List<Mercancia> mercancias = new ArrayList<Mercancia>();
        Mercancia mercancia1 = new Mercancia();
        mercancia1.setBienesTranspId("50433238");
        mercancia1.setDescripcion("Gomitas");
        mercancia1.setCantidad(new BigDecimal("1"));
        mercancia1.setClaveUnidadId("XPK");
        mercancia1.setPesoEnKg(new BigDecimal("10.000"));
        mercancia1.setValorMercancia(new BigDecimal("1200.00"));
        mercancia1.setMonedaId("USD");
        mercancia1.setFraccionArancelariaId("2005800100");
        mercancia1.setTipoMateriaId("04");
        mercancias.add(mercancia1);

        Mercancia mercancia2 = new Mercancia();
        mercancia2.setBienesTranspId("50433238");
        mercancia2.setDescripcion("Pulparindo");
        mercancia2.setCantidad(new BigDecimal("1"));
        mercancia2.setClaveUnidadId("XPK");
        mercancia2.setPesoEnKg(new BigDecimal("10.000"));
        mercancia2.setValorMercancia(new BigDecimal("1000.00"));
        mercancia2.setMonedaId("USD");
        mercancia2.setFraccionArancelariaId("2005800100");
        mercancia2.setTipoMateriaId("04");
        mercancias.add(mercancia2);

        cartaPorte.setMercancias(mercancias);

        Autotransporte autotransporte = new Autotransporte();
        autotransporte.setPermSCTId("TPAF02");
        autotransporte.setNumPermisoSCT("123456");
        autotransporte.setConfigVehicularId("C2");
        autotransporte.setPesoBrutoVehicular(new BigDecimal("1"));
        autotransporte.setPlacaVM("555TTT");
        autotransporte.setAnioModeloVM(2023);
        autotransporte.setAseguraRespCivil("ODISEA");
        autotransporte.setPolizaRespCivil("3456YUHNB234RT");
        cartaPorte.setAutotransporte(autotransporte);

        List<TipoFigura> tiposFigura = new ArrayList<TipoFigura>();
        TipoFigura tipoFigura = new TipoFigura();
        tipoFigura.setTipoFiguraId("01");
        tipoFigura.setRfcFigura("KAHO641101B39");
        tipoFigura.setNumLicencia("D0908240");
        tipoFigura.setNombreFigura("OSCAR KALA HAAK");
        tiposFigura.add(tipoFigura);

        cartaPorte.setTiposFigura(tiposFigura);

        complement.setCartaPorte(cartaPorte);

        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("FOB");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio emisorDomicilio = new ComercioExteriorEmisorDomicilio();
        emisorDomicilio.setCalle("CALLE DEL PAPEL");
        emisorDomicilio.setColoniaId("0214");
        emisorDomicilio.setLocalidadId("01");
        emisorDomicilio.setMunicipioId("014");
        emisorDomicilio.setEstadoId("QUE");
        emisorDomicilio.setPaisId("MEX");
        emisorDomicilio.setCodigoPostalId("76199");
        emisor.setDomicilio(emisorDomicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("ST. A");
        receptorDomicilio.setEstado("TX");
        receptorDomicilio.setPaisId("USA");
        receptorDomicilio.setCodigoPostal("00000");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorMercancia> comercioExteriorMercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia mercancia = new ComercioExteriorMercancia();
        mercancia.setNoIdentificacion("UT421511");
        mercancia.setFraccionArancelariaId("2402200100");
        mercancia.setCantidadAduana(new BigDecimal("100.00"));
        mercancia.setUnidadAduanaId("01");
        mercancia.setValorUnitarioAduana(new BigDecimal("1.00"));
        mercancia.setValorDolares(new BigDecimal("0.00"));
        comercioExteriorMercancias.add(mercancia);

        comercioExterior.setMercancias(comercioExteriorMercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Factura CE Traslado Traslado Mercancia Propia.
     */
    private static void facturaCeTrasladoTrasladoMercanciaPropia(FiscalApiClient client) {
        System.out.println("\n===== 7. Factura CE Traslado Traslado Mercancia Propia =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setCurrencyCode("USD");
        invoice.setTypeCode("T");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(ISSUER_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item = new InvoiceItem();
        item.setItemCode("50211503");
        item.setItemSku("131494-1055");
        item.setQuantity(new BigDecimal("1.0"));
        item.setUnitOfMeasurementCode("H87");
        item.setDescription("Descripción");
        item.setUnitPrice(new BigDecimal("0.00"));
        item.setDiscount(new BigDecimal("0"));
        item.setTaxObjectCode("01");
        items.add(item);

        invoice.setItems(items);

        Complement complement = new Complement();
        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setMotivoTrasladoId("02");
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("FCA");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio domicilio = new ComercioExteriorEmisorDomicilio();
        domicilio.setCalle("CALLE DEL PAPEL");
        domicilio.setColoniaId("0214");
        domicilio.setLocalidadId("01");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("QUE");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("76199");
        emisor.setDomicilio(domicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("SW Street.");
        receptorDomicilio.setNumeroExterior("12345");
        receptorDomicilio.setLocalidad("Oregon");
        receptorDomicilio.setEstado("OR");
        receptorDomicilio.setPaisId("USA");
        receptorDomicilio.setCodigoPostal("12345");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorDestinatario> destinatarios = new ArrayList<ComercioExteriorDestinatario>();
        ComercioExteriorDestinatario destinatario = new ComercioExteriorDestinatario();
        destinatario.setNumRegIdTrib("123456789");
        destinatario.setNombre("EKU9003173C9");
        List<ComercioExteriorDestinatarioDomicilio> domicilios = new ArrayList<ComercioExteriorDestinatarioDomicilio>();
        ComercioExteriorDestinatarioDomicilio domiciliosDomicilio = new ComercioExteriorDestinatarioDomicilio();
        domiciliosDomicilio.setCalle("SW Street.");
        domiciliosDomicilio.setNumeroExterior("12345");
        domiciliosDomicilio.setLocalidad("Oregon");
        domiciliosDomicilio.setEstado("OR");
        domiciliosDomicilio.setPaisId("USA");
        domiciliosDomicilio.setCodigoPostal("12345");
        domicilios.add(domiciliosDomicilio);

        destinatario.setDomicilios(domicilios);

        destinatarios.add(destinatario);

        comercioExterior.setDestinatarios(destinatarios);

        List<ComercioExteriorMercancia> mercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia mercancia = new ComercioExteriorMercancia();
        mercancia.setNoIdentificacion("131494-1055");
        mercancia.setFraccionArancelariaId("0101210100");
        mercancia.setCantidadAduana(new BigDecimal("1"));
        mercancia.setUnidadAduanaId("07");
        mercancia.setValorUnitarioAduana(new BigDecimal("22.64"));
        mercancia.setValorDolares(new BigDecimal("22.64"));
        mercancias.add(mercancia);

        comercioExterior.setMercancias(mercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Factura CE Traslado Traslado.
     */
    private static void facturaCeTrasladoTraslado(FiscalApiClient client) {
        System.out.println("\n===== 8. Factura CE Traslado Traslado =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setCurrencyCode("USD");
        invoice.setTypeCode("T");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(ISSUER_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item = new InvoiceItem();
        item.setItemCode("50211503");
        item.setItemSku("131494-1055");
        item.setQuantity(new BigDecimal("2"));
        item.setUnitOfMeasurementCode("H87");
        item.setDescription("Cigarros");
        item.setUnitPrice(new BigDecimal("200.00"));
        item.setDiscount(new BigDecimal("0"));
        item.setTaxObjectCode("01");
        items.add(item);

        invoice.setItems(items);

        Complement complement = new Complement();
        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("FOB");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio domicilio = new ComercioExteriorEmisorDomicilio();
        domicilio.setCalle("CALLE DEL PAPEL");
        domicilio.setColoniaId("0214");
        domicilio.setLocalidadId("01");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("QUE");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("76199");
        emisor.setDomicilio(domicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("ST. A");
        receptorDomicilio.setEstado("TX");
        receptorDomicilio.setPaisId("USA");
        receptorDomicilio.setCodigoPostal("00000");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorMercancia> mercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia mercancia = new ComercioExteriorMercancia();
        mercancia.setNoIdentificacion("131494-1055");
        mercancia.setFraccionArancelariaId("2402200100");
        mercancia.setCantidadAduana(new BigDecimal("117.64"));
        mercancia.setUnidadAduanaId("01");
        mercancia.setValorUnitarioAduana(new BigDecimal("3.40"));
        mercancia.setValorDolares(new BigDecimal("400.00"));
        mercancias.add(mercancia);

        comercioExterior.setMercancias(mercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Factura CE Unidades De Medida No Equivalentes.
     */
    private static void facturaCeUnidadesDeMedidaNoEquivalentes(FiscalApiClient client) {
        System.out.println("\n===== 9. Factura CE Unidades De Medida No Equivalentes =====");

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setPaymentFormCode("99");
        invoice.setPaymentMethodCode("PPD");
        invoice.setCurrencyCode("USD");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("42501");
        invoice.setSeries("Serie");
        invoice.setDate(FECHA);
        invoice.setPaymentConditions("CondicionesDePago");
        invoice.setExportCode("02");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);
        invoice.setIssuer(issuer);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setId(RECIPIENT_EXTRANJERO_ID);
        invoice.setRecipient(recipient);

        List<InvoiceItem> items = new ArrayList<InvoiceItem>();
        InvoiceItem item = new InvoiceItem();
        item.setItemCode("50201708");
        item.setItemSku("131494-1055");
        item.setQuantity(new BigDecimal("1.000"));
        item.setUnitOfMeasurementCode("H87");
        item.setDescription("Bebida");
        item.setUnitPrice(new BigDecimal("100.00"));
        item.setDiscount(new BigDecimal("0"));
        item.setTaxObjectCode("02");
        List<ItemTax> itemTaxes = new ArrayList<ItemTax>();
        ItemTax itemTax1 = new ItemTax();
        itemTax1.setTaxCode("002");
        itemTax1.setTaxTypeCode("Tasa");
        itemTax1.setTaxRate(new BigDecimal("0.160000"));
        itemTax1.setTaxFlagCode("T");
        itemTaxes.add(itemTax1);

        ItemTax itemTax2 = new ItemTax();
        itemTax2.setTaxCode("001");
        itemTax2.setTaxTypeCode("Tasa");
        itemTax2.setTaxRate(new BigDecimal("0.100000"));
        itemTax2.setTaxFlagCode("R");
        itemTaxes.add(itemTax2);

        ItemTax itemTax3 = new ItemTax();
        itemTax3.setTaxCode("002");
        itemTax3.setTaxTypeCode("Tasa");
        itemTax3.setTaxRate(new BigDecimal("0.106666"));
        itemTax3.setTaxFlagCode("R");
        itemTaxes.add(itemTax3);

        item.setItemTaxes(itemTaxes);

        items.add(item);

        invoice.setItems(items);

        Complement complement = new Complement();
        ComercioExterior comercioExterior = new ComercioExterior();
        comercioExterior.setClaveDePedimentoId("A1");
        comercioExterior.setCertificadoOrigen(0);
        comercioExterior.setIncotermId("FOB");
        comercioExterior.setTipoCambioUSD(TIPO_CAMBIO_USD);
        ComercioExteriorEmisor emisor = new ComercioExteriorEmisor();
        ComercioExteriorEmisorDomicilio domicilio = new ComercioExteriorEmisorDomicilio();
        domicilio.setCalle("CALLE DEL PAPEL");
        domicilio.setColoniaId("0214");
        domicilio.setLocalidadId("01");
        domicilio.setMunicipioId("014");
        domicilio.setEstadoId("QUE");
        domicilio.setPaisId("MEX");
        domicilio.setCodigoPostalId("76199");
        emisor.setDomicilio(domicilio);

        comercioExterior.setEmisor(emisor);

        ComercioExteriorReceptor receptor = new ComercioExteriorReceptor();
        receptor.setNumRegIdTrib("123456789");
        ComercioExteriorReceptorDomicilio receptorDomicilio = new ComercioExteriorReceptorDomicilio();
        receptorDomicilio.setCalle("ST. A");
        receptorDomicilio.setEstado("TX");
        receptorDomicilio.setPaisId("USA");
        receptorDomicilio.setCodigoPostal("00000");
        receptor.setDomicilio(receptorDomicilio);

        comercioExterior.setReceptor(receptor);

        List<ComercioExteriorMercancia> mercancias = new ArrayList<ComercioExteriorMercancia>();
        ComercioExteriorMercancia mercancia = new ComercioExteriorMercancia();
        mercancia.setNoIdentificacion("131494-1055");
        mercancia.setFraccionArancelariaId("2009310201");
        mercancia.setCantidadAduana(new BigDecimal("0.500"));
        mercancia.setUnidadAduanaId("08");
        mercancia.setValorUnitarioAduana(new BigDecimal("200.00"));
        mercancia.setValorDolares(new BigDecimal("100.00"));
        mercancias.add(mercancia);

        comercioExterior.setMercancias(mercancias);

        complement.setComercioExterior(comercioExterior);

        invoice.setComplement(complement);

        imprimirResultado(client.getInvoiceService().create(invoice));
    }

    /**
     * Imprime el folio de la factura timbrada o el motivo del rechazo.
     */
    private static void imprimirResultado(ApiResponse<Invoice> apiResponse) {
        if (!apiResponse.isSucceeded()) {
            System.out.println("Error: " + apiResponse.getMessage());
            System.out.println("Detalle: " + apiResponse.getDetails());
            return;
        }

        System.out.println("Folio: " + apiResponse.getData().getNumber());
        System.out.println("UUID:  " + apiResponse.getData().getUuid());
    }
}
