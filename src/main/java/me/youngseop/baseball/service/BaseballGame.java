package me.youngseop.baseball.service;

import me.youngseop.baseball.code.GameStatus;
import me.youngseop.baseball.domain.BaseballComputer;
import me.youngseop.baseball.domain.BaseballNumber;
import me.youngseop.baseball.domain.GameResult;
import me.youngseop.baseball.input.BaseBallInput;

public class BaseballGame {
    private BaseBallInput input;
    private BaseballComputer computer;

    public BaseballGame() {
        this.input = new BaseBallInput();
        this.computer = new BaseballComputer();
    }

    public void run() {
        do {
            computer.reGame();
            play();
        } while (reGameCheck());
    }

    private void play() {
        BaseballNumber baseBallNumber;
        GameResult result;
        do {
            baseBallNumber = input.getBaseBallNumber();
            result = GameResult.makeAnswer(computer.getComputerNumber(), baseBallNumber);
            result.answer();
        } while (!result.isCollect());
    }

    private boolean reGameCheck() {
        GameStatus continueGameStatus;
        do {
            continueGameStatus = input.getContinueGameStatus();
        } while (!continueGameStatus.isValidInput());
        return continueGameStatus.isContinue();
    }

}
