package com.fiscalapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.GlobalInformation;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.models.invoicing.InvoiceIssuer;
import com.fiscalapi.models.invoicing.InvoiceItem;
import com.fiscalapi.models.invoicing.InvoiceRecipient;
import com.fiscalapi.models.invoicing.ItemTax;
import com.fiscalapi.services.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * InvoiceItem.ticketId (Auto CFDI): liga cada concepto de la factura global a su ticket. Los mismos escenarios viven en
 * los SDK de .NET, Node.js, Python y PHP: sin ticketId el cuerpo de create es exactamente el de la version anterior; con
 * el, cada concepto lleva "ticketId" (un ticket puede ir en varios conceptos); un ticketId null nunca viaja, ni siquiera
 * con un ObjectMapper que incluye los null, y el 409 de tickets no disponibles expone data.unavailableTickets en
 * getErrorData().
 */
class InvoiceItemTicketIdTest {

    private static final String ISSUER_ID = "4b1c2d3e-0000-4000-8000-000000000002";
    private static final String TICKET_ID = "9f8e7d6c-0000-4000-8000-0000000000a1";
    private static final String OTHER_TICKET_ID = "9f8e7d6c-0000-4000-8000-0000000000a2";

    // Cuerpo que enviaba la version anterior del SDK (sin ticketId en InvoiceItem) para la misma global.
    private static final String PREVIOUS_PAYLOAD = json("{'versionCode':'4.0','series':'G','number':'1001',"
            + "'paymentFormCode':'01','currencyCode':'MXN','typeCode':'I','expeditionZipCode':'06000','exportCode':'01',"
            + "'paymentMethodCode':'PUE','issuer':{'id':'" + ISSUER_ID + "'},'recipient':{'tin':'XAXX010101000',"
            + "'legalName':'PUBLICO EN GENERAL','taxRegimeCode':'616','cfdiUseCode':'S01','zipCode':'06000'},"
            + "'items':[{'itemCode':'01010101','quantity':'1','unitOfMeasurementCode':'ACT','description':'Venta',"
            + "'unitPrice':'100.00','taxObjectCode':'02','itemSku':'F-1001','itemTaxes':[{'taxCode':'002',"
            + "'taxTypeCode':'Tasa','taxRate':'0.160000','taxFlagCode':'T'}]},{'itemCode':'01010101','quantity':'1',"
            + "'unitOfMeasurementCode':'ACT','description':'Venta','unitPrice':'50.00','taxObjectCode':'02',"
            + "'itemSku':'F-1001','itemTaxes':[{'taxCode':'002','taxTypeCode':'Tasa','taxRate':'0.000000',"
            + "'taxFlagCode':'T'}]}],'globalInformation':{'periodicityCode':'04','monthCode':'09','year':2026},"
            + "'date':'2026-10-01T10:00:00'}");

