package com.pismery.study.gof23.pattern.create.prototype.genernal;

import com.pismery.study.gof23.pattern.create.prototype.Address;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

    public static void main(String[] args) {
        Prototype prototype = prototype();
        Prototype copy = prototype.copy();

        log.debug("prototype: " + prototype);
        log.debug("copy:      " + copy);
        log.debug("prototype == copy:" + String.valueOf(prototype == copy));
        log.debug("prototype.getClass() == copy.getClass():" + String.valueOf(prototype.getClass() == copy.getClass()));
    }

    private static Prototype prototype() {
        Prototype prototype = new PrototypeImpl();
        ((PrototypeImpl) prototype).setAge(17);
        ((PrototypeImpl) prototype).setName("IQ Chan");
        Address address = new Address("China", "GuangDong");
        ((PrototypeImpl) prototype).setAddress(address);

        return prototype;
    }

}
