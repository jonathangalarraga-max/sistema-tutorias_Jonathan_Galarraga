package com.tutorias;

import java.util.ArrayList;
import java.util.List;

public class GestorObservadoresReserva {

    private final List<IObservadorReserva> observadores = new ArrayList<>();

    public void agregar(IObservadorReserva observador) {
        if (observador != null) {
            observadores.add(observador);
        }
    }

    public void quitar(IObservadorReserva observador) {
        observadores.remove(observador);
    }

    public void notificar(Reserva reserva) {
        for (IObservadorReserva observador : observadores) {
            observador.actualizar(reserva);
        }
    }
}