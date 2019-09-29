package com.pismery.study.gof23.pattern.behavior.observer.jdk;

import lombok.ToString;

import java.util.Observable;
import java.util.Observer;

@ToString
public class ConcreteObserver implements Observer {
    private String status;

    public ConcreteObserver(String status) {
        this.status = status;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.status = "observer "+(String) arg;
    }
}
