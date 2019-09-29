package com.pismery.basic.thread.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.stream.IntStream;

@Slf4j
public class AtomicFieldUpdaterDemo implements Runnable {
    private static final AtomicIntegerFieldUpdater<AtomicFieldUpdaterDemo> intUpdater
            = AtomicIntegerFieldUpdater.newUpdater(AtomicFieldUpdaterDemo.class, "i");
    private static final AtomicLongFieldUpdater<AtomicFieldUpdaterDemo> longUpdater
            = AtomicLongFieldUpdater.newUpdater(AtomicFieldUpdaterDemo.class, "l");
    private static final AtomicReferenceFieldUpdater<AtomicFieldUpdaterDemo, Integer> refUpdater
            = AtomicReferenceFieldUpdater.newUpdater(AtomicFieldUpdaterDemo.class, Integer.class, "integer");

    private volatile int i = 0;
    private volatile long l = 0;
    private volatile Integer integer = 0;


    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AtomicFieldUpdaterDemo demo = new AtomicFieldUpdaterDemo();

        IntStream.range(0, 10)
                .forEach(i -> executorService.submit(demo));

        Thread.sleep(1000L);
        executorService.shutdown();

        demo.getResult();
    }

    private void getResult() {
        log.debug("Result int :" + i);
        log.debug("Result long :" + l);
        log.debug("Result Integer :" + integer);
    }

    @Override
    public void run() {
        intUpdater.incrementAndGet(this);
        longUpdater.incrementAndGet(this);
        refUpdater.updateAndGet(this, (integer) -> integer + 1);
    }
}
