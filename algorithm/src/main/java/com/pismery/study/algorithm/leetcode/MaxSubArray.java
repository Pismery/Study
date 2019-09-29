package com.pismery.study.algorithm.leetcode;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {

    /**
     * 动态规划法
     * dp[n] = max(dp[n-1],dp[n-1] + a(n))
     *
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }

            result = Math.max(result, sum);
        }

        return result;
    }

    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public static int solution2(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
