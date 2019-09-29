package com.pismery.basic.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
class ScheduleThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        fixedRateSenior1();
        fixedRateSenior2();
        fixedDelayDemo();
    }

    private static void fixedDelayDemo() throws InterruptedException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);

        threadPool.scheduleWithFixedDelay(
                () -> log.debug(Thread.currentThread().getName() + ":scheduleWithFixedDelay Senior 1")
                , 1L
                , 1L
                , TimeUnit.SECONDS
        );


        Thread.sleep(5000L);
        threadPool.shutdown();
    }

    private static void fixedRateSenior1() throws InterruptedException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);

        threadPool.scheduleAtFixedRate(
                () -> log.debug(Thread.currentThread().getName() + ":scheduleAtFixedRate Senior 1")
                , 1L
                , 1L
                , TimeUnit.SECONDS
        );


        Thread.sleep(5500L);
        threadPool.shutdown();
    }

    private static void fixedRateSenior2() throws InterruptedException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);

        threadPool.scheduleAtFixedRate(
                () -> {
                    try {
                        Thread.sleep(2000L);
                        log.debug(Thread.currentThread().getName() + ":scheduleAtFixedRate execute time more than delay time");
                    } catch (InterruptedException e) {
                        log.debug(Thread.currentThread().getName() + ":sleep interrupt...");
                    }
                }
                , 1L
                , 1L
                , TimeUnit.SECONDS
        );


        Thread.sleep(5500L);
        threadPool.shutdownNow();
    }


}
