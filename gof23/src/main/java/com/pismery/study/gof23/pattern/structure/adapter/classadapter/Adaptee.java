package com.pismery.study.gof23.pattern.structure.adapter.classadapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Adaptee {

    public void specialMethod() {
        log.debug("Adaptee specialMethod running...");
    }
}
