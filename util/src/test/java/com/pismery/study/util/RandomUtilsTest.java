package com.pismery.study.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.*;


/**
 * Created by pismery on 2018-06-03.
 */
public class RandomUtilsTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void randomInt_Equals() {
        assertEquals(1, RandomUtils.randomInt(1, 1));
    }

    @Test
    public void randomInt_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("maxValue < minValue");

        RandomUtils.randomInt(2, 1);
    }

    @Test(expected = RuntimeException.class)
    public void randomInt_Exception_2() {
        RandomUtils.randomInt(2, 1);
    }

    @Test
    public void randomArray() {
        int[] randomResult = RandomUtils.randomArray(1, 100, 5000);

        for (int i = 0; i < randomResult.length; i++) {
            assertTrue(100 > randomResult[i]);
        }
        assertEquals(5000, randomResult.length);
    }

    @Test
    public void randomArrayNoRepeat_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("size is bigger than the range size");

        RandomUtils.randomArrayNoRepeat(1, 100, 101);
    }

    @Test
    public void randomArrayNoRepeat() {
        int[] expect = new int[100];
        for (int i = 0; i < 100; i++) {
            expect[i] = i;
        }

        int[] randomResult = RandomUtils.randomArrayNoRepeat(0, 100, 100);

        Arrays.sort(randomResult);
        assertArrayEquals(expect, randomResult);
    }


    @Test
    public void randomArrayNearlySorted() {
        int[] expect = new int[100];
        for (int i = 0; i < 100; i++) {
            expect[i] = i + 1;
        }

        int[] randomResult = RandomUtils.randomArrayNearlySorted(100, 0);

        assertArrayEquals(expect, randomResult);
    }

    @Test
    public void randomArrayNearlySorted_Exception_changeTimes_illegal() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("paramter is illegal");

        RandomUtils.randomArrayNearlySorted(10, -1);
    }

    @Test
    public void randomArrayNearlySorted_Exception_size_illegal() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("paramter is illegal");

        RandomUtils.randomArrayNearlySorted(0, 10);
    }
}
