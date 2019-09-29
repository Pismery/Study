package com.pismery.study.gof23.pattern.behavior.responsibility;

public class Client {
    public static void main(String[] args) {
        Approver diector = getApproverChain();

        askForLeave(2,diector);
        askForLeave(9,diector);
        askForLeave(29,diector);
        askForLeave(30,diector);
    }

    private static Approver getApproverChain() {
        Approver ceo = new CEO(null);
        Approver manager = new Manager(ceo);
        Approver director = new Director(manager);
        return director;
    }

    private static void askForLeave(int leaveDayNum,Approver approver) {
        LeaveForm form = new LeaveForm(leaveDayNum);
        approver.audit(form);
    }
}
