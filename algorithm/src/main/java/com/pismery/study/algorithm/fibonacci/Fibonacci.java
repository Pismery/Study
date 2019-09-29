package com.pismery.study.algorithm.fibonacci;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * 斐波那契数列[0,1,1,2,3,5,8,13,21,...]
 */
public class Fibonacci {
    /**
     * 根据递归。时间复杂度 O(2^n);
     *
     * @param x
     * @return
     */
    public static Long versionOne(int x) {
        if (x == 0)
            return 0L;
        if (x == 1)
            return 1L;

        return versionOne(x - 1) + versionOne(x - 2);
    }

    /**
     * 通过由低位推导至高位。时间复杂度：O(n)
     *
     * @param x
     * @return
     */
    public static Long versionTwo(int x) {
        if (x == 0)
            return 0L;
        if (x == 1)
            return 1L;

        long x0 = 0;
        long x1 = 1;
        long result = 0;
        for (int i = 2; i <= x; i++) {
            result = x0 + x1;
            x0 = x1;
            x1 = result;
        }
        return result;
    }

    /**
     * 通过斐波那契数列通向公式：a(n) = 1/√5(((1+√5)/2)^n - ((1-√5)/2)^n)。
     * 时间复杂度O(n)：因为求指数次幂的问题;
     *
     * @param x
     * @return
     */
    public static Long versionThree(int x) {
        double a = 1.0 / sqrt(5);
        double b = (1.0 + sqrt(5)) / 2;
        double c = (1.0 - sqrt(5)) / 2;

        return (long) (a * (pow(b, x) - pow(c, x)));
    }

    /**
     * 将指数次幂通过分解为
     * n%2==0 : a(n) = a(n/2)*a(n/2);
     * n%2==1 : a(n) = a((n-1)/2)*a((n-1)/2) * a;
     * 使得求指数幂时间复杂度达到O(lgn)
     *
     * @param x
     * @return
     */
    public static long versionFour(int x) {
        double a = 1.0 / sqrt(5);
        double b = (1.0 + sqrt(5)) / 2;
        double c = (1.0 - sqrt(5)) / 2;

        return (long) (a * (binaryPow(b, x) - binaryPow(c, x)));
    }

    static double binaryPow(double a, int n) {
        if (n == 0)
            return 1L;
        if (n == 1)
            return a;

        if (n % 2 == 0) {
            double binaryPow = binaryPow(a, n / 2);
            return binaryPow * binaryPow;
        } else {
            double binaryPow = binaryPow(a, (n - 1) / 2);
            return binaryPow * binaryPow * a;
        }
    }
}
