package com.pismery.study.algorithm.leetcode;

import com.pismery.study.algorithm.bean.ListNode;

import java.util.Objects;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {
    public static ListNode solution1(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
