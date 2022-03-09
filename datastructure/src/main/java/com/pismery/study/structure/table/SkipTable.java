package com.pismery.study.structure.table;

import java.util.Arrays;

/**
 * 1206. 设计跳表
 *
 *不使用任何库函数，设计一个 跳表 。
 *
 * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 *
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
 *
 *
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 *
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 *
 * 了解更多 :https://en.wikipedia.org/wiki/Skip_list
 *
 * 在本题中，你的设计应该要包含这些函数：
 *
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num):插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果num不存在，直接返回false. 如果存在多个num，删除其中任意一个即可。
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 *
 * 
 *
 * 示例 1:
 *
 * 输入
 * ["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
 * [[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
 * 输出
 * [null, null, null, null, false, null, true, false, true, false]
 *
 * 解释
 * Skiplist skiplist = new Skiplist();
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 * 
 *
 * 提示:
 *
 * 0 <= num, target <= 2 * 104
 * 调用search, add, erase操作次数不大于5 * 104
 * @author 盒子
 * @since 2022/3/3
 */
public class SkipTable {
    private final int MAX_LEVEL = 32;
    private final double NEXT_LEVEL_PERCENTAGE = 0.25D;
    private final Node head = new Node(null, MAX_LEVEL);
    private int curMaxLevel = 1;

    public boolean search(int target) {
        Node searchNode = head;
        for (int curLevel = curMaxLevel; curLevel > 0; curLevel--) {
            searchNode = findClosestNode(searchNode, curLevel, target);
            if (searchNode.nexts[curLevel - 1] != null && searchNode.nexts[curLevel - 1].value == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1. 新建节点
     * 2. 更新跳表最大层高
     * 3. 根据新节点的层高，找到各层的最近节点
     * 4. 插入新节点至各层的最近节点后 => new.next = forward.next; forward.net = new;
     */
    public void add(int num) {
        int newNodeLevel = randomLevel();
        curMaxLevel = Math.max(curMaxLevel, newNodeLevel);
        Node newNode = new Node(num, newNodeLevel);

        Node searchNode = head;
        for(int curLevel = newNodeLevel; curLevel > 0; curLevel--) {
            searchNode = findClosestNode(searchNode, curLevel, num);

            newNode.nexts[curLevel - 1] = searchNode.nexts[curLevel - 1];
            searchNode.nexts[curLevel - 1] =  newNode;
        }
    }

    /**
     * 1. 找到当前层高距离 num 最近的节点
     * 2. 如果下个节点为 num， 则移除下一个节点 a.next = a.next.next
     * 3. 更新当前跳表的最大层高
     */
    public boolean erase(int num) {
        boolean result = false;
        Node searchNode = head;
        for (int curLevel = curMaxLevel; curLevel > 0; curLevel--) {
            searchNode = findClosestNode(searchNode, curLevel, num);
            if (searchNode.nexts[curLevel - 1] != null && searchNode.nexts[curLevel - 1].value == num) {
                searchNode.nexts[curLevel - 1] =  searchNode.nexts[curLevel - 1].nexts[curLevel - 1];
                result = true;
            }
        }

        // 重新设置当前跳表最高层级
        while (curMaxLevel > 1 && head.nexts[curMaxLevel - 1] == null) {
            curMaxLevel--;
        }

        return result;
    }

    public void printAll() {
        System.out.println();
        Node p = head;
        for (int i = curMaxLevel; i > 0; i--) {
            while (p.nexts[i -1] != null) {
                System.out.print(p.nexts[i -1] + " ");
                p = p.nexts[i -1];
            }
            System.out.println();
            p = head;
        }
    }

    /**
     * 查找当前层高距离 value 最近的节点
     */
    private Node findClosestNode(Node node,int level, int value) {
        while(node.nexts[level - 1] != null && node.nexts[level -1].value < value) {
            node = node.nexts[level - 1];
        }
        return node;
    }

    /**
     * 计算当前节点可以有多少层高
     */
    private int randomLevel() {
        int result = 1;
        while (Math.random() < NEXT_LEVEL_PERCENTAGE && result < MAX_LEVEL) {
            result++;
        }
        return result;
    }

    static class Node {
        Integer value;
        Node[] nexts;

        public Node(Integer value, int level) {
            this.value = value;
            nexts = new Node[level];
        }

        @Override
        public String toString() {
            return ""+value;
        }
    }

}
