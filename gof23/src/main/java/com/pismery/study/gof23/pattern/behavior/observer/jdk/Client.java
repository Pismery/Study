package com.pismery.study.gof23.pattern.behavior.observer.jdk;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject("status");
        ConcreteObserver observer = new ConcreteObserver("observer status");
        subject.addObserver(observer);
        log.debug(observer.toString());
        subject.setStatus("update-status");
        log.debug(observer.toString());

    }
}
