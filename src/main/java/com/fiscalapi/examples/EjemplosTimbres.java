// package com.fiscalapi.examples;

// import com.fiscalapi.common.FiscalApiSettings;
// import com.fiscalapi.services.FiscalApiClient;

// public class EjemplosTimbres {
//     public static void main(String[] args) {
//         FiscalApiSettings settings = new FiscalApiSettings();
//         settings.setDebugMode(true);
//         settings.setApiUrl("https://test.fiscalapi.com");
//         settings.setApiKey("sk_test_b4f8cc00_d02a_4ecc_a68a_f87ae970958c");
//         settings.setTenant("275510ee-f64d-435a-9e92-1553d8f10a7e");
//         FiscalApiClient client = FiscalApiClient.create(settings);

//         // //Listar movimientos
//         // ApiResponse<PagedList<StampTransaction>> apiResponse = client.getStampService().getList(1, 10);
//         // System.out.println(apiResponse);

//         // //Obtener movimiento por ID
//         // ApiResponse<StampTransaction> transactionResponse = client.getStampService().getById("e29720d5-fa29-4690-bdb3-9fc8344fcef8", false);
//         // System.out.println(transactionResponse); 

//         //  //Transferir timbres 
//         //  StampTransactionParams transParams = new StampTransactionParams();
//         //  transParams.setFromPersonId("0e82a655-5f0c-4e07-abab-8f322e4123ef");
//         //  transParams.setToPersonId("da71df0c-f328-45ee-9bd9-3096ed02c164");
//         //  transParams.setAmount(1);
//         //  transParams.setComments("venta de timbres");
//         //  ApiResponse<Boolean> apiResponse = client.getStampService().transferStamps(transParams);
//         //  System.out.println(apiResponse);

//         //  //Retirar timbres
//         //  StampTransactionParams transParams = new StampTransactionParams();
//         //  transParams.setFromPersonId("da71df0c-f328-45ee-9bd9-3096ed02c164");
//         //  transParams.setToPersonId("0e82a655-5f0c-4e07-abab-8f322e4123ef");
//         //  transParams.setAmount(1);
//         //  transParams.setComments("prestamo");
//         //  ApiResponse<Boolean> apiResponse = client.getStampService().withdrawStamps(transParams);
//         //  System.out.println(apiResponse);     
//     }

// }
