package com.pismery.study.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 169. 求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    /**
     * Map<K,V> K: 表示数组中的数，V: 出现的次数；
     */
        public static int solution1(int[] nums) {
            int n = nums.length / 2;
            if(n <= 0) { //当数组只有一个数的时候；
                return nums[0];
            }

            Map<Integer,Integer> map = new HashMap<>();
            for(int num : nums) {

                if(!map.containsKey(num)) {
                    map.put(num,1);
                    continue;
                }

                int value = map.get(num) + 1;
                if(value > n) {
                    return num;
                }
                map.put(num,value);
            }
            throw new RuntimeException();
        }

    /**
     * 排序法，由题目知众数是多余 n/2 的数，并且一定存在；所以对于排好的数，n/2 位置就是众数；
     */
    public static int solution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 投票法；如果遇到众数则 +1，遇到负数则 -1；则最终结果一定大于零；
     *
     * 算法：
     * 1. 选第一个数为众数，遍历执行+1，-1 操作；
     * 2. 若值变为了 0；则再选取下一个数为众数，继续向后计算；
     *  （ps: 当变为 0 选取下一个数时相当与舍弃众数 <= 舍弃的非众数，因此不影响最终选取众数的结果）
     * 3. 直到遍历完全，最后选取的数则为最终结果；
     */
    public static int solution3(int[] nums) {
        int count = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count++;
                continue;
            }

            if (result == nums[i]) {
                count++;
            }else {
                count--;
            }
        }
        return result;
    }

}
