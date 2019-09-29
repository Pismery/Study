package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSubArrayTest {


    @Test
    public void solution1() {
        assertEquals(6, MaxSubArray.solution1(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        }));

        assertEquals(1, MaxSubArray.solution1(new int[]{1}));
        assertEquals(-1, MaxSubArray.solution1(new int[]{-1}));
        assertEquals(1, MaxSubArray.solution1(new int[]{-1, 1}));
    }


    @Test
    public void solution2() {
        assertEquals(6, MaxSubArray.solution2(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        }));

        assertEquals(1, MaxSubArray.solution2(new int[]{1}));
        assertEquals(-1, MaxSubArray.solution2(new int[]{-1}));
        assertEquals(1, MaxSubArray.solution2(new int[]{-1, 1}));
    }

}