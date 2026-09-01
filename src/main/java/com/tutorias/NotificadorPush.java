package com.tutorias;

public class NotificadorPush implements INotificador {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("Enviando notificación Push a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }
}