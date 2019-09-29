package com.pismery.study.gof23.pattern.behavior.responsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Director extends Approver {

    public static final int MAX_LEAVE_DAY = 3;

    public Director(Approver successor) {
        super(successor);
    }

    @Override
    public void audit(LeaveForm form) {
        if (form.getLeaveDayNum() < MAX_LEAVE_DAY) {
            log.debug("Director approve leave " + form.getLeaveDayNum() + " days");
            return;
        }
        successor.audit(form);

    }
}
