package me.youngseop.baseball.domain;

import me.youngseop.baseball.code.BallType;

public class GameResult {
    int strike = 0;
    int ball = 0;
    int out = 0;

    public void answer() {
        if (strike == 3) {
            log("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return;
        }
        if (out == 3) {
            log("3 아웃 입니다.");
            return;
        }
        log(makeMessage());
    }

    private String makeMessage() {
        String result = "";
        if (strike > 0)
            result += String.format("%d 스트라이크", strike);
        if (ball > 0)
            result += String.format(" %d 볼", ball);
        return result.trim();
    }

    public boolean isCollect() {
        return strike == 3;
    }

    public static GameResult makeAnswer(BaseballNumber computer, BaseballNumber input) {
        GameResult result = new GameResult();
        int index = 0;
        for (Integer number : computer.getNumbers()) {
            BallType strikeBall = BallType.getStrikeBall(input, index, number);
            fix(result, strikeBall);
            index++;
        }
        return result;
    }

    private static void fix(GameResult result, BallType strikeBall) {
        if (strikeBall.isStrike()) {
            result.addStrike();
        } else if (strikeBall.isBall()) {
            result.addBall();
        } else {
            result.addOut();
        }
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public void addOut() {
        this.out++;
    }

    private void log(String string) {
        System.out.println(string);
    }

}
