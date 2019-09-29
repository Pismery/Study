package com.pismery.study.algorithm.leetcode.shares;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit1 {

    /**
     * 暴力解法
     */
    public static int solution1(int[] prices) {
        int result = 0;

        for (int i = 0, n = prices.length; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] - prices[i] > 0) {
                    result = Math.max(result, prices[j] - prices[i]);
                }
            }
        }
        return result;
    }

    /**
     * 找到从 minPrice 开始的 maxPrice；
     * 取 max(result,maxPrice - minPrice)
     */
    public static int solution2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0]; //最小值
        int maxPrice = prices[0]; //从 minPrice 开始后的最大值
        int result = maxPrice - minPrice;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                maxPrice = prices[i];
            }
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
            result = Math.max(result, maxPrice - minPrice);
        }
        return result;
    }

    /**
     * solution2 基础上移除了 maxPrice;
     */
    public static int solution3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            result = Math.max(result, prices[i] - minPrice);
        }
        return result;
    }

    /**
     * 动态规划
     *
     * dp[i][0] = max(dp[i-1][1] + prices[i], dp[i-1][0])
     * dp[i][1] = max(dp[i-1][1], -prices[i])
     * result = dp[i][0];
     */
    public static int solution4(int[] prices) {
        if (prices.length == 0)
            return 0;

        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(-prices[i], dp_i_1);
        }

        return dp_i_0;
    }

}
