package com.pismery.study.gof23.pattern.create.factory.nomal.factory;

import com.pismery.study.gof23.pattern.create.factory.nomal.product.BenzCar;
import com.pismery.study.gof23.pattern.create.factory.nomal.product.Car;

public class BenzFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new BenzCar();
    }
}
