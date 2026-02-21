// package com.fiscalapi.examples;

// public class EjemplosNominaReferencias {
//     public static void main(String[] args) {
//         // FiscalApiSettings settings = new FiscalApiSettings();
//         // settings.setDebugMode(true);
//         // settings.setApiUrl("https://test.fiscalapi.com");
//         // settings.setApiKey("api_+key");
//         // settings.setTenant("tenant_id");

//         //final String escuelaKemperUrgateId = "0e82a655-5f0c-4e07-abab-8f322e4123ef";
//         //final String karlaFuenteNolascoId = "da71df0c-f328-45ee-9bd9-3096ed02c164";
//         //final String organicosNavezOsorioId = "ab7ec306-6f81-4f9f-b55f-bbbb1ab2f153";
//         //final String xochiltCasasChavezId = "acf43966-4672-48b6-a01a-d04cac6c3d64";
//         //final String ingridXodarJimenezId = "aa2ad8c3-6ec5-4601-91be-d827d9a865bc";

//         // FiscalApiClient client = FiscalApiClient.create(settings);

//         // LocalDateTime currentDate = OptUtil.parseLocalDateTime(LocalDateTime.now().toString());

//         // // Crear nómina ordinaria por referencias
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(escuelaKemperUrgateId);

//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2025-08-30T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2025-07-31T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2025-08-30T00:00:00"));
//     //     payroll.setDaysPaid(30);
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("1003");
//     //     e1.setConcept("Sueldo nominal");
//     //     e1.setTaxedAmount(new BigDecimal("95030.00"));
//     //     e1.setExemptAmount(new BigDecimal("0"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("005");
//     //     e2.setCode("5913");
//     //     e2.setConcept("Fondo de Ahorro Aportación Patrón");
//     //     e2.setTaxedAmount(new BigDecimal("0"));
//     //     e2.setExemptAmount(new BigDecimal("0"));

//     //     PayrollEarning e3 = new PayrollEarning();
//     //     e3.setEarningTypeCode("038");
//     //     e3.setCode("1885");
//     //     e3.setConcept("Bono Ingles");
//     //     e3.setTaxedAmount(new BigDecimal("14254.50"));
//     //     e3.setExemptAmount(new BigDecimal("0"));

//     //     PayrollEarning e4 = new PayrollEarning();
//     //     e4.setEarningTypeCode("029");
//     //     e4.setCode("1941");
//     //     e4.setConcept("Vales Despensa");
//     //     e4.setTaxedAmount(new BigDecimal("0"));
//     //     e4.setExemptAmount(new BigDecimal("3439"));

//     //     PayrollEarning e5 = new PayrollEarning();
//     //     e5.setEarningTypeCode("038");
//     //     e5.setCode("1824");
//     //     e5.setConcept("Herramientas Teletrabajo (telecom y prop. electri)");
//     //     e5.setTaxedAmount(new BigDecimal("273"));
//     //     e5.setExemptAmount(new BigDecimal("0"));

//     //     PayrollEarning e6 = new PayrollEarning();
//     //     e6.setEarningTypeCode("002");
//     //     e6.setCode("5050");
//     //     e6.setConcept("Exceso de subsidio al empleo");
//     //     e6.setTaxedAmount(new BigDecimal("0"));
//     //     e6.setExemptAmount(new BigDecimal("0"));

//     //     earnings.add(e1);
//     //     earnings.add(e2);
//     //     earnings.add(e3);
//     //     earnings.add(e4);
//     //     earnings.add(e5);
//     //     earnings.add(e6);

//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();
//     //     PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//     //     op1.setOtherPaymentTypeCode("002");
//     //     op1.setCode("5050");
//     //     op1.setConcept("exceso de subsidio al empleo");
//     //     op1.setAmount(new BigDecimal("0"));
//     //     op1.setSubsidyCaused(new BigDecimal("0"));

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("002");
//     //     d1.setCode("5003");
//     //     d1.setConcept("ISR Causado");
//     //     d1.setAmount(new BigDecimal("27645"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("004");
//     //     d2.setCode("5910");
//     //     d2.setConcept("Fondo de ahorro Empleado Inversión");
//     //     d2.setAmount(new BigDecimal("4412.46"));

