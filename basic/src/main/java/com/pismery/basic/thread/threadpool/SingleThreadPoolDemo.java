package com.pismery.basic.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

class SingleThreadPoolDemo {
    public static void main(String[] args) {
        final ExecutorService fixed = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) fixed;
        executor.setCorePoolSize(4);


        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        execute(threadPool);
        execute(executorService);
    }


    private static void execute(ExecutorService threadPool) {

        List<Future> fixedFuture = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fixedFuture.add(threadPool.submit(new ThreadPoolDemo.Task(index)));
        }

        threadPool.shutdown();
    }
}
