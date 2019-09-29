package com.pismery.study.algorithm.doubleindex;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidPalidromeTest {

    @Test
    public void example1() {
        assertTrue(ValidPalidrome.valid("a"));
    }
    @Test
    public void example2() {
        assertTrue(ValidPalidrome.valid("aa"));
    }
    @Test
    public void example3() {
        assertTrue(ValidPalidrome.valid("aba"));
    }
    @Test
    public void example4() {
        assertTrue(ValidPalidrome.valid("abba"));
    }
    @Test
    public void example5() {
        assertTrue(ValidPalidrome.valid("abca"));
    }

}