package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 盒子
 * @since 2021/11/17
 */
public class FindTargetSumWaysTest {

    @Test
    public void solution1() {
        assertEquals(5, FindTargetSumWays.solution1(new int[] {1,1,1,1,1}, 3));
        assertEquals(1, FindTargetSumWays.solution1(new int[] {1}, 1));
        assertEquals(1, FindTargetSumWays.solution1(new int[] {1}, -1));
        assertEquals(0, FindTargetSumWays.solution1(new int[] {1}, 0));
    }
}