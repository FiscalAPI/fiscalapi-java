# FiscalAPI SDK para Java

[![Maven Central](https://img.shields.io/maven-central/v/com.fiscalapi/fiscalapi)](https://search.maven.org/artifact/com.fiscalapi/fiscalapi)
[![License](https://img.shields.io/github/license/FiscalAPI/fiscalapi-java)](https://github.com/FiscalAPI/fiscalapi-java/blob/main/LICENSE)

**SDK oficial de FiscalAPI para Java**, la API de facturación CFDI y otros servicios fiscales en México. Simplifica la integración con los servicios de facturación electrónica, eliminando las complejidades del SAT y facilitando la generación de facturas, notas de crédito, complementos de pago, nómina, carta porte, y más. ¡Factura sin dolor!

## 🚀 Características

- Soporte completo para **CFDI 4.0**
- Compatible con múltiples versiones de Java (desde **Java 8** en adelante)
- Operaciones asíncronas mediante CompletableFuture
- Dos modos de operación: **Por valores** o **Por referencias**
- Manejo simplificado de errores
- Búsqueda en catálogos del SAT
- Documentación completa y ejemplos prácticos

## 📦 Instalación

**Maven**:
```xml
<dependency>
    <groupId>com.fiscalapi</groupId>
    <artifactId>fiscalapi</artifactId>
    <version>4.0.120</version>
</dependency>
```

**Gradle**:
```groovy
implementation 'com.fiscalapi:fiscalapi:4.0.120'
```

## ⚙️ Configuración

Puedes usar el SDK tanto en aplicaciones sin inyección de dependencias como en proyectos que usan Spring Boot. A continuación se describen ambas formas:

### A) Aplicaciones sin Inyección de Dependencias

1. **Crea tu objeto de configuración** con [tus credenciales](https://docs.fiscalapi.com/credentials-info):
```java
FiscalApiConfig config = new FiscalApiConfig.Builder()
    .apiUrl("https://test.fiscalapi.com") // https://live.fiscalapi.com (producción)
    .apiKey("<tu_api_key>")
    .tenant("<tenant>")
    .build();
```

2. **Crea la instancia del cliente**:
```java
FiscalApiClient fiscalApi = new FiscalApiClient(config);
```

Para ejemplos completos, consulta [java-examples](https://github.com/FiscalAPI/fiscalapi-samples-java).

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
        return new FiscalApiClient(new FiscalApiConfig.Builder()
            .apiUrl(apiUrl)
            .apiKey(apiKey)
            .tenant(tenant)
            .build());
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

### 1. Crear una Persona (Emisor o Receptor)

```java
Person request = new Person.Builder()
    .legalName("Persona de Prueba")
    .email("someone@somewhere.com")
    .password("YourStrongPassword123!")
    .build();

ApiResponse<Person> response = fiscalApi.persons().create(request);
```

### 2. Subir Certificados CSD

```java
TaxFile certificadoCsd = new TaxFile.Builder()
    .personId("984708c4-fcc0-43bd-9d30-ec017815c20e")
    .base64File("MIIFsDCCA5igAwIBAgI...==") // Certificado .cer codificado en Base64
    .fileType(FileType.CERTIFICATE_CSD)
    .password("12345678a")
    .tin("EKU9003173C9")
    .build();

TaxFile clavePrivadaCsd = new TaxFile.Builder()
    .personId("984708c4-fcc0-43bd-9d30-ec017815c20e")
    .base64File("MIIFDjBABgkqhkiG9w0BBQ0...==") // Llave privada .key codificada en Base64
    .fileType(FileType.PRIVATE_KEY_CSD)
    .password("12345678a")
    .tin("EKU9003173C9")
    .build();

ApiResponse<TaxFile> responseCer = fiscalApi.taxFiles().create(certificadoCsd);
ApiResponse<TaxFile> responseKey = fiscalApi.taxFiles().create(clavePrivadaCsd);
```

### 3. Crear un Producto o Servicio

```java
Product request = new Product.Builder()
    .description("Servicios contables")
    .unitPrice(new BigDecimal("100"))
    .satUnitMeasurementId("E48")
    .satTaxObjectId("02")
    .satProductCodeId("84111500")
    .build();

ApiResponse<Product> response = fiscalApi.products().create(request);
```

### 4. Crear una Factura de Ingreso (Por Referencias)

```java
Invoice invoice = new Invoice.Builder()
    .versionCode("4.0")
    .series("SDK-F")
    .date(LocalDateTime.now())
    .paymentFormCode("01")
    .currencyCode("MXN")
    .typeCode("I")
    .expeditionZipCode("42501")
    .issuer(new InvoiceIssuer.Builder()
        .id("<id-emisor-en-fiscalapi>")
        .build())
    .recipient(new InvoiceRecipient.Builder()
        .id("<id-receptor-en-fiscalapi>")
        .build())
    .addItem(new InvoiceItem.Builder()
        .id("<id-producto-en-fiscalapi>")
        .quantity(new BigDecimal("1"))
        .discount(new BigDecimal("10.85"))
        .build())
    .paymentMethodCode("PUE")
    .build();

ApiResponse<Invoice> response = fiscalApi.invoices().create(invoice);
```

[Continúa con el resto de ejemplos adaptados a Java...]

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia **Apache 2.0**. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## 🔗 Enlaces Útiles

- [Documentación Oficial](https://docs.fiscalapi.com)
- [Portal de FiscalAPI](https://fiscalapi.com)
- [Ejemplos Java](https://github.com/FiscalAPI/fiscalapi-samples-java)
- [Ejemplos Spring Boot](https://github.com/FiscalAPI/fiscalapi-samples-spring)

---

Desarrollado con ❤️ por [Fiscalapi](https://www.fiscalapi.com)