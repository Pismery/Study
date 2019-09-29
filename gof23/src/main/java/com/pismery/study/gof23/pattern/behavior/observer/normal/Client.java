package com.pismery.study.gof23.pattern.behavior.observer.normal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject("status-1");
        ConcreteObserver observer = new ConcreteObserver("ConcreteObserver status-1");
        subject.add(observer);

        log.debug(observer.toString());
        subject.setStatus("update-status");
        log.debug(observer.toString());
    }
}
