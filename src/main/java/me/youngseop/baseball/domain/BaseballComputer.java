package me.youngseop.baseball.domain;

import me.youngseop.baseball.code.BaseballGameConfig;

import java.util.Random;

public class BaseballComputer {
    private final BaseballGameConfig config = BaseballGameConfig.NUMBER3;
    private final Random random = new Random();
    private BaseballNumber computerNumber;

    public void reGame() {
        computerNumber = newNumber();
    }

    private BaseballNumber newNumber() {
        BaseballNumber baseballNumber;
        do {
            baseballNumber = BaseballNumber.of(getRandomNumber(), false);
        } while (baseballNumber.isInValid(false));
        System.out.println("(debug)CREATE NUMBER : " + baseballNumber.toString());
        return baseballNumber;
    }

    private int getRandomNumber() {
        return random.nextInt(config.getNextInt()) + config.getStart();
    }

    public BaseballNumber getComputerNumber() {
        return computerNumber;
    }
}
