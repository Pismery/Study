package com.pismery.study.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class CompareUtilsTest {

    @Test
    public void isListEqual_Empty() {
        assertTrue(CompareUtils.isListEqual(null,null));
        assertTrue(CompareUtils.isListEqual(null,new ArrayList<>()));
        assertTrue(CompareUtils.isListEqual(new ArrayList<>(),null));
        assertTrue(CompareUtils.isListEqual(new ArrayList<>(),new ArrayList<>()));
    }

    @Test
    public void isListEqual_SizeDiff() {
        assertFalse(CompareUtils.isListEqual(null, Collections.singletonList(1)));
        assertFalse(CompareUtils.isListEqual(Collections.singletonList(1),Arrays.asList(1,2)));
        assertFalse(CompareUtils.isListEqual(Collections.singletonList(1),null));
    }


    @Test
    public void isListEqual_Normal() {
        assertTrue(CompareUtils.isListEqual(Arrays.asList(1,2,3),Arrays.asList(3,2,1)));
        assertTrue(CompareUtils.isListEqual(Arrays.asList(1.0,2.0),Arrays.asList(2.0,1.0)));
        assertTrue(CompareUtils.isListEqual(Arrays.asList("1","2"),Arrays.asList("2","1")));
    }
}