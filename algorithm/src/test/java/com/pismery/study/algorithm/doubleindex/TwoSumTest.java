package com.pismery.study.algorithm.doubleindex;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class TwoSumTest {

    private int[] sources;

    @Before
    public void init() {
        sources = new int[]{1, 2, 5, 9, 13, 17, 18, 25};
    }

    @Test
    public void find26() {
        assertArrayEquals(new int[]{1, 25}, TwoSum.find(sources, 26));
    }
    @Test
    public void find22() {
        assertArrayEquals(new int[]{5, 17}, TwoSum.find(sources, 22));
    }
    @Test
    public void find44() {
        assertNull(TwoSum.find(sources, 44));
    }
    @Test
    public void find1() {
        assertNull(TwoSum.find(sources, 1));
    }
    @Test
    public void findInNull() {
        assertNull(TwoSum.find(null, 26));
    }

}