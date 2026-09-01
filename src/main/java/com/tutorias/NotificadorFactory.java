package com.tutorias;

public class NotificadorFactory {

    public static INotificador crearNotificador() {
        return new NotificadorCorreo();
    }
}