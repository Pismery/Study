package com.pismery.study.algorithm.leetcode;

/**
 * 713. 乘积小于K的子数组
 *
 * 给定一个正整数数组 nums和整数 k 。
 *
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2:
 *
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *  
 *
 * 提示: 
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 *
 * @author 盒子
 * @since 2021/11/9
 */
public class NumSubarrayProductLessThanK {

    /**
     * 双指针 - 从头遍历
     */
    public static int solution2(int[] nums, int k) {
        int result = 0;
        if (k <= 1) return result;

        int current = 1;
        for (int right = 0, left = 0; right < nums.length; right++) {
            current *= nums[right];

            while(current >= k) {
                current /= nums[left++];
            }

            result += right - left + 1;
        }

        return result;
    }

    /**
     * 双指针 - 从尾遍历
     */
    public static int solution1(int[] nums, int k) {
        int result = 0;
        if( k <= 1) return result;

        for(int right = nums.length -1; right >= 0; right--) {
            int current = nums[right];

            int left = right;
            while(true) {
                if (current >= k) {
                    break;
                }

                if (left > 0) {
                    current *= nums[--left];
                }

                if (current < k && left == 0) {
                    left = -1;
                    break;
                }
            }

            result += right - left ;
        }

        return result;
    }
}
