package com.pismery.study.gof23.pattern.structure.adapter.defaultadpater;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Target extends Adapter{
    @Override
    public void specialMethod1() {
        super.specialMethod1();
        log.debug("Target orverride");
    }
}
