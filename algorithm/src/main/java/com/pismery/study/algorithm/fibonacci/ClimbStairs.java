package com.pismery.study.algorithm.fibonacci;

/**
 * 有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法
 *
 * 思路：
 * 第 i 个楼梯可以从第 i-1 和 i-2 个楼梯再走一步到达，
 * 所以走到第 i 个楼梯的方法数为走到第 i-1 和第 i-2 个楼梯的方法数之和。
 */
public class ClimbStairs {
    public static int climb(int stairNum) {
        if (stairNum <= 2)
            return stairNum;

        int pre1 = 1;
        int pre2 = 2;
        int cur = 0;
        for (int i = 3; i <= stairNum; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }

        return cur;
    }
}
