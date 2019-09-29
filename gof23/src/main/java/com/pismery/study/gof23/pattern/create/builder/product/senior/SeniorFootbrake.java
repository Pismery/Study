package com.pismery.study.gof23.pattern.create.builder.product.senior;

import com.pismery.study.gof23.pattern.create.builder.product.Footbrake;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeniorFootbrake implements Footbrake {
    @Override
    public void brake() {
        log.debug("SeniorFootbrake braking...");
    }
}
