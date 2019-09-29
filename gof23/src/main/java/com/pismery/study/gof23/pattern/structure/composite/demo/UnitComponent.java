package com.pismery.study.gof23.pattern.structure.composite.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class UnitComponent implements  Component{
    @Override
    public void display() {
    }

    @Override
    public void add(Component component) {
        log.debug("Illegal Access");
    }

    @Override
    public void delete(Component component) {
        log.debug("Illegal Access");
    }

    @Override
    public Component get(int index) {
        log.debug("Illegal Access");
        return null;
    }
}
