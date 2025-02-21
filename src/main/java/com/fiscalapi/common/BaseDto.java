package com.fiscalapi.common;

public class BaseDto extends AuditableDto {
    private String id;
    public String getId() { return id; }

    @Override
    public String toString() {
        return "BaseDto{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
