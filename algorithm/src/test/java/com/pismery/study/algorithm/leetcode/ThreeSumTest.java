package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ThreeSumTest {

    @Test
    public void solution1() {
        int param[] = new int[]{-4, -1, -4, 0, 2, -2, -4, -3, 2, -3, 2, 3, 3, -4};

        List<List<Integer>> expect = Arrays.asList(
                Arrays.asList(-4, 2, 2),
                Arrays.asList(-3, 0, 3),
                Arrays.asList(-2, -1, 3),
                Arrays.asList(-2, 0, 2)
        );

        List<List<Integer>> actual = ThreeSum.solution1(param);
        for (int i = 0; i < expect.size(); i++) {
            assertTrue(checkDiffrent(expect.get(i), actual.get(i)));
        }

    }

    private static boolean checkDiffrent(List<Integer> list, List<Integer> list1) {
        list.sort(Comparator.comparing(Integer::intValue));
        list1.sort(Comparator.comparing(Integer::intValue));
        return list.toString().equals(list1.toString());
    }
}