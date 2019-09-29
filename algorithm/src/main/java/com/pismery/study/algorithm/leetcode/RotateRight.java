package com.pismery.study.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {

    public static ListNode solution1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //ListNode result = head;
        for (int i = 0; i < k; i++) {

            ListNode pre = head;
            ListNode cur = head;
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
            }

            pre.next = null;
            cur.next = head;
            head = cur;
            //  result = cur;
        }
        return head;
    }

    /**
     * @startuml start
     * :遍历一遍 head 存储在 nodeList;
     * :通过计算头节点和尾节点下标;
     * note right
     * 尾节点：lastNodeIndex = length - k % length - 1
     * 头节点：(lastNodeIndex + 1) % length
     * end note
     * :将尾节点 next 设置为 null;
     * :将原尾节点 next 设置为 head;
     * :返回头节点;
     * end
     * @enduml
     */
    public static ListNode solution2(ListNode head, int k) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }
        int length = nodeList.size();
        if (head == null || head.next == null
                || k == 0 || k % length == 0) {
            return head;
        }

        int lastNodeIndex = length - k % length - 1;
        nodeList.get(lastNodeIndex).next = null;
        nodeList.get(length - 1).next = head;

        return nodeList.get((lastNodeIndex + 1) % length);
    }

    /**
     * @startuml
     * start
     * : 将 head 转换为循环链表;
     * : 从新的尾节点(newTailNode) 断开链表;
     * note right: newTailNodeIndex = (n - (k % n) - 1)
     * : 获取新的头节点(newHeadNode);
     * note right: newHeadNodeIndex = (n - (k % n))
     * end
     * @enduml
     */
    public static ListNode solution3(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        ListNode oldTailNode = head;
        int n = 1;
        while (oldTailNode.next != null) {
            oldTailNode = oldTailNode.next;
            n++;
        }
        oldTailNode.next = head;

        ListNode newTailNode = head;
        for (int i = 0; i < (n - (k % n) - 1); i++) {
            newTailNode = newTailNode.next;
        }

        ListNode newHead = newTailNode.next;
        newTailNode.next = null;

        return newHead;
    }


    static class ListNode {
        int val;
        ListNode next;

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



