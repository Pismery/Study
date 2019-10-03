package com.pismery.study.algorithm;

import org.junit.Test;

import static com.pismery.study.algorithm.GetMaxStringAfterRemove.solution1;
import static org.junit.Assert.*;

public class GetMaxStringAfterRemoveTest {


    @Test
    public void test() {
        assertEquals("1220",solution1("12220", 1));
        assertEquals("120",solution1("12220", 2));
        assertEquals("10",solution1("12220", 3));
        assertEquals("0",solution1("12220", 4));
        assertEquals("0",solution1("12220", 5));


        assertEquals("132219",solution1("1432219", 1));
        assertEquals("12219",solution1("1432219", 2));
        assertEquals("1219",solution1("1432219", 3));
        assertEquals("119",solution1("1432219", 4));
        assertEquals("11",solution1("1432219", 5));
        assertEquals("1",solution1("1432219", 6));
        assertEquals("0",solution1("1432219", 7));


        assertEquals("200",solution1("10200", 1));
        assertEquals("0",solution1("10200", 2));
        assertEquals("0",solution1("10200", 3));
        assertEquals("0",solution1("10200", 4));
        assertEquals("0",solution1("10200", 5));

        assertEquals("0",solution1("10", 1));
        assertEquals("0",solution1("10", 2));
    }

}