package com.pismery.study.gof23.pattern.create.factory.abstrct.factory;

import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Enginee;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Footbrake;
import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Tyre;

public interface AbstractFactory {
    Tyre createTyre();
    Enginee createEnginee();
    Footbrake createFootbrake();
}
