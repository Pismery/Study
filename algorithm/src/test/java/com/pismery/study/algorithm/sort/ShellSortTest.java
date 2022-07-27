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
public class ShellSortTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void shellSortTest() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        ShellSort.shellSort(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void shellSortOptimization() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        ShellSort.shellSortOptimization(actual);

        assertArrayEquals(expect, actual);
    }


    @Test
    public void shellSortTest_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        ShellSort.shellSort(null);
    }

    @Test
    public void shellSortOptimization_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        ShellSort.shellSortOptimization(null);
    }
}
