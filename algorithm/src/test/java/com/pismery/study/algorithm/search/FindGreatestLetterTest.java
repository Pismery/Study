package com.pismery.study.algorithm.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindGreatestLetterTest {

    private char[] sources;

    @Before
    public void init() {
        sources = new char[]{'b', 'c', 'e', 'k', 'n'};
    }

    @Test
    public void findInMiddle() {
        assertEquals('e',FindGreatestLetter.find(sources,'d'));
    }

    @Test
    public void findInFirst() {
        assertEquals('b',FindGreatestLetter.find(sources,'a'));
    }

    @Test
    public void findInLast() {
        assertEquals('n',FindGreatestLetter.find(sources,'l'));
    }

    @Test
    public void findNull() {
        assertEquals('b',FindGreatestLetter.find(sources,'z'));
    }

}