---
title: "AUTH-004 — Validación de contraseña inconsistente"
labels: ["ticket", "junit", "mockito", "nested"]
---

**Descripción**  
Usuarios activos a veces acceden con contraseñas incorrectas.

**Módulo afectado**
- `es.fplumara.dam1.auth`

**Comportamiento esperado**
- Solo contraseña correcta permite acceso

**Features obligatorias**  
**JUnit**
- `@Nested`
- `assertFalse` y `assertTrue` (en casos distintos)

**Mockito**
- `when(repo.findByEmail(...)).thenReturn(Optional.of(...))`
- `when(hasher.hash(...)).thenReturn(...)`

**Tareas**
1. Dentro de `AuthServiceTest`, añade escenarios:
    - contraseña incorrecta → `false`
    - credenciales correctas → `true`
2. Verifica que todos los escenarios quedan cubiertos y pasan.

**Criterios de cierre**
- Escenarios completos en `@Nested`
- `mvn test` en verde