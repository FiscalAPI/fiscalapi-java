package com.fiscalapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.tickets.Ticket;
import com.fiscalapi.models.tickets.TicketActorType;
import com.fiscalapi.models.tickets.TicketCodeResult;
import com.fiscalapi.models.tickets.TicketEvent;
import com.fiscalapi.models.tickets.TicketEventType;
import com.fiscalapi.models.tickets.TicketIngestionResult;
import com.fiscalapi.models.tickets.TicketIssuer;
import com.fiscalapi.models.tickets.TicketItem;
import com.fiscalapi.models.tickets.TicketItemTax;
import com.fiscalapi.models.tickets.TicketListFilters;
import com.fiscalapi.models.tickets.TicketStatus;
import com.fiscalapi.services.FiscalApiClient;
import com.fiscalapi.services.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Servicio de tickets de Auto CFDI (POST/GET/DELETE /api/v4/tickets). Los mismos escenarios viven en los SDK de .NET,
 * Node.js, Python y PHP: el cuerpo exacto de la ingesta y el header Idempotency-Key solo si se pasa; la respuesta 201 de
 * la ingesta; el 409 y el 422 con la forma de error del SDK (details con el texto de la API); la query de la
 * lista con status repetido; el detalle con y sin details; el código; la cancelación con DELETE, y un estado que el SDK
 * no conoce, conservado en el getter *Value con el getter del enum en null.
 */
class TicketServiceTest {

    private static final String TICKETS_URL = FakeApi.BASE_URL + "/api/v4/tickets";
    private static final String ISSUER_ID = "4b1c2d3e-0000-4000-8000-000000000002";
    private static final String GLOBAL_INVOICE_ID = "7c1d2e3f-0000-4000-8000-0000000000b2";
    private static final String TICKET_ID = "9f8e7d6c-0000-4000-8000-0000000000a1";
    private static final String IDEMPOTENCY_KEY = "550e8400-e29b-41d4-a716-446655440000";

    private static final String INGESTED = "{'id':'" + TICKET_ID + "','ticketCode':'K7M2Q9X4TB3H',"
            + "'qrUrl':'https://portal.fiscalapi.com/t/K7M2Q9X4TB3H','status':'pending','selfInvoiceEligible':true,"
            + "'eligibleUntil':'2026-10-31T23:59:59.000','subtotal':100,'totalTransferredTaxes':16,'totalWithheldTaxes':0,"
            + "'total':116}";

    private static final String SUMMARY_FIELDS = "'id':'" + TICKET_ID + "','personId':'" + ISSUER_ID + "','folio':'F-1001',"
            + "'series':'A','paymentDate':'2026-09-01T00:00:00.000','paymentFormCode':'01','currencyCode':'MXN',"
            + "'exchangeRate':null,'expeditionZipCode':'06000','subtotal':100,'totalTransferredTaxes':16,"
            + "'totalWithheldTaxes':0,'total':116,'selfInvoiceEligible':true,'eligibleUntil':'2026-09-30T23:59:59.000',"
            + "'invoiceId':null,'globalInvoiceId':null,'createdAt':'2026-09-01T00:05:00.000'";

    private static final String DETAIL = "{" + SUMMARY_FIELDS + ",'status':'cancelled','items':[{'itemCode':'50202306',"
            + "'itemSku':'SKU-1','quantity':1,'unitOfMeasurementCode':'H87','description':'Refresco','unitPrice':100,"
            + "'discount':0,'taxObjectCode':'02','itemTaxes':[{'taxCode':'002','taxTypeCode':'Tasa','taxRate':0.16,"
            + "'taxFlagCode':'T'}]}],'events':[{'type':'ingested','occurredAt':'2026-09-01T00:05:00.000',"
            + "'actorType':'tenant','invoiceId':null},{'type':'cancelled','occurredAt':'2026-09-01T01:00:00.000',"
            + "'actorType':'tenant','invoiceId':null}]}";

