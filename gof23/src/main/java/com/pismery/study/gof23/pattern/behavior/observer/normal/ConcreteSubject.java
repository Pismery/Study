package com.pismery.study.gof23.pattern.behavior.observer.normal;

import lombok.ToString;

@ToString
public class ConcreteSubject extends Subject {

    private String status;

    public ConcreteSubject(String status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
        call(status);
    }

    @Override
    public void call(String status) {
        observers.stream().forEach(o -> o.update(status));
    }
}
