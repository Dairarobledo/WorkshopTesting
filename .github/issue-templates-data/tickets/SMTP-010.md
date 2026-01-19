---
title: "SMTP-010 — Error al enviar notificaciones"
labels: ["ticket", "mockito", "void", "junit"]
---

**Descripción**  
Cuando el servicio de correo falla, el sistema se comporta de forma inesperada.

**Módulo afectado**
- `es.fplumara.dam1.users`

**Comportamiento esperado**  
Define y documenta una regla clara:
- ¿Debe propagarse la excepción?
- ¿Debe ignorarse y continuar?

**Features obligatorias**  
**Mockito**
- `doThrow(new RuntimeException("SMTP down")).when(emailSender).sendWelcomeEmail(anyString())`
- `verify(...)` + `never()` según la regla

**JUnit**
- `@DisplayName` explicando la regla
- `assertThrows` **o** `assertDoesNotThrow` (según la regla elegida)

**Tareas**
1. Elige una regla (y escríbela en el `@DisplayName` del test).
2. Simula el fallo de SMTP con `doThrow`.
3. Verifica efectos colaterales con `verify`/`never`.

**Criterios de cierre**
- Regla documentada
- Test reproducible
- `mvn test` en verde