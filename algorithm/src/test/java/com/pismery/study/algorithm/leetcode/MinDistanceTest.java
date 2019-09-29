package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinDistanceTest {

    @Test
    public void solution1() {
        assertEquals(3,MinDistance.solution1("horse","ros"));
        assertEquals(1,MinDistance.solution1("","a"));
        assertEquals(0,MinDistance.solution1("a","a"));
        assertEquals(5,MinDistance.solution1("intention","execution"));
    }
}