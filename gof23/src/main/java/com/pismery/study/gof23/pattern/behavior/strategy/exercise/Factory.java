package com.pismery.study.gof23.pattern.behavior.strategy.exercise;

import com.pismery.study.gof23.pattern.behavior.strategy.exercise.plane.*;
import com.pismery.study.gof23.pattern.behavior.strategy.exercise.sonicfly.SubSonicFly;
import com.pismery.study.gof23.pattern.behavior.strategy.exercise.sonicfly.SuperSonicFly;
import com.pismery.study.gof23.pattern.behavior.strategy.exercise.takeoff.LongDistanceTakeOff;
import com.pismery.study.gof23.pattern.behavior.strategy.exercise.takeoff.VerticalTakeOff;

public class Factory {
    private Factory(){}
    public static Plane createPlane(PlaneName planeName){
        switch (planeName) {
            case AirPlane: return new AirPlane(new SubSonicFly(),new LongDistanceTakeOff());
            case Fighter: return new Fighter(new SuperSonicFly(),new LongDistanceTakeOff());
            case Harrier: return new Harrier(new SuperSonicFly(),new VerticalTakeOff());
            case Helicopter: return new Helicopter(new SubSonicFly(),new VerticalTakeOff());
            default: return null;
        }
    }
}
