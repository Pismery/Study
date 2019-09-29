package com.pismery.study.algorithm.doubleindex;

import static java.lang.Math.sqrt;

/**
 * 判断一个数是否为两个数的平方和，例如 5 = 1^2 + 2^2。
 */
public class SquareSum {


    public static boolean judge(int x) {
        if (x < 0)
            return false;

        int left = 0;
        int right = (int) sqrt(x);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == x)
                return true;
            else if (sum < x)
                left++;
            else
                right--;
        }

        return false;
    }
}
