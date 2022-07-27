package com.pismery.study.algorithm.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by pismery on 2018-07-02.
 */
@Slf4j
public class HeapSortTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void heapSort() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        //int[] actual = {9, 8, 6, 10, 1, 4, 3, 7, 5, 2};
        log.debug("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        HeapSort.heapSort(actual);

        log.debug("Array: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void heapSort1() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.debug("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        HeapSort.heapSort1(actual);

        log.debug("Array: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void heapSort2() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.debug("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        HeapSort.heapSort2(actual);

        log.debug("Array: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

}
