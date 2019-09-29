package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountAndSayTest {

    @Test
    public void solution1() {
        assertEquals("1",CountAndSay.solution1(1));
        assertEquals("11",CountAndSay.solution1(2));
        assertEquals("21",CountAndSay.solution1(3));
        assertEquals("1211",CountAndSay.solution1(4));
        assertEquals("111221",CountAndSay.solution1(5));
        assertEquals("312211",CountAndSay.solution1(6));
    }
}