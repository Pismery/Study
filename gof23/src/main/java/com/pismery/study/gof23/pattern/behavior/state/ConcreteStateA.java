package com.pismery.study.gof23.pattern.behavior.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteStateA implements State{
    @Override
    public void handle() {
        log.debug("ConcreteStateA handle...");
    }
}
