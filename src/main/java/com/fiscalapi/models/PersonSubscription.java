package com.fiscalapi.models;

import com.fiscalapi.common.SerializableDto;

/**
 * La suscripción que otorga los features del tenant ({@link PersonFeatures#getSubscription()}).
 */
public class PersonSubscription extends SerializableDto {

    private String status;
    private Boolean isAvailable;

    /**
     * @return Estado de la suscripción (active, trialing o past_due), o null si ninguna otorga features
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return false si no se pudieron leer los features del tenant (o la persona no tiene roles)
     */
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
