package com.pismery.basic.thread.atomic;

import com.pismery.study.util.J8RandomUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

@Slf4j
public class AccumulatorDemo {
    public static void main(String[] args) throws InterruptedException {
        LongAccumulator accumulator = new LongAccumulator(Long::max, Long.MIN_VALUE);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        IntStream.range(0, 10).forEach(i -> executorService.submit(() -> {
            Random random = new Random();
            long value = J8RandomUtils.randomInt(0, 2000);
            log.debug("Random value: " + value);
            accumulator.accumulate(value);
        }));

        Thread.sleep(1000L);
        executorService.shutdown();

        log.debug("Max value: " + accumulator.longValue());
    }
}
