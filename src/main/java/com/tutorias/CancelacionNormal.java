package com.tutorias;

public class CancelacionNormal implements ICancelacionStrategy {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return reserva != null;
    }
}

