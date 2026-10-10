package com.fiscalapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.Complement;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.models.invoicing.InvoiceIssuer;
import com.fiscalapi.models.invoicing.payroll.EmployerData;
import com.fiscalapi.models.invoicing.payroll.Payroll;
import com.fiscalapi.services.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Consistencia entre SDK (SDK-059, DEC-136): los mismos escenarios viven en el SDK de .NET y ya los cumplian Node.js,
 * Python y PHP:
 * 1. nomina: daysPaid admite dias fraccionarios (BigDecimal) y viaja sin perder precision;
 * 2. nomina por valores: issuer.employerData.curp;
 * 3. factura: uuid (folio fiscal) en la raiz se lee de la respuesta (Java ya lo modelaba);
 * 4. 400 de validacion: getDetails() une todas las fallas con "; ".
 */
class PayrollAndInvoiceConsistencyTest {

    private static final String INVOICE_ID = "9c1d2e3f-0000-4000-8000-0000000000a1";
    private static final String UUID = "5F8C2D3E-1A2B-4C5D-8E9F-0A1B2C3D4E5F";

    private static final String INVOICE_RESPONSE = "{\"data\":{\"id\":\"" + INVOICE_ID + "\",\"versionCode\":\"4.0\","
            + "\"typeCode\":\"N\",\"uuid\":\"" + UUID + "\",\"consecutive\":7,\"total\":1000.00,"
            + "\"complement\":{\"payroll\":{\"version\":\"1.2\",\"payrollTypeCode\":\"O\",\"daysPaid\":15.5}}},"
            + "\"succeeded\":true,\"message\":\"\",\"details\":\"\",\"httpStatusCode\":200}";

    private static final String DISCOUNT_FAILURE = "'discount' admite como máximo 6 decimales (se recibieron 17): "
            + "redondéalo antes de enviarlo; FiscalAPI no lo redondea.";
    private static final String DAYS_PAID_FAILURE = "'daysPaid' admite como máximo 3 decimales (se recibieron 4): "
            + "redondéalo antes de enviarlo; FiscalAPI no lo redondea.";

    private static final String TWO_FAILURES_RESPONSE = "{\"data\":["
            + "{\"propertyName\":\"Items[0].Discount\",\"errorMessage\":\"" + DISCOUNT_FAILURE + "\","
            + "\"attemptedValue\":0.30000000000000004},"
            + "{\"propertyName\":\"Complement.Payroll.DaysPaid\",\"errorMessage\":\"" + DAYS_PAID_FAILURE + "\","
            + "\"attemptedValue\":15.1234}],"
            + "\"succeeded\":false,\"message\":\"Sorry, it's not me, it's you.\","
            + "\"details\":\"One or more validation failures have occurred.\",\"httpStatusCode\":400}";

