package com.fiscalapi.models.satValidations;

/**
 * Ids de los tipos de validación SAT, en el orden del catálogo.
 */
public final class SatValidationTypeIds {

    /** Estructura del XML contra el Anexo 20 y sus complementos. Requiere xml. */
    public static final String XML_STRUCTURE = "sat.xml.structure";

    /** Vigencia del certificado del emisor a la fecha de emisión. Requiere xml. */
    public static final String CERTIFICATE_VALIDITY = "sat.certificate.validity";

    /** Sello del CFDI contra la cadena original y el certificado del emisor. Requiere xml. */
    public static final String CFDI_SELLO = "sat.cfdi.sello";

    /** Sello del SAT en el TimbreFiscalDigital. Requiere xml. */
    public static final String TFD_SELLO = "sat.tfd.sello";

    /** Estado actual del comprobante en el SAT: vigente, cancelado o no encontrado. Requiere xml. */
    public static final String CFDI_STATUS = "sat.cfdi.status";

    /** Lista negra del artículo 69-B CFF. Admite xml o tin. */
    public static final String BLACKLIST_69B = "sat.blacklist.69b";

    /** Lista negra del artículo 69-B Bis CFF. Admite xml o tin. */
    public static final String BLACKLIST_69B_BIS = "sat.blacklist.69bbis";

    private SatValidationTypeIds() {
    }
}
