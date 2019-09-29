package com.pismery.study.algorithm.leetcode.shares;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaximizedCapitalTest {

    @Test
    public void solution1() {
        assertEquals(4,FindMaximizedCapital.solution1(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }

    @Test
    public void solution2() {
        assertEquals(4,FindMaximizedCapital.solution2(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }

    @Test
    public void solution3() {
        assertEquals(4,FindMaximizedCapital.solution3(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }
}