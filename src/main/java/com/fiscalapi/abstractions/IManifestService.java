package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.invoicing.FileResponse;
import com.fiscalapi.models.manifests.SignManifestRequest;

/**
 * Firma de la carta manifiesto con la FIEL (e.firma) del contribuyente.
 */
public interface IManifestService {

    /**
     * Firma la carta manifiesto y devuelve el PDF resultante.
     * POST /api/{apiVersion}/manifests
     *
     * <p>La credencial debe ser una FIEL vigente y el RFC del certificado debe corresponder a
     * una persona del tenant; ambas reglas las resuelve la API. Al firmar, la persona queda con
     * el estatus de manifiesto en {@code Signed}.</p>
     *
     * @param requestModel Certificado y llave privada de la FIEL en base64, más la contraseña
     * @return ApiResponse con el PDF de la carta manifiesto firmada
     */
    ApiResponse<FileResponse> sign(SignManifestRequest requestModel);
}
