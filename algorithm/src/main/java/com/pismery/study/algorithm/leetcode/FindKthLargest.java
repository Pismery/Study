package com.pismery.study.algorithm.leetcode;

import com.pismery.study.util.ExchangeUtils;
import com.pismery.study.util.RandomUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {

    /**
     * 先排序后返回倒数第 k 个值
     */
    public static int solution1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 维持一个大小为 k 的优先队列，最后返回队列中最后的值；
     */
    public static int solution2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

    /**
     * 通过快速排序的思想得到第 k 大的值；
     *
     * @startuml
     * start
     * :随机选择一个 pivot;
     * :将小于 pivot 的值放到 pivot 的左边，大于等于的值放在右边;
     * :判断 pivot 所在位置与 nums.length - k 位置比较，从而选着递归某一边;
     * :直到 pivot 所在位置是 nums.length - k;
     * end
     * @enduml
     */
    public static int solution3(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }

        return findTopK(nums, 0, nums.length - 1, k);
    }

    private static int findTopK(int[] nums, int begin, int end, int k) {
        int result = -1;

        int left = begin;
        int right = end;
        int pivot = RandomUtils.randomInt(left, right);

        while (left < right) {
            while (right == pivot || (nums[right] > nums[pivot] && left < right)) {
                right--;
            }
            while (left == pivot || (nums[left] <= nums[pivot] && left < right)) {
                left++;
            }

            ExchangeUtils.exchange(nums, left, right);

            if (right == left) {
                ExchangeUtils.exchange(nums, left, pivot);
                if (left == nums.length - k) {
                    result = nums[pivot];
                } else if (left < k) {
                    left++;
                    right = end;
                    pivot = RandomUtils.randomInt(left, right);
                } else {
                    left = begin;
                    right--;
                    pivot = RandomUtils.randomInt(left, right);
                }
            }
        }

        return result;
    }
}
