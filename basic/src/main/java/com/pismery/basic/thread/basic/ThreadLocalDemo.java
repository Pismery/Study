package com.pismery.basic.thread.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class ThreadLocalDemo {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> atomicInteger.incrementAndGet());

    public static int getId(){
        return threadLocal.get();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach(i ->
            executorService.submit(() -> log.debug("ID: "+ getId()))
        );
        executorService.shutdown();
    }
}
