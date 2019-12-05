package com.pismery.study.util;

/**
 * Created by pismery on 2018-06-03.
 */
public class RandomUtils {

    public static int randomInt(int minValue, int maxValue) {
        if (maxValue < minValue) {
            throw new IllegalArgumentException("maxValue < minValue");
        }
        if (maxValue == minValue) {
            return minValue;
        }
        return (int) (Math.random() * (maxValue - minValue)) + minValue;
    }

    public static int[] randomArray(int minValue, int maxValue, int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomInt(minValue, maxValue);
        }
        return result;
    }

    public static int[] randomArrayNoRepeat(int minValue, int maxValue, int size) {
        int sourceSize = maxValue - minValue;
        if (sourceSize < size) { //size过大
            throw new IllegalArgumentException("size is bigger than the range size");
        }
        //生成[minValue,maxValue]的数组
        int[] source = new int[sourceSize];
        for (int i = 0; i < sourceSize; i++) {
            source[i] = i + minValue;
        }

        int[] result = new int[size];
        int index = 0; //source数组的下标
        for (int i = 0; i < size; i++) {
            index = randomInt(0, sourceSize);
            result[i] = source[index];
            source[index] = source[--sourceSize]; //#注意是 --source
        }

        return result;
    }


    public static int[] randomArrayNearlySorted(int size, int changeTimes) {
        if ( size <= 0 || changeTimes < 0) {
            throw new IllegalArgumentException("parameter is illegal");
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i + 1;
        }

        for (int i = 0; i < changeTimes; i++) {
            ExchangeUtils.exchange(result, randomInt(0, size), randomInt(0, size));
        }

        return result;
    }
}
