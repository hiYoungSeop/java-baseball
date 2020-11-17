package me.youngseop.baseball.code;

import me.youngseop.baseball.domain.BaseballNumber;

import java.util.Set;

public enum BallType {
    STRIKE, BALL, OUT;

    public static BallType getStrikeBall(Set<Integer> numbers, int idx, Integer checkNumber) {
        int checkIdx = 0;
        for (Integer number : numbers) {
            if (number.equals(checkNumber))
                return getStrikeBall(idx, checkIdx);
            checkIdx++;
        }
        return OUT;
    }

    private static BallType getStrikeBall(int idx, int checkIdx) {
        if (idx == checkIdx) return STRIKE;
        return BALL;
    }

    public boolean isBall() {
        return this == BALL;
    }


    public boolean isStrike() {
        return this == STRIKE;
    }
}
