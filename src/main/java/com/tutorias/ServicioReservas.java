package com.tutorias;

import java.util.ArrayList;
import java.util.List;

public class ServicioReservas {

    private List<Reserva> reservas;
    private INotificador notificador;

    // NUEVO: estrategia de cancelación
    private ICancelacionStrategy estrategiaCancelacion;

    public ServicioReservas(INotificador notificador) {
        this.reservas = new ArrayList<>();
        this.notificador = notificador;
        this.estrategiaCancelacion = new CancelacionNormal();
    }

    public boolean verificarDisponibilidad(Horario horario) {
        return horario.estaDisponible();
    }

    public Reserva crearReserva(Estudiante estudiante, Horario horario) {

        if (!verificarDisponibilidad(horario)) {
            throw new IllegalArgumentException(
                    "El horario no está disponible."
            );
        }

        int id = reservas.size() + 1;

        Reserva reserva = new Reserva(
                id,
                estudiante,
                horario
        );

        horario.reservar();

        reserva.confirmar();

        reservas.add(reserva);

        notificador.enviarNotificacion(
                estudiante.getCorreo(),
                "Su reserva de tutoría ha sido confirmada."
        );

        return reserva;
    }

    // NUEVO: permite cambiar la estrategia
    public void setEstrategiaCancelacion(
            ICancelacionStrategy estrategiaCancelacion) {

        this.estrategiaCancelacion = estrategiaCancelacion;
    }

    // MODIFICADO: ahora utiliza Strategy
    public boolean cancelarReserva(Reserva reserva) {

        if (reserva == null) {
            return false;
        }

        if (estrategiaCancelacion == null) {
            estrategiaCancelacion = new CancelacionNormal();
        }

        if (!estrategiaCancelacion.puedeCancelar(reserva)) {
            return false;
        }

        reserva.cancelar();

        notificador.enviarNotificacion(
                reserva.getEstudiante().getCorreo(),
                "Su reserva de tutoría ha sido cancelada."
        );

        return true;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}