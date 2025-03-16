package com.fiscalapi.models.invoicing;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class InvoiceConstants {
    // Formato para serialización (siempre debe ser exactamente yyyy-MM-ddTHH:mm:ss)
    public static final DateTimeFormatter SAT_DATE_FORMAT_OUT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    // Formato flexible para deserialización (soporta varios formatos de entrada)
    public static final DateTimeFormatter SAT_DATE_FORMAT_IN = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
            .optionalStart()
            .appendFraction(ChronoField.NANO_OF_SECOND, 0, 7, true)
            .optionalEnd()
            .optionalStart()
            .appendOffset("+HH:MM", "Z")
            .optionalEnd()
            .toFormatter();
}
