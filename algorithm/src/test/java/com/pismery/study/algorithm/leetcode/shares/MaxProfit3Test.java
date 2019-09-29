package com.pismery.study.algorithm.leetcode.shares;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfit3Test {

    @Test
    public void solution1() {
        assertEquals(3,MaxProfit3.solution1(new int[]{1,2,3,0,2}));
        assertEquals(0,MaxProfit3.solution1(new int[]{5,4,3,2,1}));
        assertEquals(0,MaxProfit3.solution1(new int[]{1,1,1,1,1}));
        assertEquals(0,MaxProfit3.solution1(new int[]{}));
    }
}