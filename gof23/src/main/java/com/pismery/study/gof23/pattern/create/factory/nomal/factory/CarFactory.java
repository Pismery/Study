package com.pismery.study.gof23.pattern.create.factory.nomal.factory;

import com.pismery.study.gof23.pattern.create.factory.nomal.product.Car;

public abstract class CarFactory {
    public abstract Car createCar();

    public void run() {
        Car car = this.createCar();
        car.run();
    }
}
