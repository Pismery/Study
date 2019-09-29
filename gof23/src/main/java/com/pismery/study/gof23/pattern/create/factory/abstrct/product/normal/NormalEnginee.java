package com.pismery.study.gof23.pattern.create.factory.abstrct.product.normal;

import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Enginee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NormalEnginee implements Enginee {
    @Override
    public void start() {
        log.debug("NormalEnginee start...");
    }
}
