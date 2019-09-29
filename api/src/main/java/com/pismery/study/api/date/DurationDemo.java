package com.pismery.study.api.date;

import java.time.*;

public class DurationDemo {

    public static void main(String[] args) {
        System.out.println(getLivedDays());
    }

    public static long getLivedDays() {
        LocalDateTime birthday = LocalDateTime.of(
                LocalDate.of(1990, Month.JANUARY, 1),
                LocalTime.of(10, 10));
        LocalDateTime deathDay = LocalDateTime.of(
                LocalDate.of(2090, Month.JANUARY, 1),
                LocalTime.of(10, 10));

        return Duration.between(birthday, deathDay).toDays(); //36525
    }
}
