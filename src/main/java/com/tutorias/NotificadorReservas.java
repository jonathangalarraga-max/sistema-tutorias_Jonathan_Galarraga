package com.tutorias;

public class NotificadorReservas {

    private final INotificador notificador;

    public NotificadorReservas(INotificador notificador) {
        this.notificador = notificador;
    }

    public void notificarConfirmacion(Reserva reserva) {
        notificador.enviarNotificacion(
                reserva.getEstudiante().getCorreo().valor(),
                "Su reserva de tutoría ha sido confirmada."
        );
    }

    public void notificarCancelacion(Reserva reserva) {
        notificador.enviarNotificacion(
                reserva.getEstudiante().getCorreo().valor(),
                "Su reserva de tutoría ha sido cancelada."
        );
    }
}