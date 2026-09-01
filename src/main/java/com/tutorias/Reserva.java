package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private int id;
    private Estudiante estudiante;
    private Docente docente;
    private LocalDate fecha;
    private LocalTime hora;
    private String modalidad;
    private String observaciones;
    private int duracion;
    private String ubicacion;
    private String estado;

    // Constructor utilizado por Builder
    public Reserva(
            Estudiante estudiante,
            Docente docente,
            LocalDate fecha,
            LocalTime hora,
            String modalidad,
            String observaciones,
            int duracion,
            String ubicacion) {

        this.id = 0;
        this.estudiante = estudiante;
        this.docente = docente;
        this.fecha = fecha;
        this.hora = hora;
        this.modalidad = modalidad;
        this.observaciones = observaciones;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.estado = "Pendiente";
    }

    // Constructor original
    public Reserva(int id, Estudiante estudiante, Horario horario) {

        this.id = id;
        this.estudiante = estudiante;
        this.fecha = horario.getFecha();
        this.estado = "Pendiente";
    }

    public int getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Docente getDocente() {
        return docente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void confirmar() {
        this.estado = "Confirmada";
    }

    public void cancelar() {
        this.estado = "Cancelada";
    }
}