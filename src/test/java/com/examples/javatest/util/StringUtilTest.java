package com.examples.javatest.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testRepeat_Once(){
        Assert.assertEquals(StringUtil.repeat("Hola", 1), "Hola");
    }

    @Test
    public void testRepeat_Three_Times(){
        Assert.assertEquals(StringUtil.repeat("Qué más pues?", 3), "Qué más pues?Qué más pues?Qué más pues?");
    }
    @Test
    public void testRepeat_Five_Times(){
        Assert.assertEquals(StringUtil.repeat("Hola Mijo", 5), "Hola MijoHola MijoHola MijoHola MijoHola Mijo");
    }
    @Test
    public void testRepeat_Zero_Times(){
        Assert.assertEquals("", StringUtil.repeat("Hola", 0));
    }
    //No se espera un resultado, sólo retornar una excepción
    @Test(expected = IllegalArgumentException.class)
    public void testRepeat_Negative_Times(){
        StringUtil.repeat("Hola", -1);
    }

}