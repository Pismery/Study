package com.pismery.study.kata.bowling;

public class BowlingGame {

    private int[] rollPins = new int[21];
    private int currentIndex = 0;

    public void roll(int pins) {
        rollPins[currentIndex++] = pins;
    }

    public int getScore() {
        int score = 0;
        int index = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(index)) {
                score = addSpareScore(score, index);
                index += 2;
                continue;
            }
            if (isStrike(index)) {
                score = addStrikeScore(score, index);
                index += 1;
                continue;
            }
            score = addNoramlFrameScore(score, index);
            index += 2;
        }

        return score;
    }

    private int addNoramlFrameScore(int score, int index) {
        score += rollPins[index] + rollPins[index + 1];
        return score;
    }

    private int addStrikeScore(int score, int index) {
        score += 10 + rollPins[index + 1] + rollPins[index + 2];
        return score;
    }

    private int addSpareScore(int score, int index) {
        score += 10 + rollPins[index + 2];
        return score;
    }

    private boolean isStrike(int index) {
        return rollPins[index] == 10;
    }

    private boolean isSpare(int index) {
        return rollPins[index] + rollPins[index + 1] == 10;
    }

}
