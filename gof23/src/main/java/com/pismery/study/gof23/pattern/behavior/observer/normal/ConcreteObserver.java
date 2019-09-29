package com.pismery.study.gof23.pattern.behavior.observer.normal;

import lombok.ToString;

@ToString
public class ConcreteObserver implements Observer {

    private String status;

    public ConcreteObserver(String status) {
        this.status = status;
    }

    @Override
    public void update(String status) {
        this.status = "ConcreteObserver " + status;
    }
}
