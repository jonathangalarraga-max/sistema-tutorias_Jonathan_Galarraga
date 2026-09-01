package com.tutorias;

public class PushCreator extends NotificadorCreator {

    @Override
    public INotificador crearNotificador() {
        return new NotificadorPush();
    }
}