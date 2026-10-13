package com.fiscalapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.CreditBalance;
import com.fiscalapi.models.CreditType;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.StampTransaction;
import com.fiscalapi.models.StampTransactionParams;
import com.fiscalapi.models.StampTransactionStatus;
import com.fiscalapi.models.StampTransactionType;
import com.fiscalapi.models.invoicing.GlobalInformation;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.services.InvoiceService;
import com.fiscalapi.services.PersonService;
import com.fiscalapi.services.StampService;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tolerancia del SDK a respuestas del API con valores y campos que el SDK modela o todavia no conoce.
 *
 * Una prueba cuyo nombre incluye fixedBy o exposedBy documenta un defecto conocido que se invierte cuando el SDK lo
 * corrija. Los casos son:
 * 1. transacciones con creditType 3 (CreditType.TICKET) y con valores de enum que el SDK no conoce (99);
 * 2. una persona con el saldo de creditos de ticket en balances;
 * 3. propiedades desconocidas en la envoltura, en data y en objetos anidados;
 * 4. globalInformation en la respuesta de una factura.
 */
class ResponseToleranceTest {

    private static final String TICKET_TRANSACTION_ID = "8d0f6a52-6f1e-4c3a-9a10-000000000103";
    private static final String PERSON_ID = "4b1c2d3e-0000-4000-8000-000000000001";
    private static final String INVOICE_ID = "3f2a9c1e-0b7d-4e55-9a61-2c8f0e4d7b10";
    private static final int TICKET_CREDIT_TYPE = 3;
    private static final int UNKNOWN_VALUE = 99;

