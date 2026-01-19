---
title: "LAB-JU-10 — assertTimeoutPreemptively"
labels: ["lab", "junit", "timeout"]
---

**Objetivo**  
Cortar ejecuciones largas de forma agresiva.

**Features obligatorias (JUnit)**
- `assertTimeoutPreemptively(Duration.ofMillis(...), ...)`

**Tareas**  
Crea un test con un bloque que tardaría demasiado y fuerza el timeout.

**Entrega**
- 1 test que use `assertTimeoutPreemptively`.