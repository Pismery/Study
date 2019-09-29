package com.pismery.study.algorithm.fibonacci;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@Slf4j
public class FibonacciTest {


    @Test
    @Ignore
    public void timeTest() throws InterruptedException {
        LocalTime begin = LocalTime.now();
        LocalTime end = LocalTime.now();
        long excuteTime;

        begin = LocalTime.now();
        Fibonacci.versionOne(47);
        end = LocalTime.now();
        excuteTime = (end.toNanoOfDay() - begin.toNanoOfDay())/1000000;
        log.debug("versionOne:"+excuteTime + "ms");

        begin = LocalTime.now();
        Fibonacci.versionTwo(49);
        end = LocalTime.now();
        excuteTime = (end.toNanoOfDay() - begin.toNanoOfDay())/1000000;
        log.debug("versionTwo:"+excuteTime + "ms");

        begin = LocalTime.now();
        Fibonacci.versionThree(49);
        end = LocalTime.now();
        excuteTime = (end.toNanoOfDay() - begin.toNanoOfDay())/1000000;
        log.debug("versionTwo:"+excuteTime + "ms");

    }

    @Test
    public void version1() {
        long[] result = new long[10];
        for (int i = 0; i < 10; i++) {
            result[i] = Fibonacci.versionOne(i);
        }

        assertArrayEquals(new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, result);
    }


    @Test
    public void version2() {
        long[] result = new long[10];
        for (int i = 0; i < 10; i++) {
            result[i] = Fibonacci.versionTwo(i);
        }
        log.debug(Integer.MAX_VALUE+"");
        log.debug(Long.MAX_VALUE+"");
        log.debug(Arrays.toString(result));
        assertArrayEquals(new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, result);
    }

    @Test
    public void version3() {
        long[] result = new long[10];
        for (int i = 0; i < 10; i++) {
            result[i] = Fibonacci.versionThree(i);
        }

        log.debug(Arrays.toString(result));
        assertArrayEquals(new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, result);
    }

    @Test
    public void version4() {
        long[] result = new long[10];
        for (int i = 0; i < 10; i++) {
            result[i] = Fibonacci.versionFour(i);
        }

        log.debug(Arrays.toString(result));
        assertArrayEquals(new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}, result);
    }


    @Test
    public void binaryPow() {
        assertEquals(1,Fibonacci.binaryPow(2,0),0.1);
        assertEquals(2,Fibonacci.binaryPow(2,1),0.1);
        assertEquals(4,Fibonacci.binaryPow(2,2),0.1);
        assertEquals(8,Fibonacci.binaryPow(2,3),0.1);
        assertEquals(16,Fibonacci.binaryPow(2,4),0.1);
        assertEquals(32,Fibonacci.binaryPow(2,5),0.1);
    }
}