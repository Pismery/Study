package com.pismery.study.algorithm;

import com.pismery.study.algorithm.Score2Rank;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pismery on 2018-03-25.
 */
public class Score2RankTest {

    @Test
    public void test01() {

        assertEquals("E", Score2Rank.getRank(0));
        assertEquals("E",Score2Rank.getRank(59));
        assertEquals("D",Score2Rank.getRank(60));
        assertEquals("D",Score2Rank.getRank(61));


        assertEquals("D", Score2Rank.getRank(69));
        assertEquals("C", Score2Rank.getRank(70));
        assertEquals("C", Score2Rank.getRank(71));


        assertEquals("C", Score2Rank.getRank(79));
        assertEquals("B", Score2Rank.getRank(80));
        assertEquals("B", Score2Rank.getRank(81));


        assertEquals("B", Score2Rank.getRank(89));
        assertEquals("A", Score2Rank.getRank(90));
        assertEquals("A", Score2Rank.getRank(91));
        assertEquals("A", Score2Rank.getRank(100));

    }

}
