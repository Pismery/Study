package com.pismery.study.structure.sort;

/**
 * Created by pismery on 2018-06-09.
 */
public class SelectSort {

    public static void SelectSort(int[] sources) {
        if (null == sources) {
            throw new RuntimeException("NPE");
        }

        int minIndex;
        for (int i = 0, size = sources.length; i < size - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (sources[minIndex] > sources[j])
                    minIndex = j;
            }

            //如果相同，不通过中间变量的交换会交换失败.
            //因为是在数组中操作，改变sources[minIndex],sources[i]也跟着变了
            if (minIndex == i)
                continue;

            //exchange source[j] and source[j + 1]
            sources[minIndex] ^= sources[i];
            sources[i] ^= sources[minIndex];
            sources[minIndex] ^= sources[i];

        }
    }
}
