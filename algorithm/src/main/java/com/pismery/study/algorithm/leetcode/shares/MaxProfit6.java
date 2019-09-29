package com.pismery.study.algorithm.leetcode.shares;

/**
 * 188. 买卖股票的最佳时机 IV
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
public class MaxProfit6 {

    /**
     * 动态规划：
     * dp[n][k][0]: 第 n 天进行了 k 次交易持有股票
     * dp[n][k][1]: 第 n 天进行了 k 次交易不持有股票
     *
     * dp[n][k][0] = max(dp[n-1][k][0], dp[n-1][k][1] + prices[n])
     * dp[n][k][1] = max(dp[n-1][k][1], dp[n-1][k-1][0] - prices[n])
     *
     */
    public static int solution1(int k, int[] prices) {
        if (null == prices || prices.length <= 1 || k <= 0) {
            return 0;
        }
        int n = prices.length;

        if (k >= n / 2) {
            //当最大交易次数> n/2 等价于交易次数无上限，相当于 MaxProfit2
            //为了避免 k 过大，使用过大得内存
            int dp_i0 = 0, dp_i1 = -prices[0];
            for (int i = 1; i < n; i++) {
                int temp = dp_i0;
                dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
                dp_i1 = Math.max(dp_i1, temp - prices[i]);
            }
            return dp_i0;
        }


        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[0][j][0] = Math.max(0, Integer.MIN_VALUE + prices[i]);
                    dp[0][j][1] = Math.max(Integer.MIN_VALUE, -prices[i]);
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                if (j == 1) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                } else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }


            }
        }
        return dp[n - 1][k][0];
    }
}
