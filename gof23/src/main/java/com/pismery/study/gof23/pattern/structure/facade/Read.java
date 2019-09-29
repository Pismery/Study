package com.pismery.study.gof23.pattern.structure.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Read {
    public String read(String readPath) {
        log.debug("Read is reading...");
        return "string";
    }
}
