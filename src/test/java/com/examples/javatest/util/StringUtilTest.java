package com.examples.javatest.util;

public class StringUtilTest {
    public static void main(String[] args) {
    String result = StringUtil.repeat(" Qué más pues?", 3);
        System.out.println(result);

        String result2 = StringUtil.repeat("Hola Mijo", 5);
        if (result2.equals("Hola MijoHola MijoHola MijoHola MijoHola Mijo")){
            System.out.println("Ok");
        }else {
            System.out.println("No pasa la prueba");
        }
        String result3 = StringUtil.repeat("Hola", 1);
        if(!result3.equals("Hola")){
            System.err.println("Error!!");
        }
    }
}