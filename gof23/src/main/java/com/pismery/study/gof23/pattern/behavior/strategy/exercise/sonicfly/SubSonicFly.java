package com.pismery.study.gof23.pattern.behavior.strategy.exercise.sonicfly;

public class SubSonicFly implements  SonicFly {
    @Override
    public void fly() {
        System.out.println("SubSonicFly fly...");
    }
}
