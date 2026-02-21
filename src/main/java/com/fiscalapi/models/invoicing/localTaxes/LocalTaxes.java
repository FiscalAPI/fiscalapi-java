package com.fiscalapi.models.invoicing.localTaxes;

import java.util.List;

public class LocalTaxes {
    private List<LocalTax> taxes;

    public List<LocalTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<LocalTax> taxes) {
        this.taxes = taxes;
    }
}
