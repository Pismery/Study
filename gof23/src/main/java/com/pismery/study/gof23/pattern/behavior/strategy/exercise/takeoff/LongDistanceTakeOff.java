package com.pismery.study.gof23.pattern.behavior.strategy.exercise.takeoff;

public class LongDistanceTakeOff implements  TakeOff{
    @Override
    public void takeOff() {
        System.out.println("LongDistanceTakeOff take off...");
    }
}
