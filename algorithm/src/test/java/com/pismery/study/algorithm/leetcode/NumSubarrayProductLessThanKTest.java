package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author 盒子
 * @since 2021/11/9
 */
public class NumSubarrayProductLessThanKTest{


    @Test
    public void solution1() {
        assertEquals(8, NumSubarrayProductLessThanK.solution1(new int[]{10, 5, 2, 6}, 100));
        assertEquals(18,NumSubarrayProductLessThanK.solution1(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
        assertEquals(1,NumSubarrayProductLessThanK.solution1(new int[]{57,44,92,28,66,60,37,33,52,38,29,76,8,75,22}, 18));
    }
    @Test

    public void solution2() {
        assertEquals(8, NumSubarrayProductLessThanK.solution2(new int[]{10, 5, 2, 6}, 100));
        assertEquals(18,NumSubarrayProductLessThanK.solution2(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
        assertEquals(1,NumSubarrayProductLessThanK.solution2(new int[]{57,44,92,28,66,60,37,33,52,38,29,76,8,75,22}, 18));
    }

}