package com.pismery.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 求100以内的全部素数。(素数:在大于1的自然数中，除了1和它本身以外不再有其他因数)
 * Created by pismery on 2018-03-17.
 */
public class GetPrime {

    public static void main(String[] args) {
        System.out.println(getPrime(100));
        System.out.println(getPrime2(100));
        System.out.println(getPrimeBy6N_way1(7));
        System.out.println(getPrimeBy6N_way2(7));

        System.out.println(getPrimeBy6N_way1(6));
        System.out.println(getPrimeBy6N_way2(6));

        System.out.println(getPrimeBy6N_way1(5));
        System.out.println(getPrimeBy6N_way2(5));
    }

    public static List<Integer> getPrime(int maxNum) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= maxNum; i++) {
            if (isPrime(i))
                result.add(i);
        }
        return result;
    }

    public static List<Integer> getPrime2(int maxNum) {
        List<Integer> result = new ArrayList<>();
        if (maxNum < 2) {
            return result;
        }

        result.add(2);

        for (int i = 3; i <= maxNum; i += 2) {
            if (isPrime(i))
                result.add(i);
        }
        return result;
    }

    /**
     * 所有的数都能用6N+x的形式表示出来：6N,6N+1,6N+2,6N+3,6N+4,6N+5 ->
     * 很容易看出6N,6N+2,6N+3,6N+4均不可能是素数。
     * 只有6N+1与6N+5有可能是素数，且6N+5等价于6N-1;
     * 所以素数只能是形如6N±1的形式，此时只需要对6N±1的数进行判断是否是素数就行了。
     *
     * @param maxNum
     * @return
     */
    public static List<Integer> getPrimeBy6N_way1(int maxNum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (maxNum >= 2)
            result.add(2);
        if (maxNum >= 3)
            result.add(3);

        int i = 0;
        while (6 * i - 1 <= maxNum || 6 * i + 1 <= maxNum) {
            if (6 * i - 1 <= maxNum && isPrime2(6 * i - 1))
                result.add(6 * i - 1);
            if (6 * i + 1 <= maxNum && isPrime2(6 * i + 1))
                result.add(6 * i + 1);
            i++;
        }

        return result;
    }

    public static List<Integer> getPrimeBy6N_way2(int maxNum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (maxNum >= 2)
            result.add(2);
        if (maxNum >= 3)
            result.add(3);

        for (int j = 0; j - 1 <= maxNum || j + 1 <= maxNum; j += 6) {
            if (j - 1 <= maxNum && isPrime2(j - 1))
                result.add(j - 1);
            if ( j + 1 <= maxNum && isPrime2(j + 1))
                result.add(j + 1);
        }

        return result;
    }


    public static boolean isPrime2(int num) {
        if (num < 2)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;

        //注意 i * i <= num 必须有=号  num = 4 9 16
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        //注意 j<= Math.sqrt(num) 必须有=号  num = 4 9 16
        double sqrt = Math.sqrt(num);
        for (int j = 2; j <= sqrt; j++) {
            if (num % j == 0 && num != j) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime3(int num) {
        if(num < 2) {
            return false;
        }
        for (int j = 2; j <= num; j++) {
            if (num % j == 0 && num != j) {
                return false;
            }
        }
        return true;
    }
}
