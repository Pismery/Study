package com.pismery.study.api.date;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DurationDemoTest {

    @Test
    public void getLivedDays() {
        assertThat(DurationDemo.getLivedDays()).isEqualTo(36525L);
    }

}