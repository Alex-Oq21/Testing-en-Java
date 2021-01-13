package com.examples.javatest.util;

public class StringUtilTest {
    public static void main(String[] args) {
        assertEquals(StringUtil.repeat("Qué más pues?", 3), "Qué más pues?Qué más pues?Qué más pues?");

        assertEquals(StringUtil.repeat("Hola Mijo", 5), "Hola MijoHola MijoHola MijoHola MijoHola Mijo");

        assertEquals(StringUtil.repeat("Hola", 1), "Hola");

    }

    private static void assertEquals(String actual, String expected) {
        if(!actual.equals(expected)){
            throw new RuntimeException(actual + " No es igual a " + expected);
        }
    }
}