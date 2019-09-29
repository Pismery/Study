package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortColorsTest {

    @Test
    public void solution1() {
        int[] nums = {2, 1, 2, 0, 1, 0};
        SortColors.solution1(nums);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    public void solution2() {
        int[] nums = {2, 1, 2, 0, 1, 0};
        SortColors.solution2(nums);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }
}