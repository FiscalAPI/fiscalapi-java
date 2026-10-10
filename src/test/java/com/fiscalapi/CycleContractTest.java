package com.fiscalapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscalapi.abstractions.IFiscalApiService;
import com.fiscalapi.abstractions.IImmutableFiscalApiService;
import com.fiscalapi.abstractions.ITaxFileService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.TaxFile;
import com.fiscalapi.services.PersonService;
import com.fiscalapi.services.TaxFileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Contrato publico que fijan estas pruebas. Los mismos escenarios viven en los SDK de .NET, Node.js, Python y PHP, con
 * el mismo resultado observable en cada uno (lo retirado no existe ni compila), cuando el cambio le aplica:
 * 1. persona: validTo de solo lectura (no se envia) y committedBalance heredado; capitalRegime, stripeCustomerId y
 *    subscriptionStatus fuera del modelo; StripePaymentMethodDto eliminado;
 * 2. certificados: tin opcional al subir y fileType 2 y 3 de la FIEL;
 * 3. certificados sin update(): el API retiro PUT tax-files; los servicios que si actualizan lo conservan.
 */
class CycleContractTest {

    private static final String PERSON_ID = "4b1c2d3e-0000-4000-8000-000000000002";
    private static final String TAX_FILE_ID = "7a1b2c3d-0000-4000-8000-0000000000f1";
    private static final String BASE64_CER = "MIIFsDCCA5igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0MTYwDQYJKoZIhvcNAQELBQAw";
    private static final String DELETED_RESPONSE =
            "{\"data\":true,\"succeeded\":true,\"message\":\"\",\"details\":\"\",\"httpStatusCode\":200}";

    private final ObjectMapper json = new ObjectMapper();
    private FakeApi api;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
    }

    private static String taxFileResponse(int fileType) {
        return "{\"data\":{\"id\":\"" + TAX_FILE_ID + "\",\"personId\":\"" + PERSON_ID + "\",\"tin\":\"EKU9003173C9\","
                + "\"fileType\":" + fileType + ",\"sequence\":1},\"succeeded\":true,\"message\":\"\",\"details\":\"\","
                + "\"httpStatusCode\":200}";
    }

    private static List<String> methodNames(Class<?> type) {
        return Arrays.stream(type.getMethods()).map(Method::getName).collect(Collectors.toList());
    }

    // 1. Persona

    @Test
    void personFromResponseReadsValidToAndCommittedBalanceAndDropsTheRetiredFields() {
        api.respondWith(FakeApi.readFixture("person-valid-to.json"));

        ApiResponse<Person> response = new PersonService(api.httpClient(), api.settings()).getById(PERSON_ID, false);

        Person person = response.getData();
        assertTrue(response.isSucceeded());
        assertEquals(LocalDateTime.of(2025, 7, 15, 10, 30), person.getValidTo());
        assertEquals(0, BigDecimal.ZERO.compareTo(person.getCommittedBalance()));
        List<String> methods = methodNames(Person.class);
        assertFalse(methods.contains("getCapitalRegime"));
        assertFalse(methods.contains("getStripeCustomerId"));
        assertFalse(methods.contains("getSubscriptionStatus"));
    }

    @Test
    void personCreateSendsNeitherValidToEvenWhenSetNorTheRetiredFields() throws IOException {
        api.respondWith(FakeApi.readFixture("person-valid-to.json"));
        Person person = new Person();
        person.setLegalName("ESCUELA KEMPER URGATE");
        person.setEmail("someone@example.com");
        person.setPassword("UserPass123!");
        person.setTin("EKU9003173C9");
        person.setValidTo(LocalDateTime.of(2025, 7, 15, 10, 30));

        new PersonService(api.httpClient(), api.settings()).create(person);

        assertEquals(1, api.requests().size());
        FakeApi.RecordedRequest request = api.requests().get(0);
        assertEquals("POST", request.method);
        assertEquals(FakeApi.BASE_URL + "/api/v4/people", request.url);
        JsonNode body = json.readTree(request.body);
        assertEquals("ESCUELA KEMPER URGATE", body.get("legalName").asText());
        for (String key : Arrays.asList("validTo", "capitalRegime", "stripeCustomerId", "subscriptionStatus")) {
            assertFalse(body.has(key), key);
        }
    }

    @Test
    void stripePaymentMethodDtoNoLongerExists() {
        assertThrows(ClassNotFoundException.class, () -> Class.forName("com.fiscalapi.common.StripePaymentMethodDto"));
    }

    // 2. Certificados: tin opcional y fileType de la FIEL

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void taxFileCreateWithoutTinSendsTheFileTypeAsANumberAndNoTin(int fileType) throws IOException {
        api.respondWith(taxFileResponse(fileType));
        TaxFile taxFile = new TaxFile();
        taxFile.setPersonId(PERSON_ID);
        taxFile.setBase64File(BASE64_CER);
        taxFile.setFileType(fileType);
        taxFile.setPassword("12345678a");

        ApiResponse<TaxFile> response = new TaxFileService(api.httpClient(), api.settings()).create(taxFile);

        assertTrue(response.isSucceeded());
        assertEquals("EKU9003173C9", response.getData().getTin());
        assertEquals(1, api.requests().size());
        FakeApi.RecordedRequest request = api.requests().get(0);
        assertEquals("POST", request.method);
        assertEquals(FakeApi.BASE_URL + "/api/v4/tax-files", request.url);
        JsonNode body = json.readTree(request.body);
        assertTrue(body.get("fileType").isInt());
        assertEquals(fileType, body.get("fileType").asInt());
        assertFalse(body.has("tin"));
        assertEquals(PERSON_ID, body.get("personId").asText());
    }

    // 3. Certificados sin update()

    @Test
    void taxFileServiceHasNoUpdate() {
        assertFalse(methodNames(ITaxFileService.class).contains("update"));
        assertFalse(methodNames(TaxFileService.class).contains("update"));
        assertFalse(IFiscalApiService.class.isAssignableFrom(TaxFileService.class));
        assertTrue(IImmutableFiscalApiService.class.isAssignableFrom(TaxFileService.class));
    }

    @Test
    void personServiceKeepsUpdateAfterTheImmutableServiceSplit() throws IOException {
        api.respondWith(FakeApi.readFixture("person-valid-to.json"));
        Person person = new Person();
        person.setId(PERSON_ID);
        person.setLegalName("ESCUELA KEMPER URGATE");

        ApiResponse<Person> response = new PersonService(api.httpClient(), api.settings()).update(person);

        assertTrue(response.isSucceeded());
        assertEquals(1, api.requests().size());
        FakeApi.RecordedRequest request = api.requests().get(0);
        assertEquals("PUT", request.method);
        assertEquals(FakeApi.BASE_URL + "/api/v4/people/" + PERSON_ID, request.url);
        assertEquals(PERSON_ID, json.readTree(request.body).get("id").asText());
    }

    @Test
    void taxFileDeleteSendsDeleteToTheTaxFile() {
        api.respondWith(DELETED_RESPONSE);

        ApiResponse<Boolean> response = new TaxFileService(api.httpClient(), api.settings()).delete(TAX_FILE_ID);

        assertTrue(response.isSucceeded());
        assertTrue(response.getData());
        assertEquals(1, api.requests().size());
        assertEquals("DELETE", api.requests().get(0).method);
        assertEquals(FakeApi.BASE_URL + "/api/v4/tax-files/" + TAX_FILE_ID, api.requests().get(0).url);
    }
}
