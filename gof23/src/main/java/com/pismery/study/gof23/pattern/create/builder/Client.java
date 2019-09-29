package com.pismery.study.gof23.pattern.create.builder;

import com.pismery.study.gof23.pattern.create.builder.builder.CarBuilder;
import com.pismery.study.gof23.pattern.create.builder.builder.MediuBuilder;
import com.pismery.study.gof23.pattern.create.builder.product.Car;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        invoke(new MediuBuilder());
    }

    private static void invoke(CarBuilder builder) {
        CarDirector director = new CarDirector(builder);
        Car car = director.constrcut();
        car.run();
    }


}
