package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateRightTest {

    @Test
    public void solution1() {
        assertEquals(init(new int[]{4,5,1,2,3})
                , RotateRight.solution1(init(new int[]{1, 2, 3, 4, 5}), 2));
        assertEquals(init(new int[]{1,2})
                , RotateRight.solution1(init(new int[]{1, 2}), 2));
        assertEquals(init(new int[]{1,2,3,4,5})
                , RotateRight.solution1(init(new int[]{1, 2, 3, 4, 5}), 10));

    }

    @Test
    public void solution2() {

        assertEquals(init(new int[]{4,5,1,2,3})
            , RotateRight.solution2(init(new int[]{1, 2, 3, 4, 5}), 2));
        assertEquals(init(new int[]{1,2})
                , RotateRight.solution2(init(new int[]{1, 2}), 2));
        assertEquals(init(new int[]{1,2,3,4,5})
                , RotateRight.solution2(init(new int[]{1, 2, 3, 4, 5}), 10));

    }

    @Test
    public void solution3() {

        RotateRight.ListNode actual = RotateRight.solution3(init(new int[]{1, 2, 3, 4, 5}), 2);
        assertEquals(init(new int[]{4,5,1,2,3})
            , actual);
        assertEquals(init(new int[]{1,2})
                , RotateRight.solution3(init(new int[]{1, 2}), 2));
        RotateRight.ListNode actual1 = RotateRight.solution3(init(new int[]{1, 2, 3, 4, 5}), 10);
        assertEquals(init(new int[]{1,2,3,4,5})
                , actual1);

    }

    private static RotateRight.ListNode init(int[] val) {
        RotateRight.ListNode result = new RotateRight.ListNode(val[0]);
        RotateRight.ListNode cur = result;
        for (int i = 1; i < val.length; i++) {
            cur.next = new RotateRight.ListNode(val[i]);
            cur = cur.next;
        }
        return result;
    }
}