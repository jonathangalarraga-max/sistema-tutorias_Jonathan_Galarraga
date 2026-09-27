# Reporte técnico – Ae6 | Suite de pruebas, cobertura y Pull Request

**Asignatura:** Diseño de Software – UCOM0310  
**Actividad:** Ae6 – Semana 7  
**Modalidad:** Individual  
**Proyecto:** Semana 7 – Sistema de reservas

## 1. Objetivo de Ae6

El objetivo de esta actividad es aplicar de manera integrada el diseño de casos de prueba, JUnit 5, estructura AAA, Stub/Mock, cobertura con JaCoCo y trazabilidad mediante Git y Pull Request. La solución protege las reglas principales del `ReservaService` mediante una suite reproducible.

La actividad solicita considerar cancelación, descuentos y confirmación, con casos normales, alternativos, límite, inválidos y excepciones. fileciteturn0file0L25-L32

## 2. Reglas y matriz de casos

Las reglas analizadas son:

1. Una reserva puede cancelarse cuando existen al menos 2 horas de anticipación.
2. El total NORMAL no recibe descuento; VIP recibe 15 % de descuento y ESTUDIANTE 10 %.
3. Una confirmación requiere una reserva válida y disponibilidad. Cuando se confirma, se actualiza el estado y se ejecutan las acciones de guardar y notificar.

La matriz contiene 14 casos. Se incluyeron valores normales, límites, alternativos, inválidos y excepciones. Los casos de límite son especialmente importantes en `puedeCancelar`, porque el valor 2 representa el umbral exacto.

## 3. Implementación JUnit 5 y AAA

La suite se implementó en `ReservaServiceTest.java`.

Cada prueba sigue la lógica:

- **Arrange:** prepara datos, objetos y dobles de prueba.
- **Act:** ejecuta el método bajo prueba.
- **Assert:** comprueba el resultado, estado, excepción o interacción.

Se utilizaron pruebas parametrizadas para las reglas NORMAL, VIP y ESTUDIANTE. Esto evita duplicación y mantiene explícita la relación entre entrada y resultado esperado.

También se utilizó `assertThrows` para las reglas que deben rechazar entradas inválidas.

## 4. Stub/Mock utilizados y justificación

En `confirmar()` existen tres dependencias: `DisponibilidadClient`, `ReservaRepository` y `Notificador`.

El cliente de disponibilidad se controla como **Stub** al definir su respuesta con:

```java
when(disponibilidad.estaDisponible(reserva)).thenReturn(true);
```

Esto permite aislar la regla del servicio de un sistema externo y decidir de manera reproducible si el horario está disponible o no.

El repositorio y el notificador se tratan como **Mocks** cuando se verifican interacciones:

```java
verify(repository).guardar(reserva);
verify(notificador).enviarConfirmacion(reserva);
```

Estas verificaciones son relevantes porque confirmar una reserva no consiste únicamente en cambiar el estado: el flujo también debe persistir la reserva y enviar la confirmación.

En el escenario no disponible se verifica lo contrario: no debe guardar ni notificar. En la reserva nula se verifica que ninguna dependencia sea consultada.

Este uso está alineado con la guía, que solicita justificar qué dependencia se controla como Stub, qué interacciones se verifican como Mock y por qué son relevantes. fileciteturn0file0L88-L103

## 5. Resultado de `mvn clean test`

La evidencia final debe generarse ejecutando desde cero:

```bash
mvn clean test
```

La guía exige que la ejecución final sea limpia y que cualquier prueba fallida sea corregida antes de generar la evidencia. fileciteturn0file0L104-L106

**Evidencia pendiente de captura:** ejecutar el comando en el equipo del estudiante con Java 21 y Maven 3.9+ y añadir una captura donde se observe `BUILD SUCCESS`.

No se inventa un resultado de ejecución en este documento porque el entorno utilizado para preparar la solución no dispone del comando Maven.

## 6. Cobertura JaCoCo e interpretación

JaCoCo se genera mediante la configuración existente en `pom.xml`. Después de ejecutar las pruebas, el reporte se encuentra en:

```text
target/site/jacoco/index.html
```

La guía solicita analizar al menos `ReservaService`, identificar métodos o ramas con menor cobertura, señalar un hueco relevante y añadir una prueba a partir de ese análisis. fileciteturn0file0L107-L116

La suite fue diseñada para cubrir las decisiones principales: límite de cancelación, entrada negativa, tipos de descuento, disponibilidad verdadera/falsa y reserva nula.

**Evidencia pendiente de captura:** copiar el porcentaje real de líneas y ramas mostrado por JaCoCo y adjuntar la captura del detalle de `ReservaService`.

La cobertura no debe interpretarse como una medida absoluta de calidad. Una línea ejecutada no demuestra que la aserción sea correcta ni que se hayan elegido todos los escenarios importantes. Por eso la matriz de casos precede al análisis de cobertura.

## 7. Flujo Git y commits

La actividad solicita una rama específica y una evolución incremental mediante commits descriptivos. fileciteturn0file0L117-L127

Se propone utilizar:

```bash
git switch main
git pull
git switch -c ae6/suite-pruebas
```

y commits como:

```text
test: agregar casos de cancelacion
test: cubrir descuentos y errores
test: agregar confirmacion con mocks
docs: analizar cobertura jacoco
docs: completar evidencia ae6
```

Al final:

```bash
git log --oneline --decorate
```

debe mostrar la evolución de la rama.

## 8. Pull Request y autorrevisión

El PR debe comparar:

```text
base: main
compare: ae6/suite-pruebas
```

y documentar objetivo, cambios, casos, instrucciones para ejecutar, cobertura, limitaciones y uso de IA. La guía establece esos elementos como parte de la descripción mínima. fileciteturn0file0L128-L150

Antes de entregar se debe revisar el diff línea por línea, evitar `target/`, comprobar que no existan credenciales, revisar nombres de pruebas, aserciones, casos límite, mocks, cobertura y commits. fileciteturn0file0L151-L161

## 9. Conclusiones, limitaciones y trabajo futuro

La suite permite convertir reglas de negocio del módulo de reservas en evidencia automatizada. Los casos de límite y excepción reducen el riesgo de aceptar entradas fuera de las reglas, mientras que los dobles de prueba permiten verificar el flujo de confirmación sin depender de implementaciones externas.

La principal limitación es que el proyecto base define interfaces para disponibilidad, persistencia y notificación, pero no implementaciones reales. Por ello esta Ae6 se concentra en pruebas unitarias y de interacción, no en pruebas de integración.

Como trabajo futuro se podrían incorporar pruebas de integración con implementaciones reales de persistencia, disponibilidad y notificación, además de ampliar escenarios de dominio.

## 10. Declaración de uso de IA

Se utilizó **ChatGPT** como herramienta de apoyo para organizar la matriz de casos, revisar la estructura AAA, proponer escenarios de prueba, apoyar la redacción de la documentación y explicar conceptos de JUnit, Mockito, JaCoCo y Git. La revisión final, adaptación del código al proyecto, ejecución de las pruebas y validación de las evidencias deben ser realizadas por el estudiante.

## Checklist final

La guía establece como elementos mínimos la matriz, suite ejecutable, evidencia de `mvn clean test`, JaCoCo, rama/commits, Pull Request, autorrevisión, reporte y README actualizado. fileciteturn0file0L215-L240

Antes de entregar, completar las evidencias marcadas como pendientes.
