package com.fiscalapi.common;

public class CatalogDto extends BaseDto {
    private String description;
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "CatalogDto{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }
}


