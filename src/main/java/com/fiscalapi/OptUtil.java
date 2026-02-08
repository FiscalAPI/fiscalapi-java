package com.fiscalapi;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import static com.fiscalapi.models.invoicing.InvoiceConstants.SAT_DATE_FORMAT_IN;

public class OptUtil {
    public static LocalDateTime formatInputDateToSATFormat(String stringDate) {
        LocalDateTime parsedDate = LocalDateTime.MIN;
        if (stringDate == null || stringDate.isEmpty()) {
            return parsedDate;
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
                throw new IllegalArgumentException("Formato de fecha inválido: " + stringDate +
                        " (debe ser compatible con el formato yyyy-MM-ddTHH:mm:ss)", e);
            }
        }
        return parsedDate;
    }
}
