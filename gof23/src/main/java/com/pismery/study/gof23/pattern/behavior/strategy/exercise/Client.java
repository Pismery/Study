package com.pismery.study.gof23.pattern.behavior.strategy.exercise;

import com.pismery.study.gof23.pattern.behavior.strategy.exercise.plane.Plane;

public class Client {
    public static void main(String[] args) {
        planeWork(PlaneName.AirPlane);
        planeWork(PlaneName.Fighter);
        planeWork(PlaneName.Harrier);
        planeWork(PlaneName.Helicopter);
    }
    private static void planeWork(PlaneName type) {
        Plane plane;
        plane = Factory.createPlane(type);
        plane.work();
        System.out.println();
    }
}
