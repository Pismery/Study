package com.pismery.study.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    @Test
    public void normal() {
        //Given
        String str = "babad";
        //When
        String result = LongestPalindrome.solution(str);
        //Then
        assertEquals("aba",result);
    }
    
    @Test
    public void emptyString() {
        //Given
        String str = "";
        //When
        String result = LongestPalindrome.solution(str);
        //Then
        assertEquals("",result);
    }

    @Test
    public void singleString() {
        //Given
        String str = "a";
        //When
        String result = LongestPalindrome.solution(str);
        //Then
        assertEquals("a",result);
    }


}