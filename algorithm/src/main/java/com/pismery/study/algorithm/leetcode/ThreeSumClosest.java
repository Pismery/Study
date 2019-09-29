package com.pismery.study.algorithm.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * 暴力解法:遍历所有可能找出结果
     */
    public static int solution1(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new RuntimeException("nums is not enough");
        }
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        if (n == 3) {
            return result;
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - temp) < Math.abs(target - result)) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }

    /**
     * 先排序，后通过双指针法；使得时间复杂度减低一个量级，排序O(nlogn) + 双指针O(n^2) = O(n^2)
     */
    public static int solution2(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new RuntimeException("nums is not enough");
        }
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while(left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - tmp) < Math.abs(target - result)) {
                    result = tmp;
                }
                if(target < tmp) {
                    right--;
                }else if (target > tmp) {
                    left++;
                }else {
                    return result;
                }

            }
        }
        return result;
    }

}
