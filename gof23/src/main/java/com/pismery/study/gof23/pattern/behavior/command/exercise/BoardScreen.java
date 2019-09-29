package com.pismery.study.gof23.pattern.behavior.command.exercise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardScreen {
    public void create() {
        log.debug("BoardScreen is creating...");
    }

    public void open() {
        log.debug("BoardScreen is opening...");
    }

    public void edit() {
        log.debug("BoardScreen is editing...");
    }
}
