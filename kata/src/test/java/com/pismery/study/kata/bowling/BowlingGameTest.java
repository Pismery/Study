package com.pismery.study.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void initGame() {
        game = new BowlingGame();
    }

    @Test
    public void rollAllZero() {
        rollMany(0,20);
        assertEquals(0, game.getScore());
    }

    @Test
    public void rollAllOne() {
        rollMany(1,20);
        assertEquals(20,game.getScore());
    }

    @Test
    public void rollOneSpare() {
        rollSpare();
        rollMany(1,17);

        assertEquals(33,game.getScore());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
    }

    @Test
    public void rollLastFrameSpare() {
        rollMany(1,18);
        rollSpare();

        assertEquals(31,game.getScore());
    }
    
    
    @Test
    public void rollOneStrike() {
        rollStrike();
        rollMany(1,16);

        assertEquals(38,game.getScore());
    }

    private void rollStrike() {
        game.roll(10);
        game.roll(3);
        game.roll(3);
    }

    @Test
    public void rollLastFrameStrike() {
        rollMany(1,18);
        rollStrike();

        assertEquals(34,game.getScore());
    }

    private void rollMany(int pins,int rollNumber) {
        for (int i = 0; i < rollNumber; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void rollAllStrike() {
        rollMany(10,12);
        assertEquals(300,game.getScore());
    }
}