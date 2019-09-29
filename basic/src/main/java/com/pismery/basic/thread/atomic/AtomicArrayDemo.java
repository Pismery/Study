package com.pismery.basic.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArrayDemo {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
        );

        for (int i = 0; i < 10; i++) {
            atomicIntegerArray.accumulateAndGet(i, 10, (x, y) -> x + y);
            System.out.println("int["+i+"]:"+atomicIntegerArray.get(i));
        }
    }


}
