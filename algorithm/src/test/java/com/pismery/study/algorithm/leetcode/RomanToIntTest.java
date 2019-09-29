package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToIntTest {

    @Test
    public void test() {
        assertEquals(3,RomanToInt.solution("III"));
        assertEquals(4,RomanToInt.solution("IV"));
        assertEquals(9,RomanToInt.solution("IX"));
        assertEquals(13,RomanToInt.solution("XIII"));
        assertEquals(14,RomanToInt.solution("XIV"));
        assertEquals(27,RomanToInt.solution("XXVII"));
    }

}