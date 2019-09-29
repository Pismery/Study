package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinPathSumTest {

    @Test
    public void solution1() {
        assertEquals(7,MinPathSum.solution(new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));

        assertEquals(4,MinPathSum.solution(new int[][] {
                {1,1,1},
                {1,1,1},
                {1,0,1}
        }));
    }

}