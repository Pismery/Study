package com.pismery.study.algorithm;

import com.pismery.study.algorithm.ValidParentheses;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidParenthesesTest {

    @Test
    public void example1() {
        assertEquals(true, ValidParentheses.soulution("()"));
    }
    @Test
    public void example2() {
        assertEquals(true, ValidParentheses.soulution("(){}[]"));
    }
    @Test
    public void example3() {
        assertEquals(false, ValidParentheses.soulution("(]"));
    }
    @Test
    public void example4() {
        assertEquals(false, ValidParentheses.soulution("([)]"));
    }
    @Test
    public void example5() {
        assertEquals(true, ValidParentheses.soulution("{[]}"));
    }
}