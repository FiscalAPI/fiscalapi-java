package com.fiscalapi.models.invoicing;

/**
 * Modelo de envío de facturas por correo
 *
 * Este modelo se utiliza para enviar una factura por correo electrónico.
 * Contiene la información necesaria para el envío.
 *
 * Se puede enviar la factura (XML y PDF) por valores o por referencias:
 * - Por referencias: Solo se requieren los campos 'invoiceId' y 'toEmail', se aplicarán las reglas de reporte
 * - Por valores: Se deben pasar todos los campos para personalizar el PDF
 */
public class InvoiceEmailRequest {

    /**
     * ID de la factura para la cual se generará el PDF.
     * Campo requerido.
     */
    private String invoiceId;

    /**
     * Correo electrónico del destinatario.
     * Campo requerido.
     */
    private String toEmail;

    /**
     * Color de la banda del PDF en formato hexadecimal.
     * Por ejemplo: "#FFA500".
     * Campo opcional.
     */
    private String bandColor;

    /**
     * Color de la fuente del texto sobre la banda en formato hexadecimal.
     * Por ejemplo: "#FFFFFF".
     * Campo opcional.
     */
    private String fontColor;

    /**
     * Logotipo en formato base64 que se mostrará en el PDF.
     * Campo opcional.
     */
    private String base64Logo;

    // Constructores

    /**
     * Constructor por defecto
     */
    public InvoiceEmailRequest() {
    }

    /**
     * Constructor para envío por referencias
     *
     * @param invoiceId ID de la factura
     * @param toEmail Correo electrónico del destinatario
     */
    public InvoiceEmailRequest(String invoiceId, String toEmail) {
        this.invoiceId = invoiceId;
        this.toEmail = toEmail;
    }

    /**
     * Constructor completo para envío por valores
     *
     * @param invoiceId ID de la factura
     * @param toEmail Correo electrónico del destinatario
     * @param bandColor Color de la banda del PDF
     * @param fontColor Color de la fuente sobre la banda
     * @param base64Logo Logotipo en formato base64
     */
    public InvoiceEmailRequest(String invoiceId, String toEmail, String bandColor, String fontColor, String base64Logo) {
        this.invoiceId = invoiceId;
        this.toEmail = toEmail;
        this.bandColor = bandColor;
        this.fontColor = fontColor;
        this.base64Logo = base64Logo;
    }

    // Getters y Setters

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getBandColor() {
        return bandColor;
    }

    public void setBandColor(String bandColor) {
        this.bandColor = bandColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getBase64Logo() {
        return base64Logo;
    }

    public void setBase64Logo(String base64Logo) {
        this.base64Logo = base64Logo;
    }
}