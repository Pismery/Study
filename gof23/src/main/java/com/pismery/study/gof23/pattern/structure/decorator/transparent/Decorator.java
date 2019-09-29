package com.pismery.study.gof23.pattern.structure.decorator.transparent;

public abstract class Decorator implements Componet{

    protected Componet component;

    public Decorator(Componet componet) {
        this.component = componet;
    }
}
