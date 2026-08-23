package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        // Crear estudiante
        Estudiante estudiante = new Estudiante(
                1,
                "Juan Pérez",
                "juan@uees.edu.ec"
        );

        // Crear docente
        Docente docente = new Docente(
                1,
                "Carlos Gómez",
                "carlos@uees.edu.ec"
        );

        // Crear horario
        Horario horario = new Horario(
                1,
                LocalDate.of(2026, 8, 25),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0)
        );

        // Mostrar información inicial
        System.out.println("=== SISTEMA DE RESERVA DE TUTORÍAS ===");
        System.out.println();
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Docente: " + docente.getNombre());
        System.out.println("Fecha: " + horario.getFecha());
        System.out.println("Hora: " + horario.getHoraInicio()
                + " - " + horario.getHoraFin());
        System.out.println("Horario disponible: "
                + horario.estaDisponible());

        // Crear reserva
        Reserva reserva = new Reserva(
                1,
                estudiante,
                horario
        );

        // Reservar horario
        horario.reservar();

        System.out.println();
        System.out.println("=== RESERVA CREADA ===");
        System.out.println("ID de reserva: " + reserva.getId());
        System.out.println("Estado: " + reserva.getEstado());
        System.out.println("Horario disponible: "
                + horario.estaDisponible());

        // Confirmar reserva
        reserva.confirmar();

        System.out.println();
        System.out.println("=== RESERVA CONFIRMADA ===");
        System.out.println("Estado: " + reserva.getEstado());

        // Cancelar reserva
        estudiante.cancelarReserva(reserva);

        System.out.println();
        System.out.println("=== RESERVA CANCELADA ===");
        System.out.println("Estado: " + reserva.getEstado());
        System.out.println("Horario disponible nuevamente: "
                + horario.estaDisponible());
    }
}