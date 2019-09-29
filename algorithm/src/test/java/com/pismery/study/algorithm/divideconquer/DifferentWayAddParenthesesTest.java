package com.pismery.study.algorithm.divideconquer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DifferentWayAddParenthesesTest {

    /**
     * Example 1:<br>
     * Input: "2-1-1"<br>
     * Output: [0, 2]<br>
     * Explanation:<br>
     * ((2-1)-1) = 0<br>
     * (2-(1-1)) = 2<br>
     */
    @Test
    public void example1() {
        List<Integer> expected = Arrays.asList(0, 2);
        List<Integer> actual =  DifferentWayAddParentheses.diffWaysToCompute("2-1-1");
        actual.sort(Integer::compareTo);
        assertEquals(expected, actual);
    }

    /**
     * Example 2:<br>
     * Input: "2*3-4*5"<br>
     * Output: [-34, -14, -10, -10, 10]<br>
     * Explanation:<br>
     * (2*(3-(4*5))) = -34<br>
     * ((2*3)-(4*5)) = -14<br>
     * ((2*(3-4))*5) = -10<br>
     * (2*((3-4)*5)) = -10<br>
     * (((2*3)-4)*5) = 10<br>
     */
    @Test
    public void example2() {
        List<Integer> expected = Arrays.asList(-34, -14, -10, -10, 10);
        List<Integer> actual =  DifferentWayAddParentheses.diffWaysToCompute("2*3-4*5");
        actual.sort(Integer::compareTo);
        assertEquals(expected, actual);
    }


}