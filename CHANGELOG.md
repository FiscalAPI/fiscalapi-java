# Changelog

Cambios del SDK y notas de comportamiento del API de FiscalAPI que afectan a quien usa el SDK.

## [Sin publicar]

### Modelo `Person`

- `capitalRegime` queda obsoleto (`@Deprecated`): el API no tiene régimen de capital, ignora el valor y no lo devuelve. Envíe la razón social sin régimen de capital en `legalName`. Se conserva para no romper a quien lo usa.
- Nuevos miembros:
  - `phoneNumber`: lo aceptan la creación y la actualización de personas.
  - `country`: país de residencia fiscal expandido (solo lectura).
  - `balances`: saldos por tipo de crédito (`CreditBalance`: `creditType` y `available`, solo lectura). Solo aparecen los tipos que la persona ha tenido; un tipo ausente tiene saldo 0, y `creditType` es `Integer` para conservar un tipo que el SDK no conoce.
  - `isOwner`: `true` si la persona es el owner de su tenant (solo lectura).
- `password`: requerida al crear; al actualizar, `null` o vacía conserva la contraseña actual. El API nunca la devuelve.
- `userTypeId`: `"C"` (cliente, el valor por omisión al crear) o `"U"` (usuario). `"T"` (tenant) solo llega en respuestas: el API lo rechaza al crear y al actualizar solo lo acepta si la persona ya es `"T"`.
- Se quitan los campos comentados `twoFactorEnabled`, `stripePaymentMethodId` y `stripePaymentMethod`, que el API ya no devuelve.

### Notas del API (sin cambio de forma en el SDK)

- `Person.taxPassword` es la contraseña de la llave privada (.key) que la persona guarda en su perfil; el API no la usa para sellar (al timbrar usa la contraseña de los certificados registrados o la de `taxCredentials`). Solo la reciben con valor la propia persona y el owner del tenant; los demás reciben `null`. Al actualizar, `null` la conserva (el SDK no envía los `null`) y `""` la borra.
- `ValidationFailure.attemptedValue` (y el placeholder `PropertyValue` de `formattedMessagePlaceholderValues`): en un 400 de validación, el valor de un secreto (contraseñas, códigos, tokens, archivos y contraseñas de CSD/FIEL) llega enmascarado como `"[masked: n]"` (`n` es su longitud), o `"[masked]"` si la falla es de un objeto o una lista que lo contiene.
- `TaxCredential.password` solo se exige en la llave privada (.key); en el certificado (.cer) el API no la usa.

### Ejemplos

- README y `Examples.java` sin `setCapitalRegime`.
