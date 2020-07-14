package com.pismery.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class DemoApplicationContext {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoApplicationContext.class);
        application.run(args);
    }
}
