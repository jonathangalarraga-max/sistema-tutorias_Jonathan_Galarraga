package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaBuilder {

    private Estudiante estudiante;
    private Docente docente;
    private LocalDate fecha;
    private LocalTime hora;
    private String modalidad;
    private String observaciones;
    private int duracion = 60;
    private String ubicacion;

    public ReservaBuilder estudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        return this;
    }

    public ReservaBuilder docente(Docente docente) {
        this.docente = docente;
        return this;
    }

    public ReservaBuilder fecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public ReservaBuilder hora(LocalTime hora) {
        this.hora = hora;
        return this;
    }

    public ReservaBuilder modalidad(String modalidad) {
        this.modalidad = modalidad;
        return this;
    }

    public ReservaBuilder observaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public ReservaBuilder duracion(int duracion) {
        this.duracion = duracion;
        return this;
    }

    public ReservaBuilder ubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
        return this;
    }

    public Reserva build() {

        // Validar campos obligatorios
        if (estudiante == null) {
            throw new IllegalArgumentException(
                    "El estudiante es obligatorio."
            );
        }

        if (docente == null) {
            throw new IllegalArgumentException(
                    "El docente es obligatorio."
            );
        }

        if (fecha == null) {
            throw new IllegalArgumentException(
                    "La fecha es obligatoria."
            );
        }

        if (hora == null) {
            throw new IllegalArgumentException(
                    "La hora es obligatoria."
            );
        }

        return new Reserva(
                estudiante,
                docente,
                fecha,
                hora,
                modalidad,
                observaciones,
                duracion,
                ubicacion
        );
    }
}