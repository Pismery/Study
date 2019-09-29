package com.pismery.study.gof23.pattern.create.prototype.java;

import com.pismery.study.gof23.pattern.create.prototype.Address;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

    public static void main(String[] args) {
        Person prototype = prototype();
        Person copy = new Person(prototype);

        log.debug("prototype: " + prototype);
        log.debug("copy:      " + copy);
        log.debug("prototype == copy:" + String.valueOf(prototype == copy));
        log.debug("prototype.getClass() == copy.getClass():" + String.valueOf(prototype.getClass() == copy.getClass()));
    }

    private static Person prototype() {
        Person prototype = new Person();
        prototype.setAge(17);
        prototype.setName("IQ Chan");
        Address address = new Address("China", "GuangDong");
        prototype.setAddress(address);

        return prototype;
    }

}
