package com.pismery.study.gof23.pattern.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {
    private static final FlyWeightFactory instance = new FlyWeightFactory();

    private FlyWeightFactory() {
        flyweightPool = new HashMap<>();
        flyweightPool.put(FlyweightType.PICTURE,new Picture());
        flyweightPool.put(FlyweightType.VIDIEO,new Video());
        flyweightPool.put(FlyweightType.ANIMATION,new Animation());
    }

    public static FlyWeightFactory getIntance() {
        return instance;
    }

    //享元池
    private Map<FlyweightType ,FlyWeight> flyweightPool;

    public FlyWeight getFlyweright(FlyweightType type) {
        return flyweightPool.get(type);
    }
}
