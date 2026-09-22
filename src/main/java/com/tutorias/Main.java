package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE TUTORÍAS ===");

        Estudiante estudiante = crearEstudiante();

        System.out.println("\nDatos del estudiante:");
        System.out.println("ID: " + estudiante.getId());
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Correo: " + estudiante.getCorreo().valor());

        Horario horario = crearHorario();

        System.out.println("\nDatos del horario:");
        System.out.println("ID: " + horario.getId());
        System.out.println("Fecha: " + horario.getFecha());
        System.out.println("Hora inicio: " + horario.getHoraInicio());
        System.out.println("Hora fin: " + horario.getHoraFin());

        Reserva reserva = estudiante.crearReserva(horario);

        System.out.println("\nReserva creada:");
        System.out.println("Estado: " + reserva.getEstado());
    }

    private static Estudiante crearEstudiante() {
        return new Estudiante(
                1,
                "Jonathan Galarraga",
                new Correo("jona@uees.edu.ec")
        );
    }

    private static Horario crearHorario() {
        return new Horario(
                1,
                LocalDate.of(2026, 9, 25),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0)
        );
    }
}