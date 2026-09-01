package com.tutorias;

public class SMSCreator extends NotificadorCreator {

    @Override
    public INotificador crearNotificador() {
        return new NotificadorSMS();
    }
}