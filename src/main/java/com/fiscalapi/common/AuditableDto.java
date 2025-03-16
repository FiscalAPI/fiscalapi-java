package com.fiscalapi.common;

import java.time.LocalDateTime;

public class AuditableDto extends  SerializableDto {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
