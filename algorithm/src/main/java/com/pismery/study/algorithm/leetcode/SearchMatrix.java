package com.pismery.study.algorithm.leetcode;

import com.pismery.study.algorithm.bean.ListNode;

/**
 * 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 * @author 盒子
 * @since 2021/11/16
 */
public class SearchMatrix {
    /**
     * 暴力遍历
     */
    public static boolean solution1(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    /**
     * 每行二分遍历查找
     */
    public static boolean solution2(int[][] matrix, int target) {

        for(int i = 0; i < matrix.length; i++) {
            int left = 0, right = matrix[0].length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    right = mid  - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * Z 字遍历法；
     *  
     * 从右上角开始遍历， 如果目标值大于当前值，则目标结果一定不在当前这一行，向下一行遍历；
     * 如果目标值小于当前值，则目标值一定不在当前列，向前一列遍历；
     */
    public static boolean solution3(int[][] matrix, int target) {

        int i = 0;
        int j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] ==  target) {
                return true;
            } else if(matrix[i][j] > target){
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
