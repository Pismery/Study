package com.pismery.study.gof23.pattern.structure.composite.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Text extends UnitComponent {
    @Override
    public void display() {
        super.display();
        log.debug("Text is displaying...");
    }
}
