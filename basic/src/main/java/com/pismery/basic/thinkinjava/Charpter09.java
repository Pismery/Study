package com.pismery.basic.thinkinjava;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by pismery on 2018-03-26.
 */
@Slf4j
public class Charpter09 {

    public static void main(String[] args) {
        exercise1_1();
        exercise1_2();
        exercise1_3();
    }


    public static void exercise1_1() {
        Object oj = "s" + 'S';
        log.info("exercise1_1");
        log.info("oj = " + oj);
        log.info("String add Char = String :" + String.valueOf(oj instanceof String));
        log.info("String add Char = Char :" + String.valueOf(oj instanceof Character));
    }

    public static void exercise1_2() {
        //boolean int char,double String add boolean int char,double String
        Object[] objects = {true, '1', 1, 1.0, "1"};
        char a1 = (char) objects[1];

    }

    public static void exercise1_3() {
        char ch = '1';
        log.info("exercise1_3");
        log.info("ch = '1'");
        log.info("++ch = " + (++ch));
        log.info("ch++ = " + (ch++));
        log.info("ch + 1 = " + (ch + 1));
    }


}
