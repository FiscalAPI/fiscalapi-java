package com.fiscalapi.services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Query string de los filtros de una lista: solo los valores asignados (un null no se envía), codificados y en el orden
 * en que se agregan. La comparten las listas con filtros (tickets, facturas, personas y productos).
 */
final class ListQuery {

    private final List<String> pairs = new ArrayList<>();

    /**
     * Agrega key=value si el valor no es null. LocalDate.toString() es ISO yyyy-MM-dd, el formato de from y to.
     */
    ListQuery add(String key, Object value) {
        if (value != null) {
            pairs.add(key + "=" + encode(value.toString()));
        }
        return this;
    }

    /**
     * @return El endpoint con la query string, o el endpoint tal cual si no se agregó ningún valor
     */
    String appendTo(String endpoint) {
        return pairs.isEmpty() ? endpoint : endpoint + "?" + String.join("&", pairs);
    }

    private static String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            // UTF-8 siempre existe en la JVM.
            throw new IllegalStateException(e);
        }
    }
}
