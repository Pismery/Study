package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveElementTest {


    @Test
    public void solution1() {
        assertEquals(2, RemoveElement.solution1(
                new int[]{3, 2, 2, 3}, 3));
        assertEquals(5, RemoveElement.solution1(
                new int[]{0,1,2,2,3,0,4,2}, 2));
    }


    @Test
    public void solution2() {
        assertEquals(2, RemoveElement.solution2(
                new int[]{3, 2, 2, 3}, 3));
        assertEquals(5, RemoveElement.solution2(
                new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    @Test
    public void solution3() {
        assertEquals(2, RemoveElement.solution3(
                new int[]{3, 2, 2, 3}, 3));
        assertEquals(5, RemoveElement.solution3(
                new int[]{0,1,2,2,3,0,4,2}, 2));
    }


}