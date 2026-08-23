package com.tutorias;

import java.util.List;

public class Estudiante {

    private int id;
    private String nombre;
    private String correo;

    public Estudiante(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public List<Horario> consultarHorarios() {
        return null;
    }

    public Reserva crearReserva(Horario horario) {
        return null;
    }

    public void cancelarReserva(Reserva reserva) {
        reserva.cancelar();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}