//     //     PayrollDeduction d3 = new PayrollDeduction();
//     //     d3.setDeductionTypeCode("004");
//     //     d3.setCode("5914");
//     //     d3.setConcept("Fondo de Ahorro Patrón Inversión");
//     //     d3.setAmount(new BigDecimal("4412.46"));

//     //     PayrollDeduction d4 = new PayrollDeduction();
//     //     d4.setDeductionTypeCode("004");
//     //     d4.setCode("1966");
//     //     d4.setConcept("Contribución póliza exceso GMM");
//     //     d4.setAmount(new BigDecimal("519.91"));

//     //     PayrollDeduction d5 = new PayrollDeduction();
//     //     d5.setDeductionTypeCode("004");
//     //     d5.setCode("1934");
//     //     d5.setConcept("Descuento Vales Despensa");
//     //     d5.setAmount(new BigDecimal("1"));

//     //     PayrollDeduction d6 = new PayrollDeduction();
//     //     d6.setDeductionTypeCode("004");
//     //     d6.setCode("1942");
//     //     d6.setConcept("Vales Despensa Electrónico");
//     //     d6.setAmount(new BigDecimal("3439"));

//     //     PayrollDeduction d7 = new PayrollDeduction();
//     //     d7.setDeductionTypeCode("001");
//     //     d7.setCode("1895");
//     //     d7.setConcept("IMSS");
//     //     d7.setAmount(new BigDecimal("2391.13"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);
//     //     payrollDeductions.add(d3);
//     //     payrollDeductions.add(d4);
//     //     payrollDeductions.add(d5);
//     //     payrollDeductions.add(d6);
//     //     payrollDeductions.add(d7);

//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(OptUtil.parseLocalDateTime("2026-02-09T10:00:00"));
//     //     invoice.setTypeCode("N");
//     //     invoice.setExpeditionZipCode("42501");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setDate(OptUtil.parseLocalDateTime("2026-02-09T10:00:00"));
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//     //     System.out.println(apiResponse);

//     // // Nómina asimilados por referencias
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//         // // Certificados del emisor
//         // List<TaxCredential> credentials = new ArrayList<>();

//         // TaxCredential cer = new TaxCredential();
//         // cer.setBase64File(escuelaKemperUrgateBase64Cer);
//         // cer.setFileType(0); // 0 = Certificado (.cer)
//         // cer.setPassword(password);

//         // TaxCredential key = new TaxCredential();
//         // key.setBase64File(escuelaKemperUrgateBase64Key);
//         // key.setFileType(1); // 1 = Clave privada (.key)
//         // key.setPassword(password);

//         // credentials.add(cer);
//         // credentials.add(key);

//         // issuer.setTaxCredentials(credentials);

//     // // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(xochiltCasasChavezId);

//     // // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("E");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-06-02T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-06-01T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-02T00:00:00"));
//     //     payroll.setDaysPaid(1);

//     // // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("046");
//     //     e1.setCode("010046");
//     //     e1.setConcept("INGRESOS ASIMILADOS A SALARIOS");
//     //     e1.setTaxedAmount(new BigDecimal("111197.73"));
//     //     e1.setExemptAmount(new BigDecimal("0.00"));

//     //     earnings.add(e1);

//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     // // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("002");
//     //     d1.setCode("020002");
//     //     d1.setConcept("ISR");
//     //     d1.setAmount(new BigDecimal("36197.73"));

//     //     payrollDeductions.add(d1);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     // // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("06880");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // //Nómina con bonos fondo de ahorro y deducciones
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//         // // Certificados del emisor
//         // List<TaxCredential> credentials = new ArrayList<>();

//         // TaxCredential cer = new TaxCredential();
//         // cer.setBase64File(escuelaKemperUrgateBase64Cer);
//         // cer.setFileType(0); // 0 = Certificado (.cer)
//         // cer.setPassword(password);

//         // TaxCredential key = new TaxCredential();
//         // key.setBase64File(escuelaKemperUrgateBase64Key);
//         // key.setFileType(1); // 1 = Clave privada (.key)
//         // key.setPassword(password);

//         // credentials.add(cer);
//         // credentials.add(key);

