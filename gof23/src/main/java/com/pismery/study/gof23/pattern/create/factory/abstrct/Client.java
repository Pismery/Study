package com.pismery.study.gof23.pattern.create.factory.abstrct;

import com.pismery.study.gof23.pattern.create.factory.abstrct.factory.AbstractFactory;
import com.pismery.study.gof23.pattern.create.factory.abstrct.factory.MediuFactory;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Enginee;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Footbrake;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Tyre;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        invoke(new MediuFactory());
    }

    private static void invoke(AbstractFactory normalFactory) {
        Tyre tyre = normalFactory.createTyre();
        Enginee enginee = normalFactory.createEnginee();
        Footbrake footbrake = normalFactory.createFootbrake();

        log.debug("begin");

        enginee.start();
        tyre.rolling();
        footbrake.brake();

        log.debug("end");
        log.debug("");

    }


}
