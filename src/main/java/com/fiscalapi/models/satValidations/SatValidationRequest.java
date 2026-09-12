package com.fiscalapi.models.satValidations;

import com.fiscalapi.common.SerializableDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Solicitud de validaciones SAT (POST /api/{apiVersion}/sat-validations).
 *
 * <p>Se envía {@code xml} o {@code tin}, nunca ambos y nunca ninguno: con {@code xml} se puede
 * solicitar cualquier tipo de validación, y con {@code tin} (RFC) únicamente listas negras
 * ({@code sat.blacklist.69b} y {@code sat.blacklist.69bbis}).</p>
 *
 * <p>Cada tipo solicitado consume un crédito de validación. El cobro es todo o nada y ocurre antes
 * de ejecutar: si el saldo no alcanza para todos, no se ejecuta ninguno y la API responde 403.</p>
 */
public class SatValidationRequest extends SerializableDto {

    private String xml;
    private String tin;
    private List<String> validationTypes = new ArrayList<>();

    /**
     * CFDI timbrado completo codificado en base64. Opcional y excluyente con {@code tin}.
     *
     * @return El CFDI en base64
     */
    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    /**
     * RFC a consultar en listas negras. Opcional y excluyente con {@code xml}.
     *
     * @return El RFC a consultar
     */
    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    /**
     * Ids de los tipos de validación a ejecutar (ver {@link SatValidationTypeIds}). Obligatorio,
     * sin elementos vacíos ni duplicados.
     *
     * @return Los ids de los tipos de validación a ejecutar
     */
    public List<String> getValidationTypes() {
        return validationTypes;
    }

    public void setValidationTypes(List<String> validationTypes) {
        this.validationTypes = validationTypes;
    }
}
