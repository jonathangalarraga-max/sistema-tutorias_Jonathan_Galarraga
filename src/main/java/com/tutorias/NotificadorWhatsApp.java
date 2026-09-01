package com.tutorias;

public class NotificadorWhatsApp implements INotificador {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("Enviando WhatsApp a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }
}