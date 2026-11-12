package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IInvoiceService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.invoicing.*;

import java.util.Collections;
import java.util.Map;

public class InvoiceService extends BaseFiscalApiService<Invoice> implements IInvoiceService {

    private static final String IDEMPOTENCY_KEY_HEADER = "Idempotency-Key";

    public InvoiceService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "invoices", settings.getApiVersion());
    }

    @Override
    protected Class<Invoice> getTypeParameterClass() {
        return Invoice.class;
    }

    @Override
    public ApiResponse<PagedList<Invoice>> getList(InvoiceListFilters filters) {
        return httpClient.getPagedList(toQuery(filters).appendTo(buildEndpoint("", null)), Invoice.class);
    }

    @Override
    public ApiResponse<InvoiceCancellationResponse> cancel(InvoiceCancellationRequest requestModel) {

        String endpoint = buildEndpoint("", null);
        return httpClient.delete(endpoint, requestModel, InvoiceCancellationResponse.class);
    }

    @Override
    public ApiResponse<InvoiceStatusResponse> status(InvoiceStatusRequest request) {

        String endpoint = buildEndpoint("status", null);

        return httpClient.post(endpoint, request, InvoiceStatusResponse.class);
    }

    @Override
    public ApiResponse<PdfResponse> getPdf(PdfRequest request) {

        String endpoint = buildEndpoint("pdf", null);

        return httpClient.post(endpoint, request, PdfResponse.class);
    }

    @Override
    public ApiResponse<Boolean> send(InvoiceEmailRequest request) {
        String endpoint = buildEndpoint("send", null);
        return httpClient.post(endpoint, request, Boolean.class);
    }

    @Override
    public ApiResponse<XmlResponse> getXml(String id) {

        //path = id/xml
        String path = id + "/xml";
        String endpoint = buildEndpoint(path, null);
        return  httpClient.get(endpoint, XmlResponse.class);
    }


    @Override
    public ApiResponse<Invoice> create(Invoice model) {
        return create(model, null);
    }

    @Override
    public ApiResponse<Invoice> create(Invoice model, String idempotencyKey) {
        Map<String, String> headers = idempotencyKey == null
                ? null
                : Collections.singletonMap(IDEMPOTENCY_KEY_HEADER, idempotencyKey);
        return httpClient.post(buildEndpoint("", null), model, Invoice.class, headers);
    }

    // Los filtros asignados, en el orden del contrato; los null no se envían.
    private static ListQuery toQuery(InvoiceListFilters filters) {
        ListQuery query = new ListQuery();
        if (filters == null) {
            return query;
        }
        return query
                .add("from", filters.getFrom())
                .add("to", filters.getTo())
                .add("issuerTin", filters.getIssuerTin())
                .add("recipientTin", filters.getRecipientTin())
                .add("typeCode", filters.getTypeCode())
                .add("statusId", filters.getStatusId())
                .add("series", filters.getSeries())
                .add("number", filters.getNumber())
                .add("uuid", filters.getUuid())
                .add("order", filters.getOrder() == null ? null : filters.getOrder().getValue())
                .add("pageNumber", filters.getPageNumber())
                .add("pageSize", filters.getPageSize());
    }
}