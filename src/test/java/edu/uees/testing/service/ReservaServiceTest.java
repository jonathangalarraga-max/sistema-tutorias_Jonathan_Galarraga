package edu.uees.testing.service;

import edu.uees.testing.availability.DisponibilidadClient;
import edu.uees.testing.domain.EstadoReserva;
import edu.uees.testing.domain.Reserva;
import edu.uees.testing.notification.Notificador;
import edu.uees.testing.repository.ReservaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Suite Ae6: pruebas de reglas de negocio de ReservaService.
 *
 * Estructura AAA:
 * Arrange  -> preparación de datos y dobles de prueba.
 * Act      -> ejecución del comportamiento bajo prueba.
 * Assert   -> verificación del resultado o interacción esperada.
 */
class ReservaServiceTest {

    private DisponibilidadClient disponibilidad;
    private ReservaRepository repository;
    private Notificador notificador;
    private ReservaService servicio;

    @BeforeEach
    void setUp() {
        disponibilidad = Mockito.mock(DisponibilidadClient.class);
        repository = Mockito.mock(ReservaRepository.class);
        notificador = Mockito.mock(Notificador.class);
        servicio = new ReservaService(disponibilidad, repository, notificador);
    }

    // -------------------- Cancelación --------------------

    @Test
    void puedeCancelarConCincoHoras() {
        // Arrange
        int horasAnticipacion = 5;

        // Act
        boolean resultado = servicio.puedeCancelar(horasAnticipacion);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void puedeCancelarExactamenteEnElLimiteDeDosHoras() {
        // Arrange
        int horasAnticipacion = 2;

        // Act
        boolean resultado = servicio.puedeCancelar(horasAnticipacion);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void noPuedeCancelarPorDebajoDelLimite() {
        // Arrange
        int horasAnticipacion = 1;

        // Act
        boolean resultado = servicio.puedeCancelar(horasAnticipacion);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void noPuedeCancelarConCeroHoras() {
        // Arrange
        int horasAnticipacion = 0;

        // Act
        boolean resultado = servicio.puedeCancelar(horasAnticipacion);

        // Assert
        assertFalse(resultado);
    }

    // -------------------- Descuentos --------------------

    @ParameterizedTest
    @CsvSource({
            "NORMAL,100.0,100.0",
            "VIP,100.0,85.0",
            "ESTUDIANTE,100.0,90.0"
    })
    void calcularTotalAplicaLaReglaSegunTipo(String tipo, double base, double esperado) {
        // Arrange: los parámetros representan escenarios de negocio.

        // Act
        double resultado = servicio.calcularTotal(tipo, base);

        // Assert
        assertEquals(esperado, resultado, 0.001);
    }

    @Test
    void calcularTotalAceptaTipoVipSinImportarMayusculas() {
        // Arrange
        String tipo = "vip";
        double base = 200.0;

        // Act
        double resultado = servicio.calcularTotal(tipo, base);

        // Assert
        assertEquals(170.0, resultado, 0.001);
    }

    @Test
    void calcularTotalCeroMantieneTotalEnCero() {
        // Arrange
        double base = 0.0;

        // Act
        double resultado = servicio.calcularTotal("NORMAL", base);

        // Assert
        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    void calcularTotalNegativoLanzaExcepcion() {
        // Arrange
        double base = -1.0;

        // Act + Assert: la excepción es el resultado esperado de la regla inválida.
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> servicio.calcularTotal("NORMAL", base)
        );

        assertEquals("Total base inválido", excepcion.getMessage());
    }

    // -------------------- Confirmación --------------------

    @Test
    void confirmarReservaDisponibleCambiaEstadoGuardaYNotifica() {
        // Arrange
        Reserva reserva = new Reserva("R-001", "NORMAL");
        when(disponibilidad.estaDisponible(reserva)).thenReturn(true);

        // Act
        servicio.confirmar(reserva);

        // Assert
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        verify(repository).guardar(reserva);
        verify(notificador).enviarConfirmacion(reserva);
        verify(disponibilidad).estaDisponible(reserva);
    }

    @Test
    void confirmarReservaNoDisponibleLanzaExcepcionYNoGuardaNiNotifica() {
        // Arrange
        Reserva reserva = new Reserva("R-002", "NORMAL");
        when(disponibilidad.estaDisponible(reserva)).thenReturn(false);

        // Act
        IllegalStateException excepcion = assertThrows(
                IllegalStateException.class,
                () -> servicio.confirmar(reserva)
        );

        // Assert
        assertEquals("Horario no disponible", excepcion.getMessage());
        assertEquals(EstadoReserva.PENDIENTE, reserva.getEstado());
        verify(repository, never()).guardar(any(Reserva.class));
        verify(notificador, never()).enviarConfirmacion(any(Reserva.class));
    }

    @Test
    void confirmarReservaNulaLanzaExcepcionSinConsultarDependencias() {
        // Arrange
        Reserva reserva = null;

        // Act
        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> servicio.confirmar(reserva)
        );

        // Assert
        assertEquals("Reserva obligatoria", excepcion.getMessage());
        verifyNoInteractions(disponibilidad, repository, notificador);
    }

    @Test
    void confirmarReservaDisponibleUsaLaReservaRecibidaEnLasInteracciones() {
        // Arrange
        Reserva reserva = new Reserva("R-003", "VIP");
        when(disponibilidad.estaDisponible(reserva)).thenReturn(true);

        // Act
        servicio.confirmar(reserva);

        // Assert
        verify(disponibilidad).estaDisponible(reserva);
        verify(repository).guardar(reserva);
        verify(notificador).enviarConfirmacion(reserva);
    }
}
