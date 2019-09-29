package com.pismery.study.algorithm;

import com.pismery.study.algorithm.PerfectSquare;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfectSquareTest {
    @Test
    public void squareNumMathematicalFor0() {
        assertEquals(0, PerfectSquare.squareNumByMathematical(0));
    }

    @Test
    public void squareNumMathematicalFor1() {
        assertEquals(1, PerfectSquare.squareNumByMathematical(1));
    }

    @Test
    public void squareNumMathematicalFor2() {
        assertEquals(2, PerfectSquare.squareNumByMathematical(2));
    }

    @Test
    public void squareNumMathematicalFor4() {
        assertEquals(1, PerfectSquare.squareNumByMathematical(4));
    }

    @Test
    public void squareNumMathematicalFor8() {
        assertEquals(2, PerfectSquare.squareNumByMathematical(8));
    }

    @Test
    public void squareNumMathematicalFor123456() {
        int result = PerfectSquare.squareNumByMathematical(123456);
        assertEquals(3, result);
    }


    @Test
    public void squareNumDPFor0() {
        assertEquals(0, PerfectSquare.squareNumByDP(0));
    }

    @Test
    public void squareNumDPFor1() {
        assertEquals(1, PerfectSquare.squareNumByDP(1));
    }

    @Test
    public void squareNumDPFor2() {
        assertEquals(2, PerfectSquare.squareNumByDP(2));
    }

    @Test
    public void squareNumDPFor4() {
        assertEquals(1, PerfectSquare.squareNumByDP(4));
    }

    @Test
    public void squareNumDPFor8() {
        assertEquals(2, PerfectSquare.squareNumByDP(8));
    }

    @Test
    public void squareNumDPFor123456() {
        int result = PerfectSquare.squareNumByDP(123456);
        assertEquals(3, result);
    }

    @Test
    public void squareNumBFSFor0() {
        int result = PerfectSquare.squareNumByBFS(0);
        assertEquals(0, result);
    }

    @Test
    public void squareNumBFSFor1() {
        int result = PerfectSquare.squareNumByBFS(1);
        assertEquals(1, result);
    }

    @Test
    public void squareNumBFSFor3() {
        int result = PerfectSquare.squareNumByBFS(3);
        assertEquals(3, result);
    }

    @Test
    public void squareNumBFSFor4() {
        int result = PerfectSquare.squareNumByBFS(4);
        assertEquals(1, result);
    }

    @Test
    public void squareNumBFSFor8() {
        int result = PerfectSquare.squareNumByBFS(8);
        assertEquals(2, result);
    }

    @Test
    public void squareNumForBFS123456() {
        int result = PerfectSquare.squareNumByBFS(123456);
        assertEquals(3, result);
    }


    @Test
    public void isSqure4() {
        assertEquals(true, PerfectSquare.isSquare(4));
        assertEquals(false, PerfectSquare.isSquare(5));
    }


}