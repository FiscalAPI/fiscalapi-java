package com.fiscalapi.models.invoicing;

// Facturas relacionadas (por ejemplo, nota de crédito)
public class RelatedInvoice {
    private String relationshipTypeCode;
    private String uuid;

    public String getRelationshipTypeCode() {
        return relationshipTypeCode;
    }
    public void setRelationshipTypeCode(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}