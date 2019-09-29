package com.pismery.study.gof23.pattern.behavior.responsibility;

import lombok.Data;

@Data
public class LeaveForm {
    private int leaveDayNum;

    public LeaveForm(int leaveDayNum) {
        this.leaveDayNum = leaveDayNum;
    }
}
