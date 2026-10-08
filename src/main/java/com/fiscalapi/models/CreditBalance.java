package com.fiscalapi.models;

/**
 * Saldo de una persona para un tipo de crédito (Person.balances). Un tipo ausente tiene saldo 0.
 *
 * <p>creditType es el entero del API (1 timbres, 2 créditos de validación; ver {@link CreditType}). Se modela como
 * Integer para conservar el número de un tipo que este SDK todavía no conoce.</p>
 */
public class CreditBalance {
    private Integer creditType;
    private Integer available;

    /**
     * @return El entero del tipo de crédito
     */
    public Integer getCreditType() {
        return creditType;
    }

    /**
     * @param creditType El entero del tipo de crédito
     */
    public void setCreditType(Integer creditType) {
        this.creditType = creditType;
    }

    /**
     * @return Saldo disponible
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * @param available Saldo disponible
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }
}
