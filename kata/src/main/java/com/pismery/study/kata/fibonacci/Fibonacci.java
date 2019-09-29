package com.pismery.study.kata.fibonacci;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * 斐波那契数列[0,1,1,2,3,5,8,13,21,...]
 */
public class Fibonacci {

    public static long calculate(int index) {
        if (index == 1 || index == 2)
            return 1L;
        return 0;
    }
}
