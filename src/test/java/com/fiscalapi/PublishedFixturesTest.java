package com.fiscalapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.Product;
import com.fiscalapi.models.TaxFile;
import com.fiscalapi.models.invoicing.Invoice;
import com.fiscalapi.models.invoicing.InvoiceCancellationRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Los cuerpos publicados (fixtures del kit sdk-e2e) deben cargar en los modelos del SDK, sin red.
 *
 * Los fixtures de src/test/resources/fixtures/sdk-e2e son copias de los cuerpos que la documentacion publica. Las fechas
 * de nomina y de carta porte llegan con y sin milisegundos, y la nomina ordinaria trae solo fecha.
 */
class PublishedFixturesTest {

    private static final String FIXTURES_DIR = "/fixtures/sdk-e2e/";
    private static final Map<String, Class<?>> MODEL_BY_FIXTURE = new HashMap<>();
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    static {
        MODEL_BY_FIXTURE.put("persona-crear.json", Person.class);
        MODEL_BY_FIXTURE.put("producto-crear.json", Product.class);
        MODEL_BY_FIXTURE.put("certificado.json", TaxFile.class);
        MODEL_BY_FIXTURE.put("llave.json", TaxFile.class);
        MODEL_BY_FIXTURE.put("cancelar-valores.json", InvoiceCancellationRequest.class);
    }

    static Stream<String> fixtureNames() throws URISyntaxException {
        File dir = new File(PublishedFixturesTest.class.getResource(FIXTURES_DIR).toURI());
        String[] names = dir.list((d, name) -> name.endsWith(".json"));
        assertNotNull(names);
        Arrays.sort(names);
        return Arrays.stream(names);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("fixtureNames")
    void publishedFixtureLoadsIntoSdkModel(String name) throws IOException {
        Class<?> model = MODEL_BY_FIXTURE.getOrDefault(name, Invoice.class);

        try (InputStream body = PublishedFixturesTest.class.getResourceAsStream(FIXTURES_DIR + name)) {
            assertNotNull(body, name);
            assertNotNull(MAPPER.readValue(body, model));
        }
    }

    @Test
    void payrollDateWithoutTimeIsReadAsStartOfDay() throws IOException {
        Invoice invoice = readFixture("nomina-ordinaria-valores.json", Invoice.class);

        assertEquals(LocalDateTime.of(2025, 7, 31, 0, 0), invoice.getComplement().getPayroll().getInitialPaymentDate());
        assertEquals(LocalDateTime.of(2025, 8, 30, 0, 0), invoice.getComplement().getPayroll().getPaymentDate());
    }

    private static <T> T readFixture(String name, Class<T> type) throws IOException {
        try (InputStream body = PublishedFixturesTest.class.getResourceAsStream(FIXTURES_DIR + name)) {
            assertNotNull(body, name);
            return MAPPER.readValue(body, type);
        }
    }
}
