package com.pismery.basic.thread.util;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ExchangerDemo {

    private static boolean done = false;

    static class ExchangerProducer implements Runnable {
        private Exchanger<Integer> exchanger;

        public ExchangerProducer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            int product = 0;

            for (int i = 0; i < 10; i++) {
                product = i;
                if (exchanger != null) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Producer produce:" + product);
                        exchanger.exchange(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            done = true;
        }
    }

    static class ExchangerConsumer implements Runnable {
        private Exchanger<Integer> exchanger;

        public ExchangerConsumer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            int i = 0;
            while (!done && exchanger != null) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    Integer exchange = exchanger.exchange(i);
                    System.out.println("Consumer:" + exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new ExchangerProducer(exchanger));
        threadPool.submit(new ExchangerConsumer(exchanger));

        threadPool.shutdown();
    }
}
