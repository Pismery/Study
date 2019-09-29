package com.pismery.study.gof23.pattern.behavior.memento.normal;

class Memento {
    Originator originator;

    public Memento(Originator originator) {
        this.originator = new Originator(originator);
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }
}