//         // issuer.setTaxCredentials(credentials);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Items
//     //     List<InvoiceItem> items = new ArrayList<>();

//     //     InvoiceItem item1 = new InvoiceItem();
//     //     item1.setItemCode("84111505");
//     //     item1.setItemSku("84111505");
//     //     item1.setQuantity(new BigDecimal("1"));
//     //     item1.setUnitOfMeasurementCode("ACT");
//     //     item1.setDescription("Pago de nómina");
//     //     item1.setUnitPrice(new BigDecimal("1842.82"));
//     //     item1.setDiscount(new BigDecimal("608.71"));
//     //     item1.setTaxObjectCode("01");

//     //     items.add(item1);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-06-11T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-06-05T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-11T00:00:00"));
//     //     payroll.setDaysPaid(7);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("SP01");
//     //     e1.setConcept("SUELDO");
//     //     e1.setTaxedAmount(new BigDecimal("1210.30"));
//     //     e1.setExemptAmount(new BigDecimal("0.00"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("010");
//     //     e2.setCode("SP02");
//     //     e2.setConcept("PREMIO PUNTUALIDAD");
//     //     e2.setTaxedAmount(new BigDecimal("121.03"));
//     //     e2.setExemptAmount(new BigDecimal("0.00"));

//     //     PayrollEarning e3 = new PayrollEarning();
//     //     e3.setEarningTypeCode("029");
//     //     e3.setCode("SP03");
//     //     e3.setConcept("MONEDERO ELECTRONICO");
//     //     e3.setTaxedAmount(new BigDecimal("0.00"));
//     //     e3.setExemptAmount(new BigDecimal("269.43"));

//     //     PayrollEarning e4 = new PayrollEarning();
//     //     e4.setEarningTypeCode("010");
//     //     e4.setCode("SP04");
//     //     e4.setConcept("PREMIO DE ASISTENCIA");
//     //     e4.setTaxedAmount(new BigDecimal("121.03"));
//     //     e4.setExemptAmount(new BigDecimal("0.00"));

//     //     PayrollEarning e5 = new PayrollEarning();
//     //     e5.setEarningTypeCode("005");
//     //     e5.setCode("SP54");
//     //     e5.setConcept("APORTACION FONDO AHORRO");
//     //     e5.setTaxedAmount(new BigDecimal("0.00"));
//     //     e5.setExemptAmount(new BigDecimal("121.03"));

//     //     earnings.add(e1);
//     //     earnings.add(e2);
//     //     earnings.add(e3);
//     //     earnings.add(e4);
//     //     earnings.add(e5);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//     //     op1.setOtherPaymentTypeCode("002");
//     //     op1.setCode("ISRSUB");
//     //     op1.setConcept("Subsidio ISR para empleo");
//     //     op1.setAmount(new BigDecimal("0.0"));
//     //     op1.setSubsidyCaused(new BigDecimal("0.0"));

//     //     BalanceCompensation balanceCompensation = new BalanceCompensation();
//     //     balanceCompensation.setFavorableBalance(new BigDecimal("0.0"));
//     //     balanceCompensation.setYear(2022);
//     //     balanceCompensation.setRemainingFavorableBalance(new BigDecimal("0.0"));

//     //     op1.setBalanceCompensation(balanceCompensation);

//     //     otherPayments.add(op1);

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("004");
//     //     d1.setCode("ZA09");
//     //     d1.setConcept("APORTACION FONDO AHORRO");
//     //     d1.setAmount(new BigDecimal("121.03"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("ISR");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("36.57"));

//     //     PayrollDeduction d3 = new PayrollDeduction();
//     //     d3.setDeductionTypeCode("001");
//     //     d3.setCode("IMSS");
//     //     d3.setConcept("Cuota de Seguridad Social EE");
//     //     d3.setAmount(new BigDecimal("30.08"));

//     //     PayrollDeduction d4 = new PayrollDeduction();
//     //     d4.setDeductionTypeCode("004");
//     //     d4.setCode("ZA68");
//     //     d4.setConcept("DEDUCCION FDO AHORRO PAT");
//     //     d4.setAmount(new BigDecimal("121.03"));

