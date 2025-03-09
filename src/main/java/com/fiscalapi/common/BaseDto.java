package com.fiscalapi.common;

public class BaseDto extends AuditableDto {
    private String id;
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
