package com.fiscalapi;


import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.services.FiscalApiClient;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Product: %s\n","Hello Fiscalapi!");

        // TENANT: e839651d-1765-4cd0-ba7f-547a4c20580f
        // KARLA ID: 3f3478b4-60fd-459e-8bfc-f8239fc96257   :KEY: sk_development_71a2d1ff_25c6_4063_aee8_a5da7d0b9967
        // ESCUELA ID: 96b46762-d246-4a67-a562-510a25dbafa9 :KEY sk_development_833a58f9_8212_43ce_b544_f2fa93b1e895

        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setApiUrl("https://localhost:7173");
        settings.setApiKey("sk_development_71a2d1ff_25c6_4063_aee8_a5da7d0b9967");
        settings.setTenant("e839651d-1765-4cd0-ba7f-547a4c20580f");

        FiscalApiClient client = FiscalApiClient.create(settings);


        client.getProductService().getByIdAsync("114a4be5-fb65-40b2-a762-ff0c55c6ebfa", false)
                .thenAccept(response -> {
                System.out.printf("apiResponse: %s\n", response.toString());
        });

        System.out.printf("Product: %s\n","End Fiscalapi!");
    }
}