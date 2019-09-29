package com.pismery.study.algorithm.leetcode.shares;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfit2Test {

    @Test
    public void solution1() {
        assertEquals(7,MaxProfit2.solution1(new int[]{7,1,5,3,6,4}));
        assertEquals(4,MaxProfit2.solution1(new int[]{1,2,3,4,5}));
        assertEquals(0,MaxProfit2.solution1(new int[]{7,6,5,4,3,2,1}));
        assertEquals(0,MaxProfit2.solution1(new int[]{3,3}));
    }

    @Test
    public void solution2() {
        assertEquals(7,MaxProfit2.solution2(new int[]{7,1,5,3,6,4}));
        assertEquals(4,MaxProfit2.solution2(new int[]{1,2,3,4,5}));
        assertEquals(0,MaxProfit2.solution2(new int[]{7,6,5,4,3,2,1}));
        assertEquals(0,MaxProfit2.solution2(new int[]{3,3}));
    }

    @Test
    public void solution3() {
        assertEquals(7,MaxProfit2.solution3(new int[]{7,1,5,3,6,4}));
        assertEquals(4,MaxProfit2.solution3(new int[]{1,2,3,4,5}));
        assertEquals(0,MaxProfit2.solution3(new int[]{7,6,5,4,3,2,1}));
        assertEquals(0,MaxProfit2.solution3(new int[]{3,3}));
    }
}