//     //     PayrollDeduction d5 = new PayrollDeduction();
//     //     d5.setDeductionTypeCode("018");
//     //     d5.setCode("ZA11");
//     //     d5.setConcept("APORTACION CAJA AHORRO");
//     //     d5.setAmount(new BigDecimal("300.00"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);
//     //     payrollDeductions.add(d3);
//     //     payrollDeductions.add(d4);
//     //     payrollDeductions.add(d5);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setItems(items);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // //Nómina con horas extra
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.8"));
//     //     e1.setExemptAmount(new BigDecimal("2191.2"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("019");
//     //     e2.setCode("00100");
//     //     e2.setConcept("Horas Extra");
//     //     e2.setTaxedAmount(new BigDecimal("50.00"));
//     //     e2.setExemptAmount(new BigDecimal("50.00"));

//     //     List<PayrollEarningOvertime> overtimeList = new ArrayList<>();
//     //     PayrollEarningOvertime overtime1 = new PayrollEarningOvertime();
//     //     overtime1.setDays(1);
//     //     overtime1.setHoursTypeCode("01");
//     //     overtime1.setExtraHours(2);
//     //     overtime1.setAmountPaid(new BigDecimal("100.00"));
//     //     overtimeList.add(overtime1);

//     //     e2.setOvertime(overtimeList);

//     //     earnings.add(e1);
//     //     earnings.add(e2);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);
//     //     payroll.setEarnings(payrollEarnings);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("001");
//     //     d1.setCode("00301");
//     //     d1.setConcept("Seguridad Social");
//     //     d1.setAmount(new BigDecimal("200.00"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("00302");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("100"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina con incapacidades
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.80"));
//     //     e1.setExemptAmount(new BigDecimal("2191.20"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("001");
//     //     d1.setCode("00301");
//     //     d1.setConcept("Seguridad Social");
//     //     d1.setAmount(new BigDecimal("200.00"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("00302");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("100.00"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);

//     //     // Disabilities
//     //     List<PayrollDisability> disabilities = new ArrayList<>();

//     //     PayrollDisability disability1 = new PayrollDisability();
//     //     disability1.setDisabilityDays(1);
//     //     disability1.setDisabilityTypeCode("01");

