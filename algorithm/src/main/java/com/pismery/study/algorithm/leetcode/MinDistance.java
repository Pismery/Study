package com.pismery.study.algorithm.leetcode;

/**
 *
 * 72. 编辑距离
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class MinDistance {

    /**
     * 采用动态规划法：
     *
     * dp[i][j]: 表示 word1 的 0-i 的字符串转换成 word2 的 0-j 的字符串的最短距离
     *
     * 可得公式：
     * if word1[i] == word2[j] => dp[i][j] = dp[i-1]j-1]
     * else dp[i][j] = min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]) + 1
     *
     * 表示含义：
     * dp[[i][j] = dp[i][j-1] + 1 => 最后一步是插入字符串
     * dp[[i][j] = dp[i-1][j] + 1 => 最后一步是删除字符串
     * dp[[i][j] = dp[i-1][j-1] + 1 => 最后一步是替换字符串
     *
     * 初始化第一行和第一列，加上空串的情况；例如 “aa” ==> "abb"
     *         ''  'a' 'a'
     *     ''   0   1   1
     *     'a'  1   0   1
     *     'b'  2   1   1
     *     'b'  3   2   2
     */
    public static int solution1(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int dp[][] = new int[n1+1][n2+1];
        for(int i = 1; i < n1 + 1;i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }

        for(int i = 1;i < n2 + 1;i++) {
            dp[0][i] = dp[0][i-1] + 1;
        }


        for (int i = 1; i < n1 + 1;i++) {
            for(int j = 1;j < n2 + 1;j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1;
                }
            }
        }

        return dp[n1][n2];
    }
}
