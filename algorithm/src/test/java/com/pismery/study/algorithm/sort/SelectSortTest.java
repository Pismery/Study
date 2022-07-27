package com.pismery.study.algorithm.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by pismery on 2018-06-09.
 */
@Slf4j
public class SelectSortTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void selectSort_Version1() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 10, 5);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        SelectSort.SelectSort(actual);

        assertArrayEquals(expect, actual);
    }

}
