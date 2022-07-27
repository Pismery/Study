package com.pismery.study.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class RadixSort {

    //基数类别个数
    private static final int RADIX_NUMBER = 10;

    /**
     * sources 不能有重复的数字；否则会无限递归；
     *
     * @param sources
     */
    public static void radixSortMSD(int[] sources) {

        int max = Integer.MIN_VALUE;
        for (int value : sources) {
            max = Math.max(max, value);
        }
        int maxPosition = String.valueOf(max).length(); //最大数的最大位

        sortMSD(sources, sources.length, maxPosition);
    }


    public static void radixSortLSD(int[] sources) {
        List<List<Integer>> table = new ArrayList<>(RADIX_NUMBER);
        for (int i = 0; i < RADIX_NUMBER; i++) {
            table.add(new ArrayList<Integer>());
        }

        int max = Integer.MIN_VALUE;
        for (int value : sources) {
            max = Math.max(max, value);
        }
        int maxPosition = String.valueOf(max).length(); //最大数的最大位


        int index = 0;
        for (int pos = 0; pos < maxPosition; pos++) {
            for (int value : sources) { //塞入数据
                table.get(getDigit(value, pos + 1)).add(value);
            }

            index = 0;
            for (List<Integer> list : table) { //放回数据
                for (int value : list) {
                    sources[index++] = value;
                }
                list.clear(); //清空table数据
            }
        }
    }

    private static void sortMSD(int[] sources, int length, int maxPos) {
        int[][] table = new int[RADIX_NUMBER][length];  //桶table[i][j] i=基数;j=value
        int[] valueNum = new int[RADIX_NUMBER]; //记录每个桶的元素个数

        for (int i = 0; i < length; i++) {  //元素入桶
            int bucketNum = getDigit(sources[i], maxPos);
            table[bucketNum][valueNum[bucketNum]++] = sources[i];
        }

        for (int i = 0; i < RADIX_NUMBER; i++) { //递归按低位排序
            if (valueNum[i] > 1 && !isAllSame(table[i]))
                sortMSD(table[i], valueNum[i], maxPos - 1);
        }

        int index = 0;
        for (int i = 0; i < RADIX_NUMBER; i++) {  //遍历桶入sources
            if (valueNum[i] < 1)
                continue;
            int[] list = table[i];
            for (int j = 0; j < valueNum[i]; j++) {
                sources[index++] = list[j];
            }
        }
    }

    /**
     * @param list
     * @return true:所有都是相同;false:存在不同
     */
    private static boolean isAllSame(int[] list) {
        int length = list.length;
        if (length <= 1)
            return false;
        int basic = list[0];
        for (int i = 1; i < length; i++) {
            if (basic != list[i])
                return false;
        }

        return true;


    }

    private static int getDigit(int num, int pos) {
        int temp = 1;
        for (int i = 0; i < pos - 1; i++) {
            temp *= 10;
        }

        return (num / temp) % 10;
    }
}
