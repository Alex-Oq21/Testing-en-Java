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
    @Test
    public void total_is_the_sum_of_prices(){
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        assertThat(calculator.getTotal(), CoreMatchers.is(25.7));
    }
}