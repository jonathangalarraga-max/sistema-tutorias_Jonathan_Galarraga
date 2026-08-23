package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {

    private int id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean disponible;

    public Horario(int id, LocalDate fecha, LocalTime horaInicio,
                   LocalTime horaFin) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = true;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void reservar() {
        if (disponible) {
            disponible = false;
        }
    }

    public void liberar() {
        disponible = true;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
}