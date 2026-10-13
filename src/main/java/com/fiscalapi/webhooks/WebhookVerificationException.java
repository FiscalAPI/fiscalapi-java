package com.fiscalapi.webhooks;

/**
 * La entrega no se puede tratar como auténtica: falta un header de Standard Webhooks, ninguna firma coincide, el
 * timestamp está fuera de la tolerancia, el cuerpo no es texto UTF-8 válido o el cuerpo firmado no es un evento. El
 * receptor la rechaza (por ejemplo con un 400) y no la procesa.
 */
public class WebhookVerificationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WebhookVerificationException(String message) {
        super(message);
    }

    public WebhookVerificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
