package com.pismery.study.gof23.pattern.create.factory.nomal.factory;

import com.pismery.study.gof23.pattern.create.factory.nomal.product.Car;
import com.pismery.study.gof23.pattern.create.factory.nomal.product.MaseratiCar;

public class MaseratiFatory extends CarFactory{
    @Override
    public Car createCar() {
        return new MaseratiCar();
    }
}
