package com.pismery.study.algorithm.search;

public class BinarySearch {
    public static int binarySearch(int[] sources, int key) {
        if (sources == null || sources.length == 0)
            return -1;

        int left = 0;
        int right = sources.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; //mid= (right + left) / 2 容易出现加法溢出

            if (sources[mid] == key)
                return mid;
            else if (sources[mid] < key)
                left = mid + 1;
            else if (sources[mid] > key)
                right = mid - 1;
        }
        return -1;
    }

    //在一个有重复元素的数组中查找 key 的最左位置
    public static int binarySearchLeftestIndex(int[] sources, int key) {
        if (sources == null || sources.length == 0)
            return -1;

        int left = 0;
        int right = sources.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sources[mid] == key) {
                right = mid;
            } else if (sources[mid] > key)
                right = mid - 1;
            else if (sources[mid] < key)
                left = mid + 1;
        }


        return sources[left] == key ? left : -1;
    }


    public static boolean binarySearchByDivide(int[] sources, int key, int begin, int end) {
        if (begin > end) {
            return false;
        }

        int mid = begin + (end - begin) / 2;

        if (sources[mid] == key)
            return true;
        else if (sources[mid] > key)
            return binarySearchByDivide(sources, key, begin, mid - 1);
        else
            return binarySearchByDivide(sources, key, mid + 1, end);

    }
}
