package com.pismery.study.util;

/**
 * Created by pismery on 2018-04-01.
 */
public class ExchangeUtils {

    /**
     * Exchange by ^=
     * @param sources
     * @param x
     * @param y
     */
    public static void exchange(int[] sources, int x, int y) {
        AssertArgs(sources.length, x, y);

        if (x == y) //because self ^ self == 0
            return;

        sources[x] ^= sources[y];
        sources[y] ^= sources[x];
        sources[x] ^= sources[y];
    }

    /**
     * nomal exchange method
     *
     * @param sources
     * @param indexX
     * @param indexY
     */
    private static void exchange1(int[] sources, int indexX, int indexY) {
        AssertArgs(sources.length, indexX, indexY);

        int temp = sources[indexX];
        sources[indexX] = sources[indexY];
        sources[indexY] = temp;
    }

    /**
     * exchange without middle variable
     *
     * @param sources
     * @param indexX
     * @param indexY
     */
    private static void exchange2(int[] sources, int indexX, int indexY) {
        AssertArgs(sources.length, indexX, indexY);

        if (indexX == indexY)
            return;

        sources[indexX] = sources[indexX] + sources[indexY];
        sources[indexY] = sources[indexX] - sources[indexY];
        sources[indexX] = sources[indexX] - sources[indexY];
    }

    private static void AssertArgs(int size, int indexX, int indexY) {
        if (indexX < 0 || indexY < 0 || indexX >= size || indexY >= size)
            throw new IllegalArgumentException("indexX:" + indexX + ";indexY:" + indexY);
    }
}
