package me.youngseop;

import me.youngseop.baseball.service.BaseballGame;

import static me.youngseop.baseball.code.BaseballGameConfig.THREE_DIGITS;

public class BaseballGameApp {
    public static void main(String[] args) {
        //THREE_DIGITS, FOUR_DIGITS
        BaseballGame baseBallGame = new BaseballGame(THREE_DIGITS);
        baseBallGame.run();
    }
}
