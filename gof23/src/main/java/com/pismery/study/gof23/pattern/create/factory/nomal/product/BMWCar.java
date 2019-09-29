package com.pismery.study.gof23.pattern.create.factory.nomal.product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BMWCar implements Car {
    @Override
    public void run() {
        log.debug("BMW is running");
    }
}
