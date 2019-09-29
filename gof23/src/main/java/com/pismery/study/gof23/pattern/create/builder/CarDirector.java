package com.pismery.study.gof23.pattern.create.builder;

import com.pismery.study.gof23.pattern.create.builder.builder.CarBuilder;
import com.pismery.study.gof23.pattern.create.builder.product.Car;

public class CarDirector {
    private CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constrcut() {
        builder.buildEnginee();
        builder.buildFootbrake();
        builder.buildTyre();

        return builder.createCar();
    }
}
