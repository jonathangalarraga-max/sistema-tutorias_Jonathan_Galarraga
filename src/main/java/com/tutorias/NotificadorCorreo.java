package com.tutorias;

public class NotificadorCorreo implements INotificador {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("Enviando correo a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }
}