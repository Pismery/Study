package com.pismery.basic.thread.basic;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadLocalDemo2 {

    static ThreadLocal<HashMap> threadLocal = new ThreadLocal<HashMap>() {
        @Override
        protected HashMap initialValue() {
            System.out.println(Thread.currentThread().getName() + "initialValue");
            return new HashMap();
        }
    };

    static HashMap hashMap = new HashMap();
    static Hashtable hashTable = new Hashtable();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(15);

        IntStream.range(0, 15).forEach(i -> {
            executorService.submit(() -> {
                threadLocalMethod(i);
//                hashTableMethod(i);
//                hashMapMethod(i);
            });
        });


        executorService.shutdown();
    }

    private static void threadLocalMethod(int i) {
        Map map = threadLocal.get();
        for (int j = 0; j < 30; j++) {
            map.put(j, j + i);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()
                + "# map.size()=" + map.size() + " # " + map);
    }

    private static void hashTableMethod(int i) {
        for (int j = 0; j < 30; j++) {
            hashTable.put(j, j + i);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()
                + "# hashTable.size()=" + hashTable.size() + " # " + hashTable);
    }

    private static void hashMapMethod(int i) {
        for (int j = 0; j < 30; j++) {
            hashMap.put(j, j + i);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()
                + "# hashMap.size()=" + hashMap.size() + " # " + hashMap);
    }

}