    private static final String UNAVAILABLE_TICKETS_DETAILS = "Uno o más tickets ya no están disponibles para la factura"
            + " global (solo entra un ticket en estado pending): 'data.unavailableTickets' dice cuáles y su estado. No se"
            + " cobró el timbre ni quedó tomado ningún ticket.";

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private FakeApi api;
    private InvoiceService invoices;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
        api.respondWith(json("{'data':{'id':'9c1d2e3f-0000-4000-8000-0000000000a1'},'succeeded':true,'message':'',"
                + "'details':'','httpStatusCode':200}"));
        invoices = new InvoiceService(api.httpClient(), api.settings());
    }

    private static String json(String singleQuoted) {
        return singleQuoted.replace('\'', '"');
    }

    // Un concepto por grupo de impuestos del mismo ticket (IVA 16 % y 0 %).
    private static InvoiceItem concept(String unitPrice, String taxRate, String ticketId) {
        ItemTax tax = new ItemTax();
        tax.setTaxCode("002");
        tax.setTaxTypeCode("Tasa");
        tax.setTaxRate(new BigDecimal(taxRate));
        tax.setTaxFlagCode("T");

        InvoiceItem item = new InvoiceItem();
        item.setItemCode("01010101");
        item.setItemSku("F-1001");
        item.setQuantity(new BigDecimal("1"));
        item.setUnitOfMeasurementCode("ACT");
        item.setDescription("Venta");
        item.setUnitPrice(new BigDecimal(unitPrice));
        item.setTaxObjectCode("02");
        item.setItemTaxes(Collections.singletonList(tax));
        item.setTicketId(ticketId);
        return item;
    }

    private static Invoice globalInvoice(InvoiceItem... items) {
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId(ISSUER_ID);

        InvoiceRecipient recipient = new InvoiceRecipient();
        recipient.setTin("XAXX010101000");
        recipient.setLegalName("PUBLICO EN GENERAL");
        recipient.setZipCode("06000");
        recipient.setTaxRegimeCode("616");
        recipient.setCfdiUseCode("S01");

        GlobalInformation globalInformation = new GlobalInformation();
        globalInformation.setPeriodicityCode("04");
        globalInformation.setMonthCode("09");
        globalInformation.setYear(2026);

        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("G");
        invoice.setNumber("1001");
        invoice.setDate(LocalDateTime.of(2026, 10, 1, 10, 0, 0));
        invoice.setPaymentFormCode("01");
        invoice.setPaymentMethodCode("PUE");
        invoice.setCurrencyCode("MXN");
        invoice.setTypeCode("I");
        invoice.setExpeditionZipCode("06000");
        invoice.setExportCode("01");
        invoice.setIssuer(issuer);
        invoice.setRecipient(recipient);
        invoice.setGlobalInformation(globalInformation);
        invoice.setItems(Arrays.asList(items));
        return invoice;
    }

    private String sentBody() {
        assertEquals(1, api.requests().size());
        FakeApi.RecordedRequest request = api.requests().get(0);
        assertEquals("POST", request.method);
        assertEquals(FakeApi.BASE_URL + "/api/v4/invoices", request.url);
        return request.body;
    }

    @Test
    void withoutTicketIdCreateSendsExactlyThePreviousPayload() {
        invoices.create(globalInvoice(concept("100.00", "0.160000", null), concept("50.00", "0.000000", null)));

        assertEquals(PREVIOUS_PAYLOAD, sentBody());
    }

    @Test
    void withTicketIdEachItemCarriesItAndNothingElseChanges() throws IOException {
        invoices.create(globalInvoice(concept("100.00", "0.160000", TICKET_ID), concept("50.00", "0.000000", TICKET_ID)));

        ObjectNode expected = (ObjectNode) MAPPER.readTree(PREVIOUS_PAYLOAD);
        for (JsonNode item : expected.get("items")) {
            ((ObjectNode) item).put("ticketId", TICKET_ID);
        }
        assertEquals(expected, MAPPER.readTree(sentBody()));
    }

    @Test
    void onlyTheItemsWithTicketIdCarryIt() throws IOException {
        invoices.create(globalInvoice(concept("100.00", "0.160000", null), concept("50.00", "0.000000", OTHER_TICKET_ID)));

        ArrayNode items = (ArrayNode) MAPPER.readTree(sentBody()).get("items");
        assertFalse(items.get(0).has("ticketId"));
        assertEquals(OTHER_TICKET_ID, items.get(1).get("ticketId").asText());
    }

    @Test
    void aNullTicketIdIsOmittedEvenByAnObjectMapperThatIncludesNulls() throws IOException {
        // ObjectMapper por omision: incluye los null (el del SDK los excluye de forma global).
        JsonNode item = MAPPER.readTree(MAPPER.writeValueAsString(concept("100.00", "0.160000", null)));

        assertFalse(item.has("ticketId"));
        assertTrue(item.has("unitOfMeasurement")); // los demas null si viajan con ese ObjectMapper
    }

    @Test
    void theTicketIdIsReadFromJson() throws IOException {
        InvoiceItem item = MAPPER.readValue(json("{'ticketId':'" + TICKET_ID + "'}"), InvoiceItem.class);

        assertEquals(TICKET_ID, item.getTicketId());
    }

    @Test
    void unavailableTicketsIs409WithTheApiDetailsAndTheTicketsInErrorData() throws IOException {
        String unavailable = json("[{'ticketId':'" + TICKET_ID + "','status':'invoiced'},"
                + "{'ticketId':'" + OTHER_TICKET_ID + "','status':'globalizing'}]");
        api.respondWith("{\"data\":{\"unavailableTickets\":" + unavailable + "},\"succeeded\":false,"
                + "\"message\":\"Sorry, it's not me, it's you.\",\"details\":\"" + UNAVAILABLE_TICKETS_DETAILS + "\","
                + "\"httpStatusCode\":409}", 409);

        ApiResponse<Invoice> response = invoices.create(
                globalInvoice(concept("100.00", "0.160000", TICKET_ID), concept("50.00", "0.000000", OTHER_TICKET_ID)));

        assertFalse(response.isSucceeded());
        assertEquals(409, response.getHttpStatusCode());
        assertEquals(UNAVAILABLE_TICKETS_DETAILS, response.getDetails());
        assertEquals(MAPPER.readTree(unavailable), response.getErrorData().get("unavailableTickets"));
    }
}
