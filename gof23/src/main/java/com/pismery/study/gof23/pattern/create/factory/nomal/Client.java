package com.pismery.study.gof23.pattern.create.factory.nomal;

import com.pismery.study.gof23.pattern.create.factory.nomal.factory.BMWFatory;
import com.pismery.study.gof23.pattern.create.factory.nomal.factory.BenzFactory;
import com.pismery.study.gof23.pattern.create.factory.nomal.factory.CarFactory;
import com.pismery.study.gof23.pattern.create.factory.nomal.factory.MaseratiFatory;
import com.pismery.study.gof23.pattern.create.factory.nomal.product.Car;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        version1();
        version2();
    }
    private static void version1() {
        log.debug("version 1");
        CarFactory factory = new BenzFactory();
        Car car = factory.createCar();
        car.run();

        factory = new BMWFatory();
        car = factory.createCar();
        car.run();

        factory = new MaseratiFatory();
        car = factory.createCar();
        car.run();
    }
    private static void version2() {
        log.debug("version 2");
        new BenzFactory().run();
        new BMWFatory().run();
        new MaseratiFatory().run();
    }
}
