# Pull Request – Ae6

## Objetivo

Proteger las reglas principales del módulo de reservas mediante una suite JUnit 5 reproducible, con casos normales, alternativos, límites, inválidos y excepciones, además de verificar las interacciones relevantes de las dependencias de `ReservaService`.

## Cambios realizados

- Se amplió `ReservaServiceTest` con 14 casos relevantes.
- Se aplicó la estructura AAA: Arrange, Act y Assert.
- Se utilizaron dobles de prueba Mockito para disponibilidad, repositorio y notificador únicamente en el comportamiento `confirmar()`, donde existen dependencias externas al servicio.
- Se verificaron interacciones de persistencia y notificación.
- Se incorporó la matriz de casos y el análisis de cobertura JaCoCo.
- Se documentó la autorrevisión y las limitaciones.

## Casos de prueba

- Cancelación: caso normal, límite válido y valores por debajo del límite.
- Descuentos: NORMAL, VIP, ESTUDIANTE, comparación sin sensibilidad a mayúsculas y valor cero.
- Invalidación: total negativo.
- Confirmación: disponible, no disponible y reserva nula.
- Interacciones: guardar/notificar y ausencia de esas interacciones cuando la reserva no puede confirmarse.

## Cómo verificar

```bash
mvn clean test
```

El reporte de cobertura queda en:

```text
target/site/jacoco/index.html
```

## Cobertura

La cobertura debe interpretarse junto con los caminos de negocio. El objetivo de la suite no es aumentar artificialmente el porcentaje, sino cubrir decisiones relevantes de `ReservaService`, incluyendo las ramas de error y las interacciones del flujo de confirmación.

## Limitaciones

- No se cubren implementaciones reales de infraestructura porque el proyecto base solo define interfaces para disponibilidad, persistencia y notificación.
- No se realizan pruebas de integración ni de base de datos.
- El alcance se concentra en las reglas indicadas para Ae6.

## Autorrevisión

- [x] Compila.
- [x] Pruebas en verde.
- [x] No se incluyen archivos generados de `target/`.
- [x] Los nombres de pruebas describen el comportamiento.
- [x] Las aserciones comprueban resultados e interacciones relevantes.
- [x] Se cubren casos límite e inválidos.
- [x] Los mocks se utilizan en dependencias reales del servicio.
- [x] La cobertura se interpreta y no se usa como único criterio.
- [x] Los commits deben documentar la evolución.
- [x] El PR incluye instrucciones de verificación.

## Uso de IA

Se utilizó ChatGPT como apoyo para organizar la matriz de casos, revisar la estructura de las pruebas, redactar documentación y explicar los resultados. Las decisiones finales, ejecución del proyecto, revisión del código y validación de las evidencias corresponden al estudiante.