    // El cuerpo exacto que recibe la API: nombres camelCase, importes como texto con su escala y sin los miembros null.
    private static final String EXPECTED_CREATE_BODY = "{'issuer':{'id':'" + ISSUER_ID + "'},'folio':'F-1001','series':'A',"
            + "'paymentDate':'2026-10-15T12:30:00','paymentFormCode':'01','currencyCode':'MXN','expeditionZipCode':'06000',"
            + "'total':'116.00','items':[{'itemCode':'50202306','itemSku':'SKU-1','quantity':'1.5',"
            + "'unitOfMeasurementCode':'H87','description':'Refresco','unitPrice':'66.666667','discount':'0.00',"
            + "'taxObjectCode':'02','itemTaxes':[{'taxCode':'002','taxTypeCode':'Tasa','taxRate':'0.160000',"
            + "'taxFlagCode':'T'}]}]}";

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private FakeApi api;
    private TicketService tickets;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
        tickets = new TicketService(api.httpClient(), api.settings());
    }

    private static String json(String singleQuoted) {
        return singleQuoted.replace('\'', '"');
    }

    private static String ok(String data, int httpStatusCode) {
        return json("{'data':" + data + ",'succeeded':true,'message':'','details':'','httpStatusCode':" + httpStatusCode + "}");
    }

    private static JsonNode tree(String json) throws IOException {
        return MAPPER.readTree(json);
    }

    private static Ticket newTicket() {
        TicketItemTax tax = new TicketItemTax();
        tax.setTaxCode("002");
        tax.setTaxTypeCode("Tasa");
        tax.setTaxRate(new BigDecimal("0.160000"));
        tax.setTaxFlagCode("T");

        TicketItem item = new TicketItem();
        item.setItemCode("50202306");
        item.setItemSku("SKU-1");
        item.setQuantity(new BigDecimal("1.5"));
        item.setUnitOfMeasurementCode("H87");
        item.setDescription("Refresco");
        item.setUnitPrice(new BigDecimal("66.666667"));
        item.setDiscount(new BigDecimal("0.00"));
        item.setTaxObjectCode("02");
        item.setItemTaxes(Collections.singletonList(tax));

        Ticket ticket = new Ticket();
        ticket.setIssuer(new TicketIssuer(ISSUER_ID));
        ticket.setFolio("F-1001");
        ticket.setSeries("A");
        ticket.setPaymentDate(LocalDateTime.of(2026, 10, 15, 12, 30, 0));
        ticket.setPaymentFormCode("01");
        ticket.setCurrencyCode("MXN");
        ticket.setExpeditionZipCode("06000");
        ticket.setTotal(new BigDecimal("116.00"));
        ticket.setItems(Collections.singletonList(item));
        return ticket;
    }

    private FakeApi.RecordedRequest singleRequest() {
        assertEquals(1, api.requests().size());
        return api.requests().get(0);
    }

    @Test
    void theClientExposesTheTicketService() {
        FiscalApiClient client = FiscalApiClient.create(api.settings());

        assertTrue(client.getTicketService() instanceof TicketService);
    }

    // a. Cuerpo e Idempotency-Key

    @Test
    void createPostsTheExactContractWithTheIdempotencyKeyHeader() throws IOException {
        api.respondWith(ok(INGESTED, 201), 201);

        tickets.create(newTicket(), IDEMPOTENCY_KEY);

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("POST", request.method);
        assertEquals(TICKETS_URL, request.url);
        assertEquals(tree(json(EXPECTED_CREATE_BODY)), tree(request.body));
        assertEquals(IDEMPOTENCY_KEY, request.headers.get("Idempotency-Key"));
    }

    @Test
    void createWithoutAKeyDoesNotSendTheIdempotencyKeyHeader() throws IOException {
        api.respondWith(ok(INGESTED, 201), 201);

        tickets.create(newTicket());

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals(tree(json(EXPECTED_CREATE_BODY)), tree(request.body));
        assertNull(request.headers.get("Idempotency-Key"));
    }

    // b. Respuesta de la ingesta: la repetición con la misma llave de idempotencia devuelve esta misma 201

    @Test
    void createReadsTheNewTicketWithItsShape() {
        api.respondWith(ok(INGESTED, 201), 201);

        ApiResponse<TicketIngestionResult> response = tickets.create(newTicket(), IDEMPOTENCY_KEY);

        assertTrue(response.isSucceeded());
        assertEquals(201, response.getHttpStatusCode());
        assertNull(response.getErrorData());
        TicketIngestionResult ingested = response.getData();
        assertEquals(TICKET_ID, ingested.getId());
        assertEquals("K7M2Q9X4TB3H", ingested.getTicketCode());
        assertEquals("https://portal.fiscalapi.com/t/K7M2Q9X4TB3H", ingested.getQrUrl());
        assertEquals(TicketStatus.PENDING, ingested.getStatus());
        assertTrue(ingested.isSelfInvoiceEligible());
        assertEquals(LocalDateTime.of(2026, 10, 31, 23, 59, 59), ingested.getEligibleUntil());
        assertEquals(0, new BigDecimal("100").compareTo(ingested.getSubtotal()));
        assertEquals(0, new BigDecimal("16").compareTo(ingested.getTotalTransferredTaxes()));
        assertEquals(0, BigDecimal.ZERO.compareTo(ingested.getTotalWithheldTaxes()));
        assertEquals(0, new BigDecimal("116").compareTo(ingested.getTotal()));
    }

    @Test
    void aDuplicateFolioIs409WithTheApiDetailsAndExistingTicketIdInErrorData() {
        api.respondWith("{\"data\":{\"existingTicketId\":\"" + TICKET_ID + "\"},\"succeeded\":false,"
                + "\"message\":\"Sorry, it's not me, it's you.\","
                + "\"details\":\"Ya hay un ticket activo con esa serie y folio para el emisor: 'data.existingTicketId' es el"
                + " ticket que lo tiene. Para volver a ingerirlo, cancela ese ticket primero.\",\"httpStatusCode\":409}", 409);

        ApiResponse<TicketIngestionResult> response = tickets.create(newTicket());

        assertFalse(response.isSucceeded());
        assertEquals(409, response.getHttpStatusCode());
        assertEquals("Sorry, it's not me, it's you.", response.getMessage());
        assertTrue(response.getDetails().startsWith("Ya hay un ticket activo con esa serie y folio para el emisor"));
        assertEquals(TICKET_ID, response.getErrorData().get("existingTicketId").asText());
    }

    @Test
    void aTotalMismatchIs422WithTheApiDetailsAndTheTotalsInErrorData() {
        api.respondWith("{\"data\":{\"expectedTotal\":116.01,\"computedTotal\":116},\"succeeded\":false,"
                + "\"message\":\"Sorry, it's not me, it's you.\","
                + "\"details\":\"'total' no cuadra al centavo con el total calculado de los conceptos e impuestos:"
                + " 'data.expectedTotal' es el enviado y 'data.computedTotal' el calculado.\",\"httpStatusCode\":422}", 422);

        ApiResponse<TicketIngestionResult> response = tickets.create(newTicket());

        assertFalse(response.isSucceeded());
        assertEquals(422, response.getHttpStatusCode());
        assertTrue(response.getDetails().startsWith("'total' no cuadra al centavo"));
        assertEquals(0, new BigDecimal("116.01").compareTo(response.getErrorData().get("expectedTotal").decimalValue()));
        assertEquals(0, new BigDecimal("116").compareTo(response.getErrorData().get("computedTotal").decimalValue()));
    }

    @Test
    void anErrorWithoutDataLeavesErrorDataNull() {
        api.respondWith("{\"data\":null,\"succeeded\":false,\"message\":\"Sorry, it's not me, it's you.\","
                + "\"details\":\"No existe el ticket.\",\"httpStatusCode\":404}", 404);

        ApiResponse<Ticket> response = tickets.getById(TICKET_ID, false);

        assertFalse(response.isSucceeded());
        assertEquals(404, response.getHttpStatusCode());
        assertNull(response.getErrorData());
    }

    // c. Lista con filtros

    @Test
    void getListSendsEveryFilterRepeatingStatus() {
        api.respondWith(ok("{'items':[{" + SUMMARY_FIELDS + ",'status':'pending'}],'pageNumber':2,'totalPages':3,"
                + "'totalCount':21,'hasPreviousPage':true,'hasNextPage':true}", 200));
        TicketListFilters filters = new TicketListFilters();
        filters.setStatus(Arrays.asList(TicketStatus.PENDING, TicketStatus.INVOICED));
        filters.setPersonId(ISSUER_ID);
        filters.setFrom(LocalDate.of(2026, 9, 1));
        filters.setTo(LocalDate.of(2026, 9, 30));
        filters.setPageNumber(2);
        filters.setPageSize(50);

        ApiResponse<PagedList<Ticket>> response = tickets.getList(filters);

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("GET", request.method);
        assertEquals(TICKETS_URL + "?status=pending&status=invoiced&personId=" + ISSUER_ID
                + "&from=2026-09-01&to=2026-09-30&pageNumber=2&pageSize=50", request.url);
        PagedList<Ticket> page = response.getData();
        assertEquals(2, page.getPageNumber());
        assertEquals(21, page.getTotalCount());
        Ticket ticket = page.getItems().get(0);
        assertEquals(ISSUER_ID, ticket.getPersonId());
        assertEquals(LocalDateTime.of(2026, 9, 1, 0, 0), ticket.getPaymentDate());
        assertEquals(TicketStatus.PENDING, ticket.getStatus());
        assertNull(ticket.getItems());
        assertNull(ticket.getEvents());
    }

    @Test
    void getListSendsDetailsAndGlobalInvoiceIdWhenAssigned() {
        api.respondWith(ok("{'items':[],'pageNumber':1,'totalPages':0,'totalCount':0,'hasPreviousPage':false,"
                + "'hasNextPage':false}", 200));
        TicketListFilters filters = new TicketListFilters();
        filters.setDetails(true);
        filters.setGlobalInvoiceId(GLOBAL_INVOICE_ID);

        tickets.getList(filters);

        assertEquals(TICKETS_URL + "?details=true&globalInvoiceId=" + GLOBAL_INVOICE_ID, singleRequest().url);
    }

    @Test
    void getListDoesNotSendDetailsWhenFalse() {
        api.respondWith(ok("{'items':[],'pageNumber':1,'totalPages':0,'totalCount':0,'hasPreviousPage':false,"
                + "'hasNextPage':false}", 200));
        TicketListFilters filters = new TicketListFilters();
        filters.setDetails(false);

        tickets.getList(filters);

        assertEquals(TICKETS_URL, singleRequest().url);
    }

    @Test
    void getListWithoutFiltersSendsNoQuery() {
        api.respondWith(ok("{'items':[],'pageNumber':1,'totalPages':0,'totalCount':0,'hasPreviousPage':false,"
                + "'hasNextPage':false}", 200));

        tickets.getList(new TicketListFilters());

        assertEquals(TICKETS_URL, singleRequest().url);
    }

    // d. Detalle

    @Test
    void getByIdWithoutDetailsAsksWithoutDetails() {
        api.respondWith(ok("{" + SUMMARY_FIELDS + ",'status':'pending'}", 200));

        ApiResponse<Ticket> response = tickets.getById(TICKET_ID, false);

        assertEquals(TICKETS_URL + "/" + TICKET_ID + "?details=false", singleRequest().url);
        assertEquals(TICKET_ID, response.getData().getId());
        assertNull(response.getData().getItems());
    }

    @Test
    void getByIdWithDetailsReadsItemsAndEvents() {
        api.respondWith(ok(DETAIL, 200));

        Ticket ticket = tickets.getById(TICKET_ID, true).getData();

        assertEquals(TICKETS_URL + "/" + TICKET_ID + "?details=true", singleRequest().url);
        assertEquals(TicketStatus.CANCELLED, ticket.getStatus());
        TicketItem item = ticket.getItems().get(0);
        assertEquals("50202306", item.getItemCode());
        assertEquals(0, new BigDecimal("100").compareTo(item.getUnitPrice()));
        assertEquals(0, new BigDecimal("0.16").compareTo(item.getItemTaxes().get(0).getTaxRate()));
        TicketEvent cancelled = ticket.getEvents().get(1);
        assertEquals(TicketEventType.INGESTED, ticket.getEvents().get(0).getType());
        assertEquals(TicketEventType.CANCELLED, cancelled.getType());
        assertEquals(TicketActorType.TENANT, cancelled.getActorType());
        assertEquals(LocalDateTime.of(2026, 9, 1, 1, 0), cancelled.getOccurredAt());
    }

    // e. Código

    @Test
    void getCodeReadsTheCodeAndTheQrUrl() {
        api.respondWith(ok("{'ticketCode':'K7M2Q9X4TB3H','qrUrl':'https://portal.fiscalapi.com/t/K7M2Q9X4TB3H'}", 200));

        TicketCodeResult code = tickets.getCode(TICKET_ID).getData();

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("GET", request.method);
        assertEquals(TICKETS_URL + "/" + TICKET_ID + "/code", request.url);
        assertEquals("K7M2Q9X4TB3H", code.getTicketCode());
        assertEquals("https://portal.fiscalapi.com/t/K7M2Q9X4TB3H", code.getQrUrl());
    }

    // f. Cancelación

    @Test
    void cancelUsesDelete() {
        api.respondWith(ok("true", 200));

        ApiResponse<Boolean> response = tickets.cancel(TICKET_ID);

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("DELETE", request.method);
        assertEquals(TICKETS_URL + "/" + TICKET_ID, request.url);
        assertTrue(response.getData());
    }

    // g. Valores que el SDK no conoce

    @Test
    void aStatusEventTypeAndActorTypeThatTheSdkDoesNotKnowKeepTheirText() {
        api.respondWith(ok("{" + SUMMARY_FIELDS + ",'status':'unknownState','items':[],'events':[{'type':'unknownEvent',"
                + "'occurredAt':'2026-09-01T00:05:00.000','actorType':'unknownActor','invoiceId':null}]}", 200));

        ApiResponse<Ticket> response = tickets.getById(TICKET_ID, true);

        assertTrue(response.isSucceeded());
        Ticket ticket = response.getData();
        assertNull(ticket.getStatus());
        assertEquals("unknownState", ticket.getStatusValue());
        TicketEvent event = ticket.getEvents().get(0);
        assertNull(event.getType());
        assertEquals("unknownEvent", event.getTypeValue());
        assertNull(event.getActorType());
        assertEquals("unknownActor", event.getActorTypeValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void everyCallByIdRejectsAMissingIdWithoutCallingTheApi(String id) {
        assertThrows(IllegalArgumentException.class, () -> tickets.getById(id, false));
        assertThrows(IllegalArgumentException.class, () -> tickets.getCode(id));
        assertThrows(IllegalArgumentException.class, () -> tickets.cancel(id));
        assertTrue(api.requests().isEmpty());
    }
}
