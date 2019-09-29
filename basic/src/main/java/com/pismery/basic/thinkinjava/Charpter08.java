package com.pismery.basic.thinkinjava;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by pismery on 2018-03-26.
 */
public class Charpter08 {


    public static void main(String[] args) {
        int[] ii1 = createRandomInts(20);

        short i1 = 1;
        String a = File.separator;

        System.out.println(Arrays.toString(ii1));
        System.out.println(maxInRange(ii1, 0, ii1.length - 1));
        System.out.println(maxInRange(ii1, 0, 0));
        System.out.println(maxInRange(ii1, 0, 3));
        System.out.println(max(ii1));
    }



    public static int[] createRandomInts(int length) {
        int[] result = new int[length];
        Random random = new Random();
        for (int i = 0; i < length - 1; i++) {
            result[i] = random.nextInt(length);
        }
        return result;
    }

    public static int max(int[] aim) {
        return maxInRange(aim,0,aim.length-1);
    }

    public static int maxInRange(int[] aim,int lowIndex,int highIndex) {
        if(lowIndex == highIndex) {
            return aim[lowIndex];
        }

        if(aim[lowIndex] <= aim[highIndex]) {
            return maxInRange(aim,lowIndex+1,highIndex);
        }else {
            return maxInRange(aim,lowIndex,highIndex-1);
        }
    }

}
