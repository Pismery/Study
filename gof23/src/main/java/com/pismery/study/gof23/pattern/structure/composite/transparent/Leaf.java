package com.pismery.study.gof23.pattern.structure.composite.transparent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Leaf implements Component {
    @Override
    public void operate() {
        log.debug("Leaf is operating...");
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
