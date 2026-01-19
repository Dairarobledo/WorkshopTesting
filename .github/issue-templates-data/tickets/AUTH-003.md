---
title: "AUTH-003 — Login permite acceso incorrecto"
labels: ["ticket", "junit", "mockito", "nested"]
---

**Descripción**  
Se han detectado accesos incorrectos al sistema en situaciones no autorizadas.

**Módulo afectado**
- `es.fplumara.dam1.auth`

**Casos reportados**
- Usuario inexistente accede
- Usuario inactivo accede

**Comportamiento esperado**
- Usuario inexistente → acceso denegado
- Usuario inactivo → acceso denegado

**Features obligatorias**  
**JUnit**
- `@Nested` (escenarios)
- `@DisplayName` en cada bloque `@Nested`
- `@Test`

**Mockito**
- `@ExtendWith(MockitoExtension.class)`
- `@Mock` (repo + hasher)
- `@InjectMocks`
- `when(...).thenReturn(...)`

**Tareas**
1. Crea `AuthServiceTest` organizado por escenarios con `@Nested`.
2. Escribe el test que reproduzca el fallo del “usuario inexistente”.
3. Corrige el código y deja el test en verde.

**Criterios de cierre**
- Test por escenarios con `@Nested`
- `mvn test` en verde