//     //     disabilities.add(disability1);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);
//     //     payroll.setDisabilities(disabilities);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // //Nómina con SNCF
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(organicosNavezOsorioId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(xochiltCasasChavezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-16T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-01T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-16T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("P001");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("3322.20"));
//     //     e1.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("038");
//     //     e2.setCode("P540");
//     //     e2.setConcept("Compensacion");
//     //     e2.setTaxedAmount(new BigDecimal("100.0"));
//     //     e2.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e3 = new PayrollEarning();
//     //     e3.setEarningTypeCode("038");
//     //     e3.setCode("P550");
//     //     e3.setConcept("Compensación Garantizada Extraordinaria");
//     //     e3.setTaxedAmount(new BigDecimal("2200.0"));
//     //     e3.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e4 = new PayrollEarning();
//     //     e4.setEarningTypeCode("038");
//     //     e4.setCode("P530");
//     //     e4.setConcept("Servicio Extraordinario");
//     //     e4.setTaxedAmount(new BigDecimal("200.0"));
//     //     e4.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e5 = new PayrollEarning();
//     //     e5.setEarningTypeCode("001");
//     //     e5.setCode("P506");
//     //     e5.setConcept("Otras Prestaciones");
//     //     e5.setTaxedAmount(new BigDecimal("1500.0"));
//     //     e5.setExemptAmount(new BigDecimal("0.0"));

//     //     PayrollEarning e6 = new PayrollEarning();
//     //     e6.setEarningTypeCode("001");
//     //     e6.setCode("P505");
//     //     e6.setConcept("Remuneración al Desempeño Legislativo");
//     //     e6.setTaxedAmount(new BigDecimal("17500.0"));
//     //     e6.setExemptAmount(new BigDecimal("0.0"));

//     //     earnings.add(e1);
//     //     earnings.add(e2);
//     //     earnings.add(e3);
//     //     earnings.add(e4);
//     //     earnings.add(e5);
//     //     earnings.add(e6);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//     //     op1.setOtherPaymentTypeCode("002");
//     //     op1.setCode("o002");
//     //     op1.setConcept("Subsidio para el empleo efectivamente entregado al trabajador");
//     //     op1.setAmount(new BigDecimal("0.0"));
//     //     op1.setSubsidyCaused(new BigDecimal("0.0"));

//     //     otherPayments.add(op1);

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("002");
//     //     d1.setCode("D002");
//     //     d1.setConcept("ISR");
//     //     d1.setAmount(new BigDecimal("4716.61"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("004");
//     //     d2.setCode("D525");
//     //     d2.setConcept("Redondeo");
//     //     d2.setAmount(new BigDecimal("0.81"));

//     //     PayrollDeduction d3 = new PayrollDeduction();
//     //     d3.setDeductionTypeCode("001");
//     //     d3.setCode("D510");
//     //     d3.setConcept("Cuota Trabajador ISSSTE");
//     //     d3.setAmount(new BigDecimal("126.78"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);
//     //     payrollDeductions.add(d3);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("39074");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina extraordinaria
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("E");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setDaysPaid(30);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("002");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Gratificación Anual (Aguinaldo)");
//     //     e1.setTaxedAmount(new BigDecimal("0.00"));
//     //     e1.setExemptAmount(new BigDecimal("10000.00"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions (empty list)
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina separacion indemnización
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("E");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-05T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setDaysPaid(30);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("023");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Pagos por separación");
//     //     e1.setTaxedAmount(new BigDecimal("0.00"));
//     //     e1.setExemptAmount(new BigDecimal("10000.00"));

//     //     PayrollEarning e2 = new PayrollEarning();
//     //     e2.setEarningTypeCode("025");
//     //     e2.setCode("00900");
//     //     e2.setConcept("Indemnizaciones");
//     //     e2.setTaxedAmount(new BigDecimal("0.00"));
//     //     e2.setExemptAmount(new BigDecimal("500.00"));

//     //     earnings.add(e1);
//     //     earnings.add(e2);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     // Severance
//     //     PayrollSeverance severance = new PayrollSeverance();
//     //     severance.setTotalPaid(new BigDecimal("10500.00"));
//     //     severance.setYearsOfService(1);
//     //     severance.setLastMonthlySalary(new BigDecimal("10000.00"));
//     //     severance.setAccumulableIncome(new BigDecimal("10000.00"));
//     //     severance.setNonAccumulableIncome(new BigDecimal("0.00"));

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);
//     //     payrollEarnings.setSeverance(severance);

//     //     // Deductions (empty list)
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//     //     System.out.println(apiResponse);

//     // // Nómina jubilación
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("E");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-05T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-06-04T00:00:00"));
//     //     payroll.setDaysPaid(30);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("039");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Jubilaciones, pensiones o haberes de retiro");
//     //     e1.setTaxedAmount(new BigDecimal("0.00"));
//     //     e1.setExemptAmount(new BigDecimal("10000.00"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     // Retirement
//     //     PayrollRetirement retirement = new PayrollRetirement();
//     //     retirement.setTotalOneTime(new BigDecimal("10000.00"));
//     //     retirement.setAccumulableIncome(new BigDecimal("10000.00"));
//     //     retirement.setNonAccumulableIncome(new BigDecimal("0.00"));

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);
//     //     payrollEarnings.setRetirement(retirement);

//     //     // Deductions (empty list)
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);
//     //     System.out.println(apiResponse);

//     // // Nómina sin deducciones
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.8"));
//     //     e1.setExemptAmount(new BigDecimal("2191.2"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions (empty list)
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);
        
//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina viáticos
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-09-26T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-09-11T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-09-26T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("050");
//     //     e1.setCode("050");
//     //     e1.setConcept("Viaticos");
//     //     e1.setTaxedAmount(new BigDecimal("0.00"));
//     //     e1.setExemptAmount(new BigDecimal("3000.00"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("081");
//     //     d1.setCode("081");
//     //     d1.setConcept("Ajuste en viaticos entregados al trabajador");
//     //     d1.setAmount(new BigDecimal("3000.00"));

