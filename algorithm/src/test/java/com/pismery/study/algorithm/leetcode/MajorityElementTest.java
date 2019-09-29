package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {

    @Test
    public void solution1() {
        assertEquals(3,MajorityElement.solution1(new int[]{3,2,3}));
        assertEquals(2,MajorityElement.solution1(new int[]{2,2,1,1,1,2,2}));
        assertEquals(3,MajorityElement.solution1(new int[]{3}));
        assertEquals(3,MajorityElement.solution3(new int[]{1,1,2,2,3,3,3}));
    }

    @Test
    public void solution2() {
        assertEquals(3,MajorityElement.solution2(new int[]{3,2,3}));
        assertEquals(2,MajorityElement.solution2(new int[]{2,2,1,1,1,2,2}));
        assertEquals(3,MajorityElement.solution2(new int[]{3}));
        assertEquals(3,MajorityElement.solution3(new int[]{1,1,2,2,3,3,3}));
    }

    @Test
    public void solution3() {
        assertEquals(3,MajorityElement.solution3(new int[]{3,2,3}));
        assertEquals(2,MajorityElement.solution3(new int[]{2,2,1,1,1,2,2}));
        assertEquals(3,MajorityElement.solution3(new int[]{3}));
        assertEquals(3,MajorityElement.solution3(new int[]{1,1,2,2,3,3,3}));
    }
}