package com.pismery.study.gof23.pattern.create.builder.builder;


import com.pismery.study.gof23.pattern.create.builder.product.normal.NormalEnginee;
import com.pismery.study.gof23.pattern.create.builder.product.normal.NormalFootbrake;
import com.pismery.study.gof23.pattern.create.builder.product.normal.NormalTyre;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NormalBuilder extends CarBuilder {
    @Override
    public void buildTyre() {
        log.debug("Normal Tyre building...");
        this.car.setTyre(new NormalTyre());
    }

    @Override
    public void buildEnginee() {
        log.debug("Normal Enginee building...");
        this.car.setEnginee(new NormalEnginee());
    }

    @Override
    public void buildFootbrake() {
        log.debug("Normal Footbrake building...");
        this.car.setFootbrake(new NormalFootbrake());
    }
}
