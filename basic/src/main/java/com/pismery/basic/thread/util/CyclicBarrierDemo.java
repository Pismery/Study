package com.pismery.basic.thread.util;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    private static final CyclicBarrier CYCLIC_BARRIER =  new CyclicBarrier(5,
            ()-> System.out.println("All people arrived,start the meeting")
    );


    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("n1"),
                new Person("n2"),
                new Person("n3"),
                new Person("n4"),
                new Person("n5")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        people.forEach(person -> executorService.execute(person));

        executorService.shutdown();
    }


    @AllArgsConstructor
    private static class Person implements Runnable {

        private String name;

        @Override
        public void run() {
            System.out.println(name+" attended...");

            try {
                CYCLIC_BARRIER.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
