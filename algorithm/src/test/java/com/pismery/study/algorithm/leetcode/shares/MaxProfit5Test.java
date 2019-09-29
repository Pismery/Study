package com.pismery.study.algorithm.leetcode.shares;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfit5Test {


    @Test
    public void solution1() {
        assertEquals(6,MaxProfit5.solution1(new int[]{3,3,5,0,0,3,1,4}));
        assertEquals(4,MaxProfit5.solution1(new int[]{1,2,3,4,5}));
        assertEquals(0,MaxProfit5.solution1(new int[]{5,4,3,2,1}));
    }

}