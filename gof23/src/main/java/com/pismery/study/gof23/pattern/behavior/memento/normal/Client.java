package com.pismery.study.gof23.pattern.behavior.memento.normal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Originator originator = new Originator();
        originator.setStatus("init1");

        taker.add(originator.save());

        originator.setStatus("init2");
        log.debug("init status: "+originator.getStatus());

        originator.reverse(taker.get(0));
        log.debug("reverse status: "+originator.getStatus());
    }
}
