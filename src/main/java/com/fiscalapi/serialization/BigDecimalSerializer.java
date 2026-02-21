package com.fiscalapi.serialization;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.JsonSerializer;

public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, com.fasterxml.jackson.core.JsonGenerator gen,
            com.fasterxml.jackson.databind.SerializerProvider serializers) throws java.io.IOException {
        if (value == null) {
            gen.writeNull();
        } else {
            gen.writeString(value.toPlainString());
        }
    }
}
