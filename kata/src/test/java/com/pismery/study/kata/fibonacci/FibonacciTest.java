package com.pismery.study.kata.fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void should_return_1_given_1_or_2() {
        assertEquals(1, Fibonacci.calculate(1));
        assertEquals(1, Fibonacci.calculate(2));
    }


}