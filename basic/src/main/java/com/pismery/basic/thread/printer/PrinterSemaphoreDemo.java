package com.pismery.basic.thread.printer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * 输入指定线程数目交替打印[0-100]的数目
 */
//多个线程交替打印[0-100]的数
public class PrinterSemaphoreDemo {
    static int value = 0;

    public static void main(String[] args) throws InterruptedException {
        int threadNum = 5;
        Semaphore[] semaphores = new Semaphore[threadNum];
        for (int index = 0; index < threadNum; index++) {
            semaphores[index] = new Semaphore(1);
            semaphores[index].acquire();
        }
        semaphores[0].release();

        ExecutorService threadPool = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            final Semaphore curSemaphore = semaphores[i];
            final Semaphore nextSemaphore = semaphores[(i + 1) % threadNum];

            threadPool.submit(() -> {
                try {
                    while (true) {
                        curSemaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + ":" + value++);
                        if (value > 100) {
                            System.exit(0);
                        }
                        nextSemaphore.release();
                    }
                } catch (InterruptedException e) {
                }
            });
        }
        TimeUnit.SECONDS.sleep(1L);
    }
}
