package com.pismery.study.gof23.pattern.create.builder.builder;

import com.pismery.study.gof23.pattern.create.builder.product.Car;

public abstract class CarBuilder {
    Car car = new Car();

    public abstract void buildTyre();

    public abstract void buildEnginee();

    public abstract void buildFootbrake();

    public Car createCar() {
        return this.car;
    }

}
