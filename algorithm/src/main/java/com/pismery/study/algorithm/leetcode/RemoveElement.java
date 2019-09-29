package com.pismery.study.algorithm.leetcode;

/**
 * 27. 移除元素
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static int solution1(int[] nums, int val) {
        int result = 0;
        int skipNum = 0;
        for (int i = 0, length = nums.length; i < length - skipNum; ) {
            if (nums[i + skipNum] != val) {
                nums[result++] = nums[i + skipNum];
                i++;
            } else {
                skipNum++;
            }
        }
        return result;
    }

    public static int solution2(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result++] = nums[i];
            }
        }
        return result;
    }

    /**
     * 每次都与最后一个元素交换；注意交换的最后一个元素也可能是移除元素，所以要再检查；
     *
     * @param nums
     * @param val
     * @return
     */
    public static int solution3(int[] nums, int val) {
        int removeNum =0;
        for (int i = 0; i < nums.length - removeNum; ) {
            if (nums[i] == val) {
                removeNum++;
                nums[i] = nums[nums.length - removeNum];
                continue;
            }
            i++;
        }

        return nums.length - removeNum;
    }

}
