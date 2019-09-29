package com.pismery.study.algorithm.doubleindex;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SquareSumTest {
    
    @Test
    public void judgeNegative() {
        assertFalse(SquareSum.judge(-1));
    }
    @Test
    public void judge0() {
        assertTrue(SquareSum.judge(0));
    }
    @Test
    public void judge3() {
        assertFalse(SquareSum.judge(3));
    }
    @Test
    public void judge4() {
        assertTrue(SquareSum.judge(4));
    }
    @Test
    public void judge5() {
        assertTrue(SquareSum.judge(5));
    }

}