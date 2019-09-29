package com.pismery.basic.thread.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockDemo {

    private Lock lock = new ReentrantLock();

    private volatile int lockInt = 0;
    private volatile int withoutLockInt = 0;
    private volatile int synchronizedInt = 0;


    public int getSumWithLock() {
        lock.lock();
        try {
            Thread.sleep(10);
            lockInt++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return lockInt;
    }

    public synchronized int getSumeSynchronized() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronizedInt++;
        return synchronizedInt;
    }

    public int getSumeWithoutLock() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        withoutLockInt++;
        return withoutLockInt;
    }


    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();

        sychronizedThread(lockDemo);
        lockThread(lockDemo);
        withoutLockThread(lockDemo);
    }

    private static void withoutLockThread(LockDemo lockDemo) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("withoutLockInt: " + lockDemo.getSumeWithoutLock());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("withoutLockInt2: " + lockDemo.getSumeWithoutLock());
            }
        }).start();
    }

    private static void lockThread(LockDemo lockDemo) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("lockInt: " + lockDemo.getSumWithLock());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("lockInt2: " + lockDemo.getSumWithLock());
            }
        }).start();
    }

    private static void sychronizedThread(LockDemo lockDemo) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("synchronizedInt: " + lockDemo.getSumeSynchronized());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug("synchronizedInt2: " + lockDemo.getSumeSynchronized());
            }
        }).start();
    }

}
