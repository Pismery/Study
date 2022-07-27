package com.pismery.study.algorithm.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@Slf4j
public class RadixSortTest {



    @Test
    public void redixSortMSD() {
        //int[] actual = RandomUtils.randomArrayNoRepeat(1, 200000, 10000);
        int[] actual = RandomUtils.randomArray(1,200,300);
        log.debug("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        RadixSort.radixSortMSD(actual);

        log.debug("Array: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
    @Test
    public void redixSortLSD() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 10);
        //int[] actual = {1428, 1119, 338, 824, 1481, 1436, 1159, 715, 453, 612};
        log.debug("Array: " + Arrays.toString(actual));
        int[] expected = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expected);

        RadixSort.radixSortLSD(actual);

        log.debug("Array: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}