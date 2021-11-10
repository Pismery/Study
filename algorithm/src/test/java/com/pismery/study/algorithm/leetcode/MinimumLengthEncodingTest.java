package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 盒子
 * @since 2021/11/10
 */
public class MinimumLengthEncodingTest {


    @Test
    public void solution1() {
        assertEquals(10, MinimumLengthEncoding.solution1(new String[]{"time","me","bell"}));
        assertEquals(2, MinimumLengthEncoding.solution1(new String[]{"t"}));
    }

    @Test
    public void solution2() {
        assertEquals(10, MinimumLengthEncoding.solution2(new String[]{"time","me","bell"}));
        assertEquals(2, MinimumLengthEncoding.solution2(new String[]{"t"}));
    }

}