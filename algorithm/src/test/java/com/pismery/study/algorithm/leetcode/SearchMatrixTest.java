package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 盒子
 * @since 2021/11/16
 */
public class SearchMatrixTest {


    @Test
    public void solution1() {
        assertEquals(true, SearchMatrix.solution1(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        assertEquals(false, SearchMatrix.solution1(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        assertEquals(true, SearchMatrix.solution1(new int[][]{{-5}}, -5));

    }
    @Test
    public void solution2() {
        assertEquals(true, SearchMatrix.solution2(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        assertEquals(false, SearchMatrix.solution2(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        assertEquals(true, SearchMatrix.solution2(new int[][]{{-5}}, -5));
    }

    @Test
    public void solution3() {
        assertEquals(true, SearchMatrix.solution3(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        assertEquals(false, SearchMatrix.solution3(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));
        assertEquals(true, SearchMatrix.solution3(new int[][]{{-5}}, -5));
    }


}