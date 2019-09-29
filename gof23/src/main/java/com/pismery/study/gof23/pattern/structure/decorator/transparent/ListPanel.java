package com.pismery.study.gof23.pattern.structure.decorator.transparent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListPanel implements Componet{
    @Override
    public void display() {
        log.debug("ListPanel is displaying...");
    }
}
