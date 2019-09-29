package com.pismery.study.gof23.pattern.structure.facade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Write {
    public void write(String content){
        log.debug("Write is writing");
    }
}
