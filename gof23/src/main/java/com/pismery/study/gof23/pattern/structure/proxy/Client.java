package com.pismery.study.gof23.pattern.structure.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        Image image = new BufferProxyImage("fileName");
        log.debug("first display");
        image.display();
        log.debug("second display");
        image.display();
    }
}
