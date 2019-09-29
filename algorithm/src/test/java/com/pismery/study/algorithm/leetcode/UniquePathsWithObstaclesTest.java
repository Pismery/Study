package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsWithObstaclesTest {

    @Test
    public void solution() {

        int result = UniquePathsWithObstacles.solution(new int[][]{
                {0, 0, 0}
                , {0, 1, 0}
                , {0, 0, 0}
        });

        assertEquals(2,result);
    }
}