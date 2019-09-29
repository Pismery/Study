package com.pismery.basic.thread;

import com.pismery.study.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class CallableDemo implements Callable<Integer> {

    private Integer number;

    public CallableDemo(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(200);
            }
        }
        log.debug("Result for number - " + number + " -> " + result);
        return result;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            CallableDemo callableDemo = new CallableDemo(RandomUtils.randomInt(1,10));
            futureList.add(executor.submit(callableDemo));
        }

        futureList.forEach(integerFuture -> {
            try {
                log.debug("Future is done 1 - " + integerFuture.isDone());
                log.debug("Future result is - " + integerFuture.get());
                log.debug("Future is done 2 - " + integerFuture.isDone());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }
}