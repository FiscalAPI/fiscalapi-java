package com.fiscalapi.models.invoicing.payroll;

import java.math.BigDecimal;

public class PayrollStockOptions {
    private BigDecimal marketPrice;
    private BigDecimal grantPrice;

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = new BigDecimal(marketPrice);
    }

    public BigDecimal getGrantPrice() {
        return grantPrice;
    }
    
    public void setGrantPrice(String grantPrice) {
        this.grantPrice = new BigDecimal(grantPrice);
    }
}
