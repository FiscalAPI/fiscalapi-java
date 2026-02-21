# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Official Java SDK for FiscalAPI - a Mexican CFDI electronic invoicing service (SAT integration). Provides CFDI 4.0 invoicing, certificate management, mass downloads, payroll, and SAT catalog queries.

## Build Commands

```bash
mvn clean compile          # Compile
mvn test                   # Run tests
mvn package                # Create JAR
mvn clean deploy -Prelease # Deploy to Maven Central (requires GPG)
```

## Architecture

### Entry Point
`FiscalApiClient.create(FiscalApiSettings)` - Factory method creating the main client with all services.

### Service Layer Pattern
```
IFiscalApiClient (facade)
  ├── getInvoiceService()      → IInvoiceService extends IFiscalApiService<Invoice>
  ├── getPersonService()       → IPersonService extends IFiscalApiService<Person>
  ├── getProductService()      → IProductService extends IFiscalApiService<Product>
  ├── getTaxFileService()      → ITaxFileService extends IFiscalApiService<TaxFile>
  ├── getCatalogService()      → ICatalogService extends IFiscalApiService<CatalogDto>
  └── ... (other services)
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
SerializableDto → AuditableDto (createdAt, updatedAt) → BaseDto (id)
```
All models extend `BaseDto`. Responses wrapped in `ApiResponse<T>`.

### HTTP Layer
- `OkHttpClientFactory` - Creates/caches OkHttpClient instances with auth headers (X-API-KEY, X-TENANT-KEY, X-API-VERSION, X-TIMEZONE)
- `FiscalApiHttpClient` - Wraps OkHttp with Jackson, handles request/response logging in debug mode

### Key Packages
- `abstractions/` - Service interfaces
- `common/` - ApiResponse, PagedList, settings
- `http/` - HTTP client implementation
- `models/` - All DTOs (invoicing/, downloading/ subpackages)
- `services/` - Service implementations

## Configuration

```java
FiscalApiSettings settings = new FiscalApiSettings();
settings.setApiUrl("https://test.fiscalapi.com");  // or https://live.fiscalapi.com
settings.setApiKey("sk_test_...");
settings.setTenant("...");
settings.setDebugMode(true);  // Logs requests/responses
FiscalApiClient client = FiscalApiClient.create(settings);
```

## API Endpoint Pattern

`{apiUrl}/api/{apiVersion}/{resource}/{id?}/{action?}`

Example: `POST api/v4/invoices`, `GET api/v4/invoices/{id}?details=true`

## Dependencies

- OkHttp3 4.12.0 (HTTP)
- Jackson 2.14.2 (JSON)
- Java 8+ (source/target)
