package com.pismery.study.algorithm.leetcode;

public class RomanToInt {

    public static int solution(String s) {

        char[] chars = s.toCharArray();
        int result = 0;
        char[] combinChars = new char[2];
        for(int i = 0,length = chars.length;i < length; i++) {
            if(i == length -1) {
                result += charToInt(chars[i]);
                break;
            }

            combinChars[0] = chars[i];
            combinChars[1] = chars[i+1];
            int combinInt = charsToInt(combinChars);
            if(combinInt != 0) {
                i++;
                result += combinInt;
                continue;
            }

            int charInt = charToInt(chars[i]);
            result += charInt;
        }

        return result;
    }


    private static int charToInt(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    private static int charsToInt(char[] chars) {

        if(chars.length != 2)
            return 0;
        if(chars[0] == 'I' && chars[1] == 'V')
            return 4;
        if(chars[0] == 'I' && chars[1] == 'X')
            return 9;
        if(chars[0] == 'X' && chars[1] == 'L')
            return 40;
        if(chars[0] == 'X' && chars[1] == 'C')
            return 90;
        if(chars[0] == 'C' && chars[1] == 'D')
            return 400;
        if(chars[0] == 'C' && chars[1] == 'M')
            return 900;

        return 0;
    }
}
