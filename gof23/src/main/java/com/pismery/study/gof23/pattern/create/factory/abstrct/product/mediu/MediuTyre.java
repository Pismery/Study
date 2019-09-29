package com.pismery.study.gof23.pattern.create.factory.abstrct.product.mediu;

import com.pismery.study.gof23.pattern.create.factory.abstrct.product.Tyre;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MediuTyre implements Tyre {
    @Override
    public void rolling() {
        log.debug("MediuTyre rolling");
    }
}
