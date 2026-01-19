---
title: "USER-005 — Registro duplicado por formato de email"
labels: ["ticket", "mockito", "captor", "junit"]
---

**Descripción**  
Se están registrando usuarios duplicados por diferencias de formato en el email.

**Ejemplo reportado**
- `" A@B.COM "`
- `"a@b.com"`

**Módulo afectado**
- `es.fplumara.dam1.users`

**Comportamiento esperado**
- El sistema debe tratar ambos emails como el mismo
- El email almacenado debe ser consistente (normalizado)

**Features obligatorias**  
**Mockito**
- `@ExtendWith(MockitoExtension.class)`
- `@Mock` (repo + emailSender + clock)
- `@InjectMocks`
- `verify(repo).existsByEmail(eq("a@b.com"))`
- `ArgumentCaptor<User>` (capturar el usuario guardado)
- `verify(emailSender).sendWelcomeEmail(eq("a@b.com"))`

**JUnit**
- `@Test`
- `assertAll` para validar el `User` capturado

**Tareas**
1. Diseña un test que obligue a normalizar el email (trim + lower).
2. Demuestra que falla al inicio.
3. Corrige el `UserService` para que normalice.

**Criterios de cierre**
- Se verifica el email normalizado en consulta, guardado y envío
- `mvn test` en verde