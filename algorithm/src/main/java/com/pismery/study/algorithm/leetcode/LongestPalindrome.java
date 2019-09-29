package com.pismery.study.algorithm.leetcode;

import java.util.Arrays;

public class LongestPalindrome {

    /**
     * 暴力解法
     * @param s 目标字符串
     * @return 最长回文串
     */
    public static String solution(String s) {


        String result = "";
        if (s == null || s.isEmpty()) {
            return result;
        }

        result = s.substring(0,1);

        char[] chars = s.toCharArray();
        for(int i = 0,length = chars.length; i < length - 1; i++) {
            for(int j = i + 1; j < length; j++) {
                int left = i;
                int right = j;
                boolean isPalidrome = true;
                while(left < right) {
                    if(chars[left++] != chars[right--]) {
                        isPalidrome = false;
                        break;
                    }
                }

                //如果是回文串，并且长度大于等于已找到得回文串
                if(isPalidrome && result.length() <= (j - i + 1)) {
                    char[] resultChars = Arrays.copyOfRange(chars,i,j+1);
                    result = String.valueOf(resultChars);
                }
            }
        }

        return result;
    }


}
