# Fiscalapi SDK para Java

[![Maven Central](https://img.shields.io/maven-central/v/com.fiscalapi/fiscalapi)](https://search.maven.org/artifact/com.fiscalapi/fiscalapi)
[![License](https://img.shields.io/github/license/FiscalAPI/fiscalapi-java)](https://github.com/FiscalAPI/fiscalapi-java/blob/main/LICENSE)

**SDK oficial de FiscalAPI para Java**, la API de facturación CFDI y otros servicios fiscales en México. Simplifica la integración con los servicios de facturación electrónica, eliminando las complejidades del SAT y facilitando la generación de facturas, notas de crédito, complementos de pago, nómina, carta porte, y más. ¡Factura sin dolor!

## 🚀 Características

- Soporte completo para **CFDI 4.0**
- Compatible con múltiples versiones de Java (desde **Java 8** en adelante)
- Dos [modos de operación](https://docs.fiscalapi.com/modes-of-operation): **Por valores** o **Por referencias**
- Manejo simplificado de errores
- Búsqueda en catálogos del SAT
- Documentación completa y ejemplos prácticos

## 📦 Instalación

Snippets de instalación más comunes:

**Maven**:
```xml
<dependency>
    <groupId>com.fiscalapi</groupId>
    <artifactId>fiscalapi</artifactId>
    <version>4.0.125</version>
</dependency>
```

**Gradle (Groovy)**:
```groovy
implementation 'com.fiscalapi:fiscalapi:4.0.125'
```

**Gradle (Kotlin)**:
```kotlin
implementation("com.fiscalapi:fiscalapi:4.0.125")
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

💡 **Tip:** Para más ejemplos (facturas por valores, notas de crédito, complementos de pago, catálogos SAT, cancelaciones, etc.), revisa la documentación oficial en [docs.fiscalapi.com](https://docs.fiscalapi.com).

💡 [Más ejemplos Java](https://github.com/FiscalAPI/fiscalapi-java/blob/main/src/main/java/com/fiscalapi/Examples.java)

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia **Apache 2.0**. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## 🔗 Enlaces Útiles

- [Documentación Oficial](https://docs.fiscalapi.com)
- [Portal de FiscalAPI](https://fiscalapi.com)
- [Ejemplos Java](https://github.com/FiscalAPI/fiscalapi-samples-spring/blob/main/src/main/java/com/fiscalapi/samples/spring/AllSamples.java)
- [Ejemplos Spring Boot](https://github.com/FiscalAPI/fiscalapi-samples-spring)

---

Desarrollado con ❤️ por [Fiscalapi](https://www.fiscalapi.com)
