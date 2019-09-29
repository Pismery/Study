package com.pismery.study.algorithm.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SqrtTest {

    @Test
    public void sqrt0() {
        assertEquals(-1, Sqrt.sqrt(0));
    }

    @Test
    public void sqrt1() {
        assertEquals(1, Sqrt.sqrt(1));
    }

    @Test
    public void sqrt2() {
        assertEquals(1, Sqrt.sqrt(2));
    }

    @Test
    public void sqrt8() {
        assertEquals(2, Sqrt.sqrt(8));
    }

    @Test
    public void sqrt9() {
        assertEquals(3, Sqrt.sqrt(9));
    }

}