package com.pismery.study.gof23.pattern.create.builder.builder;


import com.pismery.study.gof23.pattern.create.builder.product.mediu.MediuEnginee;
import com.pismery.study.gof23.pattern.create.builder.product.mediu.MediuFootbrake;
import com.pismery.study.gof23.pattern.create.builder.product.mediu.MediuTyre;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MediuBuilder extends CarBuilder {
    @Override
    public void buildTyre() {
        log.debug("Mediu Tyre building...");
        this.car.setTyre(new MediuTyre());
    }

    @Override
    public void buildEnginee() {
        log.debug("Mediu Enginee building...");
        this.car.setEnginee(new MediuEnginee());
    }

    @Override
    public void buildFootbrake() {
        log.debug("Mediu Footbrake building...");
        this.car.setFootbrake(new MediuFootbrake());
    }
}
