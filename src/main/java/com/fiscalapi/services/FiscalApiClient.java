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
    private final IApiKeyService apiKeyService;
    private final ITaxFileService taxFileService;
    private final ICatalogService catalogService;
    // etc.

    private FiscalApiClient(FiscalApiSettings settings) {
        validateSettings(settings);

        // http clients
        OkHttpClient okHttpClient = OkHttpClientFactory.createClient(settings);
        FiscalApiHttpClient httpClient = new FiscalApiHttpClient(okHttpClient, settings);

        // Inicializar servicios
        this.invoiceService = new InvoiceService(httpClient, settings);
        this.productService = new ProductService(httpClient, settings);
        this.personService = new PersonService(httpClient, settings);
        this.apiKeyService = new ApiKeyService(httpClient, settings);
        this.taxFileService = new TaxFileService(httpClient, settings);
        this.catalogService = new CatalogService(httpClient, settings);


        // ...
    }

    public static FiscalApiClient create(FiscalApiSettings settings) {
        return new FiscalApiClient(settings);
    }

    @Override
    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }

    @Override
    public IProductService getProductService() {
        return productService;
    }

    @Override
    public IPersonService getPersonService() {
        return personService;
    }

    @Override
    public IApiKeyService getApiKeyService() {
        return apiKeyService;
    }

    @Override
    public ITaxFileService getTaxFileService() {
        return taxFileService;
    }

    @Override
    public ICatalogService getCatalogService() {
        return catalogService;
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
