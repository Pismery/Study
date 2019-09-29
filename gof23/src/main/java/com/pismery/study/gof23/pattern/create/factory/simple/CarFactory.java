package com.pismery.study.gof23.pattern.create.factory.simple;

import com.pismery.study.gof23.pattern.create.factory.simple.product.BMWCar;
import com.pismery.study.gof23.pattern.create.factory.simple.product.BenzCar;
import com.pismery.study.gof23.pattern.create.factory.simple.product.Car;
import com.pismery.study.gof23.pattern.create.factory.simple.product.MaseratiCar;

public class CarFactory {

    public static Car createCar(String carName) {
        Car result = null;
        switch (carName) {
            case "benz":
                result = new BenzCar();
                break;
            case "bmw":
                result = new BMWCar();
                break;
            case "maserati":
                result = new MaseratiCar();
                break;
            default:
                break;
        }
        return result;
    }

}
