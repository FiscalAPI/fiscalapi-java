package com.fiscalapi.models.invoicing;

// Información global en caso de factura global
public class GlobalInformation {
    private String periodicityCode;
    private String monthCode;
    private Integer year;

    public String getPeriodicityCode() {
        return periodicityCode;
    }
    public void setPeriodicityCode(String periodicityCode) {
        this.periodicityCode = periodicityCode;
    }
    public String getMonthCode() {
        return monthCode;
    }
    public void setMonthCode(String monthCode) {
        this.monthCode = monthCode;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
}
