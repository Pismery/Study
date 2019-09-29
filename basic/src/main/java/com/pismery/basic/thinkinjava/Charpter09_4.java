package com.pismery.basic.thinkinjava;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pismery on 2018-03-26.
 */
public class Charpter09_4 {

    public static void main(String[] args) {
        printString("asdfghjkl;");
        System.out.println();
        printBackward("asdfghjkl;");

        System.out.println("reverseString : " + reverseString("coffee"));


        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("aa"));
        System.out.println(isPalindrome("aaaaa"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abcdba"));


        isAbecedarian_iterative("abdest");
        isAbecedarian_iterative("acknow");
        isAbecedarian_iterative("cestuy");
        isAbecedarian_iterative("bcaa");
        isAbecedarian_iterative(null);

        System.out.println("isAbecedarian_recursive: " + isAbecedarian_recursive("abdest"));
        System.out.println("isAbecedarian_recursive: " + isAbecedarian_recursive("acknow"));
        System.out.println("isAbecedarian_recursive: " + isAbecedarian_recursive("cestuy"));
        System.out.println("isAbecedarian_recursive: " + isAbecedarian_recursive("bcaa"));
        System.out.println("isAbecedarian_recursive: " + isAbecedarian_recursive("null"));


        Map<Character,Integer> result = new HashMap<Character,Integer>();
        System.out.println(result.get('a')) ;

    }

    public static boolean isAnagrams(String str1,String str2) {

        return true;
    }

    public static boolean isDoubloon(String str) {
        if(null == str ) {
            return false;
        }

        String aim = str.toLowerCase();
        Map<Character,Integer> result = new HashMap<Character,Integer>();
        for (int i = 0; i < aim.length(); i++) {
            result.get(aim.charAt(i));
        }


        return true;
    }


    public static boolean isAbecedarian_recursive(String str) {
        if(null == str) {
            return false;
        }
        if(str.length() == 1) {
            return true;
        }
        if(str.charAt(0) > str.charAt(1)) {
            return false;
        }

        return isAbecedarian_recursive(rest(str));
    }

    public static boolean isAbecedarian_iterative(String str) {
        if(null == str) {
            System.out.println("isAbecedarian_iterative : except");
            return false;
        }

        String aim = str.toLowerCase();
        int charIndex = str.charAt(0);
        for (int i = 1; i < aim.length(); i++) {
            if(charIndex > str.charAt(i)) {
                System.out.println("isAbecedarian_iterative : false");
                return false;
            }
            charIndex = str.charAt(i);
        }
        System.out.println("isAbecedarian_iterative : true");
        return true;
    }

    public static boolean isPalindrome(String str) {
//        System.out.println("isPalindrome : " + str);
        if (first(str) != first(reverseString(str))) {
            return false;
        }
        if (length(str) == 1) {
            return true;
        }
        if (length(str) == 2 && rest(str).equals(first(str) + "")) {
            return true;
        }

        return isPalindrome(middle(str));


    }

    public static String reverseString(String str) {
        if (length(str) == 0) {
            return "";
        }
        String result = reverseString(rest(str));

        result += first(str);
        return result;
    }

    public static void printBackward(String str) {
        if (length(str) == 0) {
            return;
        }
        printBackward(rest(str));
        System.out.println(first(str));
    }

    public static void printString(String str) {
        if (length(str) == 0) {
            return;
        }
        System.out.println(first(str));
        printString(rest(str));
    }

    /**
     * Returns the first character of the given String.
     */
    public static char first(String s) {
        return s.charAt(0);
    }

    /**
     * Returns all but the first letter of the given String.
     */
    public static String rest(String s) {
        return s.substring(1);
    }

    /**
     * Returns all but the first and last letter of the String.
     */
    public static String middle(String s) {
        return s.substring(1, s.length() - 1);
    }

    /**
     * Returns the length of the given String.
     */
    public static int length(String s) {
        return s.length();
    }


}
