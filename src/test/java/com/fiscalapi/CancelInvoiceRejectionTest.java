package com.fiscalapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.InvoiceCancellationRequest;
import com.fiscalapi.models.invoicing.InvoiceCancellationResponse;
import com.fiscalapi.services.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/** Cancelar factura con rechazo del SAT: 422, isSucceeded() en false y el acuse en getErrorData(). */
class CancelInvoiceRejectionTest {

    private static final String INVOICE_ID = "21c39425-9d0a-449b-a7ba-49335b85b062";
    private static final String INVOICE_UUID = "de841944-bd4f-4bb8-adfe-2a2282787c62";
    private static final String SAT_REJECTION = "{\"data\":{\"base64CancellationAcknowledgement\":"
            + "\"PD94bWwgdmVyc2lvbj0iMS4wIj8+...\",\"invoiceUuids\":{\"" + INVOICE_UUID + "\":\"203\"}},"
            + "\"succeeded\":false,\"message\":\"Sorry, it's not me, it's you.\","
            + "\"details\":\"SAT 203: el folio fiscal no corresponde al emisor de la solicitud de cancelación.\","
            + "\"httpStatusCode\":422}";

    private FakeApi api;
    private InvoiceService invoices;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
        invoices = new InvoiceService(api.httpClient(), api.settings());
    }

    @Test
    void aSatRejectionIs422WithTheSatDetailsAndTheAcknowledgementInErrorData() {
        api.respondWith(SAT_REJECTION, 422);
        InvoiceCancellationRequest request = new InvoiceCancellationRequest();
        request.setId(INVOICE_ID);
        request.setCancellationReasonCode("02");

        ApiResponse<InvoiceCancellationResponse> response = invoices.cancel(request);

        assertFalse(response.isSucceeded());
        assertEquals(422, response.getHttpStatusCode());
        assertEquals("Sorry, it's not me, it's you.", response.getMessage());
        assertEquals("SAT 203: el folio fiscal no corresponde al emisor de la solicitud de cancelación.",
                response.getDetails());
        InvoiceCancellationResponse acknowledgement = response.getData();
        assertEquals("PD94bWwgdmVyc2lvbj0iMS4wIj8+...", acknowledgement.getBase64CancellationAcknowledgement());
        assertEquals("203", acknowledgement.getInvoiceUuids().get(INVOICE_UUID));
        JsonNode rejection = response.getErrorData();
        assertEquals("PD94bWwgdmVyc2lvbj0iMS4wIj8+...", rejection.get("base64CancellationAcknowledgement").asText());
        assertEquals("203", rejection.get("invoiceUuids").get(INVOICE_UUID).asText());
        assertEquals("DELETE", api.requests().get(0).method);
    }
}
