package com.fiscalapi.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Tipo de crédito que mueve una transacción del ledger de timbres. Los saldos nunca se mezclan:
 * STAMP afecta el saldo de timbres (availableBalance) y VALIDATION el de créditos de validación
 * SAT (availableValidationBalance).
 *
 * <p>La API lo representa como entero, por eso cada constante lleva su valor explícito.</p>
 */
public enum CreditType {
    STAMP(1),
    VALIDATION(2);

    private final int value;

    CreditType(int value) {
        this.value = value;
    }

    /**
     * @return El entero con el que la API representa este tipo de crédito
     */
    @JsonValue
    public int getValue() {
        return value;
    }

    /**
     * Resuelve el tipo de crédito a partir del entero que devuelve la API.
     *
     * @param value Entero recibido en la respuesta
     * @return El tipo correspondiente, o null si el entero no corresponde a ninguno conocido
     */
    @JsonCreator
    public static CreditType fromValue(int value) {
        for (CreditType creditType : values()) {
            if (creditType.value == value) {
                return creditType;
            }
        }
        return null;
    }
}
