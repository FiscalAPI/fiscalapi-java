package com.fiscalapi;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.TaxFile;
import com.fiscalapi.services.PersonService;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Certificados de una persona: GET people/{id}/tax-files, solo metadatos, sin archivo ni contraseña. */
class PersonServiceTaxFilesTest {

    private static final String PERSON_ID = "p1";
    private static final String TAX_FILES_BODY =
            "{\"data\":["
                    + "{\"id\":\"a1\",\"personId\":\"p1\",\"tin\":\"EKU9003173C9\",\"fileType\":0,"
                    + "\"validFrom\":\"2023-05-18T11:43:51\",\"validTo\":\"2027-05-18T11:43:51\",\"sequence\":1},"
                    + "{\"id\":\"a2\",\"personId\":\"p1\",\"tin\":\"EKU9003173C9\",\"fileType\":1,"
                    + "\"validFrom\":\"2023-05-18T11:43:51\",\"validTo\":\"2027-05-18T11:43:51\",\"sequence\":1}"
                    + "],\"succeeded\":true,\"message\":\"\",\"details\":\"\",\"httpStatusCode\":200}";

    private FakeApi api;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
    }

    @Test
    void getTaxFilesCallsTheTaxFilesSubresourceOfThePerson() {
        api.respondWith(TAX_FILES_BODY);

        new PersonService(api.httpClient(), api.settings()).getTaxFiles(PERSON_ID);

        assertEquals(1, api.requests().size());
        FakeApi.RecordedRequest request = api.requests().get(0);
        assertEquals("GET", request.method);
        assertEquals("/api/v4/people/p1/tax-files", HttpUrl.get(request.url).encodedPath());
        assertNull(request.body);
    }

    @Test
    void getTaxFilesReadsTheMetadataOfEachCertificate() {
        api.respondWith(TAX_FILES_BODY);

        ApiResponse<List<TaxFile>> response = new PersonService(api.httpClient(), api.settings()).getTaxFiles(PERSON_ID);

        assertTrue(response.isSucceeded());
        List<TaxFile> files = response.getData();
        assertEquals(2, files.size());

        TaxFile csd = files.get(0);
        assertEquals("a1", csd.getId());
        assertEquals("p1", csd.getPersonId());
        assertEquals("EKU9003173C9", csd.getTin());
        assertEquals(0, csd.getFileType());
        assertEquals(Date.from(LocalDateTime.of(2023, 5, 18, 11, 43, 51).toInstant(ZoneOffset.UTC)), csd.getValidFrom());
        assertEquals(Date.from(LocalDateTime.of(2027, 5, 18, 11, 43, 51).toInstant(ZoneOffset.UTC)), csd.getValidTo());
        assertEquals(Integer.valueOf(1), csd.getSequence());

        TaxFile csdKey = files.get(1);
        assertEquals("a2", csdKey.getId());
        assertEquals(1, csdKey.getFileType());
    }

    @Test
    void getTaxFilesDoesNotExposeTheFileNorThePassword() {
        api.respondWith(TAX_FILES_BODY);

        List<TaxFile> files = new PersonService(api.httpClient(), api.settings()).getTaxFiles(PERSON_ID).getData();

        for (TaxFile file : files) {
            assertNull(file.getBase64File());
            assertNull(file.getPassword());
        }
    }
}
