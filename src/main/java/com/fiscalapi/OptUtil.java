package com.fiscalapi;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_IN;

public class OptUtil {
    public static LocalDateTime parseLocalDateTime(String stringDate) {
        LocalDateTime parsedDate = null;
        if (stringDate == null || stringDate.isEmpty()) {
            throw new IllegalArgumentException("Fecha no puede ser nula o vacía");
        }

        try {
            // Intenta primero parsearlo como LocalDateTime
            parsedDate = LocalDateTime.parse(stringDate, SAT_DATE_FORMAT_IN);
        } catch (DateTimeParseException e) {
            try {
                // Si falla, intenta parsearlo como ZonedDateTime y convertirlo a LocalDateTime
                ZonedDateTime zdt = ZonedDateTime.parse(stringDate);
                parsedDate = zdt.toLocalDateTime();
            } catch (DateTimeParseException e2) {
                throw new DateTimeParseException("Fecha en formato no reconocido: " + stringDate, stringDate, 0, null);
            }
        }
        return parsedDate;
    }

    public static BigDecimal parseBigDecimal(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Valor numérico inválido: " + value);
        }
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor numérico inválido: " + value, e);
        }
    }
}