    // Los numeros del cuerpo se leen como BigDecimal para comparar sin pasar por double.
    private final ObjectMapper json = new ObjectMapper()
            .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
    private FakeApi api;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
    }

    private InvoiceService invoices() {
        return new InvoiceService(api.httpClient(), api.settings());
    }

    private static Invoice payrollInvoice(BigDecimal daysPaid) {
        EmployerData employerData = new EmployerData();
        employerData.setCurp("XEXX010101HNEXXXA4");
        employerData.setEmployerRegistration("B5510768108");
        InvoiceIssuer issuer = new InvoiceIssuer();
        issuer.setTin("EKU9003173C9");
        issuer.setEmployerData(employerData);
        Payroll payroll = new Payroll();
        payroll.setVersion("1.2");
        payroll.setPayrollTypeCode("O");
        payroll.setDaysPaid(daysPaid);
        Complement complement = new Complement();
        complement.setPayroll(payroll);
        Invoice invoice = new Invoice();
        invoice.setTypeCode("N");
        invoice.setIssuer(issuer);
        invoice.setComplement(complement);
        return invoice;
    }

    private JsonNode sentBody() throws IOException {
        assertEquals(1, api.requests().size());
        FakeApi.RecordedRequest request = api.requests().get(0);
        assertEquals("POST", request.method);
        assertEquals(FakeApi.BASE_URL + "/api/v4/invoices", request.url);
        return json.readTree(request.body);
    }

    // 1. daysPaid BigDecimal

    @ParameterizedTest
    @ValueSource(strings = {"15.5", "15.125", "30"})
    void payrollDaysPaidIsSentAsTheExactDecimal(String daysPaid) throws IOException {
        api.respondWith(INVOICE_RESPONSE);

        invoices().create(payrollInvoice(new BigDecimal(daysPaid)));

        JsonNode sent = sentBody().path("complement").path("payroll").path("daysPaid");
        // El serializador de importes del SDK (BigDecimalSerializer) lo escribe como texto plano, sin notacion
        // cientifica ni decimales de mas; el API lo lee como numero.
        assertEquals(daysPaid, sent.asText());
        assertEquals(0, new BigDecimal(daysPaid).compareTo(new BigDecimal(sent.asText())));
    }

    @Test
    void payrollDaysPaidFromValueOfDoubleKeepsItsShortForm() throws IOException {
        api.respondWith(INVOICE_RESPONSE);

        invoices().create(payrollInvoice(BigDecimal.valueOf(15.5)));

        assertEquals("15.5", sentBody().path("complement").path("payroll").path("daysPaid").asText());
    }

    @Test
    void payrollDaysPaidIsReadFromTheResponse() {
        api.respondWith(INVOICE_RESPONSE);

        ApiResponse<Invoice> response = invoices().getById(INVOICE_ID, false);

        assertEquals(new BigDecimal("15.5"), response.getData().getComplement().getPayroll().getDaysPaid());
    }

    // 2. curp del empleador del emisor

    @Test
    void issuerEmployerDataCurpIsSentAsCurp() throws IOException {
        api.respondWith(INVOICE_RESPONSE);

        invoices().create(payrollInvoice(new BigDecimal("15")));

        JsonNode employerData = sentBody().path("issuer").path("employerData");
        assertEquals("XEXX010101HNEXXXA4", employerData.path("curp").asText());
        assertEquals("B5510768108", employerData.path("employerRegistration").asText());
    }

    @Test
    void issuerEmployerDataWithoutCurpDoesNotSendIt() throws IOException {
        api.respondWith(INVOICE_RESPONSE);
        Invoice invoice = payrollInvoice(new BigDecimal("15"));
        invoice.getIssuer().getEmployerData().setCurp(null);

        invoices().create(invoice);

        assertFalse(sentBody().path("issuer").path("employerData").has("curp"));
    }

    // 3. uuid en la raiz de la factura

    @Test
    void invoiceUuidIsReadFromTheCreateResponse() {
        api.respondWith(INVOICE_RESPONSE);

        ApiResponse<Invoice> response = invoices().create(payrollInvoice(new BigDecimal("15.5")));

        assertEquals(UUID, response.getData().getUuid());
    }

    // 4. 400 de validacion con varias fallas

    @Test
    void validationFailureDetailsJoinsEveryFailureWithSemicolon() {
        api.respondWith(TWO_FAILURES_RESPONSE, 400);

        ApiResponse<Invoice> response = invoices().create(payrollInvoice(new BigDecimal("15.1234")));

        assertFalse(response.isSucceeded());
        assertEquals(400, response.getHttpStatusCode());
        assertEquals("Sorry, it's not me, it's you.", response.getMessage());
        assertEquals("Items[0].Discount: " + DISCOUNT_FAILURE + "; Complement.Payroll.DaysPaid: " + DAYS_PAID_FAILURE,
                response.getDetails());
        assertNull(response.getData());
    }

    @Test
    void validationFailureDetailsWithOneFailureIsThatFailure() {
        api.respondWith("{\"data\":[{\"propertyName\":\"Items[0].Discount\",\"errorMessage\":\"" + DISCOUNT_FAILURE
                + "\"}],\"succeeded\":false,\"message\":\"Sorry, it's not me, it's you.\","
                + "\"details\":\"One or more validation failures have occurred.\",\"httpStatusCode\":400}", 400);

        ApiResponse<Invoice> response = invoices().create(payrollInvoice(new BigDecimal("15")));

        assertEquals("Items[0].Discount: " + DISCOUNT_FAILURE, response.getDetails());
    }
}
