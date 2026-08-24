# Sistema de Tutorías

## Descripción

El Sistema de Tutorías es una aplicación desarrollada en Java para gestionar las tutorías entre estudiantes y docentes.

## Objetivo

Desarrollar un sistema que permita a los estudiantes reservar tutorías y a los docentes administrar sus horarios disponibles.

## Funcionalidades

- Publicar horarios de tutorías.
- Consultar horarios disponibles.
- Reservar una tutoría.
- Cancelar una reserva.
- Evitar reservas duplicadas.
- Notificar al docente sobre las reservas.
- Notificar al docente sobre las cancelaciones.
- Mantener un registro de las reservas.

## Actores

### Estudiante

- Consultar horarios.
- Reservar tutorías.
- Cancelar reservas.
- Consultar sus reservas.

### Docente

- Publicar horarios.
- Consultar sus horarios.
- Recibir notificaciones de reservas.
- Recibir notificaciones de cancelaciones.

## Tecnologías utilizadas

- Java
- Maven
- Git
- GitHub
- Visual Studio Code

## Clases principales

- Estudiante: representa al estudiante.
- Docente: representa al docente.
- Horario: representa los horarios disponibles.
- Reserva: representa una reserva de tutoría.
- ServicioReservas: gestiona las reservas.
- Notificador: gestiona las notificaciones.

## Requisitos

Para ejecutar el proyecto se necesita:

- Java JDK
- Maven
- Git
- Visual Studio Code

## Ejecución

Para ejecutar las pruebas:

mvn clean test

Para ejecutar el programa:

mvn exec:java "-Dexec.mainClass=com.tutorias.Main"

## Control de versiones

El proyecto utiliza Git y GitHub para el control de versiones.

## Estado del proyecto

Proyecto académico desarrollado para la asignatura de Diseño de Software.

## Autores

Proyecto desarrollado como parte de la asignatura de Diseño de Software.

## Licencia

Este proyecto fue desarrollado con fines académicos.