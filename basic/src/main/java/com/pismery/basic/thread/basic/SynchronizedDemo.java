package com.pismery.basic.thread.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedDemo implements Runnable {
    boolean flag = true;

    @Override
    public void run() {
//        noStop();
        willStop();
    }

    private void noStop() {
        synchronized (this) {
            while (flag) {

            }
        }
    }

    public void willStop() {
        while (flag) {
            synchronized (this) {

            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo target = new SynchronizedDemo();
        new Thread(target).start();

        Thread.sleep(100L);

        target.flag = false;

    }
}
