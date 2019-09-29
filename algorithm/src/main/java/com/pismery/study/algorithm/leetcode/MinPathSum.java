package com.pismery.study.algorithm.leetcode;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {

    public static int solution(int[][] grid) {

        int length = grid[0].length;
        int width = grid.length;
        int[][] resultGrid = new int[width][length];

        resultGrid[0][0] = grid[0][0];

        for (int i = 1; i < width; i++) { //初始化第一列
            resultGrid[i][0] = resultGrid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < length; i++) { //初始化第一行
            resultGrid[0][i] = resultGrid[0][i - 1] + grid[0][i];
        }
        //填充剩下格子
        for (int i = 1; i < width; i++) {
            for (int j = 1; j < length; j++) {
                resultGrid[i][j] = Math.min(resultGrid[i][j - 1], resultGrid[i - 1][j]) + grid[i][j];
            }
        }

        return resultGrid[width - 1][length - 1];
    }
}
