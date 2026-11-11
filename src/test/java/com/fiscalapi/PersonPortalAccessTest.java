package com.fiscalapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscalapi.models.Person;
import com.fiscalapi.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Acceso al portal de una persona (loginEnabled) y contraseña opcional: sin asignar, ninguno de los dos viaja, así que
 * crear una persona sin contraseña no manda password y un update que no fija loginEnabled no cambia el acceso.
 */
class PersonPortalAccessTest {

    private static final String PERSON_ID = "4b1c2d3e-0000-4000-8000-000000000002";
    private static final String PERSON_BODY = ("{'data':{'id':'" + PERSON_ID + "','legalName':'Persona de Prueba',"
            + "'email':'someone@somewhere.com','loginEnabled':true,'isOwner':false},"
            + "'succeeded':true,'message':'','details':'','httpStatusCode':200}").replace('\'', '"');

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private FakeApi api;
    private PersonService persons;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
        api.respondWith(PERSON_BODY);
        persons = new PersonService(api.httpClient(), api.settings());
    }

    private static Person newPerson() {
        Person person = new Person();
        person.setLegalName("Persona de Prueba");
        person.setEmail("someone@somewhere.com");
        return person;
    }

    private static Person existingPerson() {
        Person person = newPerson();
        person.setId(PERSON_ID);
        return person;
    }

    private FakeApi.RecordedRequest singleRequest() {
        assertEquals(1, api.requests().size());
        return api.requests().get(0);
    }

    private JsonNode sentBody() throws IOException {
        return MAPPER.readTree(singleRequest().body);
    }

    @Test
    void createWithoutPasswordSendsNeitherPasswordNorLoginEnabled() throws IOException {
        persons.create(newPerson());

        JsonNode body = sentBody();
        assertEquals("Persona de Prueba", body.get("legalName").asText());
        assertFalse(body.has("password"));
        assertFalse(body.has("loginEnabled"));
    }

    @Test
    void createWithPortalAccessSendsPasswordAndLoginEnabled() throws IOException {
        Person person = newPerson();
        person.setPassword("YourStrongPassword123!");
        person.setLoginEnabled(true);

        persons.create(person);

        JsonNode body = sentBody();
        assertEquals("YourStrongPassword123!", body.get("password").asText());
        assertTrue(body.get("loginEnabled").isBoolean());
        assertTrue(body.get("loginEnabled").booleanValue());
    }

    @Test
    void updateWithoutLoginEnabledDoesNotSendIt() throws IOException {
        persons.update(existingPerson());

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("PUT", request.method);
        assertEquals(FakeApi.BASE_URL + "/api/v4/people/" + PERSON_ID, request.url);
        assertFalse(sentBody().has("loginEnabled"));
    }

    @Test
    void updateWithLoginEnabledFalseSendsFalse() throws IOException {
        Person person = existingPerson();
        person.setLoginEnabled(false);

        persons.update(person);

        JsonNode body = sentBody();
        assertTrue(body.get("loginEnabled").isBoolean());
        assertFalse(body.get("loginEnabled").booleanValue());
    }

    @Test
    void theResponseReadsTheEffectiveLoginEnabled() {
        Person person = persons.getById(PERSON_ID, false).getData();

        assertEquals(Boolean.TRUE, person.getLoginEnabled());
    }
}
