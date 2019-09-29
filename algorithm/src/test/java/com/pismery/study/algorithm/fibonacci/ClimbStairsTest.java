package com.pismery.study.algorithm.fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbStairsTest {

    @Test
    public void climb3() {
        assertEquals(3,ClimbStairs.climb(3));
    }
    @Test
    public void climb4() {
        assertEquals(5,ClimbStairs.climb(4));
    }


}