package com.pismery.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoAppliacationContext {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DemoAppliacationContext.class);
        application.run(args);
    }
}
