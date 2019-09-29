package com.pismery.basic.thread.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("thread1 running times: " + i);
            }
        });

        thread1.start();

        for (int i = 0; i < 10; i++) {
            if ( i == 3)
                thread1.join();

            log.debug("main running times: " + i);
        }

    }
}
