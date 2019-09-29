package com.pismery.study.algorithm.leetcode.shares;

import java.util.*;

/**
 * 502. IPO
 *
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * <p>
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * <p>
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 * <p>
 * 输出: 4
 * <p>
 * 解释:
 * 由于你的初始资本为 0，你尽可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 * <p>
 * <p>
 * 注意:
 * <p>
 * 假设所有输入数字都是非负整数。
 * 表示利润和资本的数组的长度不超过 50000。
 * 答案保证在 32 位有符号整数范围内。
 */
public class FindMaximizedCapital {

    /**
     * 暴力解 + 贪心算法
     */
    public static int solution1(int k, int W, int[] Profits, int[] Capital) {
        List<Integer> selectedList = new ArrayList<>();

        for (int index = 0; index < k; index++) {
            Map<Integer, Integer> project = new HashMap<>();
            for (int i = 0; i < Capital.length; i++) {
                if (W >= Capital[i] && !selectedList.contains(i)) {
                    project.put(i, Profits[i]);
                }
            }

            int maxProfitIndex = 0;
            int maxProfit = 0;
            for (Map.Entry<Integer, Integer> entry : project.entrySet()) {
                if (maxProfit < entry.getValue()) {
                    maxProfit = entry.getValue();
                    maxProfitIndex = entry.getKey();
                }
            }
            W += maxProfit;
            selectedList.add(maxProfitIndex);
        }
        return W;
    }

    /**
     * solution 1 基础上去掉 Map
     */
    public static int solution2(int k, int W, int[] Profits, int[] Capital) {
        List<Integer> selectedList = new ArrayList<>();

        for (int index = 0; index < k; index++) {
            int maxProfitIndex = 0;
            int maxProfit = 0;
            for (int i = 0; i < Capital.length; i++) {
                if (W >= Capital[i] && !selectedList.contains(i)) {
                    if (maxProfit < Profits[i]) {
                        maxProfitIndex = i;
                        maxProfit = Profits[i];
                    }
                }
            }

            W += maxProfit;
            selectedList.add(maxProfitIndex);
        }
        return W;
    }

    /**
     * 通过优先队列实现快速找到每次得最优解；
     * profitQueue: 按 profit 从大到小优先排列；
     * capitalQueue: 按 capital 从小到大优先排列；
     */
    public static int solution3(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Project> profitQueue = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
        PriorityQueue<Project> capitalQueue = new PriorityQueue<>((o1, o2) -> o1.capital - o2.capital);

        for (int i = 0; i < Profits.length; i++) {
            capitalQueue.add(new Project(Profits[i], Capital[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!capitalQueue.isEmpty() && W >= capitalQueue.peek().capital) {
                profitQueue.add(capitalQueue.poll());
            }
            if (profitQueue.isEmpty()) {
                break;
            }
            W += profitQueue.poll().profit;
        }

        return W;
    }


    public static class Project {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

}
