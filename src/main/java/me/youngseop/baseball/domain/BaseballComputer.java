package me.youngseop.baseball.domain;

import me.youngseop.baseball.code.BaseballGameConfig;

import java.util.Random;

public class BaseballComputer {
    private final BaseballGameConfig config;
    private final Random random;
    private BaseballNumber computerNumber;

    public BaseballComputer(BaseballGameConfig config) {
        this.config = config;
        this.random = new Random();
    }

    public void reGame() {
        computerNumber = newNumber();
    }

    private BaseballNumber newNumber() {
        BaseballNumber baseballNumber = new BaseballNumber(config, false);
        do {
            baseballNumber.setNumber( getRandomNumber());
        } while (baseballNumber.isInValid());
        System.out.println("[DEBUG] CREATED NUMBER : " + baseballNumber.toString());
        return baseballNumber;
    }

    private int getRandomNumber() {
        return random.nextInt(config.getNextInt()) + config.getStart();
    }

    public BaseballNumber getComputerNumber() {
        return computerNumber;
    }
}
