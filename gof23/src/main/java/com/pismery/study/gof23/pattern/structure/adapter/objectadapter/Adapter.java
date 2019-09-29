package com.pismery.study.gof23.pattern.structure.adapter.objectadapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Adapter implements Target{

    private Adaptee adaptee = new Adaptee();

    @Override
    public void method() {
        log.debug("Adapter pre running...");
        adaptee.specialMethod();
        log.debug("Adapter post running...");
    }
}
