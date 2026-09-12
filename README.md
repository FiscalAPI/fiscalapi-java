# Fiscalapi SDK para Java

[![Maven Central](https://img.shields.io/maven-central/v/com.fiscalapi/fiscalapi)](https://search.maven.org/artifact/com.fiscalapi/fiscalapi)
[![License](https://img.shields.io/github/license/FiscalAPI/fiscalapi-java)](https://github.com/FiscalAPI/fiscalapi-java/blob/main/LICENSE)

**SDK oficial de https://fiscalapi.com para Java**, la API de facturación CFDI y otros servicios fiscales en México. Simplifica la integración con los servicios de facturación electrónica, eliminando las complejidades del SAT y facilitando la generación de facturas, notas de crédito, complementos de pago, nómina, carta porte, y más. ¡Factura sin dolor!


## 📋 Facturación CFDI 4.0
- **Soporte completo para CFDI 4.0** con todas las especificaciones oficiales
- **Timbrado de facturas de ingreso** con validación automática
- **Timbrado de notas de crédito** (facturas de egreso)
- **Timbrado de complementos de pago** en MXN, USD y EUR
- **Timbrado de facturas de nómina** 
- **Timbrado de facturas de carta porte** 
- **Timbrado de facturas de comercio exterior**  
- **Consulta del estatus de facturas** en el SAT en tiempo real
- **Cancelación de facturas** 
- **Generación de archivos PDF** de las facturas con formato profesional
- **Personalización de logos y colores** en los PDF generados
- **Envío de facturas por correo electrónico** automatizado
- **Descarga de archivos XML** con estructura completa
- **Almacenamiento y recuperación** de facturas por 5 años.
- Dos [modos de operación](https://docs.fiscalapi.com/modes-of-operation): **Por valores** o **Por referencias**

## 📥 Descarga Masiva
- **Acceso a catálogos de descarga masiva** del SAT
- **Descarga de CFDI y Metadatos** en lotes grandes
- **Descarga masiva XML** con filtros personalizados
- **Reglas de descarga automática por RFC** 
- **Solicitudes de descarga** via API y Dashboard.
- **Automatización de solicitudes de descarga**

## 👥 Gestión de Personas
- **Administración de personas** (emisores, receptores, clientes, usuarios, etc.)
- **Gestión de certificados CSD y FIEL** (subir archivos .cer y .key a FiscalAPI)
- **Configuración de datos fiscales** (RFC, domicilio fiscal, régimen fiscal)
- **Datos de empleado** (agrega/actualiza/elimina datos de empleado a una persona. CFDI Nómina)
- **Datos de empleador** (agrega/actualiza/elimina datos de empleador a una persona. CFDI Nómina)

## 🎖️ Gestión de Timbres
- **Gestión de folios fiscales** Compra timbres a fiscalapi y transfiere/retira a las personas de tu organizacion segun tus reglas de negocio.
- **Listar transacciones de timbres** con paginación
- **Consultar transacciones** por ID
- **Transferir timbres** entre personas
- **Retirar timbres** de una persona
- **Créditos de validación SAT** transfiere y retira créditos de validación con el mismo servicio, eligiendo el saldo con `creditType`

## ✅ Validaciones SAT
- **Validación de CFDI timbrados** estructura del Anexo 20, vigencia del certificado del emisor, sello del CFDI y sello del SAT en el TimbreFiscalDigital
- **Estatus del comprobante en el SAT** vigente, cancelado o no encontrado
- **Listas negras del SAT** artículos 69-B y 69-B Bis del CFF, por CFDI o por RFC
- **Catálogo de validaciones** consulta los tipos disponibles y los estatus que cada uno puede tomar

## 🛍️ Gestión de Productos/Servicios
- **Gestión de productos y servicios** con catálogo personalizable
- **Administración de impuestos aplicables** (IVA, ISR, IEPS)

## 📚 Consulta de Catálogos SAT
- **Consulta en catálogos oficiales del SAT** actualizados
- **Consulta en catálogos oficiales de Descarga masiva del SAT** actualizados
- **Búsqueda de información** en catálogos del SAT con filtros avanzados
- **Acceso y búsqueda** en catálogos completos

## 📖 Recursos Adicionales
- **Cientos de ejemplos de código** disponibles en múltiples lenguajes de programación
- Documentación completa con guías paso a paso
- Ejemplos prácticos para casos de uso comunes
- Soporte técnico especializado
- Actualizaciones regulares conforme a cambios del SAT

## 📦 Instalación
Compatible con múltiples versiones de Java (desde **Java 8** en adelante)

**Maven**:
```xml
<dependency>
    <groupId>com.fiscalapi</groupId>
    <artifactId>fiscalapi</artifactId>
    <version>4.0.410</version>
</dependency>
```

**Gradle (Groovy)**:
```groovy
implementation 'com.fiscalapi:fiscalapi:4.0.410'
```

**Gradle (Kotlin)**:
```kotlin
implementation("com.fiscalapi:fiscalapi:4.0.410")
```

Para más información, consulta [Snippets en Maven Central](https://central.sonatype.com/artifact/com.fiscalapi/fiscalapi).

## ⚙️ Configuración

Puedes usar el SDK tanto en aplicaciones sin inyección de dependencias como en proyectos que usan Spring Boot. A continuación se describen ambas formas:

### A) Aplicaciones sin Inyección de Dependencias

1. **Crea tu objeto de configuración** con tus [credenciales](https://docs.fiscalapi.com/credentials-info): 
```java
FiscalApiSettings settings = new FiscalApiSettings();
settings.setDebugMode(true);
settings.setApiUrl("https://test.fiscalapi.com"); // https://live.fiscalapi.com (producción) 
settings.setApiKey("<api-key>");
settings.setTenant("<tenant-key>");
FiscalApiClient client = FiscalApiClient.create(settings);
```

2. **Utiliza los servicios** de `FiscalApiClient` según tus necesidades (ver ejemplos más adelante).

---

### B) Aplicaciones con Spring Boot

1. **Agrega la configuración** en tu `application.properties` o `application.yml`:
```yaml
fiscalapi:
  api-url: https://test.fiscalapi.com
  api-key: <YourApiKeyHere>
  tenant: <YourTenantHere>
```

2. **Registra el bean** en tu configuración de Spring:
```java
@Configuration
public class FiscalApiConfig {
    @Bean
    public FiscalApiClient fiscalApiClient(
        @Value("${fiscalapi.api-url}") String apiUrl,
        @Value("${fiscalapi.api-key}") String apiKey,
        @Value("${fiscalapi.tenant}") String tenant
    ) {
        FiscalApiSettings settings = new FiscalApiSettings();
        settings.setApiUrl(apiUrl);
        settings.setApiKey(apiKey);
        settings.setTenant(tenant);
        return FiscalApiClient.create(settings);
    }
}
```

Posteriormente, podrás **inyectar** `FiscalApiClient` donde lo requieras:

```java
@RestController
public class InvoicesController {
    private final FiscalApiClient fiscalApi;

    public InvoicesController(FiscalApiClient fiscalApi) {
        this.fiscalApi = fiscalApi;
    }
    
    // Usa fiscalApi en tus métodos del controlador...
}
```

## 📝 Ejemplos de Uso

### 1. Crear una Persona

```java
// ***Crear persona ***//
Person person = new Person();
person.setLegalName("MI EMPRESA");
person.setCapitalRegime("S.A De C.V");
person.setEmail("john.doe@fiscalapi.com");
person.setPassword("Password123!");
ApiResponse<Person> apiResponse = client.getPersonService().create(person);
System.out.printf("apiResponse: %s\n", apiResponse);
```

---

### 2. Subir Certificados CSD

```java
// ***Subir archivo .cer (certificado)***//
TaxFile archivoCer = new TaxFile();
archivoCer.setPersonId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
archivoCer.setTin("FUNK671228PH6");
archivoCer.setBase64File("MIIFgDCCA2igAwIBAgIUMzAwMDEwMDAwMDA1MDAwMDM0NDYwDQYJKoZIhvcNAQELBQAwggEr...");
archivoCer.setFileType(0); // 0 para certificado
archivoCer.setPassword("12345678a");

ApiResponse<TaxFile> apiResponseCer = client.getTaxFileService().create(archivoCer);
System.out.printf("apiResponse: %s\n", apiResponseCer);


// ***Subir archivo .key (clave privada)***//
TaxFile archivoKey = new TaxFile();
archivoKey.setPersonId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
archivoKey.setTin("FUNK671228PH6");
archivoKey.setBase64File("MIIFDjBABgkqhkiG9w0BBQ0...==");
archivoKey.setFileType(1); // 1 para llave privada
archivoKey.setPassword("12345678a");

ApiResponse<TaxFile> apiResponseKey = client.getTaxFileService().create(archivoKey);
System.out.printf("apiResponse: %s\n", apiResponseKey);
```

---

### 3. Crear un Producto o Servicio

```java
// ***Crear producto***//
Product product = new Product();
product.setDescription("Libro de Java sin impuestos");
product.setUnitPrice(100.75986);
ApiResponse<Product> apiResponseProduct = client.getProductService().create(product);
System.out.printf("apiResponse: %s\n", apiResponseProduct);
```

---

### 4. Crear una Factura de Ingreso (Por Referencias)

```java
// Generar factura por referencias
Invoice invoice = new Invoice();
invoice.setVersionCode("4.0");
invoice.setSeries("F");
invoice.setDate(LocalDateTime.now());
invoice.setPaymentFormCode("01");
invoice.setCurrencyCode("MXN");
invoice.setTypeCode("I");
invoice.setExpeditionZipCode("42501");
invoice.setPaymentMethodCode("PUE");

// Emisor por referencia
InvoiceIssuer issuer = new InvoiceIssuer();
issuer.setId("3f3478b4-60fd-459e-8bfc-f8239fc96257");
invoice.setIssuer(issuer);

// Receptor por referencia
InvoiceRecipient recipient = new InvoiceRecipient();
recipient.setId("96b46762-d246-4a67-a562-510a25dbafa9");
invoice.setRecipient(recipient);

// Producto / Servicio por referencia
List<InvoiceItem> items = new ArrayList<>();
InvoiceItem item = new InvoiceItem();
item.setId("114a4be5-fb65-40b2-a762-ff0c55c6ebfa");
item.setQuantity(2.0);
item.setDiscount(255.85);
items.add(item);
invoice.setItems(items);

ApiResponse<Invoice> apiResponseInvoice = client.getInvoiceService().create(invoice);
System.out.println(apiResponseInvoice);
```

---

### 5. Validar un CFDI ante el SAT

Cada tipo de validación solicitado consume un crédito de validación. El cobro es todo o nada: si el saldo no alcanza para todos, no se ejecuta ninguno. Se envía `xml` (CFDI timbrado en base64) o `tin` (RFC), nunca ambos; con `tin` solo se pueden solicitar listas negras.

```java
// *** Validar un CFDI timbrado ***//
SatValidationRequest request = new SatValidationRequest();
request.setXml(Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("C:\\facturas\\FacturaXml.xml"))));
request.setValidationTypes(new ArrayList<>(Arrays.asList(
        SatValidationTypeIds.XML_STRUCTURE,
        SatValidationTypeIds.CFDI_SELLO,
        SatValidationTypeIds.CFDI_STATUS,
        SatValidationTypeIds.BLACKLIST_69B)));

ApiResponse<List<SatValidationResult>> apiResponse = client.getSatValidationService().validate(request);

for (SatValidationResult result : apiResponse.getData()) {
    System.out.printf("%s -> %s (passed: %s)%n",
            result.getType().getId(), result.getStatus().getId(), result.isPassed());
}
```

---

### 6. Transferir créditos de validación

El mismo servicio de timbres mueve los dos saldos, que nunca se mezclan: `CreditType.STAMP` (por defecto) mueve timbres y `CreditType.VALIDATION` mueve créditos de validación SAT.

```java
// *** Transferir créditos de validación ***//
StampTransactionParams transParams = new StampTransactionParams();
transParams.setFromPersonId("0e82a655-5f0c-4e07-abab-8f322e4123ef");
transParams.setToPersonId("da71df0c-f328-45ee-9bd9-3096ed02c164");
transParams.setAmount(10);
transParams.setComments("venta de creditos de validacion");
transParams.setCreditType(CreditType.VALIDATION);

ApiResponse<Boolean> apiResponse = client.getStampService().transferStamps(transParams);
System.out.printf("apiResponse: %s\n", apiResponse);
```

---

💡 **Tip:** Para más ejemplos (facturas por valores, notas de crédito, complementos de pago, catálogos SAT, cancelaciones, etc.), revisa la documentación oficial en [docs.fiscalapi.com](https://docs.fiscalapi.com).

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia **Apache 2.0**. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## 🔗 Enlaces Útiles

- [Documentación Oficial](https://docs.fiscalapi.com)
- [Portal de FiscalAPI](https://fiscalapi.com)
- [Ejemplos Java](https://github.com/FiscalAPI/fiscalapi-samples-spring/blob/main/src/main/java/com/fiscalapi/samples/spring/AllSamples.java)
- [Ejemplos Spring Boot](https://github.com/FiscalAPI/fiscalapi-samples-spring)
- [Postman Collection](https://documenter.getpostman.com/view/4346593/2sB2j4eqXr)
- [SDKs](https://docs.fiscalapi.com/sdks)
---

Desarrollado con ❤️ por [Fiscalapi](https://www.fiscalapi.com)
