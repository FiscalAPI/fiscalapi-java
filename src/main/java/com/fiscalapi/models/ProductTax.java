package com.fiscalapi.models;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.common.CatalogDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fiscalapi.serialization.MoneySerializer;

import java.math.BigDecimal;

/**
 * Representa la información de un impuesto aplicado a un producto, incluyendo la tasa,
 * el código de impuesto y la información de catálogos expandidos para el impuesto, la
 * naturaleza del impuesto y el tipo de impuesto.
 *
 * <p>
 * Los campos {@code taxId}, {@code taxFlagId} y {@code taxTypeId} contienen los códigos
 * según el catálogo del SAT con los siguientes valores permitidos:
 * <ul>
 *   <li><strong>taxId</strong>: "001", "002", "003"</li>
 *   <li><strong>taxFlagId</strong>: "T", "R"</li>
 *   <li><strong>taxTypeId</strong>: "Tasa", "Cuota", "Exento"</li>
 * </ul>
 *
 * @see CatalogDto
 */
public class ProductTax extends BaseDto {

    /**
     * Identificador del producto asociado a este impuesto.
     */
    private String productId;


    /**
     * Tasa del impuesto. El valor debe estar entre 0.00000 y 1.000000 (ej: 0.160000).
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal rate;

    /**
     * Código del impuesto según el catálogo del SAT (valores: "001", "002", "003").
     */
    private String taxId;

    /**
     * Objeto expandido del catálogo del impuesto.
     */
    private CatalogDto tax;

    /**
     * Código que identifica la naturaleza del impuesto (valores: "T", "R").
     */
    private String taxFlagId;

    /**
     * Objeto expandido del catálogo de la naturaleza del impuesto.
     */
    private CatalogDto taxFlag;

    /**
     * Código que identifica el tipo de impuesto (valores: "Tasa", "Cuota", "Exento").
     */
    private String taxTypeId;

    /**
     * Objeto expandido del catálogo del tipo de impuesto.
     */
    private CatalogDto taxType;

    /**
     * Constructor por defecto.
     */
    public ProductTax() {
    }


    /**
     * Obtiene el identificador del producto asociado a este impuesto.
     *
     * @return el identificador del producto.
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Establece el identificador del producto asociado a este impuesto.
     *
     * @param productId el identificador del producto a establecer.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Obtiene la tasa del impuesto.
     *
     * @return la tasa del impuesto.
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Establece la tasa del impuesto.
     *
     * @param rate la tasa a establecer.
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * Obtiene el código del impuesto.
     *
     * @return el código del impuesto.
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Establece el código del impuesto.
     *
     * @param taxId el código a establecer.
     */
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * Obtiene el objeto expandido del catálogo del impuesto.
     *
     * @return el catálogo del impuesto.
     */
    public CatalogDto getTax() {
        return tax;
    }

    /**
     * Establece el objeto expandido del catálogo del impuesto.
     *
     * @param tax el catálogo a establecer.
     */
    public void setTax(CatalogDto tax) {
        this.tax = tax;
    }

    /**
     * Obtiene el código que identifica la naturaleza del impuesto.
     *
     * @return el código de la naturaleza del impuesto.
     */
    public String getTaxFlagId() {
        return taxFlagId;
    }

    /**
     * Establece el código que identifica la naturaleza del impuesto.
     *
     * @param taxFlagId el código a establecer.
     */
    public void setTaxFlagId(String taxFlagId) {
        this.taxFlagId = taxFlagId;
    }

    /**
     * Obtiene el objeto expandido del catálogo de la naturaleza del impuesto.
     *
     * @return el catálogo de la naturaleza del impuesto.
     */
    public CatalogDto getTaxFlag() {
        return taxFlag;
    }

    /**
     * Establece el objeto expandido del catálogo de la naturaleza del impuesto.
     *
     * @param taxFlag el catálogo a establecer.
     */
    public void setTaxFlag(CatalogDto taxFlag) {
        this.taxFlag = taxFlag;
    }

    /**
     * Obtiene el código que identifica el tipo de impuesto.
     *
     * @return el código del tipo de impuesto.
     */
    public String getTaxTypeId() {
        return taxTypeId;
    }

    /**
     * Establece el código que identifica el tipo de impuesto.
     *
     * @param taxTypeId el código a establecer.
     */
    public void setTaxTypeId(String taxTypeId) {
        this.taxTypeId = taxTypeId;
    }

    /**
     * Obtiene el objeto expandido del catálogo del tipo de impuesto.
     *
     * @return el catálogo del tipo de impuesto.
     */
    public CatalogDto getTaxType() {
        return taxType;
    }

    /**
     * Establece el objeto expandido del catálogo del tipo de impuesto.
     *
     * @param taxType el catálogo a establecer.
     */
    public void setTaxType(CatalogDto taxType) {
        this.taxType = taxType;
    }


}
