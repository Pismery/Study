package com.pismery.basic.vertify;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StaticUtilTest {

    @Mock
    StaticUtil mockUtil;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @Ignore
    public void max() {
        int methodCall = mockUtil._max(any(), any());
        when(methodCall).thenReturn(10);

        Assertions.assertThat(StaticUtil.max(1, 2)).isEqualTo(10);

    }

}