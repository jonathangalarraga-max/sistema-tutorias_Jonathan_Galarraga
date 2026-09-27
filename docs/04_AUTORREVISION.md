# Autorrevisión técnica – Ae6

## Código y pruebas

- [x] La suite usa JUnit 5.
- [x] Los nombres de las pruebas describen el comportamiento esperado.
- [x] Se cubren escenarios normales.
- [x] Se cubren valores límite.
- [x] Se cubren entradas inválidas y excepciones.
- [x] Se verifican estados relevantes de `Reserva`.
- [x] Se usa Mockito solamente en dependencias de `ReservaService`.
- [x] Las interacciones verificadas tienen relación con el flujo de confirmación.
- [x] Se evita mockear objetos de dominio simples.

## Maven y cobertura

- [ ] Ejecutar `mvn clean test` en el equipo del estudiante y guardar captura de ejecución exitosa.
- [ ] Abrir `target/site/jacoco/index.html`.
- [ ] Copiar al reporte el porcentaje real de líneas y ramas observado.
- [ ] Guardar captura de `ReservaService` en JaCoCo.
- [ ] Confirmar que la evidencia corresponde a la versión final del código.

## Git

- [x] Se preparó una rama específica `ae6/suite-pruebas`.
- [x] La evolución se organiza mediante commits descriptivos.
- [ ] Publicar la rama en el repositorio remoto del estudiante.
- [ ] Verificar `git log --oneline --decorate`.
- [ ] Confirmar que `target/` no está incluido.

## Pull Request

- [x] Se preparó objetivo.
- [x] Se documentaron cambios.
- [x] Se incluyeron instrucciones de verificación.
- [x] Se incluyeron limitaciones.
- [x] Se incluyó declaración de uso de IA.
- [ ] Crear el PR real en GitHub/GitLab desde `ae6/suite-pruebas` hacia `main`.
- [ ] Añadir enlace o captura del PR a la evidencia final.

## Archivos que NO deben entregarse

- `target/`
- credenciales
- archivos temporales del IDE
- datos personales o secretos

## Resultado

La revisión se considera técnicamente completa cuando se realicen las casillas pendientes de ejecución real, cobertura y publicación remota.
