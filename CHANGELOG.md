# Changelog

Cambios del SDK y notas de comportamiento del API de FiscalAPI que afectan a quien usa el SDK.

## [Sin publicar]

### Cambios incompatibles (BREAKING)

- Se eliminan `Person.getCapitalRegime()` y `Person.setCapitalRegime(String)` (estaban `@Deprecated`): el API no tiene régimen de capital, ignoraba el valor y nunca lo devolvía. El código que los llama deja de compilar: quite esas llamadas y envíe la razón social sin régimen de capital con `setLegalName`.
- El API deja de devolver `stripeCustomerId` y `subscriptionStatus` en las personas (`/api/v4/people` y la persona de las reglas de descarga): eran datos internos de Stripe. Este SDK nunca los modeló en `Person` (estaban comentados y se quitan), así que el código que usa el modelo no cambia; si su integración los lee de la respuesta JSON cruda, quite esa lectura: el campo ya no llega.
- Se elimina la clase `com.fiscalapi.common.StripePaymentMethodDto` (`stripeId`, `stripeCustomerId`, `brand`, `last4`, `expMonth`, `expYear` y demás datos de tarjeta): modelaba los métodos de pago de Stripe, que el API retiró en agosto de 2026, y ningún servicio del SDK la usaba. El código que la importa o la instancia deja de compilar: quite el `import com.fiscalapi.common.StripePaymentMethodDto;` y esos usos; el API no expone métodos de pago ni datos de Stripe que la reemplacen.

### Modelo `Person`

- Nuevos miembros:
  - `phoneNumber`: lo aceptan la creación y la actualización de personas.
  - `country`: país de residencia fiscal expandido (solo lectura).
  - `balances`: saldos por tipo de crédito (`CreditBalance`: `creditType` y `available`, solo lectura). Solo aparecen los tipos que la persona ha tenido; un tipo ausente tiene saldo 0, y `creditType` es `Integer` para conservar un tipo que el SDK no conoce.
  - `isOwner`: `true` si la persona es el owner de su tenant (solo lectura).
  - `validTo` (`LocalDateTime`, `getValidTo()`): fin de vigencia de la persona (solo lectura: se puebla al deserializar y no se envía). La asigna el API; casi siempre es `null` y es informativa (no limita el timbrado ni el acceso al API).
- `password`: requerida al crear; al actualizar, `null` o vacía conserva la contraseña actual. El API nunca la devuelve.
- `userTypeId`: `"C"` (cliente, el valor por omisión al crear) o `"U"` (usuario). `"T"` (tenant) solo llega en respuestas: el API lo rechaza al crear y al actualizar solo lo acepta si la persona ya es `"T"`.
- Se quitan los campos comentados `twoFactorEnabled`, `stripePaymentMethodId`, `stripePaymentMethod`, `stripeCustomerId` y `subscriptionStatus`, que el API ya no devuelve (el comentado `validTo` pasa a ser miembro real).

### Notas del API (sin cambio de forma en el SDK)

- `Person.taxPassword` es la contraseña de la llave privada (.key) que la persona guarda en su perfil; el API no la usa para sellar (al timbrar usa la contraseña de los certificados registrados o la de `taxCredentials`). Solo la reciben con valor la propia persona y el owner del tenant; los demás reciben `null`. Al actualizar, `null` la conserva (el SDK no envía los `null`) y `""` la borra.
- `ValidationFailure.attemptedValue` (y el placeholder `PropertyValue` de `formattedMessagePlaceholderValues`): en un 400 de validación, el valor de un secreto (contraseñas, códigos, tokens, archivos y contraseñas de CSD/FIEL) llega enmascarado como `"[masked: n]"` (`n` es su longitud), o `"[masked]"` si la falla es de un objeto o una lista que lo contiene.
- `TaxCredential.password` solo se exige en la llave privada (.key); en el certificado (.cer) el API no la usa.
- `TaxFile.tin` es opcional en `getTaxFileService().create()`: si es `null` o vacío, el API usa el RFC de la persona. Si se envía, debe ser el RFC de la persona (sin distinguir mayúsculas); si no, el API responde 400 con la falla en `Tin` (después de comprobar que puede gestionar los certificados de la persona; si no, 403). El API no guarda el valor enviado: el `tin` del archivo siempre es el RFC de la persona.
- Las personas ya no traen `stripeCustomerId` ni `subscriptionStatus` (datos internos de Stripe). `validTo` y `committedBalance` son de solo lectura: el API los ignora al crear o actualizar. `committedBalance` es un campo heredado que el API ya no calcula y siempre vale 0; para el saldo use `availableBalance`, `availableValidationBalance` o `balances`.

### Ejemplos

- README y `Examples.java` sin `setCapitalRegime`.
