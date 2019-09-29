package com.pismery.study.api.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterDemo {

    public static void main(String[] args) {
        nextWorkDate();
    }

    private static void nextWorkDate() {
        LocalDate today = LocalDate.now();
        TemporalAdjuster nextWorkingDayAdjuster = TemporalAdjusters.ofDateAdjuster(localDate -> {
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                return localDate.plusDays(3);
            } else if (dayOfWeek == DayOfWeek.SATURDAY) {
                return localDate.plusDays(2);
            }
            return localDate.plusDays(1);
        });
        System.out.println(today.with(nextWorkingDayAdjuster));
    }

}
