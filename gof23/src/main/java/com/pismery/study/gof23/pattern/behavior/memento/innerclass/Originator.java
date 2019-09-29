package com.pismery.study.gof23.pattern.behavior.memento.innerclass;

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

    public void reverse(Object memento ) {
        this.status = ((Memento)memento).originator.getStatus();
    }

    private class Memento {
        Originator originator;

        public Memento(Originator originator) {
            this.originator = originator;
        }
    }
}
