package com.tutorias;

public class Notificador implements INotificador {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("Enviando notificación a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }

}