package com.pismery.study.gof23.pattern.behavior.interpreter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    public static void main(String[] args) {
        interpert("copy view from DB1 to DB2");
        interpert("copy table tblA from DB1 to DB2");
        interpert("move view from DB1 to DB2");
        interpert("move table tblB from DB1 to DB2");
        interpert("move2 table tblB from DB1 to DB2");
    }

    private static void interpert(String command) {
        log.debug(Interperter.interperter(command));
    }
}
