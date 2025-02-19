package com.fiscalapi.services;

import com.fiscalapi.abstractions.*;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.http.FiscalApiHttpClient;
import com.fiscalapi.http.OkHttpClientFactory;
import okhttp3.OkHttpClient;

public class FiscalApiClient implements IFiscalApiClient {

    private final IInvoiceService invoiceService;
    private final IProductService productService;
    private final IPersonService personService;
    // etc.

    private FiscalApiClient(FiscalApiSettings settings) {
        validateSettings(settings);

        // Crear OkHttpClient
        OkHttpClient okHttpClient = OkHttpClientFactory.createClient(settings);

        // Crear la implementación de IFiscalApiHttpClient
        FiscalApiHttpClient httpClient = new FiscalApiHttpClient(okHttpClient);

        // Instanciar servicios concretos
        String apiVersion = settings.getApiVersion();
        this.invoiceService = new InvoiceService(httpClient, apiVersion);
        this.productService = new ProductService(httpClient, apiVersion);
        this.personService = new PersonService(httpClient, apiVersion);
        // ...
    }

    public static FiscalApiClient create(FiscalApiSettings settings) {
        return new FiscalApiClient(settings);
    }

    @Override
    public IInvoiceService getInvoices() {
        return invoiceService;
    }

    @Override
    public IProductService getProducts() {
        return productService;
    }

    @Override
    public IPersonService getPersons() {
        return personService;
    }

    // etc...

    private void validateSettings(FiscalApiSettings settings) {
        if (settings.getApiUrl() == null || settings.getApiUrl().isEmpty()) {
            throw new IllegalArgumentException("ApiUrl is required");
        }
        if (settings.getApiKey() == null || settings.getApiKey().isEmpty()) {
            throw new IllegalArgumentException("ApiKey is required");
        }
        if (settings.getTenant() == null || settings.getTenant().isEmpty()) {
            throw new IllegalArgumentException("Tenant is required");
        }
    }
}
