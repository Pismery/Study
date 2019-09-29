package com.pismery.study.algorithm.leetcode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;


/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    /**
     * 维持一个大小为 lists.length 的优先队列；每次将最小值取出，并将下一个值放入；直到所有值遍历完毕
     */
    public static ListNode solution1(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(n -> n.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }
        ListNode result = null;
        ListNode cur = null;
        while (!pq.isEmpty()) {
            if (result == null) {
                result = pq.poll();
                cur = result;
                if (result.next != null) {
                    pq.add(result.next);
                }
                continue;
            }
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return result;
    }


    static class ListNode {
        int val;
        MergeKLists.ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

}
