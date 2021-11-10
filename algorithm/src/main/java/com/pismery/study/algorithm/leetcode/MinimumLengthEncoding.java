package com.pismery.study.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 820. 单词的压缩编码
 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 *
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["time", "me", "bell"]
 * 输出：10
 * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
 * words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * 示例 2：
 *
 * 输入：words = ["t"]
 * 输出：2
 * 解释：一组有效编码为 s = "t#" 和 indices = [0] 。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * words[i] 仅由小写字母组成
 * @author 盒子
 * @since 2021/11/10
 */
public class MinimumLengthEncoding {

    public static void main(String[] args) {
        new StringBuilder().reverse();

    }

    /**
     * 通过 Set 集合去除每个字符串的子串，最后计算 set 剩下的字符串数
     */
    public static int solution1(String[] words) {
        List<String> wordList = Arrays.asList(words);
        Set<String> wordSet = new HashSet<>(wordList);

        for(String word : wordList) {
            for(int i = 1; i < word.length(); i ++) {
                String tmp = word.substring(i);
                wordSet.remove(tmp);
            }
        }

        return wordSet.stream().mapToInt(word -> word.length() + 1).sum();
    }

    /**
     * 先将字符串反转，然后根据字符串排序，此时，如果下一个字符串开头包含了上一个，则上一个可以排除；反之，上一个字符串即为最终压缩结果；
     */
    public static int solution2(String[] words) {
        String[] reverseWords = new String[words.length];
        for(int i = 0;i < words.length; i++) {
            reverseWords[i] = new StringBuilder(words[i]).reverse().toString();
        }

        Arrays.sort(reverseWords);

        int result = 0;
        for(int i = 0;i < reverseWords.length; i++) {
            if(i == reverseWords.length - 1 || !reverseWords[i+1].startsWith(reverseWords[i])) {
                result += reverseWords[i].length() + 1;
            }
        }
        return result;
    }
}
