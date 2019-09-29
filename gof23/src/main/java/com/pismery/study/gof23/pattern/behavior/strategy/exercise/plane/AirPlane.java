package com.pismery.study.gof23.pattern.behavior.strategy.exercise.plane;

import com.pismery.study.gof23.pattern.behavior.strategy.exercise.sonicfly.SonicFly;
import com.pismery.study.gof23.pattern.behavior.strategy.exercise.takeoff.TakeOff;

public class AirPlane implements Plane{

    private SonicFly sonicFly;
    private TakeOff takeOff;

    public AirPlane(SonicFly sonicFly, TakeOff takeOff) {
        this.sonicFly = sonicFly;
        this.takeOff = takeOff;
    }

    @Override
    public void work() {
        System.out.println("AirePlane working...");
        takeOff.takeOff();
        sonicFly.fly();
    }
}
