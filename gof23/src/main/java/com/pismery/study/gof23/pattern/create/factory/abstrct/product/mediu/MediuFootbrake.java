package com.pismery.study.gof23.pattern.create.factory.abstrct.product.mediu;

import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Footbrake;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MediuFootbrake implements Footbrake {
    @Override
    public void brake() {
        log.debug("MediuFootbrake braking...");
    }
}
