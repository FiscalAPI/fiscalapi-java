package com.fiscalapi.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Lee un LocalDateTime con o sin fraccion de segundos, o solo con fecha (la fecha sola se lee como medianoche), porque la
 * API publica esos formatos. La serializacion la siguen decidiendo las anotaciones de cada propiedad.
 */
public class FlexibleLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {


    public FlexibleLocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String text = parser.getValueAsString();
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        String value = text.trim();

        LocalDateTime parsed = tryParseDateTime(value);
        if (parsed != null) {
            return parsed;
        }
        LocalDate date = tryParseDate(value);
        if (date != null) {
            return date.atStartOfDay();
        }
        throw context.weirdStringException(value, LocalDateTime.class,
                "se esperaba yyyy-MM-dd'T'HH:mm[:ss[.fraccion]] o yyyy-MM-dd");
    }

    private static LocalDateTime tryParseDateTime(String value) {
        try {
            return LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private static LocalDate tryParseDate(String value) {
        try {
            return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
