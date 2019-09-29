package com.pismery.study.algorithm.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private int[] sourcesByNormal;
    private int[] sourcesByLeftest;

    @Before
    public void init() {
        sourcesByNormal = new int[]{1, 4, 6, 7, 9, 19, 123, 436, 3213};
        sourcesByLeftest = new int[]{1, 1, 1, 5, 5, 6, 8, 8, 11, 11, 33, 33};
    }

    @Test
    public void findNothing() {
        assertEquals(-1, BinarySearch.binarySearch(sourcesByNormal, -1));
    }

    @Test
    public void find1() {
        assertEquals(0, BinarySearch.binarySearch(sourcesByNormal, 1));
    }

    @Test
    public void find19() {
        assertEquals(5, BinarySearch.binarySearch(sourcesByNormal, 19));
    }

    @Test
    public void find3213() {
        assertEquals(8, BinarySearch.binarySearch(sourcesByNormal, 3213));
    }


    @Test
    public void findNothingByBinarySearchByDivide() {
        assertFalse(BinarySearch.binarySearchByDivide(sourcesByNormal, -1, 0, sourcesByNormal.length - 1));
    }

    @Test
    public void find1ByBinarySearchByDivide() {
        assertTrue( BinarySearch.binarySearchByDivide(sourcesByNormal, 1, 0, sourcesByNormal.length - 1));
    }

    @Test
    public void find19ByBinarySearchByDivide() {
        assertTrue( BinarySearch.binarySearchByDivide(sourcesByNormal, 19, 0, sourcesByNormal.length - 1));
    }

    @Test
    public void find3213ByBinarySearchByDivide() {
        assertTrue( BinarySearch.binarySearchByDivide(sourcesByNormal, 3213, 0, sourcesByNormal.length - 1));
    }

    @Test
    public void findLeftest1() {
        assertEquals(0, BinarySearch.binarySearchLeftestIndex(sourcesByLeftest, 1));
    }

    @Test
    public void findLeftest5() {
        assertEquals(3, BinarySearch.binarySearchLeftestIndex(sourcesByLeftest, 5));
    }

    @Test
    public void findLeftest33() {
        assertEquals(10, BinarySearch.binarySearchLeftestIndex(sourcesByLeftest, 33));
    }

    @Test
    public void findLeftest0() {
        assertEquals(-1, BinarySearch.binarySearchLeftestIndex(sourcesByLeftest, 0));
    }

    @Test
    public void findLeftest34() {
        assertEquals(-1, BinarySearch.binarySearchLeftestIndex(sourcesByLeftest, 34));
    }

}