package com.pismery.study.algorithm.search;

/**
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class RangeSearch {
    public static int[] search(int[] sources, int target) {
        int left = searchLeftest(sources, target);
        if (sources[left] != target)
            return new int[]{-1, -1};

        int right = searchLeftest(sources, target + 1) - 1;
        return new int[]{left,Math.max(left,right)};
    }

    static int searchLeftest(int[] sources, int target) {

        int left = 0;
        int right = sources.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sources[mid] >= target) {
                right = mid;
            } else
                left = mid + 1;
        }

        return sources[right] >= target ? right : -1;
    }
}
