package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeKListsTest {

    @Test
    public void solution1() {
        assertEquals(init(new int[]{1, 1, 2, 3, 4, 4, 5, 6}),
                MergeKLists.solution1(new MergeKLists.ListNode[]{
                        init(new int[]{1, 4, 5})
                        , init(new int[]{1, 3, 4})
                        , init(new int[]{2, 6})
                }));

        assertEquals(null, MergeKLists.solution1(new MergeKLists.ListNode[]{}));
        assertEquals(null, MergeKLists.solution1(null));
        assertEquals(null, MergeKLists.solution1(new MergeKLists.ListNode[]{null}));
        assertEquals(init(new int[]{1}), MergeKLists.solution1(new MergeKLists.ListNode[]{init(new int[]{1})}));


    }


    private static MergeKLists.ListNode init(int[] val) {
        MergeKLists.ListNode result = new MergeKLists.ListNode(val[0]);
        MergeKLists.ListNode cur = result;
        for (int i = 1; i < val.length; i++) {
            cur.next = new MergeKLists.ListNode(val[i]);
            cur = cur.next;
        }
        return result;
    }
}