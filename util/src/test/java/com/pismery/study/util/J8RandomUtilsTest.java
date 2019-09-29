package com.pismery.study.util;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;


public class J8RandomUtilsTest {

    @Test
    public void randomInt() {
        assertThat(J8RandomUtils.randomInt(0, 1)).isEqualTo(0);

        for (int i = 0; i < 10; i++) {
            assertThat(RandomUtils.randomInt(0, 2)).isBetween(0, 1);
        }
    }

    @Test
    public void randomArray() {
        int[] randomResult = J8RandomUtils.randomIntArray(1, 100, 5000);

        for (int i = 0; i < randomResult.length; i++) {
            assertTrue(100 > randomResult[i]);
        }
        assertEquals(5000, randomResult.length);
    }

    @Test
    public void randomArrayNoRepeat() {
        int[] expect = new int[100];
        for (int i = 0; i < 100; i++) {
            expect[i] = i;
        }

        int[] randomResult = J8RandomUtils.randomArrayNoRepeat(0, 100, 100);

        Arrays.sort(randomResult);
        assertArrayEquals(expect, randomResult);
    }

    @Test
    public void randomArrayNearlySorted() {
        int[] expect = new int[100];
        for (int i = 0; i < 100; i++) {
            expect[i] = i;
        }

        int[] randomResult = J8RandomUtils.randomArrayNearlySorted(100, 0);

        assertArrayEquals(expect, randomResult);
    }
}