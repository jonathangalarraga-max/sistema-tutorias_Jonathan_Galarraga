# Sistema de Reserva de Tutorías Universitarias

## Descripción del proyecto

Este proyecto consiste en un sistema de reserva de tutorías universitarias desarrollado en **Java con Maven**. Su objetivo es permitir que los estudiantes consulten horarios disponibles y realicen reservas con docentes, evitando conflictos de horarios y manteniendo una estructura organizada del sistema.

Durante el desarrollo se aplicaron los patrones de diseño **Factory Method** y **Builder**, con el propósito de mejorar la organización, flexibilidad y mantenimiento del código.

## Objetivo

Desarrollar un sistema de reserva de tutorías aplicando patrones de diseño que permitan separar responsabilidades y facilitar la creación y gestión de los objetos del sistema.

## Funcionalidades principales

* Registrar y representar estudiantes.
* Registrar y representar docentes.
* Publicar y consultar horarios de tutorías.
* Verificar la disponibilidad de un horario.
* Crear reservas de tutorías.
* Evitar reservas en horarios no disponibles.
* Permitir la cancelación de reservas.
* Generar notificaciones relacionadas con las reservas.
* Construir reservas mediante el patrón Builder.
* Crear diferentes tipos de notificaciones mediante Factory Method.

## Actores principales

### Estudiante

Puede consultar los horarios disponibles y realizar o cancelar reservas.

### Docente

Puede publicar sus horarios y consultar las reservas realizadas.

### Sistema

Se encarga de verificar la disponibilidad, gestionar las reservas y generar las notificaciones correspondientes.

## Patrones de diseño utilizados

### Factory Method

El patrón **Factory Method** se utiliza para determinar qué implementación concreta de notificación debe crearse.

En el proyecto permite separar la creación de las notificaciones de la lógica principal del sistema.

Por ejemplo, el sistema puede trabajar con diferentes tipos de notificadores, como correo electrónico u otros medios.

**Ventaja:** permite agregar nuevas formas de notificación sin modificar directamente la lógica principal del sistema.

### Builder

El patrón **Builder** se utiliza para construir objetos `Reserva` de manera organizada.

La clase `ReservaBuilder` permite configurar los diferentes atributos de una reserva mediante métodos y finalmente utilizar `build()` para crear el objeto `Reserva`.

**Ventaja:** facilita la creación de reservas cuando el objeto tiene varios atributos y permite que el código sea más claro y flexible.

## Estructura del proyecto

```text
sistema-tutorias/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── tutorias/
│   │               ├── Main.java
│   │               ├── Estudiante.java
│   │               ├── Docente.java
│   │               ├── Horario.java
│   │               ├── Reserva.java
│   │               ├── ReservaBuilder.java
│   │               ├── ServicioReservas.java
│   │               ├── Notificador.java
│   │               └── NotificadorCorreo.java
│   │
├── pom.xml
├── README.md
└── UML/
    ├── factory-method.puml
    └── builder.puml
```

## UML

El proyecto cuenta con diagramas UML correspondientes a los patrones implementados.

### UML de Factory Method

El diagrama representa las clases relacionadas con la creación de notificadores y muestra la relación entre la clase creadora, el producto y las implementaciones concretas.

### UML de Builder

El diagrama representa `ReservaBuilder`, sus atributos, los métodos utilizados para configurar la reserva y el método `build()`, que permite crear finalmente un objeto `Reserva`.

Los diagramas UML mantienen correspondencia con las clases implementadas en Java.

## Tecnologías utilizadas

* Java
* Maven
* Visual Studio Code
* Git
* GitHub
* PlantUML

## Requisitos

Para ejecutar el proyecto se necesita tener instalado:

* Java JDK
* Maven
* Git

## Ejecución del proyecto

Clonar el repositorio:

```bash
git clone https://github.com/jonathangalarraga-max/sistema-tutorias_Jonathan_Galarraga.git
```

Ingresar a la carpeta del proyecto:

```bash
cd sistema-tutorias_Jonathan_Galarraga
```

Compilar y ejecutar las pruebas:

```bash
mvn clean test
```

Ejecutar el programa:

```bash
mvn exec:java "-Dexec.mainClass=com.tutorias.Main"
```

## Comprobación del funcionamiento

Al ejecutar el programa se pueden comprobar las principales funcionalidades del sistema mediante la información mostrada en consola.

Entre las evidencias se encuentra:

* Información del estudiante.
* Información del docente.
* Horario disponible.
* Confirmación de la reserva.
* Uso del `ReservaBuilder`.
* Creación de notificaciones mediante Factory Method.

## Comparación de patrones

| Característica     | Factory Method                                 | Builder                                     |
| ------------------ | ---------------------------------------------- | ------------------------------------------- |
| Propósito          | Crear diferentes implementaciones de un objeto | Construir objetos paso a paso               |
| Uso en el proyecto | Creación de notificadores                      | Creación de reservas                        |
| Clase principal    | Factory/creador                                | ReservaBuilder                              |
| Beneficio          | Facilita agregar nuevas implementaciones       | Facilita crear objetos con varios atributos |
| Método principal   | Método fábrica                                 | `build()`                                   |

## Problemas identificados

Inicialmente, concentrar toda la funcionalidad en una sola clase podía generar un código difícil de mantener y modificar.

La aplicación de patrones permite solucionar estos problemas separando responsabilidades. **Factory Method** organiza la creación de objetos de notificación, mientras que **Builder** organiza la construcción de objetos `Reserva`.

## Conclusiones

La implementación de Factory Method y Builder permitió mejorar la organización del sistema de reserva de tutorías.

Factory Method facilita la creación de diferentes tipos de notificaciones, mientras que Builder permite construir reservas de manera más clara y flexible.

El uso de estos patrones demuestra cómo los patrones de diseño pueden ayudar a desarrollar software más mantenible, reutilizable y fácil de ampliar.

## Evidencias del proyecto

El proyecto contiene las siguientes evidencias:

* Análisis del problema.
* Descripción de los problemas identificados.
* UML del patrón Factory Method.
* UML del patrón Builder.
* Código fuente Java.
* Implementación con Maven.
* Tabla comparativa de los patrones.
* Pruebas de funcionamiento.
* Conclusiones.
* README actualizado.
* Enlace funcional al repositorio.
* Declaración de uso de IA cuando corresponda.

## Repositorio

**GitHub:**

https://github.com/jonathangalarraga-max/sistema-tutorias_Jonathan_Galarraga.git

## Declaración de uso de IA

Para el desarrollo del proyecto se utilizó inteligencia artificial como herramienta de apoyo para comprender conceptos relacionados con patrones de diseño, revisar errores de código, mejorar la documentación y orientar la implementación. El código final fue revisado y adaptado de acuerdo con los requerimientos del proyecto.
