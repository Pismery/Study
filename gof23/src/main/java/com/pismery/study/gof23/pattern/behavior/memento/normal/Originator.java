package com.pismery.study.gof23.pattern.behavior.memento.normal;

import lombok.Data;

@Data
public class Originator{
    private String status;

    public Originator() {
    }

    public Originator(Originator originator) {
        this.status = originator.getStatus();
    }

    public Memento save() {
        return new Memento(this);
    }

    public void reverse(Memento memento) {
        this.status = memento.originator.getStatus();
    }

}
