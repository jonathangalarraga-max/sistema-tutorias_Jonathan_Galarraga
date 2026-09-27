# Análisis de cobertura JaCoCo – Ae6

## Resultado observado

La configuración Maven del proyecto genera el reporte JaCoCo durante la fase `test`. La ejecución que debe utilizarse como evidencia final es:

```bash
mvn clean test
```

Después se debe abrir:

```text
target/site/jacoco/index.html
```

**Nota de reproducibilidad:** en el entorno donde se preparó esta entrega no está instalado Maven, por lo que no se declara aquí un porcentaje de ejecución que no haya sido observado. El porcentaje final debe copiarse del reporte generado en el equipo del estudiante después de ejecutar `mvn clean test`.

## Clase analizada

`edu.uees.testing.service.ReservaService`

## Interpretación de las ramas

El servicio contiene decisiones de negocio en tres métodos:

- `puedeCancelar(int)`: permite cancelar cuando la anticipación es igual o superior a 2 horas.
- `calcularTotal(String, double)`: rechaza bases negativas y aplica reglas VIP/ESTUDIANTE.
- `confirmar(Reserva)`: rechaza reservas nulas, valida disponibilidad y posteriormente confirma, guarda y notifica.

La suite cubre los caminos relevantes de esas decisiones: valores por encima y por debajo del límite, valor exactamente igual al límite, total negativo, los tres tipos de descuento, disponibilidad positiva, disponibilidad negativa y reserva nula.

## Huecos relevantes considerados

El riesgo principal era que una suite probara solamente los caminos exitosos. Por eso se incorporaron explícitamente:

1. `calcularTotalNegativoLanzaExcepcion()` para comprobar la entrada inválida.
2. `confirmarReservaNoDisponibleLanzaExcepcionYNoGuardaNiNotifica()` para comprobar que una reserva no disponible no cambia de estado ni genera persistencia/notificación.
3. `confirmarReservaNulaLanzaExcepcionSinConsultarDependencias()` para comprobar la validación temprana.
4. `puedeCancelarExactamenteEnElLimiteDeDosHoras()` junto con `noPuedeCancelarPorDebajoDelLimite()` para demostrar el comportamiento alrededor del umbral.

## Relación entre cobertura y calidad

Una cobertura alta no garantiza que el software sea correcto. JaCoCo informa qué instrucciones o ramas fueron ejecutadas, pero no determina por sí mismo si los valores esperados son correctos ni si los escenarios seleccionados representan todos los riesgos del negocio. Por ejemplo, una prueba podría ejecutar una línea sin comprobar adecuadamente el estado resultante.

Por esta razón, la suite se diseñó primero a partir de reglas de negocio y después se utilizó JaCoCo para detectar caminos que todavía no tenían evidencia.

## Decisión de mejora

El análisis de cobertura se utiliza como retroalimentación: si una rama de error no estuviera cubierta, se agregaría un caso específico para ese comportamiento antes de considerar terminada la suite. La evidencia final debe contener el porcentaje real obtenido en el equipo del estudiante y una captura del reporte.
