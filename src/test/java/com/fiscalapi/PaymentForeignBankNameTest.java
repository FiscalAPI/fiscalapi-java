package com.fiscalapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscalapi.models.invoicing.Complement;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.models.invoicing.InvoiceIssuer;
import com.fiscalapi.models.invoicing.paymentComplement.InvoicePayment;
import com.fiscalapi.services.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * InvoicePayment.foreignBankName (NomBancoOrdExt del complemento de pago): el SAT lo exige cuando sourceBankTin es
 * XEXX010101000 (CRP20223). Como en los SDK de .NET, Node.js y Python, viaja en complement.payment solo si se asigna.
 */
class PaymentForeignBankNameTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private FakeApi api;
    private InvoiceService invoices;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
        api.respondWith("{\"data\":{\"id\":\"9c1d2e3f-0000-4000-8000-0000000000a1\"},\"succeeded\":true,"
                + "\"message\":\"\",\"details\":\"\",\"httpStatusCode\":200}");
        invoices = new InvoiceService(api.httpClient(), api.settings());
    }

    private static Invoice paymentInvoice(String sourceBankTin, String foreignBankName) {
        InvoicePayment payment = new InvoicePayment();
        payment.setPaymentDate(LocalDateTime.of(2026, 10, 8, 10, 0, 0));
        payment.setPaymentFormCode("03");
        payment.setCurrencyCode("MXN");
        payment.setAmount(new BigDecimal("100.00"));
        payment.setSourceBankTin(sourceBankTin);
        payment.setForeignBankName(foreignBankName);
        payment.setPaidInvoices(Collections.emptyList());

        Complement complement = new Complement();
        complement.setPayment(payment);

        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setId("4b1c2d3e-0000-4000-8000-000000000002");

        Invoice invoice = new Invoice();
        invoice.setTypeCode("P");
        invoice.setIssuer(issuer);
        invoice.setComplement(complement);
        return invoice;
    }

    private JsonNode sentPayment() throws IOException {
        assertEquals(1, api.requests().size());
        return MAPPER.readTree(api.requests().get(0).body).get("complement").get("payment");
    }

    @Test
    void aForeignBankNameIsSentInTheComplementPayment() throws IOException {
        invoices.create(paymentInvoice("XEXX010101000", "BANK OF TOKY"));

        assertEquals("BANK OF TOKY", sentPayment().get("foreignBankName").asText());
    }

    @Test
    void withoutForeignBankNameTheFieldDoesNotTravel() throws IOException {
        invoices.create(paymentInvoice("BSM970519DU8", null));

        assertFalse(sentPayment().has("foreignBankName"));
    }
}
