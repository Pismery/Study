package com.pismery.study.structure.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by pismery on 2018-06-09.
 */
@Slf4j
public class QuickSortTest {
    @Test
    public void quickSortThreeWay() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 10, 5);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        QuickSort.quickSortThreeWay(actual, 0, actual.length - 1);
        assertArrayEquals(expect, actual);
    }

    @Test
    public void quickSortRecursion() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        QuickSort.quickSortRecursion(actual, 0, actual.length - 1);

        assertArrayEquals(expect, actual);
    }
    @Test
    public void quickSortRecursionVersion2() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 10, 5);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        QuickSort.quickSortRecursionVersion2(actual, 0, actual.length - 1);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void quickSortNoRecursion() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        QuickSort.quickSortNoRecursion(actual);

        assertArrayEquals(expect, actual);
    }
    @Test
    public void quickSortNoRecursionVersion2() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 1000);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        QuickSort.quickSortNoRecursionVersion2(actual);

        assertArrayEquals(expect, actual);
    }


}
