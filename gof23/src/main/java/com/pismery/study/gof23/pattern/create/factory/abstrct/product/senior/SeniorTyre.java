package com.pismery.study.gof23.pattern.create.factory.abstrct.product.senior;

import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Tyre;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeniorTyre implements Tyre {
    @Override
    public void rolling() {
        log.debug("SeniorTyre rolling");
    }
}
