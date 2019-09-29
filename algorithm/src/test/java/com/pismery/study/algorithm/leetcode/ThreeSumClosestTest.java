package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumClosestTest {

    @Test
    public void solution1() {
        assertEquals(3, ThreeSumClosest.solution1(new int[]{0, 1, 2}, 0));
        assertEquals(0, ThreeSumClosest.solution1(new int[]{0, 2, 1, -3}, 1));
    }


    @Test
    public void solution2() {
        assertEquals(3, ThreeSumClosest.solution2(new int[]{0, 1, 2}, 0));
        assertEquals(0, ThreeSumClosest.solution2(new int[]{0, 2, 1, -3}, 1));
    }
}