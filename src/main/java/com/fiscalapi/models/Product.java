package com.fiscalapi.models;

import com.fiscalapi.common.AuditableDto;
import com.fiscalapi.common.BaseDto;
import com.fiscalapi.common.CatalogDto;
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representa un producto o servicio con toda su información, incluyendo precios,
 * catálogos del SAT y los impuestos aplicables.
 * <p>
 * Los valores de catálogo tienen un valor por defecto en caso de no ser especificados:
 * <ul>
 *   <li><code>satUnitMeasurementId</code>: "H87"</li>
 *   <li><code>satTaxObjectId</code>: "02"</li>
 *   <li><code>satProductCodeId</code>: "01010101"</li>
 * </ul>
 * </p>
 *
 * <p>Esta clase extiende de {@link BaseDto} que a su vez extiende de {@link AuditableDto}.</p>
 *
 * @see BaseDto
 * @see AuditableDto
 * @see CatalogDto
 */
public class Product extends BaseDto {

    /**
     * Descripción o nombre del producto (requerido).
     */
    private String description;

    /**
     * Precio unitario del producto sin impuestos (requerido).
     */
    private BigDecimal unitPrice;

    /**
     * Código de la unidad de medida. Catálogo del SAT c_ClaveUnidad.
     * Valor por defecto: "H87".
     */
    @JsonProperty(defaultValue = "H87")
    private String satUnitMeasurementId;

    /**
     * Objeto expandido del catálogo de unidad de medida.
     */
    private CatalogDto satUnitMeasurement;

    /**
     * Código que identifica las obligaciones fiscales del producto. Catálogo del SAT c_ObjetoImp.
     * Valor por defecto: "02".
     */
    @JsonProperty(defaultValue = "02")
    private String satTaxObjectId;

    /**
     * Objeto expandido del catálogo de obligaciones fiscales.
     */
    private CatalogDto satTaxObject;

    /**
     * Código del producto o servicio. Catálogo del SAT c_ClaveProdServ.
     * Valor por defecto: "01010101".
     */
    @JsonProperty(defaultValue = "01010101")
    private String satProductCodeId;

    /**
     * Objeto expandido del catálogo del código del producto.
     */
    private CatalogDto satProductCode;

    /**
     * Impuestos aplicables al producto.
     */
    private List<ProductTax> productTaxes;

    /**
     * Constructor por defecto.
     */
    public Product() {
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return la descripción del producto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param description la descripción a establecer.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el precio unitario del producto sin impuestos.
     *
     * @return el precio unitario.
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Establece el precio unitario del producto sin impuestos.
     *
     * @param unitPrice el precio unitario a establecer.
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Obtiene el código de la unidad de medida (SAT).
     *
     * @return el código de unidad de medida.
     */
    public String getSatUnitMeasurementId() {
        return satUnitMeasurementId;
    }

    /**
     * Establece el código de la unidad de medida (SAT).
     *
     * @param satUnitMeasurementId el código a establecer.
     */
    public void setSatUnitMeasurementId(String satUnitMeasurementId) {
        this.satUnitMeasurementId = satUnitMeasurementId;
    }

    /**
     * Obtiene el objeto del catálogo de unidad de medida.
     *
     * @return el catálogo de unidad de medida.
     */
    public CatalogDto getSatUnitMeasurement() {
        return satUnitMeasurement;
    }

    /**
     * Establece el objeto del catálogo de unidad de medida.
     *
     * @param satUnitMeasurement el catálogo a establecer.
     */
    public void setSatUnitMeasurement(CatalogDto satUnitMeasurement) {
        this.satUnitMeasurement = satUnitMeasurement;
    }

    /**
     * Obtiene el código que identifica las obligaciones fiscales del producto (SAT).
     *
     * @return el código de obligaciones fiscales.
     */
    public String getSatTaxObjectId() {
        return satTaxObjectId;
    }

    /**
     * Establece el código que identifica las obligaciones fiscales del producto (SAT).
     *
     * @param satTaxObjectId el código a establecer.
     */
    public void setSatTaxObjectId(String satTaxObjectId) {
        this.satTaxObjectId = satTaxObjectId;
    }

    /**
     * Obtiene el objeto expandido del catálogo de obligaciones fiscales.
     *
     * @return el catálogo de obligaciones fiscales.
     */
    public CatalogDto getSatTaxObject() {
        return satTaxObject;
    }

    /**
     * Establece el objeto expandido del catálogo de obligaciones fiscales.
     *
     * @param satTaxObject el catálogo a establecer.
     */
    public void setSatTaxObject(CatalogDto satTaxObject) {
        this.satTaxObject = satTaxObject;
    }

    /**
     * Obtiene el código del producto o servicio (SAT).
     *
     * @return el código del producto o servicio.
     */
    public String getSatProductCodeId() {
        return satProductCodeId;
    }

    /**
     * Establece el código del producto o servicio (SAT).
     *
     * @param satProductCodeId el código a establecer.
     */
    public void setSatProductCodeId(String satProductCodeId) {
        this.satProductCodeId = satProductCodeId;
    }

    /**
     * Obtiene el objeto expandido del catálogo del código del producto.
     *
     * @return el catálogo del código del producto.
     */
    public CatalogDto getSatProductCode() {
        return satProductCode;
    }

    /**
     * Establece el objeto expandido del catálogo del código del producto.
     *
     * @param satProductCode el catálogo a establecer.
     */
    public void setSatProductCode(CatalogDto satProductCode) {
        this.satProductCode = satProductCode;
    }

    /**
     * Obtiene la lista de impuestos aplicables al producto.
     *
     * @return la lista de {@link ProductTax}.
     */
    public List<ProductTax> getProductTaxes() {
        return productTaxes;
    }

    /**
     * Establece la lista de impuestos aplicables al producto.
     *
     * @param productTaxes la lista de impuestos a establecer.
     */
    public void setProductTaxes(List<ProductTax> productTaxes) {
        this.productTaxes = productTaxes;
    }

}
