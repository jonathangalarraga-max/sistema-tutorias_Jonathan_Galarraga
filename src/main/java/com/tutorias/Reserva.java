package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    public static final String ESTADO_PENDIENTE = "Pendiente";
    public static final String ESTADO_CONFIRMADA = "Confirmada";
    public static final String ESTADO_CANCELADA = "Cancelada";

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

    // NUEVO: lista de observadores
    private List<IObservadorReserva> observadores = new ArrayList<>();

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
        this.estado = ESTADO_PENDIENTE;
    }

    // Constructor original
    public Reserva(int id, Estudiante estudiante, Horario horario) {

        this.id = id;
        this.estudiante = estudiante;
        this.fecha = horario.getFecha();
        this.estado = ESTADO_PENDIENTE;
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

    // NUEVO: agregar observador
    public void agregarObservador(IObservadorReserva observador) {
        if (observador != null) {
            observadores.add(observador);
        }
    }

    // NUEVO: quitar observador
    public void quitarObservador(IObservadorReserva observador) {
        observadores.remove(observador);
    }

    // NUEVO: notificar observadores
    private void notificarObservadores() {
        for (IObservadorReserva observador : observadores) {
            observador.actualizar(this);
        }
    }

    public void confirmar() {
        this.estado = ESTADO_CONFIRMADA;

        // Notificar cuando cambia el estado
        notificarObservadores();
    }

    public void cancelar() {
        this.estado = ESTADO_CANCELADA;

        // Notificar cuando cambia el estado
        notificarObservadores();
    }
}