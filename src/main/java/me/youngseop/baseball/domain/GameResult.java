package me.youngseop.baseball.domain;

import me.youngseop.baseball.code.BallType;
import me.youngseop.baseball.code.BaseballGameConfig;

import java.util.Set;

import static java.lang.String.format;

public class GameResult {
    private final BaseballGameConfig config;
    int strike;
    int ball;
    int out;

    public GameResult(BaseballGameConfig config) {
        this.config = config;
        resetBallType();
    }

    public void answer() {
        int size = config.getSize();
        if (strike == size) {
            log(format("%d개의 숫자를 모두 맞히셨습니다! 게임종료", size));
            return;
        }
        if (out == size) {
            log(format("%d 아웃", size));
            return;
        }
        log(makeMessage());
    }

    public void makeAnswer(BaseballNumber computer, BaseballNumber input) {
        int idx = 0;
        Set<Integer> inputNumbers = input.getNumbers();
        resetBallType();
        for (Integer checkNumber : computer.getNumbers()) {
            BallType strikeBall = BallType.getStrikeBall(inputNumbers, idx, checkNumber);
            addBallType(strikeBall);
            idx++;
        }
    }

    public boolean isNotCollect() {
        return strike != config.getSize();
    }

    private void resetBallType() {
        this.strike = 0;
        this.ball = 0;
        this.out = 0;
    }

    private void addBallType(BallType strikeBall) {
        if (strikeBall.isStrike()) {
            this.strike++;
        } else if (strikeBall.isBall()) {
            this.ball++;
        } else {
            this.out++;
        }
    }

    private String makeMessage() {
        String result = "";
        if (strike > 0)
            result += format("%d 스트라이크", strike);
        if (ball > 0)
            result += format(" %d 볼", ball);
        return result.trim();
    }

    private void log(String string) {
        System.out.println(string);
    }

}
