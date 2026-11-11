package com.fiscalapi.models;

import com.fiscalapi.common.SerializableDto;

import java.util.List;

/**
 * Un permiso negado ({@link PersonFeatures#getDenied()}): los features que le faltan al tenant.
 */
public class DeniedPermission extends SerializableDto {

    private List<String> missingFeatures;

    /**
     * @return Códigos de los features que le faltan al tenant
     */
    public List<String> getMissingFeatures() {
        return missingFeatures;
    }

    public void setMissingFeatures(List<String> missingFeatures) {
        this.missingFeatures = missingFeatures;
    }
}
