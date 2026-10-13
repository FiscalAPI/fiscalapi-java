package com.fiscalapi.models.tickets;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.common.SerializableDto;
import com.fiscalapi.serialization.BigDecimalSerializer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Concepto de un ticket, con los nombres de los conceptos de las facturas (sin terceros, aduanas, predial ni partes).
 * Los importes se envían tal cual (como texto, con su escala): constrúyalos desde un String.
 */
public class TicketItem extends SerializableDto {

    private String itemCode;
    private String itemSku;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal quantity;
    private String unitOfMeasurementCode;
    private String description;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal unitPrice;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal discount;
    private String taxObjectCode;
    private List<TicketItemTax> itemTaxes;

    /**
     * @return Clave de producto o servicio (c_ClaveProdServ)
     */
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return Número de identificación (SKU) del producto en el punto de venta
     */
    public String getItemSku() {
        return itemSku;
    }

    public void setItemSku(String itemSku) {
        this.itemSku = itemSku;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Clave de unidad (c_ClaveUnidad)
     */
    public String getUnitOfMeasurementCode() {
        return unitOfMeasurementCode;
    }

    public void setUnitOfMeasurementCode(String unitOfMeasurementCode) {
        this.unitOfMeasurementCode = unitOfMeasurementCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return Descuento del concepto; opcional
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * @return Objeto de impuesto (c_ObjetoImp): 02 exige impuestos; 01, 03, 04 y 05 no admiten
     */
    public String getTaxObjectCode() {
        return taxObjectCode;
    }

    public void setTaxObjectCode(String taxObjectCode) {
        this.taxObjectCode = taxObjectCode;
    }

    public List<TicketItemTax> getItemTaxes() {
        return itemTaxes;
    }

    public void setItemTaxes(List<TicketItemTax> itemTaxes) {
        this.itemTaxes = itemTaxes;
    }
}
