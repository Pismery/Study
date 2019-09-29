package com.pismery.study.gof23.pattern.create.factory.abstrct.factory;


import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Enginee;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Footbrake;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Tyre;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.normal.NormalEnginee;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.normal.NormalFootbrake;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.normal.NormalTyre;

public class NormalFactory implements AbstractFactory {
    @Override
    public Tyre createTyre() {
        return new NormalTyre();
    }

    @Override
    public Enginee createEnginee() {
        return new NormalEnginee();
    }

    @Override
    public Footbrake createFootbrake() {
        return new NormalFootbrake();
    }
}
