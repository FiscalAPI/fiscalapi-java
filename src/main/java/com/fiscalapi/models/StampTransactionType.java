package com.fiscalapi.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Tipo de movimiento en el ledger de timbres. La API lo representa como entero, por eso cada
 * constante lleva su valor explícito en lugar de depender del orden de declaración.
 */
public enum StampTransactionType {
    PURCHASE(1),
    TRANSFER(2),
    CONSUMPTION(3),
    AUTOINVOICE(4),
    ROLLBACK(5);

    private final int value;

    StampTransactionType(int value) {
        this.value = value;
    }

    /**
     * @return El entero con el que la API representa este tipo de movimiento
     */
    @JsonValue
    public int getValue() {
        return value;
    }

    /**
     * Resuelve el tipo de movimiento a partir del entero que devuelve la API.
     *
     * @param value Entero recibido en la respuesta
     * @return El tipo correspondiente, o null si el entero no corresponde a ninguno conocido
     */
    @JsonCreator
    public static StampTransactionType fromValue(int value) {
        for (StampTransactionType transactionType : values()) {
            if (transactionType.value == value) {
                return transactionType;
            }
        }
        return null;
    }
}
