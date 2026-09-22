package com.tutorias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JUnitPruebaTest {

    @Test
    void pruebaJUnit() {
        int resultado = 2 + 2;

        assertEquals(4, resultado);
    }
}