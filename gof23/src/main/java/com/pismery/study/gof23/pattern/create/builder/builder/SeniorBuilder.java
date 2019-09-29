package com.pismery.study.gof23.pattern.create.builder.builder;


import com.pismery.study.gof23.pattern.create.builder.product.senior.SeniorEnginee;
import com.pismery.study.gof23.pattern.create.builder.product.senior.SeniorFootbrake;
import com.pismery.study.gof23.pattern.create.builder.product.senior.SeniorTyre;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeniorBuilder extends CarBuilder {
    @Override
    public void buildTyre() {
        log.debug("Senior Tyre building...");
        this.car.setTyre(new SeniorTyre());
    }

    @Override
    public void buildEnginee() {
        log.debug("Senior Enginee building...");
        this.car.setEnginee(new SeniorEnginee());
    }

    @Override
    public void buildFootbrake() {
        log.debug("Senior Footbrake building...");
        this.car.setFootbrake(new SeniorFootbrake());
    }
}
