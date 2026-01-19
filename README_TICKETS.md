# **🐛 TICKETS ABIERTOS**

---

## **🎫 DIV-001 — División inconsistente**

**Descripción**

En algunos cálculos se están obteniendo resultados incorrectos al dividir.

El sistema no avisa de errores y devuelve valores inesperados.

**Módulo afectado**

- es.fplumara.dam1.core.calculator

**Impacto**

Cálculos incorrectos en informes y estadísticas.

**Comportamiento esperado**

- Dividir entre cero **no es una operación válida**
- El sistema debe **avisar claramente del error**

**Tareas**

- Escribe un test que demuestre el problema
- Define el tipo de excepción y el mensaje estándar
- Corrige el código hasta que el test pase

---

## **🎫 AGE-002 — Validación incorrecta de edad**

**Descripción**

Se ha detectado que se aceptan edades fuera del rango permitido por normativa.

**Módulo afectado**

- es.fplumara.dam1.core.validation

**Regla de negocio**

- Edad válida: **0 a 120** (ambos inclusive)

**Comportamiento esperado**

- Valores fuera del rango deben considerarse inválidos

**Pistas técnicas**

- Usa tests parametrizados
- Evita duplicación de tests

---

## **🎫 TXT-007 — Normalización de texto defectuosa**

**Descripción**

Al comparar textos, algunos valores no coinciden aunque visualmente sean iguales.

**Ejemplo reportado**

- " Hola " y "hola" se tratan como distintos

**Módulo afectado**

- es.fplumara.dam1.core.util

**Comportamiento esperado**

- Normalización consistente para comparaciones
- El resultado debe ser predecible

---

## **🎫 AUTH-003 — Login permite acceso incorrecto**

**Descripción**

Se han detectado accesos incorrectos al sistema en situaciones no autorizadas.

**Módulo afectado**

- es.fplumara.dam1.auth

**Casos reportados**

- Usuario inexistente accede
- Usuario inactivo accede

**Comportamiento esperado**

- Usuario inexistente → acceso denegado
- Usuario inactivo → acceso denegado

**Pistas técnicas**

- Organiza los tests por escenarios
- Piensa en términos de “cuando ocurre X…”

---

## **🎫 AUTH-004 — Validación de contraseña inconsistente**

**Descripción**

Usuarios activos a veces acceden con contraseñas incorrectas.

**Módulo afectado**

- es.fplumara.dam1.auth

**Comportamiento esperado**

- Solo contraseña correcta permite acceso

**Pistas técnicas**

- Aísla dependencias
- Simula respuestas controladas

---

## **🎫 USER-005 — Registro duplicado por formato de email**

**Descripción**

Se están registrando usuarios duplicados por diferencias de formato en el email.

**Ejemplo reportado**

- " A@B.COM "
- "a@b.com"

**Impacto**

Usuarios duplicados y notificaciones erróneas.

**Módulo afectado**

- es.fplumara.dam1.users

**Comportamiento esperado**

- El sistema debe tratar ambos emails como el mismo
- El email almacenado debe ser consistente

**Pistas técnicas**

- Verifica qué valor se usa para consultar el repositorio
- Inspecciona qué valor se guarda realmente

---

## **🎫 REP-006 — Exportación de reportes incorrecta**

**Descripción**

Los reportes se exportan pero no se pueden abrir correctamente.

**Módulo afectado**

- es.fplumara.dam1.reporting

**Impacto**

Pérdida de información y errores en procesos automáticos.

**Comportamiento esperado**

- El fichero exportado debe:
    - tener el nombre correcto
    - existir físicamente
    - contener exactamente el contenido generado

**Pistas técnicas**

- Usa rutas temporales
- No escribas en el sistema real

---

## **🎫 ORD-009 — Orden incorrecto de operaciones**

**Descripción**

Se han enviado notificaciones aunque la operación principal haya fallado.

**Módulo afectado**

- es.fplumara.dam1.users

**Comportamiento esperado**

- Primero se realiza la operación principal
- Solo después se notifica

**Pistas técnicas**

- Verifica el orden de llamadas
- No basta con saber que se llaman

---

## **🎫 SMTP-010 — Error al enviar notificaciones**

**Descripción**

Cuando el servicio de correo falla, el sistema se comporta de forma inesperada.

**Módulo afectado**

- es.fplumara.dam1.users

**Comportamiento esperado**

Define y documenta una regla clara:

- ¿Debe propagarse la excepción?
- ¿Debe ignorarse y continuar?

**Pistas técnicas**

- Simula fallos en métodos void
- Verifica efectos colaterales

---

## **🎫 CI-011 — Tests dependientes del entorno**

**Descripción**

Algunos tests solo deben ejecutarse en ciertos entornos (CI, sistema operativo).

**Objetivo**

Aprender a **saltar tests conscientemente**, no a ocultar errores.

**Pistas técnicas**

- Usa assumptions
- Un test “skipped” no es un fallo

---
