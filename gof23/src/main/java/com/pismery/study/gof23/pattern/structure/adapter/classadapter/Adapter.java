package com.pismery.study.gof23.pattern.structure.adapter.classadapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Adapter extends Adaptee implements Target{

    @Override
    public void method() {
        log.debug("Adapter pre running...");
        this.specialMethod();
        log.debug("Adapter post running...");
    }
}