    private final ObjectMapper json = new ObjectMapper();
    private FakeApi api;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
    }

    // 1. creditType 3 (TICKET) y valores desconocidos

    @Test
    void stampListReadsCreditType3AsTicket() {
        api.respondWith(FakeApi.readFixture("stamps-page-credit-type-3.json"));

        ApiResponse<PagedList<StampTransaction>> response =
                new StampService(api.httpClient(), api.settings()).getList(1, 10);

        List<CreditType> creditTypes = response.getData().getItems().stream()
                .map(StampTransaction::getCreditType)
                .collect(Collectors.toList());
        assertTrue(response.isSucceeded());
        assertEquals(Arrays.asList(CreditType.STAMP, CreditType.VALIDATION, CreditType.TICKET), creditTypes);
        HttpUrl requested = HttpUrl.get(api.requestedUrls().get(0));
        assertEquals("/api/v4/stamps", requested.encodedPath());
        assertEquals("1", requested.queryParameter("PageNumber"));
        assertEquals("10", requested.queryParameter("PageSize"));
    }

    @Test
    void stampByIdReadsCreditType3AsTicket() {
        api.respondWith(FakeApi.readFixture("stamp-credit-type-3.json"));

        ApiResponse<StampTransaction> response =
                new StampService(api.httpClient(), api.settings()).getById(TICKET_TRANSACTION_ID, false);

        assertTrue(response.isSucceeded());
        assertEquals(CreditType.TICKET, response.getData().getCreditType());
        assertEquals(Integer.valueOf(TICKET_CREDIT_TYPE), response.getData().getCreditTypeValue());
        assertEquals(StampTransactionType.TRANSFER, response.getData().getTransactionType());
        assertEquals(StampTransactionStatus.COMPLETED, response.getData().getTransactionStatus());
        assertEquals(25, response.getData().getAmount());
    }

    @Test
    void stampListKeepsTheNumberOfAnUnknownCreditType() throws IOException {
        api.respondWith(withCreditType(FakeApi.readFixture("stamps-page-credit-type-3.json"), UNKNOWN_VALUE));

        ApiResponse<PagedList<StampTransaction>> response =
                new StampService(api.httpClient(), api.settings()).getList(1, 10);

        List<StampTransaction> items = response.getData().getItems();
        assertTrue(response.isSucceeded());
        assertEquals(Arrays.asList(CreditType.STAMP, CreditType.VALIDATION, null),
                items.stream().map(StampTransaction::getCreditType).collect(Collectors.toList()));
        assertEquals(Integer.valueOf(UNKNOWN_VALUE), items.get(2).getCreditTypeValue());
        assertEquals(UNKNOWN_VALUE, json.readTree(items.get(2).toString()).get("creditType").asInt());
    }

    @Test
    void stampByIdKeepsTheNumberOfAnUnknownCreditType() throws IOException {
        api.respondWith(withCreditType(FakeApi.readFixture("stamp-credit-type-3.json"), UNKNOWN_VALUE));

        ApiResponse<StampTransaction> response =
                new StampService(api.httpClient(), api.settings()).getById(TICKET_TRANSACTION_ID, false);

        StampTransaction transaction = response.getData();
        assertTrue(response.isSucceeded());
        assertNull(transaction.getCreditType());
        assertEquals(Integer.valueOf(UNKNOWN_VALUE), transaction.getCreditTypeValue());
        assertEquals(UNKNOWN_VALUE, json.readTree(transaction.toString()).get("creditType").asInt());
        assertEquals(25, transaction.getAmount());
    }

    @Test
    void stampByIdKeepsTheNumbersOfAnUnknownTransactionTypeAndStatus() throws IOException {
        api.respondWith(FakeApi.readFixture("stamp-credit-type-3.json")
                .replace("\"transactionType\": 2", "\"transactionType\": " + UNKNOWN_VALUE)
                .replace("\"transactionStatus\": 1", "\"transactionStatus\": " + UNKNOWN_VALUE));

        ApiResponse<StampTransaction> response =
                new StampService(api.httpClient(), api.settings()).getById(TICKET_TRANSACTION_ID, false);

        StampTransaction transaction = response.getData();
        JsonNode reserialized = json.readTree(transaction.toString());
        assertTrue(response.isSucceeded());
        assertNull(transaction.getTransactionType());
        assertEquals(Integer.valueOf(UNKNOWN_VALUE), transaction.getTransactionTypeValue());
        assertNull(transaction.getTransactionStatus());
        assertEquals(Integer.valueOf(UNKNOWN_VALUE), transaction.getTransactionStatusValue());
        assertEquals(UNKNOWN_VALUE, reserialized.get("transactionType").asInt());
        assertEquals(UNKNOWN_VALUE, reserialized.get("transactionStatus").asInt());
        assertEquals(TICKET_CREDIT_TYPE, reserialized.get("creditType").asInt());
        for (String key : Arrays.asList("transactionTypeValue", "transactionStatusValue", "creditTypeValue")) {
            assertFalse(reserialized.has(key), key);
        }
        assertEquals(CreditType.TICKET, transaction.getCreditType());
    }

    @Test
    void transferStampsWithTicketSendsCreditType3() throws IOException {
        api.respondWith("{\"data\":true,\"succeeded\":true,\"message\":\"\",\"details\":\"\",\"httpStatusCode\":200}");
        StampTransactionParams requestModel = new StampTransactionParams();
        requestModel.setFromPersonId("1");
        requestModel.setToPersonId(PERSON_ID);
        requestModel.setAmount(25);
        requestModel.setCreditType(CreditType.TICKET);

        ApiResponse<Boolean> response = new StampService(api.httpClient(), api.settings()).transferStamps(requestModel);

        assertTrue(response.isSucceeded());
        assertEquals(1, api.requests().size());
        FakeApi.RecordedRequest request = api.requests().get(0);
        assertEquals("POST", request.method);
        assertEquals("/api/v4/stamps", HttpUrl.get(request.url).encodedPath());
        assertEquals(TICKET_CREDIT_TYPE, json.readTree(request.body).get("creditType").asInt());
    }

    // 2. Saldo de creditos de ticket en balances

    @Test
    void personReadsTheTicketBalanceFromBalances() {
        api.respondWith(FakeApi.readFixture("person-ticket-balance.json"));

        ApiResponse<Person> response = new PersonService(api.httpClient(), api.settings()).getById(PERSON_ID, false);

        Person person = response.getData();
        assertTrue(response.isSucceeded());
        assertEquals(0, new BigDecimal("100").compareTo(person.getAvailableBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(person.getCommittedBalance()));
        assertEquals(Integer.valueOf(50), person.getAvailableValidationBalance());
        assertEquals(Arrays.asList(
                        Arrays.asList(CreditType.STAMP.getValue(), 100),
                        Arrays.asList(CreditType.VALIDATION.getValue(), 50),
                        Arrays.asList(CreditType.TICKET.getValue(), 25)),
                person.getBalances().stream()
                        .map((CreditBalance b) -> Arrays.asList(b.getCreditType(), b.getAvailable()))
                        .collect(Collectors.toList()));
    }

    /** La fixture con el creditType 3 de la transaccion de tickets cambiado por otro valor. */
    private static String withCreditType(String fixture, int creditType) {
        return fixture.replace("\"creditType\": " + TICKET_CREDIT_TYPE, "\"creditType\": " + creditType);
    }

    // 3. Propiedades desconocidas

    @Test
    void unknownPropertiesOnTheEnvelopeThePageTheDataAndNestedObjectsAreIgnored() {
        api.respondWith(FakeApi.readFixture("stamps-page-credit-type-3.json"));

        ApiResponse<PagedList<StampTransaction>> response =
                new StampService(api.httpClient(), api.settings()).getList(1, 10);

        StampTransaction ticketTransaction = response.getData().getItems().get(2);
        assertTrue(response.isSucceeded());
        assertEquals(200, response.getHttpStatusCode());
        assertEquals(3, response.getData().getTotalCount());
        assertEquals(TICKET_TRANSACTION_ID, ticketTransaction.getId());
        assertEquals("FISCALAPI", ticketTransaction.getFromPerson().getLegalName());
        assertFalse(ticketTransaction.toString().contains("unknown"));
    }

    // 4. globalInformation en la respuesta de una factura

    @Test
    void invoiceWithGlobalInformationDeserializesIt() {
        api.respondWith(FakeApi.readFixture("invoice-global-information.json"));

        ApiResponse<Invoice> response = new InvoiceService(api.httpClient(), api.settings()).getById(INVOICE_ID, false);

        GlobalInformation globalInformation = response.getData().getGlobalInformation();
        assertTrue(response.isSucceeded());
        assertEquals("04", globalInformation.getPeriodicityCode());
        assertEquals("09", globalInformation.getMonthCode());
        assertEquals(Integer.valueOf(2026), globalInformation.getYear());
        assertEquals("EKU9003173C9", response.getData().getIssuer().getTin());
    }

    @Test
    void invoiceWithNullGlobalInformationDeserializesItAsNull() {
        api.respondWith(FakeApi.readFixture("invoice-global-information-null.json"));

        ApiResponse<Invoice> response = new InvoiceService(api.httpClient(), api.settings()).getById(INVOICE_ID, false);

        assertTrue(response.isSucceeded());
        assertNull(response.getData().getGlobalInformation());
        assertEquals(0, new BigDecimal("1160").compareTo(response.getData().getTotal()));
    }

    @Test
    void invoiceWithNullMembersInGlobalInformationDeserializesThemAsNull() {
        api.respondWith(FakeApi.readFixture("invoice-global-information-null-members.json"));

        ApiResponse<Invoice> response = new InvoiceService(api.httpClient(), api.settings()).getById(INVOICE_ID, false);

        GlobalInformation globalInformation = response.getData().getGlobalInformation();
        assertTrue(response.isSucceeded());
        assertNull(globalInformation.getPeriodicityCode());
        assertNull(globalInformation.getMonthCode());
        assertNull(globalInformation.getYear());
    }
}
