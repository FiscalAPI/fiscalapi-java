package com.fiscalapi.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.satValidations.SatValidationRequest;
import com.fiscalapi.models.satValidations.SatValidationResult;
import com.fiscalapi.models.satValidations.SatValidationType;
import com.fiscalapi.models.satValidations.SatValidationTypeIds;
import com.fiscalapi.models.satValidations.SatValidationTypeStatus;
import com.fiscalapi.services.FiscalApiClient;

/**
 * Ejemplos de uso del servicio de validaciones SAT.
 *
 * Reglas del endpoint POST /api/v4/sat-validations:
 * - Se envía xml (CFDI timbrado en base64) o tin (RFC), nunca ambos y nunca ninguno.
 * - Con xml se puede solicitar cualquier tipo de validación.
 * - Con tin solo se pueden solicitar listas negras (sat.blacklist.69b, sat.blacklist.69bbis).
 * - Cada tipo solicitado consume un crédito de validación. El cobro es todo o nada: si el saldo
 *   no alcanza para todos, no se ejecuta ninguno y la API responde 403.
 * - Los resultados vienen en el orden del catálogo, no en el orden solicitado.
 */
public class EjemplosValidacionesSat {

    // CFDI timbrado real que usan los ejemplos
    private static final String RUTA_CFDI = "C:\\facturas\\FacturaXml.xml";

    // RFC del emisor del CFDI anterior, para los ejemplos de listas negras por RFC
    private static final String RFC_EMISOR = "MAX0611157H8";

    // ID de la persona dueña del API key: es a quien se le cobran los créditos de validación
    private static final String PERSONA_ID = "<PERSON_ID>";

    public static void main(String[] args) {
        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(false);
        settings.setApiUrl("https://test.fiscalapi.com");
        settings.setApiKey("<API_KEY>");
        settings.setTenant("<TENANT_KEY>");

        FiscalApiClient client = FiscalApiClient.create(settings);

        listarTiposDeValidacion(client);
        obtenerTipoPorId(client);
        listarEstatusDeUnTipo(client);

        // Saldo antes de validar
        consultarSaldoDeValidaciones(client);

        // Consume 7 créditos
        validarCfdiCompleto(client);

        // Consume 2 créditos
        validarListasNegrasPorRfc(client);

        // Saldo después de validar: debe haber bajado 9 créditos
        consultarSaldoDeValidaciones(client);
    }

    /**
     * Lista los tipos de validación SAT disponibles, en el orden del catálogo.
     */
    private static void listarTiposDeValidacion(FiscalApiClient client) {
        System.out.println("\n===== 1. Listar tipos de validación =====");

        ApiResponse<List<SatValidationType>> apiResponse = client.getSatValidationService().getTypes();

        if (!apiResponse.isSucceeded()) {
            System.out.println("Error: " + apiResponse.getDetails());
            return;
        }

        for (SatValidationType validationType : apiResponse.getData()) {
            System.out.println(validationType.getId() + ": " + recortar(validationType.getDescription()));
        }
    }

    /**
     * Obtiene un tipo de validación por su id.
     */
    private static void obtenerTipoPorId(FiscalApiClient client) {
        System.out.println("\n===== 2. Obtener tipo de validación por id =====");

        ApiResponse<SatValidationType> apiResponse =
                client.getSatValidationService().getTypeById(SatValidationTypeIds.CFDI_STATUS);

        System.out.println(apiResponse);
    }

    /**
     * Lista los estatus que un tipo de validación puede tomar al ejecutarse.
     * No ejecuta la validación ni consume créditos.
     */
    private static void listarEstatusDeUnTipo(FiscalApiClient client) {
        System.out.println("\n===== 3. Listar estatus de un tipo de validación =====");

        ApiResponse<List<SatValidationTypeStatus>> apiResponse =
                client.getSatValidationService().getStatuses(SatValidationTypeIds.CFDI_STATUS);

        if (!apiResponse.isSucceeded()) {
            System.out.println("Error: " + apiResponse.getDetails());
            return;
        }

        for (SatValidationTypeStatus status : apiResponse.getData()) {
            System.out.println(status.getId() + ": " + recortar(status.getDescription()));
        }
    }

