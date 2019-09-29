package com.pismery.study.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target,请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public int[] solution1(int[] nums, int target) {
        for (int i = 0, length = nums.length; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0, length = nums.length; i < length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0, length = nums.length; i < length; i++) {
            int miuns = target - nums[i];
            if (hashMap.containsKey(miuns) && hashMap.get(miuns) != i) {
                return new int[]{i, hashMap.get(miuns)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] solution3(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0, length = nums.length; i < length; i++) {
            int miuns = target - nums[i];
            if (hashMap.containsKey(miuns)) {
                return new int[]{i, hashMap.get(miuns)};
            }

            hashMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
