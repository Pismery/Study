package com.pismery.study.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.stream.IntStream;

public class J8RandomUtils {

    private static final Random RANDOM = new Random(
            LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"))
    );

    /**
     * Generate a random value in [minValue,maxValue)
     *
     * @param minValue the minimum value
     * @param maxValue the maximum value
     * @return a random value in [minValue,maxValue),
     * @throws IllegalArgumentException if {@code minValue}
     *                                  is greater than or equal to {@code maxValue}
     */
    public static int randomInt(int minValue, int maxValue) {
        return RANDOM.ints(1, minValue, maxValue).findFirst().getAsInt();
    }

    /**
     * Generate a random array,the elements are in [minValue,maxValue)
     *
     * @param minValue the minimum value
     * @param maxValue the maximum value
     * @param size     the array size
     * @return a random array which elements are in [minValue,maxValue)
     * @throws IllegalArgumentException if {@code size} is
     *                                  less than zero, or {@code minValue}
     *                                  is greater than or equal to {@code maxValue}
     */
    public static int[] randomIntArray(int minValue, int maxValue, int size) {
        return RANDOM.ints(size, minValue, maxValue).toArray();
    }

    /**
     * Generate a random array,the elements are in [minValue,maxValue),
     * and all elements are not repeat others
     * <p>Operation steps: </p>
     * <ol>
     * <li>Generate a source order array in [minValue,maxValue)</li>
     * <li>Generate an index in [0,orderArraySize)</li>
     * <li>Set the source[index] as result element </li>
     * <li>Set the source[--currSourceSize] to source[index],
     * It is for ensure the next random round have not duplicate element
     * or lack some element</li>
     * </ol>
     *
     * @param minValue the minimum value
     * @param maxValue the maximum value
     * @param size     the array size
     * @return a random array.
     * @throws IllegalArgumentException if {@code size} is
     *                                  less than zero, or {@code minValue}
     *                                  is greater than or equal to {@code maxValue},
     *                                  or {@code mavValue - minValue} is smaller than {@code size}
     */
    public static int[] randomArrayNoRepeat(int minValue, int maxValue, int size) {
        int sourceSize = maxValue - minValue;
        if (sourceSize < size) { //size过大
            throw new IllegalArgumentException("size is bigger than the range size");
        }

        int[] source = IntStream.iterate(minValue, value -> value + 1).limit(sourceSize).toArray();

        int[] result = new int[size];
        int index = 0; //source数组的下标
        for (int i = 0; i < size; i++) {
            index = randomInt(0, sourceSize);
            result[i] = source[index];
            source[index] = source[--sourceSize]; //#注意是 --source
        }

        return result;
    }

    /**
     * Generate a random array which is nearly sorted.
     *
     * @param size        the size of array
     * @param changeTimes the sorted array change times.
     * @return a random array which is nearly sorted.
     */
    public static int[] randomArrayNearlySorted(int size, int changeTimes) {
        int[] result = IntStream.iterate(0, value -> value + 1).limit(size).toArray();

        for (int i = 0; i < changeTimes; i++) {
            ExchangeUtils.exchange(result, randomInt(0, size), randomInt(0, size));
        }

        return result;
    }

}
