package com.fiscalapi;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.CreditType;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.StampTransaction;
import com.fiscalapi.models.invoicing.GlobalInformation;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.services.InvoiceService;
import com.fiscalapi.services.PersonService;
import com.fiscalapi.services.StampService;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tolerancia del SDK a respuestas que el API devolvera en las proximas fases (SDK-001).
 *
 * Son pruebas de caracterizacion: fijan el comportamiento ACTUAL. Una prueba cuyo nombre cita
 * SDK-014 documenta un defecto conocido; SDK-014 la invierte al corregirlo. Los casos son:
 * 1. una transaccion de timbres con creditType 3 (creditos de ticket, Fase 1);
 * 2. una persona con el campo nuevo availableTicketBalance (Fase 1);
 * 3. propiedades desconocidas en la envoltura, en data y en objetos anidados;
 * 4. globalInformation en la respuesta de una factura (BE-008).
 */
class ResponseToleranceTest {

    private static final String TICKET_TRANSACTION_ID = "8d0f6a52-6f1e-4c3a-9a10-000000000103";
    private static final String PERSON_ID = "4b1c2d3e-0000-4000-8000-000000000001";
    private static final String INVOICE_ID = "3f2a9c1e-0b7d-4e55-9a61-2c8f0e4d7b10";

    private FakeApi api;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
    }

    // 1. creditType 3

    @Test
    void stampListWithCreditType3LosesTheValueAsNull_fixedBySdk014() {
        api.respondWith(FakeApi.readFixture("stamps-page-credit-type-3.json"));

        ApiResponse<PagedList<StampTransaction>> response =
                new StampService(api.httpClient(), api.settings()).getList(1, 10);

        List<CreditType> creditTypes = response.getData().getItems().stream()
                .map(StampTransaction::getCreditType)
                .collect(Collectors.toList());
        assertTrue(response.isSucceeded());
        assertEquals(Arrays.asList(CreditType.STAMP, CreditType.VALIDATION, null), creditTypes);
        HttpUrl requested = HttpUrl.get(api.requestedUrls().get(0));
        assertEquals("/api/v4/stamps", requested.encodedPath());
        assertEquals("1", requested.queryParameter("PageNumber"));
        assertEquals("10", requested.queryParameter("PageSize"));
    }

    @Test
    void stampByIdWithCreditType3LosesTheValueAsNull_fixedBySdk014() {
        api.respondWith(FakeApi.readFixture("stamp-credit-type-3.json"));

        ApiResponse<StampTransaction> response =
                new StampService(api.httpClient(), api.settings()).getById(TICKET_TRANSACTION_ID, false);

        assertTrue(response.isSucceeded());
        assertNull(response.getData().getCreditType());
        assertEquals(25, response.getData().getAmount());
    }

    // 2. availableTicketBalance

    @Test
    void personWithAvailableTicketBalanceDeserializesAndDropsTheField_exposedBySdk014() {
        api.respondWith(FakeApi.readFixture("person-ticket-balance.json"));

        ApiResponse<Person> response = new PersonService(api.httpClient(), api.settings()).getById(PERSON_ID, false);

        Person person = response.getData();
        assertTrue(response.isSucceeded());
        assertEquals(0, new BigDecimal("100").compareTo(person.getAvailableBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(person.getCommittedBalance()));
        assertEquals(Integer.valueOf(50), person.getAvailableValidationBalance());
        assertFalse(person.toString().contains("availableTicketBalance"));
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

    // 4. globalInformation en la respuesta de una factura (BE-008)

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
