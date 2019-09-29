package com.pismery.study.api.date;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeriodDemoTest {

    @Test
    public void getLivedDays() {
        assertThat(PeriodDemo.getLivedDays().getYears()).isEqualTo(100);
        assertThat(PeriodDemo.getLivedDays().getMonths()).isEqualTo(0);
        assertThat(PeriodDemo.getLivedDays().getDays()).isEqualTo(0);
    }

}