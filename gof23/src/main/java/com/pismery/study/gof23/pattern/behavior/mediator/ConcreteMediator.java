package com.pismery.study.gof23.pattern.behavior.mediator;

public class ConcreteMediator implements  Mediator{
    private ConcreteCollegueA collegueA;
    private ConcreteCollegueB collegueB;

    public ConcreteMediator(ConcreteCollegueA collegueA, ConcreteCollegueB collegueB) {
        this.collegueA = collegueA;
        this.collegueB = collegueB;
    }

    @Override
    public void collegueChange(Collegue collegue) {
        if (collegue.getClass() == ConcreteCollegueA.class) {
            collegueA.update();
            collegueB.update();
        } else if (collegue.getClass() == ConcreteCollegueB.class) {
            collegueB.update();
            collegueA.update();
        }
    }
}
