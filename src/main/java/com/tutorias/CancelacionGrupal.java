package com.tutorias;

public class CancelacionGrupal implements ICancelacionStrategy {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return reserva != null && !Reserva.ESTADO_CANCELADA.equals(reserva.getEstado());
    }
}

