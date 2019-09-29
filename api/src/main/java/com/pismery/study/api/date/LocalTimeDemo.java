package com.pismery.study.api.date;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

@Slf4j
public class LocalTimeDemo {

    public static void main(String[] args) {
        init();
        apiBasicUse();
    }

    public static void apiBasicUse() {
        LocalTime time = LocalTime.of(7,20,10,9999999);

        log.debug("time.getHour(): "+time.getHour()); //time.getHour(): 7
        log.debug("time.getMinute(): "+time.getMinute()); //time.getMinute(): 20
        log.debug("time.getSecond(): "+time.getSecond()); //time.getSecond(): 10
        log.debug("time.getLong(ChronoField.MICRO_OF_DAY): "+ time.getLong(ChronoField.MICRO_OF_DAY)); //time.getLong(ChronoField.MICRO_OF_DAY): 26410110000
        log.debug("time.getNano(): "+time.getNano()); //time.getNano(): 110000000

        log.debug("time.plusHours(17): "+ time.plusHours(17)); //time.plusHours(17): 00:20:10.110
        log.debug("time.plus(Duration.ofHours(17)): "+time.plus(Duration.ofHours(17))); //time.plus(Duration.ofHours(17)): 00:20:10.110

    }


    public static void init() {
        log.debug("LocalTime.MAX: "+ LocalTime.MAX); //LocalTime.MAX: 23:59:59.999999999
        log.debug("LocalTime.MIDNIGHT: "+ LocalTime.MIDNIGHT); //LocalTime.MIDNIGHT: 00:00
        log.debug("LocalTime.MIN: "+ LocalTime.MIN); //LocalTime.MIN: 00:00
        log.debug("LocalTime.NOON: "+ LocalTime.NOON); //LocalTime.NOON: 12:00
    }

}
