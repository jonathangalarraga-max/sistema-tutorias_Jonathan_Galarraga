package com.tutorias;

public class PanelReservaObserver implements IObservadorReserva {
    @Override
    public void actualizar(Reserva reserva) {
        System.out.println("Panel: reserva "
                + reserva.getId()
                + " cambió a estado "
                + reserva.getEstado());
    }
}

