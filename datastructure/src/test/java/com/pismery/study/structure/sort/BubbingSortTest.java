package com.pismery.study.structure.sort;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by pismery on 2018-06-06.
 */
@Slf4j
public class BubbingSortTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void bubbingSort_Version1() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);
        log.info("Array: " + Arrays.toString(actual));

        BubbingSort.bubbingSortNormal(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void bubbingSort_Version2() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        BubbingSort.bubbingSortOptimization(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void bubbingSort_Version3() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 2000, 100);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        BubbingSort.bubbingSortByExchangeIndex(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void bubbingSortBidirectional() {
        int[] actual = RandomUtils.randomArrayNoRepeat(1, 10, 5);
        log.info("Array: " + Arrays.toString(actual));
        int[] expect = Arrays.copyOf(actual, actual.length);
        Arrays.sort(expect);

        BubbingSort.bubbingSortBidirectional(actual);

        assertArrayEquals(expect, actual);
    }

    @Test
    public void bubbingSort_Version1_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        BubbingSort.bubbingSortNormal(null);
    }

    @Test
    public void bubbingSort_Version2_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        BubbingSort.bubbingSortOptimization(null);
    }

    @Test
    public void bubbingSort_Version3_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        BubbingSort.bubbingSortByExchangeIndex(null);
    }

    @Test
    public void bubbingSortBidirectional_Exception() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("NPE");

        BubbingSort.bubbingSortBidirectional(null);
    }
}
