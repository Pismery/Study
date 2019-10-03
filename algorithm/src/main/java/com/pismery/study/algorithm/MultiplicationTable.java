package com.pismery.study.algorithm;

/**
 * 输出乘法口诀表
 * Created by pismery on 2018-03-25.
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        printTable(9);
    }


    public static void printTable(int rowNum) {
        for (int i = 0; i < rowNum; i++) {
            printRow(i + 1, i + 1);
        }
    }

    public static void printRow(int base, int colNum) {
        for (int i = 0; i < colNum; i++) {
            System.out.printf("%3d", base * (i + 1));
        }
        System.out.println();
    }


}
