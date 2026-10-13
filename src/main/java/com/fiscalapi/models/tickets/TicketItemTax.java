package com.fiscalapi.models.tickets;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.common.SerializableDto;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;

/**
 * Impuesto de un concepto del ticket. La tasa se envía tal cual (como texto, con su escala): constrúyala desde un
 * String, por ejemplo {@code new BigDecimal("0.160000")}.
 */
public class TicketItemTax extends SerializableDto {

    private String taxCode;
    private String taxTypeCode;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal taxRate;
    private String taxFlagCode;

    /**
     * @return Impuesto: 001 (ISR), 002 (IVA) o 003 (IEPS)
     */
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    /**
     * @return Tipo de factor: Tasa, Cuota o Exento
     */
    public String getTaxTypeCode() {
        return taxTypeCode;
    }

    public void setTaxTypeCode(String taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    /**
     * @return Tasa o cuota
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return T (traslado) o R (retención)
     */
    public String getTaxFlagCode() {
        return taxFlagCode;
    }

    public void setTaxFlagCode(String taxFlagCode) {
        this.taxFlagCode = taxFlagCode;
    }
}
