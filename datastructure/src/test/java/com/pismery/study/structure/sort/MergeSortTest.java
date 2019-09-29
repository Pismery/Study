package com.pismery.study.structure.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pismery on 2018-06-19.
 */
@Slf4j
public class MergeSortTest {

    @Test
    public void mergeSortThreeWay() {
        int[] actual = RandomUtils.randomArrayNoRepeat(0, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        MergeSort.mergeSortThreeWay(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort() {
        int[] actual = RandomUtils.randomArrayNoRepeat(0, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        MergeSort.mergeSortNormal(actual);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSortFromBottomTOUp() {
        int[] actual = RandomUtils.randomArrayNoRepeat(0, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        MergeSort.mergeSortFromBottomToUp(actual);

        Assert.assertArrayEquals(expected, actual);
    }
}
