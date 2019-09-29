package com.pismery.study.algorithm.leetcode.shares;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfit4Test {

    @Test
    public void solution1() {
        assertEquals(8,MaxProfit4.solution1(new int[]{1, 3, 2, 8, 4, 9},2));
        assertEquals(0,MaxProfit4.solution1(new int[]{1, 3, 2, 8, 4, 9},20));
        assertEquals(0,MaxProfit4.solution1(new int[]{6,5,4,3,2,1},2));
        assertEquals(0,MaxProfit4.solution1(new int[]{1},2));
    }
}