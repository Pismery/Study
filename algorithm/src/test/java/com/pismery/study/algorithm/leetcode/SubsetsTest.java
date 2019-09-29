package com.pismery.study.algorithm.leetcode;

import com.pismery.study.util.CompareUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {

    @Test
    public void solution1() {
        List<List<Integer>> lists = Arrays.asList(
                Collections.EMPTY_LIST
                , Collections.singletonList(1)
                , Collections.singletonList(2)
                , Collections.singletonList(3)
                , Arrays.asList(1, 2)
                , Arrays.asList(1, 3)
                , Arrays.asList(2, 3)
                , Arrays.asList(1, 2, 3)
        );

        assertTrue(CompareUtils.isListEqual(lists,Subsets.solution1(new int[]{1,2,3})));
    }
}