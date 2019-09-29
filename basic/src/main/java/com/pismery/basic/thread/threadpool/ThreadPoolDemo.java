package com.pismery.basic.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ThreadPoolDemo {

    static class Task implements Runnable {
        private Integer index;

        public Task(Integer index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(50);
                log.debug(Thread.currentThread().getName() + ": " + index);
                //System.out.println(index+"处理结束！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        newCachedThreadPool();
        newWorkStealingPool();
        newFixedThreadPool();
//        newSingleThreadExecutor();
//        newScheduledThreadPool();
    }

    private static void newWorkStealingPool() {
        ExecutorService threadPool = Executors.newWorkStealingPool(10);
        runWithThreadPool(threadPool, "newWorkStealingPool");
    }

    private static void newFixedThreadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        runWithThreadPool(threadPool, "newFixedThreadPool");
    }

    private static void newCachedThreadPool() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        runWithThreadPool(threadPool, "newCachedThreadPool");
    }

    private static void newScheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        threadPool.scheduleAtFixedRate(
                () -> log.debug(Thread.currentThread().getName() + ":scheduleAtFixedRate")
                , 1L, 1L, TimeUnit.SECONDS);

        Thread.sleep(5000L);
        threadPool.shutdownNow();

        ScheduledExecutorService threadPool2 = Executors.newScheduledThreadPool(1);
        threadPool2.scheduleWithFixedDelay(
                () -> log.debug(Thread.currentThread().getName() + ":scheduleWithFixedDelay")
                , 1L, 1L, TimeUnit.SECONDS);

        Thread.sleep(5000L);
        threadPool2.shutdownNow();
        log.debug("newScheduledThreadPool Done: " + threadPool);
    }


    private static void newSingleThreadExecutor() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable<String> callable = () -> Thread.currentThread().getName() + " is running...";
            futureList.add(threadPool.submit(callable));
        }

        futureList.forEach(future -> {
            try {
                log.debug("newSingleThreadExecutor Middle: " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        threadPool.shutdownNow();
    }


    private static void runWithThreadPool(ExecutorService threadPool, String name) {
        log.debug("==================" + name + "==================");
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Callable<String> callable = () -> Thread.currentThread().getName() + " is running...";
            futureList.add(threadPool.submit(callable));
        }
        log.debug(name + " Middle: " + threadPool);
        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        log.debug(name + " Done: " + threadPool);

        threadPool.shutdownNow();
    }

}


