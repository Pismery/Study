package com.pismery.study.algorithm.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by pismery on 2018-06-18.
 */
@Slf4j
public class CountSortTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void countSortWithMap() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        CountSort.countSortWithMap(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void countSort() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        CountSort.countSort(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void countSortWithMap_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        CountSort.countSortWithMap(null);
    }

    @Test
    public void countSort_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        CountSort.countSort(null);
    }
}
