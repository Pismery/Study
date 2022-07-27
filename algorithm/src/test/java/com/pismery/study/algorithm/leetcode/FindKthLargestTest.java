package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindKthLargestTest {

    @Test
    public void solution1() {
        assertEquals(5, FindKthLargest.solution1(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void solution2() {
        assertEquals(5, FindKthLargest.solution2(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    @Test
    public void solution3() {
        assertEquals(5, FindKthLargest.solution3(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}