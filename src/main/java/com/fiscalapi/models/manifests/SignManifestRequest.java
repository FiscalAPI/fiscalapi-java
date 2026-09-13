package com.fiscalapi.models.manifests;

/**
 * Solicitud para firmar la carta manifiesto (POST /api/{apiVersion}/manifests).
 *
 * <p>Los archivos deben ser los de la FIEL (e.firma) del contribuyente, no los del CSD de
 * timbrado: la API rechaza la credencial si no es una FIEL vigente. El RFC del certificado
 * debe corresponder a una persona existente en el tenant.</p>
 *
 * <p>A diferencia de {@code TaxCredential}, aquí la contraseña viaja en texto plano.</p>
 *
 * <p>No se declara {@code toString()} de forma intencional: el modelo contiene la llave privada
 * y su contraseña.</p>
 */
public class SignManifestRequest {

    private String base64Cer;
    private String base64Key;
    private String password;

    /**
     * Certificado de la FIEL (archivo .cer) codificado en base64.
     *
     * @return El certificado en base64
     */
    public String getBase64Cer() {
        return base64Cer;
    }

    /**
     * @param base64Cer Certificado de la FIEL (.cer) en base64
     */
    public void setBase64Cer(String base64Cer) {
        this.base64Cer = base64Cer;
    }

    /**
     * Llave privada de la FIEL (archivo .key) codificada en base64.
     *
     * @return La llave privada en base64
     */
    public String getBase64Key() {
        return base64Key;
    }

    /**
     * @param base64Key Llave privada de la FIEL (.key) en base64
     */
    public void setBase64Key(String base64Key) {
        this.base64Key = base64Key;
    }

    /**
     * Contraseña de la llave privada de la FIEL, en texto plano.
     *
     * @return La contraseña de la llave privada
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password Contraseña de la llave privada de la FIEL, en texto plano
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
