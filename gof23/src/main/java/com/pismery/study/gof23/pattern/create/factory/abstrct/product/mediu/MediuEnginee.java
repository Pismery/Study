package com.pismery.study.gof23.pattern.create.factory.abstrct.product.mediu;

import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Enginee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MediuEnginee implements Enginee {
    @Override
    public void start() {
        log.debug("MediuEnginee start...");
    }
}
