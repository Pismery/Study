package com.pismery.study.algorithm.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoAdd {

    public ListNode solution(ListNode l1,ListNode l2) {
        ListNode ln1 = l1;
        ListNode ln2 = l2;

        ListNode result = new ListNode(0);
        ListNode node = result;
        int carry = 0;
        while(ln1 != null || ln2 != null || carry != 0) {
            int i1 = ln1 == null ? 0 : ln1.val;
            int i2 = ln2 == null ? 0 : ln2.val;
            int val = i1 + i2 + carry;
            carry = val / 10;
            node.next = new ListNode(val % 10);
            node = node.next;
            ln1 = ln1 == null ? null : ln1.next;
            ln2 = ln2 == null ? null : ln2.next;
        }


        return result.next;
    }


    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
