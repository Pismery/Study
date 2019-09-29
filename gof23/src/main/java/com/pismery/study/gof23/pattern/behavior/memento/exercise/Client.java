package com.pismery.study.gof23.pattern.behavior.memento.exercise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        Chessman chessman = new Chessman("马",3,3);
        CareTaker careTaker = new CareTaker();
        careTaker.add(chessman.save());
        chessman.move(3,6);
        careTaker.add(chessman.save());
        chessman.move(3,9);
        careTaker.add(chessman.save());

        log.debug("now: "+ chessman.toString());
        chessman.reverse(careTaker.reverse());
        log.debug("reverse: "+ chessman.toString());
        chessman.reverse(careTaker.reverse());
        log.debug("reverse: "+ chessman.toString());
        chessman.reverse(careTaker.reReverse());
        log.debug("reReverse: "+ chessman.toString());
    }
}
