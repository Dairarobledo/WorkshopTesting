# **🧪 LABS JUNIT**

## **LAB-JU-01 — assertSame y assertNotSame con Singleton**

**Contexto:** hay un cache singleton compartido en el sistema.

**Dónde está:** util.core.es.fplumara.dam1.workshoptesting.SingletonCache

**Objetivo:** comprobar identidad (misma referencia), no igualdad.

**Features obligatorias:**

- assertSame
- assertNotSame
- @Test

**Tareas:**

1. SingletonCache.getInstance() llamado 2 veces debe ser el mismo objeto (assertSame).
2. Dos new Object() distintos nunca son el mismo (assertNotSame).

---

## **LAB-JU-02 — Mensajes personalizados en asserts**

**Contexto:** cuando falla un test, el mensaje debe explicar el “por qué”.

**Dónde:** reutiliza cualquier test (por ejemplo CalculatorTest).

**Features obligatorias:**

- assertEquals(expected, actual, "mensaje")
- assertTrue(cond, "mensaje")

**Tarea:**

- Añade mensajes en 3 asserts clave de tus tests.

---

## **LAB-JU-03 — @BeforeAll/@AfterAll + @TestInstance(PER_CLASS)**

**Contexto:** hay inicialización global (simulada) y quieres evitar métodos static.

**Dónde:** crea es.fplumara.dam1.core/LifecycleTest.java

**Features obligatorias:**

- @TestInstance(PER_CLASS)
- @BeforeAll (no static)
- @AfterAll (no static)
- TestInfo (inyectado en algún test)

**Tareas:**

1. En @BeforeAll, guarda un contador o un log simple.
2. En un test, usa TestInfo.getDisplayName() o getTestMethod().
3. En @AfterAll, verifica (con assert) que se ejecutó la inicialización.

---

## **LAB-JU-04 — @Tag para separar rápidos y lentos**

**Contexto:** en CI solo se ejecutan los tests rápidos.

**Dónde:** crea TaggedTests.java en src/test/java/es/fplumara/dam1/core/

**Features obligatorias:**

- @Tag("fast")
- @Tag("slow")

**Tareas:**

- Crea 2 tests fast y 1 slow (slow puede tener un loop simple).
- (Opcional) ejecuta por tag desde IDE.

---

## **LAB-JU-05 — @Disabled con motivo**

**Contexto:** hay una feature prevista pero aún no implementada.

**Dónde:** cualquier paquete test.

**Features obligatorias:**

- @Disabled("Pendiente de implementar...")

**Tarea:**

- Crea un test deshabilitado con explicación (1 frase).

---

## **LAB-JU-06 — @EnumSource con DayOfWeek**

**Contexto:** el sistema aplica reglas por día (ejercicio didáctico).

**Dónde:** crea test EnumSourceTest.java.

**Features obligatorias:**

- @ParameterizedTest
- @EnumSource(DayOfWeek.class)
- assertNotNull

**Tarea:**

- Un test que recorra todos los días y valide una regla simple (por ejemplo que day.name() no es null).

---

## **LAB-JU-07 — @MethodSource obligatorio (casos complejos)**

**Contexto:** necesitas datos complejos para validar la política de contraseñas.

**Dónde:** crea PasswordPolicyTest.java (aunque la policy sea simple).

**Features obligatorias:**

- @MethodSource
- Stream<Arguments>
- Arguments.of(...)

**Tarea:**

- Genera al menos 6 casos con Arguments.

---

## **LAB-JU-08 — @RepeatedTest con RepetitionInfo**

**Contexto:** comprobar estabilidad y aprender repetición.

**Dónde:** RepeatedStabilityTest.java

**Features obligatorias:**

- @RepeatedTest(5)
- parámetro RepetitionInfo

**Tarea:**

- Dentro del test, usa repetitionInfo.getCurrentRepetition() para cambiar el input y comprobar algo sencillo.

---

## **LAB-JU-09 — TestReporter para publicar info**

**Contexto:** en CI quieres logs legibles del test.

**Dónde:** ReporterTest.java

**Features obligatorias:**

- parámetro TestReporter
- reporter.publishEntry(...)

---

## **LAB-JU-10 — assertTimeoutPreemptively (cuando de verdad quieres cortar)**

**Contexto:** una operación no debe bloquear el pipeline.

**Dónde:** TimeoutTest.java

**Features obligatorias:**

- assertTimeoutPreemptively(Duration.ofMillis(...), ...)

**Tarea:**

- Crea un bloque que podría tardar (un bucle) y fuerza el timeout.

---

## **LAB-JU-11 (BONUS) — Tests dinámicos @TestFactory**

**Contexto:** quieres generar tests en runtime desde una lista.

**Features:**

- @TestFactory
- DynamicTest

---

# **🧪 LABS MOCKITO (cosas nuevas)**

## **LAB-MO-01 — times, atLeast, atMost**

**Contexto:** registrar en batch debe llamar varias veces.

**Dónde:** users.es.fplumara.dam1.workshoptesting.BulkRegistrar

**Features obligatorias:**

- verify(service, times(n))...
- verify(service, atLeastOnce())...
- verify(service, atMost(n))...

**Tarea:**

- Mockea UserService, llama registerAll(List.of(...)), y verifica contadores.

---

## **LAB-MO-02 — verifyNoInteractions / verifyNoMoreInteractions**

**Contexto:** si una validación falla, no se debe tocar ninguna dependencia.

**Features obligatorias:**

- verifyNoInteractions(mock1, mock2)
- verifyNoMoreInteractions(mock)

**Tarea:**

- Crea un escenario en el que se lance excepción antes de llamar a dependencias (según tu regla) y verifica “0 interacciones”.

---

## **LAB-MO-03 — Stubbing secuencial ( thenReturn en cadena)**

**Contexto:** repo responde distinto en llamadas consecutivas.

**Features obligatorias:**

- when(...).thenReturn(x).thenReturn(y)

**Tarea:**

- Simula que el primer existsByEmail devuelve false y el segundo true y valida el comportamiento esperado.

---

## **LAB-MO-04 — @Spy + doReturn (para enseñar la diferencia)**

**Contexto:** quieres espiar una lista real.

**Features obligatorias:**

- @Spy o spy(obj)
- doReturn(...).when(spy).method(...)

**Tarea:**

- Espía una ArrayList, stubea size() para que devuelva un valor fijo sin ejecutar lógica real.

---

## **LAB-MO-05 — Captor múltiple (capturar varias llamadas)**

**Contexto:** quieres ver qué emails se enviaron en un batch.

**Features obligatorias:**

- ArgumentCaptor<String>
- captor.getAllValues()

**Tarea:**

- Lanza varias llamadas a sendWelcomeEmail y captura todas.

---

## **LAB-MO-06 (BONUS) — Mock estático con mockito-inline**

**Contexto:** legado usa TextUtils.normalize estático.

**Features:**

- try (MockedStatic<TextUtils> mocked = mockStatic(...)) { ... }