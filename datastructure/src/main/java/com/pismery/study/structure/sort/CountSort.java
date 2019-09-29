package com.pismery.study.structure.sort;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by pismery on 2018-06-18.
 */
public class CountSort {

    public static void countSortWithMap(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }

        //使用TreeMap可将数据按顺序取出;
        Map<Integer, Integer> countMap = new TreeMap<>();

        Integer mapKey;
        for (int i = 0, size = source.length; i < size; i++) { //记录数字出现次数
            mapKey = countMap.get(source[i]);
            if (null == mapKey) {
                countMap.put(source[i], 1);
                continue;
            }
            countMap.put(source[i], mapKey + 1);
        }

        int index = 0;//赋值source索引
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) { //遍历TreeMap,source重新赋值
            for (int i = entry.getValue(); i > 0; i--) {
                source[index++] = entry.getKey();
            }
        }
    }

    public static void countSort(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }
        int max = source[0];
        for (int value : source) {
            if (max < value)
                max = value;
        }

        int[] numberArray = new int[max + 1];

        for (int j = 0; j < source.length; j++) {
            numberArray[source[j]]++;
        }

        int index = 0;

        for (int i = 0; i <= max; i++) {
            while (numberArray[i]-- > 0) {
                source[index++] = i;
            }
        }
    }

}
