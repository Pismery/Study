package com.pismery.study.algorithm;

/**
 * 将考试成绩百分制转五级制并输出。
 * Created by pismery on 2018-03-25.
 */
public class Score2Rank {


    public static String getRank(int score) {
        switch (score/10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "E";
            case 6:
                return "D";
            case 7:
                return "C";
            case 8:
                return "B";
            case 9:
            case 10:
                return "A";
            default:
                return "ERROR";
        }
    }

}
