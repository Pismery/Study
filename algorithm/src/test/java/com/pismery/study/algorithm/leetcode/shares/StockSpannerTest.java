package com.pismery.study.algorithm.leetcode.shares;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockSpannerTest {

    @Test
    public void solution1() {
        assertArrayEquals(new int[]{1,2,3,4,5,6,1,2,3,4,5,1,13,14,15},
                test(new int[]{3,5,8,8,14,56,25,30,32,42,43,15,75,76,81}));


        assertArrayEquals(new int[]{1, 1, 1, 2, 1, 4, 6},
                test(new int[]{100, 80, 60, 70, 60, 75, 85}));
    }

    private int[] test(int[] prices) {
        int[] result = new int[prices.length];
        StockSpanner stockSpanner = new StockSpanner();
        for (int i = 0; i < prices.length; i++) {
            result[i] = stockSpanner.next(prices[i]);
        }
        return result;
    }

}