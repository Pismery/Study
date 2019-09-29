package com.pismery.study.api.date;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Month;

@Slf4j
public class LocalDateDemo {

    public static void main(String[] args) {
        init();
        apiBaseUse();
    }

    public static void apiBaseUse() {
        LocalDate localDate = LocalDate.of(2015,11,12);

        log.debug("toString: "+localDate.toString()); //toString: 2015-11-12
        log.debug("getYear: "+localDate.getYear()); //getYear: 2015

        log.debug("getMonth: "+localDate.getMonth()); //getMonth: NOVEMBER
        log.debug("getMonthValue: "+localDate.getMonthValue()); //getMonthValue: 11

        log.debug("getDayOfWeek: "+localDate.getDayOfWeek()); //getDayOfWeek: THURSDAY
        log.debug("getDayOfMonth: "+localDate.getDayOfMonth()); //getDayOfMonth: 12
        log.debug("getDayOfYear: "+localDate.getDayOfYear()); //getDayOfYear: 316

        log.debug("isLeapYear: "+localDate.isLeapYear()); //isLeapYear: false
        log.debug("lengthOfMonth: "+localDate.lengthOfMonth()); //lengthOfMonth: 30
        log.debug("lengthOfYear: "+localDate.lengthOfYear()); //lengthOfYear: 365
    }

    public static void init() {
        log.debug("LocalDate.MAX: "+LocalDate.MAX); //LocalDate.MAX: +999999999-12-31
        log.debug("LocalDate.MIN: "+LocalDate.MIN); //LocalDate.MIN: -999999999-01-01
        log.debug("LocalDate.of(2015, Month.SEPTEMBER,12): "+LocalDate.of(2015, Month.SEPTEMBER,12)); //LocalDate.of(2015, Month.SEPTEMBER,12): 2015-09-12
        log.debug("LocalDate.now(): "+LocalDate.now()); //LocalDate.now(): 2018-09-09
    }
    
    public static long getBetweenDays(LocalDate d1,LocalDate d2) {
        return Math.abs(d1.toEpochDay() - d2.toEpochDay());
    }
}
