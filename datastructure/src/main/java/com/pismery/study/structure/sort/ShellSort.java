package com.pismery.study.structure.sort;

/**
 * Created by pismery on 2018-06-30.
 */
public class ShellSort {

    public static void shellSort(int[] sources) {
        if (null == sources) {
            throw new RuntimeException("NPE");
        }

        int length = sources.length;
        for (int increment = length / 2; increment >= 1; increment /= 2) { //缩小增量
            for (int groupNum = 0; groupNum < increment; groupNum++) { //按增量分组
                //插入排序
                for (int j = groupNum; j < length - increment; j += increment) {
                    for (int k = j + increment; k >= increment && sources[k] < sources[k - increment]; k -= increment) {
                        sources[k] ^= sources[k - increment];
                        sources[k - increment] ^= sources[k];
                        sources[k] ^= sources[k - increment];
                    }
                }
            }
        }
    }

    public static void shellSortOptimization(int[] sources) {
        if (null == sources) {
            throw new RuntimeException("NPE");
        }
        int length = sources.length;
        int insertValue = 0;
        for (int increment = length / 2; increment >= 1; increment /= 2) { //缩小增量
            for (int groupNum = 0; groupNum < increment; groupNum++) { //按增量分组
                //插入排序
                for (int j = groupNum; j < length - increment; j += increment) {
                    insertValue = sources[j + increment];
                    for (int k = j + increment; k >= increment; k -= increment) {
                        if (insertValue >= sources[k - increment]) {
                            sources[k] = insertValue;
                            break;
                        }

                        sources[k] = sources[k - increment];

                        if (k == groupNum + increment) {
                            sources[groupNum] = insertValue;
                            break;
                        }
                    }
                }
            }
        }
    }
}
