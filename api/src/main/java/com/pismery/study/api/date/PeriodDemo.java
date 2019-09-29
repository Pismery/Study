package com.pismery.study.api.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class PeriodDemo {
    public static Period getLivedDays() {
        LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 1);
        LocalDate deathDay = LocalDate.of(2090, Month.JANUARY, 1);

        return Period.between(birthday,deathDay); //36525
    }
}
