package com.pismery.study.util;

/**
 * Created by pismery on 2018-04-01.
 */
public class ExchangeUtils {

    /**
     * Exchange by ^=
     *
     * @param sources
     * @param indexX
     * @param indexY
     */
    public static void exchange(int[] sources, int indexX, int indexY) {
        AssertArgs(sources.length, indexX, indexY);

        if (indexX == indexY) //because self ^ self == 0
            return;

        sources[indexX] ^= sources[indexY];
        sources[indexY] ^= sources[indexX];
        sources[indexX] ^= sources[indexY];
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
