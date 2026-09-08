package com.tutorias;

public class NotificadorCorreoObserver implements IObservadorReserva {
    @Override
    public void actualizar(Reserva reserva) {
        System.out.println("Correo: reserva "
                + reserva.getId()
                + " cambió a estado "
                + reserva.getEstado());
    }
}

