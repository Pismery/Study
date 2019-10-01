package com.pismery.study.algorithm;

public class BigNumberAddOne {
    public static void main(String[] args) {
        printArray(add(new int[]{9,9,9,9}));
        printArray(add(new int[]{1,9,9}));
        printArray(add(new int[]{1,2,9}));
        printArray(add(new int[]{9}));
    }

    private static void printArray(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

    private static int[] add(int[] num) {
        int added = 1;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] + added < 10) {
                num[i] += added;
                break;
            }

            if (i == 0) {
                num[i] = 0;
                int[] result = new int[num.length + 1];
                copyArray(result, num);
                result[0] = 1;
                return result;
            }

            added = 1;
            num[i] = 0;
        }

        return num;
    }


    private static void copyArray(int[] result, int[] copied) {
        for(int i = result.length -1; i > 0 ;i--) {
            result[i] = copied[i - 1];
        }
    }


}
