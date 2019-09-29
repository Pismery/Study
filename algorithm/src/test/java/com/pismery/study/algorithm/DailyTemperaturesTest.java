package com.pismery.study.algorithm;

import com.pismery.study.algorithm.DailyTemperatures;
import org.junit.Assert;
import org.junit.Test;

public class DailyTemperaturesTest {

    @Test
    public void example1() {
        Assert.assertArrayEquals(new int[]{1, 1, 0}, DailyTemperatures.solution(new int[]{1, 2, 3}));
    }
    @Test
    public void example2() {
        Assert.assertArrayEquals(new int[]{2, 1, 0}, DailyTemperatures.solution(new int[]{1, 1, 2}));
    }

}