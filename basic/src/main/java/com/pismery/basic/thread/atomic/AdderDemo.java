package com.pismery.basic.thread.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

@Slf4j
public class AdderDemo implements Runnable{

    LongAdder longAdder = new LongAdder();
    DoubleAdder doubleAdder = new DoubleAdder();


    @Override
    public void run() {
        longAdder.increment();
        doubleAdder.add(1D);
    }

    private void getResult() {
        log.debug("Result longAdder:" + longAdder);
        log.debug("Result doubleAdder:" + doubleAdder);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        AdderDemo adderDemo = new AdderDemo();

        IntStream.range(0,1000).forEach(i -> executorService.submit(adderDemo));

        Thread.sleep(1000L);
        executorService.shutdown();

        adderDemo.getResult();
    }
}
