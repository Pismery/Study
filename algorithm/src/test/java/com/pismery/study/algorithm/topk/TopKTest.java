package com.pismery.study.algorithm.topk;

import com.pismery.study.util.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TopKTest {

    private int[] sources;

    @Before
    public void init() {
        sources = RandomUtils.randomArray(1, 100, 20);
    }

    @Test
    public void versionOne() {
        int result = TopK.versionOne(sources, 5);

        Arrays.sort(sources);
        System.out.println(Arrays.toString(sources) + " topK: " + result);
        assertEquals(sources[sources.length - 5], result);
    }

    @Test
    public void versionTwo() {
        int result = TopK.versionTwo(sources, 5);

        Arrays.sort(sources);
        System.out.println(Arrays.toString(sources) + " topK: " + result);
        assertEquals(sources[sources.length - 5], result);
    }

}