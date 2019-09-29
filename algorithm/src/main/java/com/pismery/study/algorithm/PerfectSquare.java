package com.pismery.study.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.<br>
 * <br>
 * Example 1:<br>
 * Input: n = 12<br>
 * Output: 3<br>
 * Explanation: 12 = 4 + 4 + 4.<br>
 * <br>
 * Example 2:<br>
 * <p>
 * Input: n = 13<br>
 * Output: 2<br>
 * Explanation: 13 = 4 + 9.<br>
 * <br>
 * Reference<br>
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/discuss/71495/An-easy-understanding-DP-solution-in-Java<br>
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)<br>
 */
public class PerfectSquare {


    /**
     * <ul>operate steps:</ul>
     * <li>1. init all the square number which is less than n;</li>
     * <li>2. Consider a graph which consists of number 0, 1,...,n as
     * its nodes. Node j is connected to node i via an edge if
     * and only if either j = i + (a perfect square number) or
     * i = j + (a perfect square number). Starting from node 0,
     * do the breadth-first search. If we reach node n at step
     * m, then the least number of perfect square numbers which
     * sum to n is m. Here since we have already obtained the
     * perfect square numbers, we have actually finished the
     * search at step 1.</li>
     *
     * @param n the input number
     * @return the least number of perfect square number which sum to n
     */
    public static int squareNumByBFS(int n) {
        if (n <= 0) {
            return 0;
        }

        if (isSquare(n))
            return 1;

        //results[index] means the least number of perfect square number which sum to index;
        int[] results = new int[n];
        //squareList has all perfect square number which is less than n.
        List<Integer> squareList = new ArrayList<>();
        for (int i = 1; i * i < n; i++) { //step 1
            squareList.add(i * i);
            results[i * i - 1] = 1;
        }

        // step 2
        Integer squareNum = getResultByBFS(n, results, squareList);
        return squareNum;
    }

    /**
     * dp[0] = 0 <br>
     * dp[1] = dp[0]+1 = 1<br>
     * dp[2] = dp[1]+1 = 2<br>
     * dp[3] = dp[2]+1 = 3<br>
     * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }<br>
     * = Min{ dp[3]+1, dp[0]+1 }<br>
     * = 1				<br>
     * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }<br>
     * = Min{ dp[4]+1, dp[1]+1 }<br>
     * = 2<br>
     * .<br>
     * .<br>
     * .<br>
     * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }<br>
     * = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }<br>
     * = 2<br>
     * .<br>
     * .<br>
     * .<br>
     * dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1<br>
     * <p>
     * DP : Dynamic program(动态规划)
     *
     * @param n the input number
     * @return the least number of perfect square number which sum to n
     */
    public static int squareNumByDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; j++) {
                min = Math.min(dp[i - j * j] + 1, min);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    /**
     * Base on Lagrange's Four Square theorem(四平方和定理)，there are only 4 possible result: 1,2,3,4
     *
     * @param n the input number
     * @return the least number of perfect square number which sum to n
     */
    public static int squareNumByMathematical(int n) {
        if (n <= 0)
            return 0;

        if (isSquare(n))
            return 1;

        int maxSquareNum = (int) Math.sqrt(n);
        for (int i = 1; i <= maxSquareNum; i++) {
            if (isSquare(n - i * i))
                return 2;
        }

        /**
         *  Base on Legendre's three-square theorem(拉格朗日三平方和定理),if n = x^2 + y^2 + z^2,
         * if and only if n is not of the form n = 4^a(8b+7) {a,b = integer};
         */
        while ((n & 3) == 0) { //n & 3 == n % 4
            n >>= 2;
        }
        if ((n & 7)  == 7) { //n & 7 == n % 8
            return 4;
        }

        return 3;
    }

    private static Integer getResultByBFS(int n, int[] results, List<Integer> squareList) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer perfectSquare : squareList)
            queue.offer(perfectSquare);

        int curSquareNum = 1;
        while (!queue.isEmpty()) {
            curSquareNum++;

            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) { //once search

                int curData = queue.poll();
                for (Integer perfectSquare : squareList) {
                    if (curData + perfectSquare == n) //find the input
                        return curSquareNum;

                    if (curData + perfectSquare > n) //don't need consider the node which greater than n
                        continue;

                    if (curData + perfectSquare < n && results[curData + perfectSquare - 1] != 0) {
                        //when results[curData+perfectSquare-1]!= 0,this is not the first time visit the node;
                        continue;
                    }

                    if (curData + perfectSquare < n && results[curData + perfectSquare - 1] == 0) {
                        results[curData + perfectSquare - 1] = curSquareNum;
                        queue.add(curData + perfectSquare);
                    }
                }
            }
        }
        return 0;
    }

    static boolean isSquare(int input) {
        int sqrt = (int) Math.sqrt(input);
        return sqrt * sqrt == input;
    }
}
