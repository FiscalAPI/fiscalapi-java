package com.fiscalapi.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Estado de un movimiento en el ledger de timbres. La API lo representa como entero, por eso cada
 * constante lleva su valor explícito en lugar de depender del orden de declaración.
 */
public enum StampTransactionStatus {
    COMPLETED(1),
    CANCELLED(2),
    ROLLEDBACK(3);

    private final int value;

    StampTransactionStatus(int value) {
        this.value = value;
    }

    /**
     * @return El entero con el que la API representa este estado
     */
    @JsonValue
    public int getValue() {
        return value;
    }

    /**
     * Resuelve el estado a partir del entero que devuelve la API.
     *
     * @param value Entero recibido en la respuesta
     * @return El estado correspondiente, o null si el entero no corresponde a ninguno conocido
     */
    @JsonCreator
    public static StampTransactionStatus fromValue(int value) {
        for (StampTransactionStatus transactionStatus : values()) {
            if (transactionStatus.value == value) {
                return transactionStatus;
            }
        }
        return null;
    }
}
