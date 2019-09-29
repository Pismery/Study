package com.pismery.basic.thread.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YieldDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("thread 1 running...");
                Thread.yield();
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("thread 2 running...");
                Thread.yield();
            }
        });

        /*
         相同优先级，基本是交换执行
         相差一个优先级，高优先级的连续执行次数多一点
         相差两个优先级，基本由高优先级的指定先
         */
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }

}
