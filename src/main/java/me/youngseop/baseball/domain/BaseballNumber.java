package me.youngseop.baseball.domain;

import me.youngseop.baseball.code.BaseballGameConfig;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.String.format;

public class BaseballNumber {
    private final BaseballGameConfig config;
    private final Set<Integer> numbers;

    private boolean validate;
    private final boolean logged;

    public BaseballNumber(BaseballGameConfig config, boolean logged) {
        this.config = config;
        this.numbers = new LinkedHashSet<>();
        this.logged = logged;
    }

    public void setNumber(int number) {
        setNumber(String.valueOf(number));
    }

    public void setNumber(String numberStr) {
        validate = isInputValidate(numberStr);
        if (validate)
            refreshNumbers(numberStr);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public boolean isInValid() {
        return !validate;
    }

    private void refreshNumbers(String numberStr) {
        numbers.clear();
        for (int i = 0; i < numberStr.length(); i++) {
            String tmpNum = numberStr.substring(i, i + 1);
            int num = Integer.parseInt(tmpNum);
            numbers.add(num);
        }
        if (numbers.size() != config.getSize()) {
            log("중복된 수는 입력할 수 없습니다.");
            validate = false;
        }
    }

    private boolean isInputValidate(String numberStr) {
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            log("숫자만 입력 가능 합니다.");
            return false;
        }
        if (numberStr.length() != config.getSize()) {
            log(format("%d자리 정수가 아닙니다[%s]", config.getSize(), numberStr));
            return false;
        }
        return true;
    }

    private void log(String string) {
        if (logged)
            System.out.println(string);
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (Integer number : numbers) {
            tmp.append(number.toString());
        }
        return tmp.toString();
    }
}
