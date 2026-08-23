package com.tutorias;

import java.time.LocalDateTime;

public class Reserva {

    private int id;
    private LocalDateTime fechaCreacion;
    private String estado;

    private Estudiante estudiante;
    private Horario horario;

    public Reserva(int id, Estudiante estudiante, Horario horario) {
        this.id = id;
        this.estudiante = estudiante;
        this.horario = horario;
        this.fechaCreacion = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }

    public void confirmar() {
        estado = "CONFIRMADA";
    }

    public void cancelar() {
        estado = "CANCELADA";
        horario.liberar();
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Horario getHorario() {
        return horario;
    }
}