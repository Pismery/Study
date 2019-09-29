package com.pismery.basic.thread.basic;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        ArrayList<Integer> taskList = new ArrayList<>();
        ArrayList<Integer> taskList2 = new ArrayList<>();
        Producer producer = new Producer(taskList, 5);
        Consumer consumer = new Consumer(taskList2);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}


@Slf4j
class Producer implements Runnable {

    private final List<Integer> taskList;
    private final int MAX_SIZE;

    public Producer(List<Integer> taskList, int MAX_SIZE) {
        this.taskList = taskList;
        this.MAX_SIZE = MAX_SIZE;
    }

    @Override
    public void run() {
        int num = 0;
        while (true) {
            try {
                Thread.sleep(RandomUtils.randomInt(500,1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (taskList) {
                while (taskList.size() == MAX_SIZE) {
                    try {
                        log.debug("CallableTask list is full...");
                        taskList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num = num % 5 + 1;
                log.debug("Produce : " + num);

                taskList.add(num);
                taskList.notifyAll();
            }
        }
    }
}

@Slf4j
class Consumer implements Runnable {

    private final List<Integer> taskList;
    private final Random random = new Random();
    public Consumer(List<Integer> taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(RandomUtils.randomInt(500,1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (taskList) {
                while (taskList.isEmpty()) {
                    try {
                        log.debug("CallableTask List is empty...");
                        taskList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("Consume :" + taskList.remove(0));
                taskList.notifyAll();

            }
        }
    }
}