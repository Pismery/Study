package com.pismery.study.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 盒子
 * @since 2021/11/18
 */
public class MagicDictionary {

    public static void main(String[] args) {
    }



    private Map<Integer, List<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            map.computeIfAbsent(word.length(), (x) -> new ArrayList()).add(word);
        }
    }

    public boolean search(String searchWord) {
        List<String> words = map.get(searchWord.length());
        boolean result = false;
        if(words == null) {
            return result;
        }

        for(String word: words) {
            int diffCount = 0;
            for(int i = 0; i < searchWord.length(); i++) {
                if(word.charAt(i) != (searchWord.charAt(i))) {
                    if( ++ diffCount > 1) {
                        break;
                    }
                }
            }
            if(diffCount == 1) {
                result =  true;
            }
        }
        return result;
    }
}
