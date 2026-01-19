---
title: "LAB-MO-01 — verify times / atLeast / atMost"
labels: ["lab", "mockito"]
---

**Objetivo**  
Verificar número de llamadas.

**Features obligatorias (Mockito)**
- `verify(..., times(n))`
- `verify(..., atLeastOnce())`
- `verify(..., atMost(n))`

**Tareas**  
Mockea `UserService`, ejecuta `BulkRegistrar.registerAll(...)` y verifica llamadas.

**Entrega**
- 1 test que valide contadores.