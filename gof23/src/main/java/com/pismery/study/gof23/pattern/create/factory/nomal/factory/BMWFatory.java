package com.pismery.study.gof23.pattern.create.factory.nomal.factory;

import com.pismery.study.gof23.pattern.create.factory.nomal.product.BMWCar;
import com.pismery.study.gof23.pattern.create.factory.nomal.product.Car;

public class BMWFatory extends CarFactory {
    @Override
    public Car createCar() {
        return new BMWCar();
    }
}