    /**
     * Ejecuta las siete validaciones SAT sobre un CFDI timbrado. Consume 7 créditos.
     */
    private static void validarCfdiCompleto(FiscalApiClient client) {
        System.out.println("\n===== 4. Validar un CFDI timbrado (todas las validaciones) =====");

        SatValidationRequest request = new SatValidationRequest();
        request.setXml(leerCfdiEnBase64());
        request.setValidationTypes(new ArrayList<>(Arrays.asList(
                SatValidationTypeIds.XML_STRUCTURE,
                SatValidationTypeIds.CERTIFICATE_VALIDITY,
                SatValidationTypeIds.CFDI_SELLO,
                SatValidationTypeIds.TFD_SELLO,
                SatValidationTypeIds.CFDI_STATUS,
                SatValidationTypeIds.BLACKLIST_69B,
                SatValidationTypeIds.BLACKLIST_69B_BIS)));

        imprimirResultados(client.getSatValidationService().validate(request));
    }

    /**
     * Consulta un RFC en las listas negras 69-B y 69-B Bis sin enviar el CFDI.
     * Con tin solo se pueden solicitar listas negras. Consume 2 créditos.
     */
    private static void validarListasNegrasPorRfc(FiscalApiClient client) {
        System.out.println("\n===== 5. Validar un RFC en listas negras (sin CFDI) =====");

        SatValidationRequest request = new SatValidationRequest();
        request.setTin(RFC_EMISOR);
        request.setValidationTypes(new ArrayList<>(Arrays.asList(
                SatValidationTypeIds.BLACKLIST_69B,
                SatValidationTypeIds.BLACKLIST_69B_BIS)));

        imprimirResultados(client.getSatValidationService().validate(request));
    }

    /**
     * Consulta el saldo de créditos de validación de la persona dueña del API key, que es a quien
     * la API le cobra cada validación ejecutada. Es independiente del saldo de timbres: los saldos
     * nunca se mezclan.
     */
    private static void consultarSaldoDeValidaciones(FiscalApiClient client) {
        System.out.println("\n===== Saldo de créditos de validación =====");

        ApiResponse<Person> apiResponse = client.getPersonService().getById(PERSONA_ID, false);

        if (!apiResponse.isSucceeded() || apiResponse.getData() == null) {
            System.out.println("Error: " + apiResponse.getDetails());
            return;
        }

        System.out.println("Timbres disponibles:      " + apiResponse.getData().getAvailableBalance());
        System.out.println("Validaciones disponibles: " + apiResponse.getData().getAvailableValidationBalance());
    }

    /**
     * Imprime un resultado por línea: veredicto, tipo, estatus y los hechos del caso si los hay.
     */
    private static void imprimirResultados(ApiResponse<List<SatValidationResult>> apiResponse) {
        if (!apiResponse.isSucceeded()) {
            System.out.println("Error: " + apiResponse.getDetails());
            System.out.println("traceIdentifier: " + apiResponse.getTraceIdentifier());
            return;
        }

        for (SatValidationResult result : apiResponse.getData()) {
            String veredicto = result.isPassed() ? "PASSED" : "FAILED";
            System.out.println("[" + veredicto + "] " + result.getType().getId() + " -> " + result.getStatus().getId());

            if (result.getStatus().getDetails() != null) {
                System.out.println("         " + result.getStatus().getDetails());
            }
        }
    }

    /**
     * Lee el CFDI timbrado del disco y lo codifica en base64, que es lo que espera el campo xml.
     */
    private static String leerCfdiEnBase64() {
        try {
            return Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(RUTA_CFDI)));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el CFDI en " + RUTA_CFDI, e);
        }
    }

    private static String recortar(String description) {
        if (description == null || description.length() <= 80) {
            return description;
        }
        return description.substring(0, 80) + "...";
    }
}
