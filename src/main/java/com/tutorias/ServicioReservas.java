package com.tutorias;

import java.util.ArrayList;
import java.util.List;

public class ServicioReservas {

    private List<Reserva> reservas;
    private INotificador notificador;
    private NotificadorReservas notificadorReservas;

    // Estrategia de cancelación
    private ICancelacionStrategy estrategiaCancelacion;

    public ServicioReservas(INotificador notificador) {
        this.reservas = new ArrayList<>();
        this.notificador = notificador;
        this.notificadorReservas = new NotificadorReservas(notificador);
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

        notificadorReservas.notificarConfirmacion(reserva);

        return reserva;
    }

    // Permite cambiar la estrategia de cancelación
    public void setEstrategiaCancelacion(
            ICancelacionStrategy estrategiaCancelacion) {

        this.estrategiaCancelacion = estrategiaCancelacion;
    }

    // Utiliza la estrategia de cancelación
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

        notificadorReservas.notificarCancelacion(reserva);

        return true;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}