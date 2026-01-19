---
title: "LAB-JU-03 — @BeforeAll/@AfterAll sin static (PER_CLASS)"
labels: ["lab", "junit", "lifecycle"]
---

**Objetivo**  
Usar ciclo de vida de tests sin métodos `static`.

**Features obligatorias (JUnit)**
- `@TestInstance(TestInstance.Lifecycle.PER_CLASS)`
- `@BeforeAll` (no static)
- `@AfterAll` (no static)
- `TestInfo` (inyección en un test)

**Tareas**
1. Crea una clase de test nueva con PER_CLASS.
2. Guarda un flag/contador en `@BeforeAll`.
3. En un test, usa `TestInfo` (displayName o método).
4. En `@AfterAll`, verifica que se inicializó correctamente.

**Entrega**
- 1 clase de test con el ciclo de vida funcionando.