package com.pismery.basic.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class LogbackDemo implements Runnable{

    private String counterName;

    public LogbackDemo(String counterName) {
        this.counterName = counterName;
    }

    public void run() {
        MDC.put("threadGroupId", counterName);
        log.info("start counter {}", counterName);
        MDC.remove("threadGroupId");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; ++i) {
            executorService.execute(new LogbackDemo(String.valueOf(i)));
        }
        executorService.shutdown();
    }
}
