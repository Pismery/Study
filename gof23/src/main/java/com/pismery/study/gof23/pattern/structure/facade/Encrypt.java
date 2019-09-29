package com.pismery.study.gof23.pattern.structure.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Encrypt {
    public String encrypt(String content) {
        log.debug("input String is encrypting...");
        return "encrypted String";
    }
}
