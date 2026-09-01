package com.tutorias;

public class WhatsAppCreator extends NotificadorCreator {

    @Override
    public INotificador crearNotificador() {
        return new NotificadorWhatsApp();
    }
}