package com.pismery.study.algorithm.leetcode;

import com.pismery.study.algorithm.bean.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteDuplicatesTest {

    @Test
    public void solution1() {
        ListNode result = DeleteDuplicates.solution1(init(new int[]{1, 1, 1}));
        assertEquals(init(new int[]{1}), result);

        assertEquals(init(new int[]{1, 2, 3, 4}), DeleteDuplicates.solution1(
                init(new int[]{1, 1, 2, 3, 3, 4}))
        );

    }

    private static ListNode init(int[] val) {
        ListNode result = new ListNode(val[0]);
        ListNode cur = result;
        for (int i = 1; i < val.length; i++) {
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }
        return result;
    }

}