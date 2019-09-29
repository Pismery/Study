package com.pismery.study.algorithm;

import com.pismery.study.algorithm.OpenTheLock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OpenTheLockTest {

    @Test
    public void example1() {
        long result = OpenTheLock.openLock(new String[]{
                "0201", "0101", "0102", "1212", "2002"
        }, "0202");
        assertEquals(6L, result);
    }

    @Test
    public void example2() {
        long result = OpenTheLock.openLock(new String[]{"8888"}, "0009");
        assertEquals(1L, result);
    }

    @Test
    public void example3() {
        long result = OpenTheLock.openLock(new String[]{
                "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"
        }, "8888");
        assertEquals(-1L, result);
    }

    @Test

    public void example4() {
        long result = OpenTheLock.openLock(new String[]{
                "0000"}, "8888");
        assertEquals(-1L, result);
    }
}