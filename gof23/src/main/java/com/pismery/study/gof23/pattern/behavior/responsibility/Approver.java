package com.pismery.study.gof23.pattern.behavior.responsibility;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public abstract class Approver {
    protected Approver successor;
    private String name;

    public Approver(Approver successor) {
        this.successor = successor;
    }

    public abstract void audit(LeaveForm form);
}
