package me.youngseop.baseball.input;

import me.youngseop.baseball.code.GameStatus;
import me.youngseop.baseball.domain.BaseballNumber;

import java.util.Scanner;

public class BaseBallInput {
    private final Scanner scanner = new Scanner(System.in);

    public BaseballNumber getBaseBallNumber() {

        BaseballNumber baseballNumber;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            baseballNumber = BaseballNumber.of(scanner.nextLine(), true);
        } while (baseballNumber.isInValid(true));
        return baseballNumber;
    }

    public GameStatus getContinueGameStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return GameStatus.of(scanner.nextLine());
    }

    private String input() {
        System.out.println("번호를 입력해 주세요 : ");
        return scanner.nextLine();
    }

}
