package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteDuplicatesTest {

    @Test
    public void solution1() {
        DeleteDuplicates.ListNode result = DeleteDuplicates.solution1(init(new int[]{1, 1, 1}));
        assertEquals(init(new int[]{1}), result);

        assertEquals(init(new int[]{1, 2, 3, 4}), DeleteDuplicates.solution1(
                init(new int[]{1, 1, 2, 3, 3, 4}))
        );

    }

    private static DeleteDuplicates.ListNode init(int[] val) {
        DeleteDuplicates.ListNode result = new DeleteDuplicates.ListNode(val[0]);
        DeleteDuplicates.ListNode cur = result;
        for (int i = 1; i < val.length; i++) {
            cur.next = new DeleteDuplicates.ListNode(val[i]);
            cur = cur.next;
        }
        return result;
    }

}