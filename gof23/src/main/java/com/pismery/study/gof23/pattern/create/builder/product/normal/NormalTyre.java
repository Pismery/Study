package com.pismery.study.gof23.pattern.create.builder.product.normal;

import com.pismery.study.gof23.pattern.create.builder.product.Tyre;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NormalTyre implements Tyre {
    @Override
    public void rolling() {
        log.debug("NormalTyre rolling");
    }
}
