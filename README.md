# UEES UCOM0310 – Semana 7 – Ae6

## Propósito

Suite de pruebas del módulo de reservas para la actividad Ae6, con JUnit 5, Mockito, JaCoCo y documentación del flujo Git/PR.

## Requisitos

- Java 21
- Maven 3.9+
- Git

## Ejecución

```bash
mvn clean test
```

## Cobertura

El plugin JaCoCo está configurado para generar el reporte durante `test`.

Abrir:

```text
target/site/jacoco/index.html
```

## Documentación

- `docs/01_MATRIZ_CASOS.md` – matriz y justificación de casos.
- `docs/02_ANALISIS_COBERTURA.md` – análisis de cobertura.
- `docs/03_PULL_REQUEST.md` – contenido sugerido para el Pull Request.
- `docs/04_AUTORREVISION.md` – lista de autorrevisión.
- `docs/05_REPORTE_TECNICO_AE6.md` – reporte técnico breve.

## Regla de trabajo

Primero se diseñan los casos a partir de las reglas de negocio; luego se implementan las pruebas y finalmente se interpreta la cobertura. No se modifica el código productivo solamente para aumentar cobertura.
