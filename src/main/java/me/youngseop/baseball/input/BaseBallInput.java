package me.youngseop.baseball.input;

import me.youngseop.baseball.code.BaseballGameConfig;
import me.youngseop.baseball.code.GameStatus;
import me.youngseop.baseball.domain.BaseballNumber;

import java.util.Scanner;

public class BaseBallInput {
    private final BaseballGameConfig config;
    private final Scanner scanner;

    public BaseBallInput(BaseballGameConfig config) {
        this.config = config;
        this.scanner = new Scanner(System.in);
    }

    public BaseballNumber getBaseBallNumber() {

        BaseballNumber baseballNumber = new BaseballNumber(config, true);
        do {
            System.out.print("숫자를 입력해주세요 : ");
            baseballNumber.setNumber(scanner.nextLine());
        } while (baseballNumber.isInValid());
        return baseballNumber;
    }

    public GameStatus getContinueGameStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return GameStatus.of(scanner.nextLine());
    }

}
