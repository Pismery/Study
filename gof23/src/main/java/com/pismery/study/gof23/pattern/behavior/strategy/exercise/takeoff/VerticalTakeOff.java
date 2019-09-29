package com.pismery.study.gof23.pattern.behavior.strategy.exercise.takeoff;

public class VerticalTakeOff implements  TakeOff{
    @Override
    public void takeOff() {
        System.out.println("VerticalTakeOff take off...");
    }
}
