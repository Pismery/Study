package com.pismery.study.structure.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@Slf4j
public class BucketSortTest {

    @Test
    public void bucketSort() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        //int[] actual = {9, 8, 6, 10, 1, 4, 3, 7, 5, 2};
        log.debug("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        BucketSort.bucketSort(actual);

        log.debug("Array: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
    @Test
    public void bucketSort2() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        //int[] actual = {9, 8, 6, 10, 1, 4, 3, 7, 5, 2};
        log.debug("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        BucketSort.bucketSort2(actual);

        log.debug("Array: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}