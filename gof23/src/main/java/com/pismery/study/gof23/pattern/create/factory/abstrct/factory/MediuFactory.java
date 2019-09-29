package com.pismery.study.gof23.pattern.create.factory.abstrct.factory;


import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Enginee;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Footbrake;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Tyre;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.mediu.MediuEnginee;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.mediu.MediuFootbrake;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.mediu.MediuTyre;

public class MediuFactory implements AbstractFactory {
    @Override
    public Tyre createTyre() {
        return new MediuTyre();
    }

    @Override
    public Enginee createEnginee() {
        return new MediuEnginee();
    }

    @Override
    public Footbrake createFootbrake() {
        return new MediuFootbrake();
    }
}
