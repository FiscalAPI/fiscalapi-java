package com.fiscalapi.models.invoicing.payroll;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.OptUtil;
import com.fiscalapi.serialization.MoneySerializer;

import java.math.BigDecimal;

public class PayrollStockOptions {
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal marketPrice;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal grantPrice;

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = OptUtil.parseBigDecimal(marketPrice);
    }

    public BigDecimal getGrantPrice() {
        return grantPrice;
    }
    
    public void setGrantPrice(String grantPrice) {
        this.grantPrice = OptUtil.parseBigDecimal(grantPrice);
    }
}
