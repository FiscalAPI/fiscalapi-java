package com.fiscalapi;

import com.fiscalapi.models.PersonListFilters;
import com.fiscalapi.models.ProductListFilters;
import com.fiscalapi.models.invoicing.InvoiceListFilters;
import com.fiscalapi.models.invoicing.InvoiceListOrder;
import com.fiscalapi.services.InvoiceService;
import com.fiscalapi.services.PersonService;
import com.fiscalapi.services.ProductService;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Filtros de las listas de facturas, personas y productos (GET /api/v4/invoices, /people y /products): cada filtro
 * asignado viaja en camelCase y codificado, uno en null no se envía, y sin filtros (o con null) la URL no lleva query.
 * La sobrecarga getList(pageNumber, pageSize) sigue igual.
 */
class ListFiltersTest {

    private static final String EMPTY_PAGE = "{\"data\":{\"items\":[],\"pageNumber\":1,\"totalPages\":0,\"totalCount\":0,"
            + "\"hasPreviousPage\":false,\"hasNextPage\":false},\"succeeded\":true,\"message\":\"\",\"details\":\"\","
            + "\"httpStatusCode\":200}";

    private static final String INVOICES_URL = FakeApi.BASE_URL + "/api/v4/invoices";
    private static final String PEOPLE_URL = FakeApi.BASE_URL + "/api/v4/people";
    private static final String PRODUCTS_URL = FakeApi.BASE_URL + "/api/v4/products";

    private FakeApi api;

    @BeforeEach
    void setUp() {
        api = new FakeApi();
        api.respondWith(EMPTY_PAGE);
    }

    private InvoiceService invoices() {
        return new InvoiceService(api.httpClient(), api.settings());
    }

    private PersonService persons() {
        return new PersonService(api.httpClient(), api.settings());
    }

    private ProductService products() {
        return new ProductService(api.httpClient(), api.settings());
    }

    private FakeApi.RecordedRequest singleRequest() {
        assertEquals(1, api.requests().size());
        return api.requests().get(0);
    }

    @Test
    void invoicesSendEveryFilterInTheContractOrder() {
        InvoiceListFilters filters = new InvoiceListFilters();
        filters.setFrom(LocalDate.of(2026, 9, 1));
        filters.setTo(LocalDate.of(2026, 9, 30));
        filters.setIssuerTin("EKU9003173C9");
        filters.setRecipientTin("FUNK671228PH6");
        filters.setTypeCode("I");
        filters.setStatusId("V");
        filters.setSeries("SDK-F");
        filters.setNumber("1001");
        filters.setUuid("5f2c7a1e-0000-4000-8000-0000000000c3");
        filters.setOrder(InvoiceListOrder.DESC);
        filters.setPageNumber(2);
        filters.setPageSize(50);

        invoices().getList(filters);

        FakeApi.RecordedRequest request = singleRequest();
        assertEquals("GET", request.method);
        assertEquals(INVOICES_URL + "?from=2026-09-01&to=2026-09-30&issuerTin=EKU9003173C9"
                + "&recipientTin=FUNK671228PH6&typeCode=I&statusId=V&series=SDK-F&number=1001"
                + "&uuid=5f2c7a1e-0000-4000-8000-0000000000c3&order=desc&pageNumber=2&pageSize=50", request.url);
        assertNull(request.body);
    }

    @Test
    void invoicesSendOnlyTheAssignedFilters() {
        InvoiceListFilters filters = new InvoiceListFilters();
        filters.setStatusId("X");
        filters.setOrder(InvoiceListOrder.ASC);

        invoices().getList(filters);

        assertEquals(INVOICES_URL + "?statusId=X&order=asc", singleRequest().url);
    }

    @Test
    void invoicesWithoutFiltersSendNoQuery() {
        invoices().getList(new InvoiceListFilters());
        invoices().getList((InvoiceListFilters) null);

        assertEquals(2, api.requests().size());
        for (FakeApi.RecordedRequest request : api.requests()) {
            assertEquals(INVOICES_URL, request.url);
        }
    }

    @Test
    void invoicesPageOverloadIsUnchanged() {
        invoices().getList(1, 10);

        HttpUrl url = HttpUrl.get(singleRequest().url);
        assertEquals("/api/v4/invoices", url.encodedPath());
        assertEquals("1", url.queryParameter("PageNumber"));
        assertEquals("10", url.queryParameter("PageSize"));
        assertEquals(2, url.querySize());
    }

    @Test
    void personsSendSearchUserTypeAndPageEncoded() {
        PersonListFilters filters = new PersonListFilters();
        filters.setSearch("Ana María & Co");
        filters.setUserTypeId("C");
        filters.setPageNumber(1);
        filters.setPageSize(20);

        persons().getList(filters);

        assertEquals(PEOPLE_URL + "?search=Ana+Mar%C3%ADa+%26+Co&userTypeId=C&pageNumber=1&pageSize=20",
                singleRequest().url);
    }

    @Test
    void personsSendOnlyTheAssignedFilters() {
        PersonListFilters filters = new PersonListFilters();
        filters.setUserTypeId("U");

        persons().getList(filters);

        assertEquals(PEOPLE_URL + "?userTypeId=U", singleRequest().url);
    }

    @Test
    void personsWithoutFiltersSendNoQuery() {
        persons().getList((PersonListFilters) null);

        assertEquals(PEOPLE_URL, singleRequest().url);
    }

    @Test
    void productsSendSearchAndPage() {
        ProductListFilters filters = new ProductListFilters();
        filters.setSearch("01010101");
        filters.setPageNumber(3);
        filters.setPageSize(5);

        products().getList(filters);

        assertEquals(PRODUCTS_URL + "?search=01010101&pageNumber=3&pageSize=5", singleRequest().url);
    }

    @Test
    void productsWithoutFiltersSendNoQuery() {
        products().getList(new ProductListFilters());

        assertEquals(PRODUCTS_URL, singleRequest().url);
    }
}
