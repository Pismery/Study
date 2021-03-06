package com.pismery.study.gof23.pattern.behavior.responsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CEO extends Approver {

    public static final int MAX_LEAVE_DAY = 30;
    public static final int MIN_LEAVE_DAY = 10;

    public CEO(Approver successor) {
        super(successor);
    }

    @Override
    public void audit(LeaveForm form) {
        if (form.getLeaveDayNum() >= MIN_LEAVE_DAY && form.getLeaveDayNum() < MAX_LEAVE_DAY) {
            log.debug("CEO approve leave " + form.getLeaveDayNum() + " days");
            return;
        }

        log.debug("Leaving "+form.getLeaveDayNum() + " days can not approve by anyone");
    }
}
