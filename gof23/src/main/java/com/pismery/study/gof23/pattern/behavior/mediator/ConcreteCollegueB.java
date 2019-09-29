package com.pismery.study.gof23.pattern.behavior.mediator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteCollegueB extends Collegue{
    @Override
    public void update() {
        log.debug("ConcreteCollegueB update...");
    }
}
