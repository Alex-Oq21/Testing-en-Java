package com.examples.javatest.discounts;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {
    @Test
    public void total_zero_when_there_are_proces(){
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(), CoreMatchers.is(0.0));
    }
}