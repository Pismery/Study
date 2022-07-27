package com.pismery.study.algorithm.sort;

/**
 * Created by pismery on 2018-06-10.
 */
public class InsertionSort {
    private InsertionSort() {
    }

    /**
     * 1.选择一位插入值
     * 2.查找前i个已排好序的合适的位置插入插入值
     *
     * @param source
     */
    public static void insertionSortNormal(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }

        for (int i = 0, size = source.length; i < size - 1; i++) {
            for (int j = i + 1; j > 0 && source[j] < source[j - 1]; j--) {
                source[j] ^= source[j - 1];
                source[j - 1] ^= source[j];
                source[j] ^= source[j - 1];
            }
        }
    }

    /**
     * 将每次的交换变换为复制移动<
     */
    public static void insertionSortOptimization(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }
        int insertValue;
        for (int i = 0, size = source.length; i < size - 1; i++) {
            insertValue = source[i + 1];
            for (int j = i + 1; j > 0; j--) {
                if (insertValue >= source[j - 1]) { //如果插入值大于等于比较值，将插入值赋值給比较值
                    source[j] = insertValue;
                    break;
                }
                //如果插入值小于比较值，比较值右移
                source[j] = source[j - 1];
                if (j == 1) {   //如果插入值比最左比较值还小，则插入值赋值给最左比较值
                    source[0] = insertValue;
                    break;
                }
            }
        }
    }

    /**
     * 使用二分法查找插入位置
     */
    public static void insertionSortWithDichotomy(int[] source) {
        if (null == source) {
            throw new RuntimeException("NPE");
        }

        int left = 0; //左边位置索引
        int right = 0; //右边位置索引
        int middle = 0; //中间位置索引
        int insertValue = 0; //插入元素的值
        for (int i = 0, size = source.length; i < size - 1; i++) {
            insertValue = source[i + 1];
            left = 0;
            right = i;
            while (left <= right) { //等号是为了第一次right=0时 需要与第一个值比较
                middle = (left + right) / 2;
                if (insertValue > source[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

            for (int j = i; j >= left; j--) {   //将插入位置的所有值右移
                source[j + 1] = source[j];
            }
            source[left] = insertValue;
        }
    }
}
