package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;

public class PayrollStockOptions {
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal marketPrice;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal grantPrice;

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getGrantPrice() {
        return grantPrice;
    }
    
    public void setGrantPrice(BigDecimal grantPrice) {
        this.grantPrice = grantPrice;
    }
}
