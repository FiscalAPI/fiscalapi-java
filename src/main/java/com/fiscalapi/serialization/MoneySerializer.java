package com.fiscalapi.serialization;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.fasterxml.jackson.databind.JsonSerializer;

public class MoneySerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, com.fasterxml.jackson.core.JsonGenerator gen,
            com.fasterxml.jackson.databind.SerializerProvider serializers) throws java.io.IOException {
        if (value == null) {
            gen.writeNull();
        } else {
            DecimalFormat df = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.US));
            String formattedValue = df.format(value);
            gen.writeString(formattedValue);
        }
    }
}
