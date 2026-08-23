package com.tutorias;

import java.util.ArrayList;
import java.util.List;

public class ServicioReservas {

    private List<Reserva> reservas;
    private INotificador notificador;

    public ServicioReservas(INotificador notificador) {
        this.reservas = new ArrayList<>();
        this.notificador = notificador;
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

        Reserva reserva = new Reserva(id, estudiante, horario);

        horario.reservar();

        reserva.confirmar();

        reservas.add(reserva);

        notificador.enviarNotificacion(
                estudiante.getCorreo(),
                "Su reserva de tutoría ha sido confirmada."
        );

        return reserva;
    }

    public void cancelarReserva(Reserva reserva) {

        reserva.cancelar();

        notificador.enviarNotificacion(
                reserva.getEstudiante().getCorreo(),
                "Su reserva de tutoría ha sido cancelada."
        );
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}