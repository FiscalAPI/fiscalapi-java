package com.fiscalapi;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.StampTransactionParams;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.services.InvoiceService;
import com.fiscalapi.services.StampService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Llave de idempotencia en la creación de facturas y en la transferencia de timbres: con una llave de idempotencia, la petición lleva el
 * header Idempotency-Key con ese valor; sin llave de idempotencia (la sobrecarga original), no lo lleva, y el cuerpo es el mismo en los
 * dos casos.
 */
class IdempotencyKeyHeaderTest {

    private static final String INVOICES_URL = FakeApi.BASE_URL + "/api/v4/invoices";
    private static final String STAMPS_URL = FakeApi.BASE_URL + "/api/v4/stamps";
    private static final String IDEMPOTENCY_KEY = "pos-01-F-1001";
    private static final String HEADER = "Idempotency-Key";

    private FakeApi api;
    private InvoiceService invoices;
    private StampService stamps;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
        invoices = new InvoiceService(api.httpClient(), api.settings());
        stamps = new StampService(api.httpClient(), api.settings());
    }

    private static Invoice newInvoice() {
        Invoice invoice = new Invoice();
        invoice.setVersionCode("4.0");
        invoice.setSeries("F");
        invoice.setPaymentFormCode("01");
        invoice.setCurrencyCode("MXN");
        invoice.setTypeCode("I");
        return invoice;
    }

    private static StampTransactionParams newTransfer() {
        StampTransactionParams params = new StampTransactionParams();
        params.setFromPersonId("0e82a655-5f0c-4e07-abab-8f322e4123ef");
        params.setToPersonId("da71df0c-f328-45ee-9bd9-3096ed02c164");
        params.setAmount(10);
        params.setComments("venta de timbres");
        return params;
    }

    private static String ok(String data) {
        return "{\"data\":" + data + ",\"succeeded\":true,\"message\":\"\",\"details\":\"\",\"httpStatusCode\":201}";
    }

    private FakeApi.RecordedRequest singleRequest() {
        assertEquals(1, api.requests().size());
        return api.requests().get(0);
    }

    @Test
    void createInvoiceWithKeySendsTheIdempotencyKeyHeader() {
        api.respondWith(ok("{\"id\":\"9c1d2e3f-0000-4000-8000-0000000000a1\"}"), 201);

        invoices.create(newInvoice(), IDEMPOTENCY_KEY);

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("POST", request.method);
        assertEquals(INVOICES_URL, request.url);
        assertEquals(IDEMPOTENCY_KEY, request.headers.get(HEADER));
    }

    @Test
    void createInvoiceWithoutKeyDoesNotSendTheIdempotencyKeyHeader() {
        api.respondWith(ok("{\"id\":\"9c1d2e3f-0000-4000-8000-0000000000a1\"}"), 201);

        invoices.create(newInvoice());

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("POST", request.method);
        assertEquals(INVOICES_URL, request.url);
        assertNull(request.headers.get(HEADER));
    }

    @Test
    void createInvoiceSendsTheSameBodyWithAndWithoutKey() {
        api.respondWith(ok("{\"id\":\"9c1d2e3f-0000-4000-8000-0000000000a1\"}"), 201);

        invoices.create(newInvoice(), IDEMPOTENCY_KEY);
        invoices.create(newInvoice());

        assertEquals(2, api.requests().size());
        assertEquals(api.requests().get(0).body, api.requests().get(1).body);
    }

    @Test
    void createInvoiceWithKeyReturnsTheApiResponse() {
        api.respondWith(ok("{\"id\":\"9c1d2e3f-0000-4000-8000-0000000000a1\"}"), 201);

        ApiResponse<Invoice> response = invoices.create(newInvoice(), IDEMPOTENCY_KEY);

        assertTrue(response.isSucceeded());
        assertEquals("9c1d2e3f-0000-4000-8000-0000000000a1", response.getData().getId());
    }

    @Test
    void transferStampsWithKeySendsTheIdempotencyKeyHeader() {
        api.respondWith(ok("true"), 200);

        ApiResponse<Boolean> response = stamps.transferStamps(newTransfer(), IDEMPOTENCY_KEY);

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("POST", request.method);
        assertEquals(STAMPS_URL, request.url);
        assertEquals(IDEMPOTENCY_KEY, request.headers.get(HEADER));
        assertTrue(response.getData());
    }

    @Test
    void transferStampsWithoutKeyDoesNotSendTheIdempotencyKeyHeader() {
        api.respondWith(ok("true"), 200);

        stamps.transferStamps(newTransfer());

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("POST", request.method);
        assertEquals(STAMPS_URL, request.url);
        assertNull(request.headers.get(HEADER));
    }

    @Test
    void transferStampsWithKeyStillValidatesTheRequestBeforeSending() {
        assertThrows(IllegalArgumentException.class, () -> stamps.transferStamps(null, IDEMPOTENCY_KEY));
        assertTrue(api.requests().isEmpty());
    }
}
