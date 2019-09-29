package com.pismery.study.algorithm.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RangeSearchTest {

    private int[] sources;

    @Before
    public void init() {
        sources = new int[]{5,7,7,8,8,10};
    }

    @Test
    public void search5() {
        assertArrayEquals(new int[]{0,0},RangeSearch.search(sources,5));
    }

    @Test
    public void search6() {
        assertArrayEquals(new int[]{-1,-1},RangeSearch.search(sources,6));
    }

    @Test
    public void search8() {
        assertArrayEquals(new int[]{3,4},RangeSearch.search(sources,8));
    }

    @Test
    public void search10() {
        assertArrayEquals(new int[]{5,5},RangeSearch.search(sources,10));
    }

    @Test
    public void searchLeftFirst() {
        assertEquals(0,RangeSearch.searchLeftest(sources,4));
    }

    @Test
    public void searchLeftNull() {
        assertEquals(-1,RangeSearch.searchLeftest(sources,11));
    }

    @Test
    public void searchLeftMiddle() {
        assertEquals(3,RangeSearch.searchLeftest(sources,8));
    }


    @Test
    public void searchLeftLast() {
        assertEquals(5,RangeSearch.searchLeftest(sources,10));
    }

}