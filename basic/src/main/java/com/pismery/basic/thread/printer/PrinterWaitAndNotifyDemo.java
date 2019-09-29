package com.pismery.basic.thread.printer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/*
不能保证 偶数线程一定是输出偶数的；
        new Thread(PrinterWaitAndNotifyDemo::simpleTask, "偶数").start();
        new Thread(PrinterWaitAndNotifyDemo::simpleTask, "奇数").start();
两个线程交替打印 [0-100]
多个线程交替打印[0-100]的数，缺点唤醒线程不确定，可能导致一直唤醒不是目标线程，白白耗费资源；*/
public class PrinterWaitAndNotifyDemo {
    static Integer i = 0;
    public static void main(String[] args) throws InterruptedException {
        runWithMany(5);
//        runWithTwo();
    }
    private static void runWithMany(int threadNum) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(threadNum);
        IntStream.range(0, threadNum).forEach((i -> threadPool.submit(new NotifyAllTask(i,threadNum))));

        TimeUnit.SECONDS.sleep(1L);

        threadPool.shutdownNow();
    }
    public static class NotifyAllTask implements Runnable {
        int order;
        int threadTotalNum;
        public NotifyAllTask(int order, int threadTotalNum) {
            this.order = order;
            this.threadTotalNum = threadTotalNum;
        }
        @Override
        public void run() {
            while (i <= 100) {
                if (i % threadTotalNum == order) {
                    synchronized (NotifyAllTask.class) {
                        NotifyAllTask.class.notifyAll();
                        System.out.println(Thread.currentThread().getName() + ":" + i++);
                        try {
                            NotifyAllTask.class.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }
    }


    private static void runWithTwo() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        IntStream.range(0, 2).forEach(index -> threadPool.submit(PrinterWaitAndNotifyDemo::simpleTask));
        TimeUnit.SECONDS.sleep(1L);

        threadPool.shutdownNow();
    }

    private static void simpleTask() {
        while (i <= 100) {
            synchronized (PrinterWaitAndNotifyDemo.class) {
                try {
                    PrinterWaitAndNotifyDemo.class.notify();
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    PrinterWaitAndNotifyDemo.class.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }



}
