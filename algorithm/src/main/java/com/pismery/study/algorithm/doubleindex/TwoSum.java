package com.pismery.study.algorithm.doubleindex;

/**
 * 在有序数组中找出两个数，使它们的和为 target。
 */
public class TwoSum {

    public static int[] find(int[] sources, int x) {

        if (null == sources || sources.length == 0)
            return null;

        int left = 0;
        int right = sources.length - 1;

        while (left < right) {
            int sum = sources[left] + sources[right];
            if (sum == x)
                return new int[]{sources[left], sources[right]};
            else if (sum > x)
                right--;
            else
                left++;
        }

        return null;
    }
}
