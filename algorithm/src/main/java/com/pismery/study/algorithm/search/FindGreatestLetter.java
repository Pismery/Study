package com.pismery.study.algorithm.search;

/**
 * 给定一个有序的字符数组 letters 和一个字符 target，
 * 要求找出 letters 中大于 target 的最小字符，
 * 如果找不到就返回第 1 个字符。
 */
public class FindGreatestLetter {


    public static char find(char[] sources, char target) {
        if (null == sources || sources.length == 0)
            throw new RuntimeException();

        int left = 0;
        int right = sources.length - 1;

        while (left < right) { //left < right,because right = mid;
            int mid = left + (right - left) / 2;
            if (sources[mid] <= target)
                left = mid + 1;
            else
                right = mid; //mid maybe the result index so right = mid;
        }

        return sources[left] > target ? sources[left] : sources[0]; //right or left is ok
    }
}