//     //     payrollDeductions.add(d1);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina subsidio causado al empleo
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.8"));
//     //     e1.setExemptAmount(new BigDecimal("2191.2"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     PayrollEarningOtherPayment op1 = new PayrollEarningOtherPayment();
//     //     op1.setOtherPaymentTypeCode("007");
//     //     op1.setCode("0002");
//     //     op1.setConcept("ISR ajustado por subsidio");
//     //     op1.setAmount(new BigDecimal("145.80"));
//     //     op1.setSubsidyCaused(new BigDecimal("0.0"));

//     //     otherPayments.add(op1);

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("107");
//     //     d1.setCode("D002");
//     //     d1.setConcept("Ajuste al Subsidio Causado");
//     //     d1.setAmount(new BigDecimal("160.35"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("D002");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("145.80"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);

//     // // Nómina
//     //     // Emisor
//     //     InvoiceIssuer issuer = new InvoiceIssuer();
//     //     issuer.setId(escuelaKemperUrgateId);

//     //     // Receptor
//     //     InvoiceRecipient recipient = new InvoiceRecipient();
//     //     recipient.setId(ingridXodarJimenezId);

//     //     // Payroll
//     //     Payroll payroll = new Payroll();
//     //     payroll.setVersion("1.2");
//     //     payroll.setPayrollTypeCode("O");
//     //     payroll.setPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setInitialPaymentDate(OptUtil.parseLocalDateTime("2023-05-09T00:00:00"));
//     //     payroll.setFinalPaymentDate(OptUtil.parseLocalDateTime("2023-05-24T00:00:00"));
//     //     payroll.setDaysPaid(15);

//     //     // Earnings
//     //     PayrollEarnings payrollEarnings = new PayrollEarnings();
//     //     List<PayrollEarning> earnings = new ArrayList<>();

//     //     PayrollEarning e1 = new PayrollEarning();
//     //     e1.setEarningTypeCode("001");
//     //     e1.setCode("00500");
//     //     e1.setConcept("Sueldos, Salarios Rayas y Jornales");
//     //     e1.setTaxedAmount(new BigDecimal("2808.8"));
//     //     e1.setExemptAmount(new BigDecimal("2191.2"));

//     //     earnings.add(e1);

//     //     // Other Payments
//     //     List<PayrollEarningOtherPayment> otherPayments = new ArrayList<>();

//     //     payrollEarnings.setEarnings(earnings);
//     //     payrollEarnings.setOtherPayments(otherPayments);

//     //     // Deductions
//     //     List<PayrollDeduction> payrollDeductions = new ArrayList<>();

//     //     PayrollDeduction d1 = new PayrollDeduction();
//     //     d1.setDeductionTypeCode("001");
//     //     d1.setCode("00301");
//     //     d1.setConcept("Seguridad Social");
//     //     d1.setAmount(new BigDecimal("200"));

//     //     PayrollDeduction d2 = new PayrollDeduction();
//     //     d2.setDeductionTypeCode("002");
//     //     d2.setCode("00302");
//     //     d2.setConcept("ISR");
//     //     d2.setAmount(new BigDecimal("100"));

//     //     payrollDeductions.add(d1);
//     //     payrollDeductions.add(d2);

//     //     payroll.setEarnings(payrollEarnings);
//     //     payroll.setDeductions(payrollDeductions);

//     //     Complement complement = new Complement();
//     //     complement.setPayroll(payroll);

//     //     // Invoice
//     //     Invoice invoice = new Invoice();
//     //     invoice.setVersionCode("4.0");
//     //     invoice.setSeries("F");
//     //     invoice.setDate(currentDate); // Or use {{currentDate}} placeholder
//     //     invoice.setTypeCode("N");
//     //     invoice.setPaymentMethodCode("PUE");
//     //     invoice.setCurrencyCode("MXN");
//     //     invoice.setExpeditionZipCode("20000");
//     //     invoice.setExportCode("01");
//     //     invoice.setIssuer(issuer);
//     //     invoice.setRecipient(recipient);
//     //     invoice.setComplement(complement);

//     //     ApiResponse<Invoice> apiResponse = client.getInvoiceService().create(invoice);

//     //     System.out.println(apiResponse);
//     }
// }
