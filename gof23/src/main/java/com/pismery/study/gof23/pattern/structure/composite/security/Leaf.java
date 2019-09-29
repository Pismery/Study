package com.pismery.study.gof23.pattern.structure.composite.security;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Leaf implements Component{
    @Override
    public void operate() {
        log.debug("Leaf is operating...");
    }
}
