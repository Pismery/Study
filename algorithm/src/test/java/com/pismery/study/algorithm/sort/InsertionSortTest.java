package com.pismery.study.algorithm.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by pismery on 2018-06-10.
 */
@Slf4j
public class InsertionSortTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void insertionSort_Version1() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        InsertionSort.insertionSortNormal(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void insertionSortOptimization() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        InsertionSort.insertionSortOptimization(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void insertionSortWithDichotomy() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        InsertionSort.insertionSortWithDichotomy(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void insertionSort_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        InsertionSort.insertionSortNormal(null);
    }
    @Test
    public void insertionSortOptimization_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        InsertionSort.insertionSortOptimization(null);
    }
    @Test
    public void insertionSortWithDichotomy_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        InsertionSort.insertionSortWithDichotomy(null);
    }
}
