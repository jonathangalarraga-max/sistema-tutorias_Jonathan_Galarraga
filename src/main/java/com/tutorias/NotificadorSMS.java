package com.tutorias;

public class NotificadorSMS implements INotificador {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("Enviando SMS a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }
}