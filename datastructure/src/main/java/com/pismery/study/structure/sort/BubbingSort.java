package com.pismery.study.structure.sort;

/**
 * Created by pismery on 2018-03-25.
 */
public class BubbingSort {

    public static void bubbingSortNormal(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }
        for (int rangeNumber = 0, size = source.length; rangeNumber < size - 1; rangeNumber++) {
            for (int index = 0; index < size - 1 - rangeNumber; index++) {
                if (source[index] >= source[index + 1]) {
                    //exchange source[j] and source[j + 1]
                    source[index] ^= source[index + 1];
                    source[index + 1] ^= source[index];
                    source[index] ^= source[index + 1];
                }
            }
        }
    }

    public static void bubbingSortOptimization(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }
        boolean overFlag = true;
        for (int rangNumber = 0, size = source.length; rangNumber < size - 1; rangNumber++) {
            overFlag = true;
            for (int index = 0; index < size - 1 - rangNumber; index++) {
                if (source[index] >= source[index + 1]) {
                    //exchange source[j] and source[j + 1]
                    source[index] ^= source[index + 1];
                    source[index + 1] ^= source[index];
                    source[index] ^= source[index + 1];

                    overFlag = false;
                }
            }
            if (overFlag) {
                break;
            }
        }
    }

    /**
     * 设置一标志性变量lastExchangeIndex,用于记录每趟排序中最后一次进行交换的位置。
     * 由于lastExchangeIndex位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可
     *
     * @param source
     */
    public static void bubbingSortByExchangeIndex(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }
        int endIndex = source.length - 1;
        int lastExchangeIndex = 0;
        while (endIndex > 0) {
            lastExchangeIndex = 0;
            for (int j = 0; j < endIndex; j++) {
                if (source[j] > source[j + 1]) {
                    source[j] ^= source[j + 1];
                    source[j + 1] ^= source[j];
                    source[j] ^= source[j + 1];
                    lastExchangeIndex = j;
                }
            }
            endIndex = lastExchangeIndex;
        }
    }

    /**
     * 一次循环 双向冒泡 同时使用标志性变量reverseLastExchangeIndex,positiveLastExchageIndex.
     * 记录最后一次交换位置。
     *
     * @param source
     */
    public static void bubbingSortBidirectional(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }


        int endIndex = source.length - 1;
        int reverseLastExchangeIndex = source.length - 1;

        int beginIndex = 0;
        int positiveLastExchageIndex = 0;
        while (beginIndex < endIndex) {
            reverseLastExchangeIndex = source.length - 1;
            positiveLastExchageIndex = 0;
            for (int i = beginIndex; i < endIndex; i++) {
                if (source[i] > source[i + 1]) {
                    source[i] ^= source[i + 1];
                    source[i + 1] ^= source[i];
                    source[i] ^= source[i + 1];
                    positiveLastExchageIndex = i;
                }
            }
            for (int i = endIndex; i > beginIndex; i--) {
                if (source[i] <= source[i - 1]) {
                    source[i] ^= source[i - 1];
                    source[i - 1] ^= source[i];
                    source[i] ^= source[i - 1];
                    reverseLastExchangeIndex = i;
                }
            }
            beginIndex = reverseLastExchangeIndex;
            endIndex = positiveLastExchageIndex;
        }

    }

}
