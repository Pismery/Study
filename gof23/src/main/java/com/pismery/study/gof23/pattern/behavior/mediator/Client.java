package com.pismery.study.gof23.pattern.behavior.mediator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        ConcreteCollegueA collegueA = new ConcreteCollegueA();
        ConcreteCollegueB collegueB = new ConcreteCollegueB();
        Mediator mediator = new ConcreteMediator(collegueA,collegueB);
        collegueA.setMediator(mediator);
        collegueB.setMediator(mediator);

        log.debug("collegueA.onchange");
        collegueA.onchange();
        log.debug("collegueB.onchange");
        collegueB.onchange();
    }
}
