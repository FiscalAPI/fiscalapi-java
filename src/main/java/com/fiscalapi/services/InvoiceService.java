package com.fiscalapi.services;

import com.fiscalapi.abstractions.BaseFiscalApiService;
import com.fiscalapi.abstractions.IFiscalApiHttpClient;
import com.fiscalapi.abstractions.IInvoiceService;
import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.invoicing.*;

public class InvoiceService extends BaseFiscalApiService<Invoice> implements IInvoiceService {

    public InvoiceService(IFiscalApiHttpClient httpClient, FiscalApiSettings settings) {
        super(httpClient, settings, "invoices", settings.getApiVersion());
    }

    @Override
    protected Class<Invoice> getTypeParameterClass() {
        return Invoice.class;
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
        return httpClient.post(buildEndpoint("", null), model, Invoice.class);
    }
}