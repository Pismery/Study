package com.pismery.study.gof23.pattern.behavior.mediator;

public abstract class Collegue {
    private Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void update();

    public void onchange() {
        this.mediator.collegueChange(this);
    }

}
