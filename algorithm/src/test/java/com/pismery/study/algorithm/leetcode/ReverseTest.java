package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseTest {

    @Test
    public void solution1() {
        assertEquals(321,Reverse.solution1(123));
        assertEquals(21,Reverse.solution1(120));
        assertEquals(-321,Reverse.solution1(-123));
        assertEquals(-21,Reverse.solution1(-120));
        assertEquals(0,Reverse.solution1(1463847419));
        assertEquals(0,Reverse.solution1(-1463847419));
    }

}