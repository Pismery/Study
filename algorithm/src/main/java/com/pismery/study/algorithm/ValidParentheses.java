package com.pismery.study.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * <ul>An input string is valid if:
 *
 * <li>Open brackets must be closed by the same type of brackets.</li>
 * <li>Open brackets must be closed in the correct order.</li>
 * </ul>
 * <p>
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * Input: "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: "(]"
 * Output: false
 * <p>
 * Example 4:
 * Input: "([)]"
 * Output: false
 * <p>
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
@Slf4j
public class ValidParentheses {

    public static boolean soulution(String s) {
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '{' || aChar == '[' || aChar == '(') {
                stack.push(aChar);
                continue;
            }
            if (aChar == '}' && (stack.isEmpty() || stack.pop() != '{'))
                return false;
            if (aChar == ']' && (stack.isEmpty() || stack.pop() != '['))
                return false;
            if (aChar == ')' && (stack.isEmpty() || stack.pop() != '('))
                return false;
        }
        return stack.isEmpty();
    }
}
