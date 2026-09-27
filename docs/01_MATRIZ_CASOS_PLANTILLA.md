# Matriz de casos de prueba – Ae6

La matriz se construyó a partir de las reglas implementadas en `ReservaService`: cancelación con mínimo de 2 horas, descuentos por tipo de cliente y confirmación condicionada a disponibilidad. La guía solicita como mínimo 10 casos y recomienda distribuirlos entre los tres comportamientos principales. 

| ID | Regla | Escenario | Entrada | Esperado | Tipo | Riesgo |
|---|---|---|---|---|---|---|
| CP-01 | puedeCancelar | Anticipación normal | 5 horas | `true` | Normal | Permitir cancelaciones válidas |
| CP-02 | puedeCancelar | Límite válido | 2 horas | `true` | Límite | Rechazar por error el valor mínimo permitido |
| CP-03 | puedeCancelar | Debajo del límite | 1 hora | `false` | Límite | Permitir una cancelación fuera de regla |
| CP-04 | puedeCancelar | Sin anticipación | 0 horas | `false` | Inválido/Límite | Permitir cancelación inmediata |
| CP-05 | calcularTotal | Cliente NORMAL | NORMAL, 100 | `100` | Normal | Alterar el precio sin descuento |
| CP-06 | calcularTotal | Cliente VIP | VIP, 100 | `85` | Alternativo | Aplicar mal el descuento VIP |
| CP-07 | calcularTotal | Cliente ESTUDIANTE | ESTUDIANTE, 100 | `90` | Alternativo | Aplicar mal el descuento estudiantil |
| CP-08 | calcularTotal | Tipo VIP en minúsculas | vip, 200 | `170` | Alternativo | No reconocer la regla por mayúsculas/minúsculas |
| CP-09 | calcularTotal | Total base cero | NORMAL, 0 | `0` | Límite | Generar un total incorrecto para cero |
| CP-10 | calcularTotal | Total base negativo | NORMAL, -1 | `IllegalArgumentException` | Inválido/Excepción | Aceptar valores monetarios inválidos |
| CP-11 | confirmar | Reserva disponible | R-001, disponibilidad=true | Estado `CONFIRMADA`, guardar y notificar | Normal | Confirmar sin completar el flujo |
| CP-12 | confirmar | Reserva no disponible | R-002, disponibilidad=false | `IllegalStateException`, permanece pendiente, no guardar/notificar | Alternativo/Excepción | Confirmar o persistir una reserva no disponible |
| CP-13 | confirmar | Reserva nula | `null` | `IllegalArgumentException`, sin interacciones | Inválido/Excepción | Procesar una reserva inexistente |
| CP-14 | confirmar | Reserva VIP disponible | R-003, VIP, disponibilidad=true | Confirmar y usar la misma reserva en dependencias | Normal/Interacción | Enviar o guardar una reserva diferente de la validada |

## Justificación

Los casos CP-02 y CP-03 cubren ambos lados del umbral de 2 horas. CP-10 verifica explícitamente una excepción de entrada inválida. CP-11 a CP-14 cubren los caminos principales de `confirmar()`, incluyendo disponibilidad, ausencia de disponibilidad, reserva nula e interacciones con las dependencias. La matriz prioriza reglas de negocio y riesgos, no solamente líneas de código.
