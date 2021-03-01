package com.pismery.study.algorithm.leetcode;

import com.pismery.study.algorithm.bean.ListNode;
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

        ListNode actual = RotateRight.solution3(init(new int[]{1, 2, 3, 4, 5}), 2);
        assertEquals(init(new int[]{4,5,1,2,3})
            , actual);
        assertEquals(init(new int[]{1,2})
                , RotateRight.solution3(init(new int[]{1, 2}), 2));
        ListNode actual1 = RotateRight.solution3(init(new int[]{1, 2, 3, 4, 5}), 10);
        assertEquals(init(new int[]{1,2,3,4,5})
                , actual1);

    }

    static ListNode init(int[] val) {
        ListNode result = new ListNode(val[0]);
        ListNode cur = result;
        for (int i = 1; i < val.length; i++) {
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }
        return result;
    }
}