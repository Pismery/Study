package com.pismery.basic.thread.util;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo2 {

    public static void main(String[] args) {
        final Exchanger<String> excelContent = new Exchanger<>();

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); //模拟录入时间
                excelContent.exchange("content");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadPool.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1); //模拟录入时间
                String a = "content";
                String b = excelContent.exchange(a);
                System.out.println("A和B数据是否一致：" + a.equals(b) + ",A录入的是："
                        + a + ",B录入是：" + b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        threadPool.shutdown();
    }
}
