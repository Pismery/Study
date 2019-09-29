package com.pismery.study.algorithm.leetcode.shares;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit2 {

    /**
     * dp[k][(0,1)]: 第 k 天持有(1)或不持有(0) 股票的最优解；
     *
     * 动态规划法
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i-1])
     * dp[i][1] = max(dp[i-1][0] - prices[i-1],dp[i-1][1])
     *
     * result = dp[i][0]; 不是dp[i][1] 因为最后一天将所有股票卖出才是最赚钱的；
     *
     */
    public static int solution1(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_0 - prices[i], dp_i_1);
        }
        return dp_i_0;
    }

    /**
     * 在最低值买入，在从最近的最高值卖出；然后寻找下一个相邻的最低值；直至交易结束
     */
    public static int solution2(int[] prices) {
        int n = prices.length;
        int result = 0;
        int i = 0;

        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int min = prices[i];
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int max = prices[i];
            result += max - min;
        }
        return result;
    }


    /**
     * 只要下一天的交易额大于前一天的交易额就加上去，则所有赚钱的地方都赚到；
     */
    public static int solution3(int[] prices) {
        int n = prices.length;
        int result = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }

        return result;
    }

}
