package com.pismery.basic.thread.util;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SemaphoreDemo {


    public static void main(String[] args) throws InterruptedException {
        PrinterQueue printerQueue = new PrinterQueue(3);

        List<Thread> threads = Stream
                .generate(() -> new Thread(new PrintJob(printerQueue)))
                .limit(5)
                .collect(Collectors.toList());

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

    }


    @Slf4j
    private static class PrintJob implements Runnable {
        private PrinterQueue printerQueue;

        public PrintJob(PrinterQueue printerQueue) {
            this.printerQueue = printerQueue;
        }

        @Override
        public void run() {
            printerQueue.printJob(new Object());
        }
    }


    @Slf4j
    private static class PrinterQueue {
        private Semaphore semaphore;

        /**
         * True: free
         * False: working
         */
        private boolean[] printers;

        private Semaphore printerLock;

        public PrinterQueue(int num) {
            this.semaphore = new Semaphore(num, true);
            this.printerLock = new Semaphore(1, true);
            this.printers = new boolean[num];
            for (int i = 0; i < num; i++) {
                printers[i] = true;
            }
        }

        public void printJob(Object document) {
            int assignPrinter = -1;
            try {
                semaphore.acquire();

                assignPrinter = getPrinter();

                int duration = RandomUtils.randomInt(100, 1000);
                log.debug("{}: Printer:{},Cost:{},Time:{}"
                        , Thread.currentThread().getName()
                        , assignPrinter
                        , duration + "ms"
                        , LocalDateTime.now());

                Thread.sleep(duration);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.debug("{}: The print job is done...", Thread.currentThread().getName());
                releasePrinter(assignPrinter);
                semaphore.release();
            }
        }

        private void releasePrinter(int printer) {
            try {
                printerLock.acquire();
                printers[printer] = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                printerLock.release();
            }
        }


        private int getPrinter() {
            int assignPrinter = -1;
            try {
                printerLock.acquire();
                for (int i = 0; i < printers.length; i++) {
                    if (printers[i]) {
                        assignPrinter = i;
                        printers[i] = false;
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                printerLock.release();
            }
            return assignPrinter;
        }
    }
}
