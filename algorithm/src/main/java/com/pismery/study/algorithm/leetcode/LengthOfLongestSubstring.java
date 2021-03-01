package com.pismery.study.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
//3. 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
// 示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
// 示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// 示例 4:
//
//输入: s = ""
//输出: 0
//
// 提示：
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5031 👎 0
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();

        int result = solution.lengthOfLongestSubstring4("abcabcbb");
        System.out.println("result=" + result + ";isPass=" + (result == 3));

        result = solution.lengthOfLongestSubstring4("");
        System.out.println("result=" + result + ";isPass=" + (result == 0));

        result = solution.lengthOfLongestSubstring4(null);
        System.out.println("result=" + result + ";isPass=" + (result == 0));

        result = solution.lengthOfLongestSubstring4("abba");
        System.out.println("result=" + result + ";isPass=" + (result == 2));

        result = solution.lengthOfLongestSubstring4("abccba");
        System.out.println("result=" + result + ";isPass=" + (result == 3));
    }

    /**
     * 求子串问题，首先想到滑动窗口的方式解决问题；
     * 滑动窗口问题，需要思考窗口什么条件下需要扩大，什么条件下需要收缩；最后什么时候停止；
     *
     * 经过分析：
     * 当下一个字符在当前窗口不存在时，扩大窗口；
     * 当下一个字符在当前窗口存在时，收缩窗口；
     * 当一检查完最后一个字符时，停止；
     * 窗口滑动过程中，每次扩大窗口时记录最终结果；
     *
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s == null || s.length() == 0) {
            return result;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        LinkedList<Character> longestStr = new LinkedList<>();
        while(right < chars.length) {
            char currentChar = chars[right];
            if(!longestStr.contains(currentChar)) {
                result = Math.max(result, right - left + 1);

                longestStr.addLast(currentChar);
                right++;
            } else {
                longestStr.removeFirst();
                left++;
            }
        }

        return result;
    }

    /**
     * 使用 HashSet 存储窗口数值；使用 for 循环遍历字符串 s
     */
    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        if(s == null || s.length() == 0) {
            return result;
        }

        HashSet<Character> set = new HashSet<>();
        for(int left=0, right = 0; right < s.length(); right++) {
            Character curChar = s.charAt(right);
            while(set.contains(curChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(curChar);
            result = Math.max(result, set.size());
        }

        return result;
    }

    /**
     * 使用 HashMap 存储窗口数值和位置，使得收缩一步到位；
     */
    public int lengthOfLongestSubstring4(String s) {
        int result = 0;
        if(s == null || s.length() == 0) {
            return result;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int left=0, right = 0; right < s.length(); right++) {
            Character curChar = s.charAt(right);
            if (map.containsKey(curChar)) {
                left = Math.max(left, map.get(curChar) + 1);
            }

            map.put(curChar,right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    /**
     * 暴力破解
     */
    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        if(s == null || s.length() == 0) {
            return result;
        }

        for(int strSize = 1; strSize <= s.length(); strSize++) {
            for(int beginIndex = 0; beginIndex < s.length() - strSize; beginIndex++) {
                String subStr = s.substring(beginIndex, beginIndex + strSize);
                if(isUnique(subStr)) {
                    result = Math.max(result, strSize);
                    break;
                }
            }
        }

        return result;
    }

    public boolean isUnique(String str) {
        return true;
    }
}
