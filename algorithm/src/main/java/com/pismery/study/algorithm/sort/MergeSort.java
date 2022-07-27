package com.pismery.study.algorithm.sort;

/**
 * Created by pismery on 2018-06-19.
 */
public class MergeSort {

    public static void mergeSortThreeWay(int[] source) {
        int length = source.length;
        if (length < 2) {
            return;
        }
        sortThreeWay(source, 0, length - 1);
    }

    private static void sortThreeWay(int[] source, int left, int right) {
        if (left >= right)
            return;

        //计算下标
        int sliceLength = (right - left) / 3;
        int middleOne = left + sliceLength;
        int middleTwo = middleOne + sliceLength;

        sortThreeWay(source, left, middleOne);
        sortThreeWay(source, middleOne + 1, middleTwo);
        sortThreeWay(source, middleTwo + 1, right);

        mergeThreeWay(source, left, middleOne, middleTwo, right);
    }

    private static void mergeThreeWay(int[] source, int left, int middleOne, int middleTwo, int right) {
        int[] temp = new int[right - left + 1];

        int leftIndex = left;
        int middleIndex = middleOne + 1;
        int rightIndex = middleTwo + 1;
        int tempIndex = 0;

        while (leftIndex <= middleOne && middleIndex <= middleTwo && rightIndex <= right) {
            if (source[leftIndex] <= source[middleIndex] && source[leftIndex] <= source[rightIndex]) {
                temp[tempIndex++] = source[leftIndex++];
            } else if (source[middleIndex] <= source[leftIndex] && source[middleIndex] <= source[rightIndex]) {
                temp[tempIndex++] = source[middleIndex++];
            } else {
                temp[tempIndex++] = source[rightIndex++];
            }
        }

        while (leftIndex <= middleOne && middleIndex <= middleTwo) {
            //右边排完
            if (source[leftIndex] <= source[middleIndex]) {
                temp[tempIndex++] = source[leftIndex++];
            } else {
                temp[tempIndex++] = source[middleIndex++];
            }
        }
        while (leftIndex <= middleOne && rightIndex <= right) {
            //中间排完
            if (source[leftIndex] <= source[rightIndex]) {
                temp[tempIndex++] = source[leftIndex++];
            } else {
                temp[tempIndex++] = source[rightIndex++];
            }
        }
        while (middleIndex <= middleTwo && rightIndex <= right) {
            //左边排完
            if (source[middleIndex] <= source[rightIndex]) {
                temp[tempIndex++] = source[middleIndex++];
            } else {
                temp[tempIndex++] = source[rightIndex++];
            }
        }


        while (leftIndex <= middleOne) {
            temp[tempIndex++] = source[leftIndex++];
        }
        while (middleIndex <= middleTwo) {
            temp[tempIndex++] = source[middleIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = source[rightIndex++];
        }

        //将temp拷贝回source
        tempIndex = 0;
        for (int i = left; i <= right; i++) {
            source[i] = temp[tempIndex++];
        }
    }


    public static void mergeSortNormal(int[] source) {
        int length = source.length;
        if (length < 2) {
            return;
        }

        sort(source, 0, length - 1);
    }

    public static void mergeSortFromBottomToUp(int[] source) {
        int length = source.length;

        int middle = 0;
        int right = 0;
        for (int mergeSize = 1; mergeSize < length; mergeSize *= 2) {
            //mergeSize表示每次归并左右两边数组的大小，下次循环为mergeSize = 2*mergeSize,如1-2-4-8
            for (int left = 0; left + mergeSize < length; left += 2 * mergeSize) {
                //每次归并，按mergSize两两归并。
                //1. left + mergeSize< length : 确保左右两边都有数可以归并，同时确保了[left,middle]不越界;
                //2. right = Math.min(left + mergeSize + mergeSize - 1, length - 1); 确保right不越界;

                middle = left + mergeSize - 1;
                right = Math.min(left + mergeSize + mergeSize - 1, length - 1);
                merge(source, left, middle, right);
            }
        }
    }

    private static void sort(int[] source, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (right + left) / 2;

        sort(source, left, middle); //左边排好序
        sort(source, middle + 1, right); //右边排好序
        if (source[middle] <= source[middle + 1]) { //如果左边最大的 小于右边最小的 不需要合并
            return;
        }
        merge(source, left, middle, right); //合并
    }

    private static void merge(int[] source, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int leftCurrentIndex = left;//左序列指针
        int rightCurrentIndex = middle + 1;//右序列指针
        int tempIndex = 0;//临时数组指针
        while (leftCurrentIndex <= middle && rightCurrentIndex <= right) {
            if (source[leftCurrentIndex] <= source[rightCurrentIndex]) {
                temp[tempIndex++] = source[leftCurrentIndex++];
            } else {
                temp[tempIndex++] = source[rightCurrentIndex++];
            }
        }

        while (leftCurrentIndex <= middle) { //将左边剩余的插入
            temp[tempIndex++] = source[leftCurrentIndex++];
        }
        while (rightCurrentIndex <= right) { //将右边剩余的插入
            temp[tempIndex++] = source[rightCurrentIndex++];
        }

        //将temp 赋值到acutal
        tempIndex = 0;
        for (int i = left; i <= right; i++) {
            source[i] = temp[tempIndex++];
        }
    }
}
