package com.pismery.study.algorithm.leetcode.shares;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfit1Test {

    @Test
    public void solution1() {
        assertEquals(5, MaxProfit1.solution1(new int[]{7,1,5,3,6,4}));
        assertEquals(0, MaxProfit1.solution1(new int[]{7,6,5,4,3,2,1}));
        assertEquals(0, MaxProfit1.solution1(new int[]{}));
    }

    @Test
    public void solution2() {
        assertEquals(5, MaxProfit1.solution2(new int[]{7,1,5,3,6,4}));
        assertEquals(0, MaxProfit1.solution2(new int[]{7,6,5,4,3,2,1}));
        assertEquals(0, MaxProfit1.solution2(new int[]{}));

    }

    @Test
    public void solution3() {
        assertEquals(5, MaxProfit1.solution3(new int[]{7,1,5,3,6,4}));
        assertEquals(0, MaxProfit1.solution3(new int[]{7,6,5,4,3,2,1}));
        assertEquals(0, MaxProfit1.solution3(new int[]{}));
    }

    @Test
    public void solution4() {
        assertEquals(5, MaxProfit1.solution4(new int[]{7,1,5,3,6,4}));
        assertEquals(0, MaxProfit1.solution4(new int[]{7,6,5,4,3,2,1}));
        assertEquals(0, MaxProfit1.solution4(new int[]{}));
    }
}