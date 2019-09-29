package com.pismery.study.algorithm.divideconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators,
 * return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * <p>
 * <p>
 * Example 1:<br>
 * Input: "2-1-1"<br>
 * Output: [0, 2]<br>
 * Explanation:<br>
 * ((2-1)-1) = 0<br>
 * (2-(1-1)) = 2<br>
 * <p>
 * <p>
 * Example 2:<br>
 * Input: "2*3-4*5"<br>
 * Output: [-34, -14, -10, -10, 10]<br>
 * Explanation:<br>
 * (2*(3-(4*5))) = -34<br>
 * ((2*3)-(4*5)) = -14<br>
 * ((2*(3-4))*5) = -10<br>
 * (2*((3-4)*5)) = -10<br>
 * (((2*3)-4)*5) = 10<br>
 */
public class DifferentWayAddParentheses {

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                        }
                    }
                }
            }

        }

        if (result.size() == 0)
            result.add(Integer.valueOf(input));
        return result;
    }

}
