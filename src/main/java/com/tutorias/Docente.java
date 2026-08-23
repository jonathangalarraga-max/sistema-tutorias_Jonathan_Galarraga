package com.tutorias;

import java.util.List;

public class Docente {

    private int id;
    private String nombre;
    private String correo;

    public Docente(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public void publicarHorario(Horario horario) {
        System.out.println("Horario publicado correctamente.");
    }

    public List<Reserva> consultarReservas() {
        return null;
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