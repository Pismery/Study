package com.pismery.study.mapsturct.demo01;

/**
 * @author 盒子
 * @since 2022/1/24
 */
public enum Gender {
    MALE("nan"),FEMALE("nv");

    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
