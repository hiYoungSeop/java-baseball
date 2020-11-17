package me.youngseop.baseball.service;

import me.youngseop.baseball.code.BaseballGameConfig;
import me.youngseop.baseball.code.GameStatus;
import me.youngseop.baseball.domain.BaseballComputer;
import me.youngseop.baseball.domain.BaseballNumber;
import me.youngseop.baseball.domain.GameResult;
import me.youngseop.baseball.input.BaseBallInput;

public class BaseballGame {
    private final BaseBallInput input;
    private final BaseballComputer computer;
    private final GameResult gameResult;

    public BaseballGame(BaseballGameConfig config) {
        this.input = new BaseBallInput(config);
        this.computer = new BaseballComputer(config);
        this.gameResult = new GameResult(config);
    }

    public void run() {
        do {
            computer.reGame();
            play();
        } while (reGameCheck());
    }

    private void play() {
        do {
            BaseballNumber baseBallNumber = input.getBaseBallNumber();
            gameResult.scoring(computer.getComputerNumber(), baseBallNumber);
            gameResult.printAnswer();
        } while (gameResult.isNotCollect());
    }

    private boolean reGameCheck() {
        GameStatus continueGameStatus;
        do {
            continueGameStatus = input.getContinueGameStatus();
        } while (continueGameStatus.isInValidInput());
        return continueGameStatus.isContinue();
    }

}
