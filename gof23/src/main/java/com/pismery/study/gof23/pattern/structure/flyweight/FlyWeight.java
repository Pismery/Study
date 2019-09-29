package com.pismery.study.gof23.pattern.structure.flyweight;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class FlyWeight {
    private String type;

    public FlyWeight(String type) {
        this.type = type;
    }

    public void display(OutStutas outStutas) {
        log.debug("Type: " + type + ";"
                + "position: (" + outStutas.getPositionX() + "," + outStutas.getPositionY() + ");" +
                "size: " + outStutas.getSize()+";");
    }
}
