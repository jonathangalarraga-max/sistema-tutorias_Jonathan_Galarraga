package com.tutorias;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Estudiante estudiante = crearEstudiante();
        Docente docente = crearDocente();
        Horario horario = crearHorario();

        mostrarDatosIniciales(estudiante, docente, horario);
        Reserva reserva = crearReservaInicial(estudiante, horario);
        mostrarReservaConfirmada(reserva);
        probarFactoryMethod();
        probarBuilder(estudiante, docente);
        probarStrategy(reserva);
        probarObserver(estudiante, docente);

        System.out.println();
        System.out.println("=== FIN DE LA EJECUCIÓN ===");
    }

    private static Estudiante crearEstudiante() {
        return new Estudiante(
                1,
                "Jonathan Galarraga",
                "jona@uees.edu.ec"
        );
    }

    private static Docente crearDocente() {
        return new Docente(
                1,
                "Carlos Prueba",
                "carlos@uees.edu.ec"
        );
    }

    private static Horario crearHorario() {
        return new Horario(
                1,
                LocalDate.of(2026, 8, 25),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0)
        );
    }

    private static void mostrarDatosIniciales(
            Estudiante estudiante,
            Docente docente,
            Horario horario) {

        System.out.println("=== SISTEMA DE RESERVA DE TUTORÍAS ===");
        System.out.println();
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Docente: " + docente.getNombre());
        System.out.println("Fecha: " + horario.getFecha());
        System.out.println("Hora: " + horario.getHoraInicio()
                + " - " + horario.getHoraFin());
        System.out.println("Horario disponible: "
                + horario.estaDisponible());
    }

    private static Reserva crearReservaInicial(
            Estudiante estudiante,
            Horario horario) {

        Reserva reserva = new Reserva(1, estudiante, horario);
        horario.reservar();

        System.out.println();
        System.out.println("=== RESERVA CREADA ===");
        System.out.println("ID de reserva: " + reserva.getId());
        System.out.println("Estado: " + reserva.getEstado());
        System.out.println("Horario disponible: "
                + horario.estaDisponible());

        return reserva;
    }

    private static void mostrarReservaConfirmada(Reserva reserva) {
        reserva.confirmar();
        System.out.println();
        System.out.println("=== RESERVA CONFIRMADA ===");
        System.out.println("Estado: " + reserva.getEstado());
    }

    private static void probarFactoryMethod() {
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
    }

    private static void probarBuilder(
            Estudiante estudiante,
            Docente docente) {

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
        mostrarDatosReserva(reserva1);

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
        mostrarDatosReserva(reserva2);
        System.out.println("Duración: "
                + reserva2.getDuracion() + " minutos");
        System.out.println("Ubicación: " + reserva2.getUbicacion());
    }

    private static void mostrarDatosReserva(Reserva reserva) {
        System.out.println("Estudiante: "
                + reserva.getEstudiante().getNombre());
        System.out.println("Docente: "
                + reserva.getDocente().getNombre());
        System.out.println("Fecha: " + reserva.getFecha());
        System.out.println("Hora: " + reserva.getHora());
        System.out.println("Modalidad: " + reserva.getModalidad());
        System.out.println("Observaciones: "
                + reserva.getObservaciones());
    }

    private static void probarStrategy(Reserva reserva) {
        System.out.println();
        System.out.println("=== AE3 - STRATEGY ===");

        INotificador notificador = new Notificador();
        ServicioReservas servicio = new ServicioReservas(notificador);
        servicio.setEstrategiaCancelacion(new CancelacionNormal());

        System.out.println(
                "Cancelación normal: "
                + servicio.cancelarReserva(reserva)
        );
        System.out.println(
                "Estado de la reserva: "
                + reserva.getEstado()
        );
    }

    private static void probarObserver(
            Estudiante estudiante,
            Docente docente) {

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

        IObservadorReserva correoObserver =
                new NotificadorCorreoObserver();
        IObservadorReserva panelObserver =
                new PanelReservaObserver();

        reservaObserver.agregarObservador(correoObserver);
        reservaObserver.agregarObservador(panelObserver);

        System.out.println(
                "Estado inicial: "
                + reservaObserver.getEstado()
        );

        reservaObserver.cancelar();

        System.out.println(
                "Estado final: "
                + reservaObserver.getEstado()
        );
    }
}
