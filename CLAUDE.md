# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Official Java SDK for FiscalAPI - a Mexican CFDI electronic invoicing service (SAT integration). Provides CFDI 4.0 invoicing, certificate management, mass downloads, payroll, and SAT catalog queries. Published to Maven Central as `com.fiscalapi:fiscalapi`.

## Build Commands

```bash
mvn clean compile          # Compile
mvn package                # Create JAR
mvn clean deploy -Prelease # Deploy to Maven Central (requires GPG + settings.xml credentials)
```

No unit tests exist in this project currently. No linting or formatting tools are configured.

## Architecture

### Entry Point
`FiscalApiClient.create(FiscalApiSettings)` - Factory method creating the main client with all 10 services.

### Service Layer Pattern
```
IFiscalApiClient (facade)
  ├── getInvoiceService()          → IInvoiceService (cancel, status, getPdf, send, getXml)
  ├── getPersonService()           → IPersonService
  ├── getProductService()          → IProductService
  ├── getTaxFileService()          → ITaxFileService (getDefaultReferences, getDefaultValues)
  ├── getCatalogService()          → ICatalogService (custom search/query)
  ├── getApiKeyService()           → IApiKeyService
  ├── getStampService()            → IStampService (transfer, withdraw)
  ├── getDownloadCatalogService()  → IDownloadCatalogService
  ├── getDownloadRuleService()     → IDownloadRuleService
  └── getDownloadRequestService()  → IDownloadRequestService (cancel, retry, delete)
```

### Generic CRUD Base
All services extend `BaseFiscalApiService<T>` which implements standard CRUD:
- `getList(pageNumber, pageSize)` → `ApiResponse<PagedList<T>>`
- `getById(id, details)` → `ApiResponse<T>`
- `create(model)` → `ApiResponse<T>`
- `update(model)` → `ApiResponse<T>`
- `delete(id)` → `ApiResponse<Boolean>`

Subclasses must implement `getTypeParameterClass()` to return the entity type for Jackson deserialization.

### DTO Hierarchy
```
SerializableDto (toString() returns pretty-printed JSON)
  → AuditableDto (createdAt, updatedAt: LocalDateTime)
    → BaseDto (id: String)
```
All models extend `BaseDto`. Responses wrapped in `ApiResponse<T>`.

### HTTP Layer
- `OkHttpClientFactory` - Creates/caches OkHttpClient instances with auth headers (X-API-KEY, X-TENANT-KEY, X-API-VERSION, X-TIMEZONE). Default timezone: America/Mexico_City.
- `FiscalApiHttpClient` - Wraps OkHttp with Jackson. ObjectMapper configured with:
  - `JavaTimeModule` (LocalDateTime/ZonedDateTime support)
  - `FAIL_ON_UNKNOWN_PROPERTIES = false`
  - `WRITE_BIGDECIMAL_AS_PLAIN = true`
  - Non-null serialization inclusion
  - Custom `BigDecimalSerializer` in `serialization/` (avoids scientific notation)

### Key Packages
- `abstractions/` - Service interfaces (all prefixed with `I`)
- `common/` - ApiResponse, PagedList, FiscalApiSettings, BaseDto hierarchy
- `http/` - HTTP client implementation
- `models/` - All DTOs
  - `models/invoicing/` - Invoice, InvoiceItem, InvoiceIssuer, InvoiceRecipient, etc.
  - `models/invoicing/payroll/` - 13 payroll CFDI types (Payroll, EmployeeData, PayrollEarning, etc.)
  - `models/invoicing/paymentComplement/` - Payment complement models
  - `models/invoicing/localTaxes/` - Local tax models
  - `models/downloading/` - Mass download models
- `services/` - Service implementations
- `serialization/` - Custom Jackson serializers
- `examples/` - Usage examples (payroll, local taxes, stamps)

### Two Modes of Operation
The SDK supports two invoicing modes (see examples/):
- **By references** - Pass entity IDs, server resolves full data
- **By values** - Pass complete entity data inline

## Configuration

```java
FiscalApiSettings settings = new FiscalApiSettings();
settings.setApiUrl("https://test.fiscalapi.com");  // or https://live.fiscalapi.com
settings.setApiKey("sk_test_...");
settings.setTenant("...");
settings.setDebugMode(true);  // Logs requests/responses to console
// settings.setApiVersion("v4");  // default
// settings.setTimeZone("America/Mexico_City");  // default
FiscalApiClient client = FiscalApiClient.create(settings);
```

Spring Boot integration: Use `@Value` properties + `@Bean` registration (see README.md for full pattern).

## API Endpoint Pattern

`{apiUrl}/api/{apiVersion}/{resource}/{id?}/{action?}`

Example: `POST api/v4/invoices`, `GET api/v4/invoices/{id}?details=true`

## Deployment

GitHub Actions workflow (`.github/workflows/deploy.yml`): manual dispatch, builds with Java 8 Temurin, signs with GPG, deploys to Maven Central.

## Dependencies

- OkHttp3 4.12.0 (HTTP)
- Jackson 2.14.2 + JSR310 module (JSON + Java 8 time)
- Java 8+ (source/target)
