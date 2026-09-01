package com.tutorias;

public abstract class NotificadorCreator {

    public abstract INotificador crearNotificador();

    public void enviarNotificacion(String destinatario, String mensaje) {
        INotificador notificador = crearNotificador();
        notificador.enviarNotificacion(destinatario, mensaje);
    }
}