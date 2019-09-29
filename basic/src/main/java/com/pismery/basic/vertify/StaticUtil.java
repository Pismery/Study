package com.pismery.basic.vertify;

public class StaticUtil {

    private StaticUtil() {
    }

    private static StaticUtil staticUtil = new StaticUtil();

    public static int max(int x, int y) {
        return staticUtil._max(x, y);
    }

    public int _max(int x, int y) {
        return Math.max(x, y);
    }


}
