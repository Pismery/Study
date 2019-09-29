package com.pismery.study.gof23.pattern.create.factory.abstrct.factory;


import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Enginee;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Footbrake;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Tyre;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.senior.SeniorEnginee;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.senior.SeniorFootbrake;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.senior.SeniorTyre;

public class SeniorFactory implements AbstractFactory {
    @Override
    public Tyre createTyre() {
        return new SeniorTyre();
    }

    @Override
    public Enginee createEnginee() {
        return new SeniorEnginee();
    }

    @Override
    public Footbrake createFootbrake() {
        return new SeniorFootbrake();
    }
}
