package com.pismery.study.algorithm;

/**
 *
 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 注意:
 num 的长度小于 10002 且 ≥ k。
 num 不会包含任何前导零。

 示例 1 :
 输入: num = "1432219", k = 3
 输出: "1219"
 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。

 示例 2 :
 输入: num = "10200", k = 1
 输出: "200"
 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。

 示例 3 :
 输入: num = "10", k = 2
 输出: "0"
 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class GetMaxStringAfterRemove {

    /**
     * 1. 从高位至低位开始遍历，如果高位数字值 > 下一位数字值，则移除高位；
     * 2. 获取遍历后的结果，清除前导零
     */
    public static String solution1(String input, int k) {
        if (k == input.length()) {
            return "0";
        }

        String result = input;
        for (int i = 0; i < k; i++) {
            result = removeOne(result);
        }

        while (result.startsWith("0") && result.length() != 1) {
            result = result.substring(1);
        }
        return result;
    }

    private static String removeOne(String input) {
        StringBuilder result = new StringBuilder();
        boolean removed = false;
        for (int i = 0; i < input.length() - 1; i++) {
            int curValue = Integer.parseInt(input.substring(i, i + 1));
            int nextValue = Integer.parseInt(input.substring(i + 1, i + 2));
            if (curValue > nextValue && !removed) {
                removed = true;
                continue;
            }
            result.append(curValue);
        }
        if (removed) {
            result.append(Integer.parseInt(input.substring(input.length() - 1)));
        }
        return result.toString();
    }

}
