package com.tutorias;

public class CorreoCreator extends NotificadorCreator {

    @Override
    public INotificador crearNotificador() {
        return new NotificadorCorreo();
    }
}