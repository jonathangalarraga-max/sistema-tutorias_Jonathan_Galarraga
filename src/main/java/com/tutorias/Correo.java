package com.tutorias;

public record Correo(String valor) {

    public Correo {
        if (valor == null || valor.isBlank() || !valor.contains("@")) {
            throw new IllegalArgumentException("Correo inválido.");
        }
    }
}