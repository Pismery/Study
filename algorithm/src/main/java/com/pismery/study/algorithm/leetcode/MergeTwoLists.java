package com.pismery.study.algorithm.leetcode;

import com.pismery.study.algorithm.bean.ListNode;


public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode current = null;
        if( l1.val <= l2.val) {
            head = l1;
            current = l1;
            l1 = l1.next;
        } else {
            head = l2;
            current = l2;
            l2 = l2.next;
        }


        while(l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                break;
            }
            if (l2 == null) {
                current.next = l1;
                break;
            }

            if( l1.val <= l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        return head;
    }

}
