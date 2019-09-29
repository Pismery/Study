package com.pismery.basic.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class
AtomicStampedReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0, 0);

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(() -> {
                boolean flag = false;
                while (!flag) {
                    int stamp = atomicStampedReference.getStamp();
                    Integer value = atomicStampedReference.getReference();
                    flag = atomicStampedReference.compareAndSet(value, Integer.valueOf(value + 1), stamp, stamp + 1);
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("atomicIncrement reference:" + atomicStampedReference.getReference());
        System.out.println("atomicIncrement stamp:" + atomicStampedReference.getStamp());

    }
}
