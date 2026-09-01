package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        // Crear estudiante
        Estudiante estudiante = new Estudiante(
                1,
                "Jonathan Galarraga",
                "jona@uees.edu.ec"
        );

        // Crear docente
        Docente docente = new Docente(
                1,
                "Carlos Prueba",
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

        // ==========================================
        // PROBAR FACTORY METHOD
        // ==========================================

        System.out.println();
        System.out.println("=== PRUEBA FACTORY METHOD ===");

        // Crear notificador de correo
        NotificadorCreator correo = new CorreoCreator();

        correo.enviarNotificacion(
                "jona@uees.edu.ec",
                "Su tutoría ha sido confirmada."
        );

        // Crear notificador de WhatsApp
        NotificadorCreator whatsapp = new WhatsAppCreator();

        whatsapp.enviarNotificacion(
                "0999999999",
                "Su tutoría ha sido confirmada."
        );

        // Crear notificador SMS
        NotificadorCreator sms = new SMSCreator();

        sms.enviarNotificacion(
                "0999999999",
                "Su tutoría ha sido confirmada."
        );

                // Crear notificador Push
        NotificadorCreator push = new PushCreator();

        push.enviarNotificacion(
                "Usuario Jonathan",
                "Su tutoría ha sido confirmada mediante Push."
);

        // ==========================================
        // PROBAR BUILDER
        // ==========================================

        System.out.println();
        System.out.println("=== PRUEBA BUILDER ===");

        // Reserva 1
        Reserva reserva1 = new ReservaBuilder()
                .estudiante(estudiante)
                .docente(docente)
                .fecha(LocalDate.of(2026, 8, 25))
                .hora(LocalTime.of(10, 0))
                .modalidad("Virtual")
                .observaciones("Repaso para examen")
                .build();

        System.out.println();
        System.out.println("=== RESERVA 1 ===");
        System.out.println("Estudiante: " + reserva1.getEstudiante().getNombre());
        System.out.println("Docente: " + reserva1.getDocente().getNombre());
        System.out.println("Fecha: " + reserva1.getFecha());
        System.out.println("Hora: " + reserva1.getHora());
        System.out.println("Modalidad: " + reserva1.getModalidad());
        System.out.println("Observaciones: " + reserva1.getObservaciones());


        // Reserva 2
        Reserva reserva2 = new ReservaBuilder()
                .estudiante(estudiante)
                .docente(docente)
                .fecha(LocalDate.of(2026, 8, 26))
                .hora(LocalTime.of(14, 0))
                .modalidad("Presencial")
                .observaciones("Preparación para examen")
                .ubicacion("Aula 203")
                .duracion(90)
                .build();

        System.out.println();
        System.out.println("=== RESERVA 2 ===");
        System.out.println("Estudiante: " + reserva2.getEstudiante().getNombre());
        System.out.println("Docente: " + reserva2.getDocente().getNombre());
        System.out.println("Fecha: " + reserva2.getFecha());
        System.out.println("Hora: " + reserva2.getHora());
        System.out.println("Modalidad: " + reserva2.getModalidad());
        System.out.println("Observaciones: " + reserva2.getObservaciones());
        System.out.println("Duración: " + reserva2.getDuracion() + " minutos");
        System.out.println("Ubicación: " + reserva2.getUbicacion());

        }
        }