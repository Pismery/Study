package com.pismery.study.algorithm.leetcode.shares;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MaxProfit6Test {

    @Test
    public void solution1() {
        assertEquals(2,MaxProfit6.solution1(2,new int[]{2,4,1}));
        assertEquals(7,MaxProfit6.solution1(2,new int[]{3,2,6,5,0,3}));
        assertEquals(0,MaxProfit6.solution1(2,new int[]{1,1,1}));
        assertEquals(0,MaxProfit6.solution1(2,new int[]{4,3,2,1}));

        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            integerIntegerEntry.getValue();

        }
    }

}