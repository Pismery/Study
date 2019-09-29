package com.pismery.study.algorithm.doubleindex;

/**
 * 可以删除一个字符，判断是否能构成回文字符串。
 */
public class ValidPalidrome {

    public static boolean valid(String a) {
        int left = 0;
        int right = a.length() - 1;
        while (left < right) {
            if (a.charAt(left++) != a.charAt(right--))
                return isPalidrome(a, left, right - 1) || isPalidrome(a, left + 1, right);
        }
        return true;
    }

    private static boolean isPalidrome(String a, int left, int right) {
        while (left < right) {
            if (a.charAt(left++) != a.charAt(right--))
                return false;
        }
        return true;
    }
}
