package com.pismery.basic.thread.atomic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger();

        NormalIncrement normalIncrement = new NormalIncrement(0);

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(normalIncrement);
            Future<Integer> submit = threadPool.submit(integer::getAndIncrement);
        }


        Thread.sleep(1000);
        threadPool.shutdown();
        System.out.println("normalIncrement result:" + normalIncrement.getInteger());
        System.out.println("atomicIncrement result:" + integer.get());
    }


    @AllArgsConstructor
    @Getter
    static class NormalIncrement implements Runnable {
        private Integer integer;

        @Override
        public void run() {
            integer = integer + 1;
        }
    }

}
