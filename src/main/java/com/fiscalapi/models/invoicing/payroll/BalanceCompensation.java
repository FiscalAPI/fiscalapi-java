package com.fiscalapi.models.invoicing.payroll;

import com.fiscalapi.common.CatalogDto;
import java.math.BigDecimal;

public class BalanceCompensation extends CatalogDto {
    private BigDecimal favorableBalance;
    private int year;
    private BigDecimal remainingFavorableBalance;

    public BigDecimal getRemainingFavorableBalance() {
        return remainingFavorableBalance;
    }

    public void setRemainingFavorableBalance(BigDecimal remainingFavorableBalance) {
        this.remainingFavorableBalance = remainingFavorableBalance;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getFavorableBalance() {
        return favorableBalance;
    }

    public void setFavorableBalance(BigDecimal favorableBalance) {
        this.favorableBalance = favorableBalance;
    }
}
