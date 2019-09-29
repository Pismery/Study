package com.pismery.study.gof23.pattern.create.factory.simple;

import com.pismery.study.gof23.pattern.create.factory.simple.product.Car;

public class Client {
    public static void main(String[] args) {
        Car car = null;
        car = CarFactory.createCar("benz");
        car.run();
        car = CarFactory.createCar("bmw");
        car.run();
        car = CarFactory.createCar("maserati");
        car.run();
        /*Config config = new Config();
        car = CarFactory.createCar(ApplicationContextUtil.getBean(Config.class).getCartype());
        car.run();*/
    }
}
