package com.pismery.study.algorithm;

import com.pismery.study.algorithm.IslandNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandNumberTest {
    @Test
    public void exampleOne() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        assertEquals(1, IslandNumber.getIslandNumber(grid));
    }

    @Test
    public void exampleTwo() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        assertEquals(3,IslandNumber.getIslandNumber(grid));
    }

}