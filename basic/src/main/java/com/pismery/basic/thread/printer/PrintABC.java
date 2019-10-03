package com.pismery.basic.thread.printer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 1，三个线程，依次打印A，B，C(1线程打印A，2线程打印B，3线程打印C)
 *  ，打印十次，线程run方法只能执行一次，最后输出结果 ABCABCABC.....
 */
public class PrintABC {

    private static Semaphore[] locks = new Semaphore[3];

    public static void main(String[] args) throws InterruptedException {
        printABC();
    }

    private static void printABC() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int index = 0; index < 3; index++) {
            locks[index] = new Semaphore(1);
            locks[index].acquire();
        }
        locks[0].release();
        String[] strList = new String[]{"A", "B", "C"};
        for (int i = 0; i < 3; i++) {
            pool.submit(new PrintString("Printer_" + i, strList[i], locks[i], locks[(i + 1) % 3]));
        }

        pool.shutdown();
    }


    private static class PrintString implements Runnable {
        private String printerName;
        private String str;
        private Semaphore cur;
        private Semaphore next;

        public PrintString(String printerName, String str, Semaphore cur, Semaphore next) {
            this.printerName = printerName;
            this.str = str;
            this.cur = cur;
            this.next = next;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    cur.acquire();
                    System.out.print(str);
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
