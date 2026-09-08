package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // CREAR DATOS INICIALES
        // ==========================================

        Estudiante estudiante = new Estudiante(
                1,
                "Jonathan Galarraga",
                "jona@uees.edu.ec"
        );

        Docente docente = new Docente(
                1,
                "Carlos Prueba",
                "carlos@uees.edu.ec"
        );

        Horario horario = new Horario(
                1,
                LocalDate.of(2026, 8, 25),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0)
        );

        System.out.println("=== SISTEMA DE RESERVA DE TUTORÍAS ===");
        System.out.println();

        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Docente: " + docente.getNombre());
        System.out.println("Fecha: " + horario.getFecha());
        System.out.println("Hora: " + horario.getHoraInicio()
                + " - " + horario.getHoraFin());

        System.out.println("Horario disponible: "
                + horario.estaDisponible());

        // ==========================================
        // CREAR RESERVA
        // ==========================================

        Reserva reserva = new Reserva(
                1,
                estudiante,
                horario
        );

        horario.reservar();

        System.out.println();
        System.out.println("=== RESERVA CREADA ===");

        System.out.println("ID de reserva: " + reserva.getId());
        System.out.println("Estado: " + reserva.getEstado());

        System.out.println("Horario disponible: "
                + horario.estaDisponible());

        // ==========================================
        // CONFIRMAR RESERVA
        // ==========================================

        reserva.confirmar();

        System.out.println();
        System.out.println("=== RESERVA CONFIRMADA ===");

        System.out.println("Estado: " + reserva.getEstado());

        // ==========================================
        // FACTORY METHOD
        // ==========================================

        System.out.println();
        System.out.println("=== PRUEBA FACTORY METHOD ===");

        NotificadorCreator correo = new CorreoCreator();

        correo.enviarNotificacion(
                "jona@uees.edu.ec",
                "Su tutoría ha sido confirmada."
        );

        NotificadorCreator whatsapp = new WhatsAppCreator();

        whatsapp.enviarNotificacion(
                "0999999999",
                "Su tutoría ha sido confirmada."
        );

        NotificadorCreator sms = new SMSCreator();

        sms.enviarNotificacion(
                "0999999999",
                "Su tutoría ha sido confirmada."
        );

        NotificadorCreator push = new PushCreator();

        push.enviarNotificacion(
                "Usuario Jonathan",
                "Su tutoría ha sido confirmada mediante Push."
        );

        // ==========================================
        // BUILDER
        // ==========================================

        System.out.println();
        System.out.println("=== PRUEBA BUILDER ===");

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

        System.out.println("Estudiante: "
                + reserva1.getEstudiante().getNombre());

        System.out.println("Docente: "
                + reserva1.getDocente().getNombre());

        System.out.println("Fecha: " + reserva1.getFecha());
        System.out.println("Hora: " + reserva1.getHora());
        System.out.println("Modalidad: " + reserva1.getModalidad());
        System.out.println("Observaciones: "
                + reserva1.getObservaciones());

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

        System.out.println("Estudiante: "
                + reserva2.getEstudiante().getNombre());

        System.out.println("Docente: "
                + reserva2.getDocente().getNombre());

        System.out.println("Fecha: " + reserva2.getFecha());
        System.out.println("Hora: " + reserva2.getHora());
        System.out.println("Modalidad: " + reserva2.getModalidad());

        System.out.println("Observaciones: "
                + reserva2.getObservaciones());

        System.out.println("Duración: "
                + reserva2.getDuracion() + " minutos");

        System.out.println("Ubicación: "
                + reserva2.getUbicacion());

        // ==========================================
        // AE3 - STRATEGY
        // ==========================================

        System.out.println();
        System.out.println("=== AE3 - STRATEGY ===");

        // Crear notificador para ServicioReservas
        INotificador notificador = new Notificador();

        ServicioReservas servicio = new ServicioReservas(notificador);

        // Utilizar estrategia normal
        servicio.setEstrategiaCancelacion(
                new CancelacionNormal()
        );

        System.out.println(
                "Cancelación normal: "
                + servicio.cancelarReserva(reserva)
        );

        System.out.println(
                "Estado de la reserva: "
                + reserva.getEstado()
        );

        // ==========================================
        // AE3 - OBSERVER
        // ==========================================

        System.out.println();
        System.out.println("=== AE3 - OBSERVER ===");

        Reserva reservaObserver = new ReservaBuilder()
                .estudiante(estudiante)
                .docente(docente)
                .fecha(LocalDate.of(2026, 8, 27))
                .hora(LocalTime.of(15, 0))
                .modalidad("Virtual")
                .observaciones("Prueba Observer")
                .build();

        // Crear observadores
        IObservadorReserva correoObserver =
                new NotificadorCorreoObserver();

        IObservadorReserva panelObserver =
                new PanelReservaObserver();

        // Registrar observadores
        reservaObserver.agregarObservador(
                correoObserver
        );

        reservaObserver.agregarObservador(
                panelObserver
        );

        System.out.println(
                "Estado inicial: "
                + reservaObserver.getEstado()
        );

        // Cambiar estado y activar Observer
        reservaObserver.cancelar();

        System.out.println(
                "Estado final: "
                + reservaObserver.getEstado()
        );

        System.out.println();
        System.out.println("=== FIN DE LA EJECUCIÓN ===");
    }
}