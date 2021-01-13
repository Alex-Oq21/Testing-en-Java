package com.examples.javatest.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testRepeat(){
        Assert.assertEquals(StringUtil.repeat("Qué más pues?", 3), "Qué más pues?Qué más pues?Qué más pues?");

        Assert.assertEquals(StringUtil.repeat("Hola Mijo", 5), "Hola MijoHola MijoHola MijoHola MijoHola Mijo");

        Assert.assertEquals(StringUtil.repeat("Hola", 1), "Hola");

    }

}