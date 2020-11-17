package me.youngseop.baseball.code;

public enum GameStatus {
    CONTINUE, EXIT, UNKNOWN;

    public static GameStatus of(String input) {
        if ("1".equals(input)) {
            return CONTINUE;
        }
        if ("2".equals(input)) {
            return EXIT;
        }
        return UNKNOWN;
    }

    public boolean isInValidInput() {
        boolean inValid = this == UNKNOWN;
        if(inValid) {
            System.out.println("잘못 입력 하셨습니다. 다시 입력해 주세요");
        }
        return inValid;
    }

    public boolean isContinue() {
        return this == CONTINUE;
    }
}
