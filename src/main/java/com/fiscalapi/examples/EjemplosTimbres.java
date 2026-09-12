package com.fiscalapi.examples;

import com.fiscalapi.common.ApiResponse;
import com.fiscalapi.common.FiscalApiSettings;
import com.fiscalapi.common.PagedList;
import com.fiscalapi.models.CreditType;
import com.fiscalapi.models.Person;
import com.fiscalapi.models.StampTransaction;
import com.fiscalapi.models.StampTransactionParams;
import com.fiscalapi.services.FiscalApiClient;

/**
 * Ejemplos de uso del servicio de timbres.
 *
 * El ledger mueve dos saldos que nunca se mezclan y que se eligen con creditType:
 * - CreditType.STAMP (por defecto) mueve timbres, el saldo availableBalance de la persona.
 * - CreditType.VALIDATION mueve créditos de validación SAT, el saldo availableValidationBalance.
 *
 * La API expone una sola operación de movimiento: retirar es transferir invirtiendo el origen y
 * el destino, por eso withdrawStamps hace la misma petición que transferStamps.
 */
public class EjemplosTimbres {

    // Persona de la que salen los timbres o créditos
    private static final String PERSONA_ORIGEN_ID = "<FROM_PERSON_ID>";

    // Persona que recibe los timbres o créditos
    private static final String PERSONA_DESTINO_ID = "<TO_PERSON_ID>";

    public static void main(String[] args) {
        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setDebugMode(false);
        settings.setApiUrl("https://test.fiscalapi.com");
        settings.setApiKey("<API_KEY>");
        settings.setTenant("<TENANT_KEY>");

        FiscalApiClient client = FiscalApiClient.create(settings);

        listarMovimientos(client);
        consultarSaldos(client);
        transferirTimbres(client);
        transferirCreditosDeValidacion(client);
        retirarCreditosDeValidacion(client);
        consultarSaldos(client);
    }

    /**
     * Lista los movimientos del ledger con paginación. Cada movimiento indica su tipo, su estado
     * y el tipo de crédito que movió.
     */
    private static void listarMovimientos(FiscalApiClient client) {
        System.out.println("\n===== 1. Listar movimientos =====");

        ApiResponse<PagedList<StampTransaction>> apiResponse = client.getStampService().getList(1, 10);

        if (!apiResponse.isSucceeded()) {
            System.out.println("Error: " + apiResponse.getDetails());
            return;
        }

        System.out.println("Total de movimientos: " + apiResponse.getData().getTotalCount());

        for (StampTransaction transaction : apiResponse.getData().getItems()) {
            System.out.println(transaction.getConsecutive()
                    + " | " + transaction.getTransactionType()
                    + " | " + transaction.getTransactionStatus()
                    + " | " + transaction.getCreditType()
                    + " | cantidad " + transaction.getAmount());
        }
    }

    /**
     * Consulta los dos saldos de las personas que participan en las transferencias.
     */
    private static void consultarSaldos(FiscalApiClient client) {
        System.out.println("\n===== Saldos =====");

        imprimirSaldo(client, PERSONA_ORIGEN_ID);
        imprimirSaldo(client, PERSONA_DESTINO_ID);
    }

    /**
     * Transfiere timbres. Sin asignar creditType se mueven timbres, que es el comportamiento
     * por defecto.
     */
    private static void transferirTimbres(FiscalApiClient client) {
        System.out.println("\n===== 2. Transferir timbres =====");

        StampTransactionParams requestModel = new StampTransactionParams();
        requestModel.setFromPersonId(PERSONA_ORIGEN_ID);
        requestModel.setToPersonId(PERSONA_DESTINO_ID);
        requestModel.setAmount(1);
        requestModel.setComments("venta de timbres");

        ApiResponse<Boolean> apiResponse = client.getStampService().transferStamps(requestModel);
        System.out.println(apiResponse);
    }

    /**
     * Transfiere créditos de validación SAT. El saldo de timbres no se toca.
     */
    private static void transferirCreditosDeValidacion(FiscalApiClient client) {
        System.out.println("\n===== 3. Transferir créditos de validación =====");

        StampTransactionParams requestModel = new StampTransactionParams();
        requestModel.setFromPersonId(PERSONA_ORIGEN_ID);
        requestModel.setToPersonId(PERSONA_DESTINO_ID);
        requestModel.setAmount(3);
        requestModel.setComments("venta de creditos de validacion");
        requestModel.setCreditType(CreditType.VALIDATION);

        ApiResponse<Boolean> apiResponse = client.getStampService().transferStamps(requestModel);
        System.out.println(apiResponse);
    }

    /**
     * Retira créditos de validación SAT: la persona de la que se retira va como origen.
     */
    private static void retirarCreditosDeValidacion(FiscalApiClient client) {
        System.out.println("\n===== 4. Retirar créditos de validación =====");

        StampTransactionParams requestModel = new StampTransactionParams();
        requestModel.setFromPersonId(PERSONA_DESTINO_ID);
        requestModel.setToPersonId(PERSONA_ORIGEN_ID);
        requestModel.setAmount(3);
        requestModel.setComments("prestamo de creditos de validacion");
        requestModel.setCreditType(CreditType.VALIDATION);

        ApiResponse<Boolean> apiResponse = client.getStampService().withdrawStamps(requestModel);
        System.out.println(apiResponse);
    }

    private static void imprimirSaldo(FiscalApiClient client, String personId) {
        ApiResponse<Person> apiResponse = client.getPersonService().getById(personId, false);

        if (!apiResponse.isSucceeded() || apiResponse.getData() == null) {
            System.out.println("Error: " + apiResponse.getDetails());
            return;
        }

        Person person = apiResponse.getData();
        System.out.println(person.getLegalName()
                + " | timbres " + person.getAvailableBalance()
                + " | validaciones " + person.getAvailableValidationBalance());
    }
}
