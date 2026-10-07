package com.fiscalapi.abstractions;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.models.TaxFile;

import java.util.List;

/**
 * Define el contrato específico para operaciones con "tax-file".
 * Hereda la consulta, la creación y la baja de IImmutableFiscalApiService&lt;TaxFile&gt;. No tiene {@code update()}:
 * el API no actualiza certificados ({@code PUT /api/v4/tax-files/{id}} responde 405). Para cambiar un certificado,
 * suba el nuevo con {@code create()} y elimine el anterior con {@code delete()}.
 */
public interface ITaxFileService extends IImmutableFiscalApiService<TaxFile> {

    // other specific methods here...

    /**
     * Obtiene el último par de ids de certificados válidos y vigente de una persona.
     * Es decir, sus certificados por defecto (ids).
     *
     * @param personId Id de la persona dueña de los certificados.
     * @return Un ApiResponse con una lista de TaxFile (solo sus ids).
     */
    ApiResponse<List<TaxFile>> getDefaultReferences(String personId);

    /**
     * Obtiene el último par de certificados válidos y vigente de una persona.
     * Es decir, sus certificados por defecto.
     *
     * @param personId Id de la persona dueña de los certificados.
     * @return Un ApiResponse con una lista de TaxFile.
     */
    ApiResponse<List<TaxFile>> getDefaultValues(String personId);
}