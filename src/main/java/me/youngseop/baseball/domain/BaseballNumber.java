package me.youngseop.baseball.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.String.format;

public class BaseballNumber {
    private final Set<Integer> numbers = new LinkedHashSet<>();

    private final boolean validate;

    public static BaseballNumber of(int number, boolean isLogged) {
        return new BaseballNumber(String.valueOf(number), isLogged);
    }

    public static BaseballNumber of(String numberStr, boolean isLogged) {
        return new BaseballNumber(numberStr, isLogged);
    }

    public BaseballNumber(String numberStr, boolean isLogged) {
        validate = isInputValidate(numberStr, isLogged);
        if (!validate)
            return;
        numbers.clear();
        for (int i = 0; i < numberStr.length(); i++) {
            String tmpNum = numberStr.substring(i, i + 1);
            int num = Integer.parseInt(tmpNum);
            numbers.add(num);
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public boolean isInValid(boolean isLogged) {
        if (!validate) {
            return true;
        }
        if (numbers.size() != 3) {
            log("중복된 수는 입력할 수 없습니다.", isLogged);
            return true;
        }
        return false;
    }

    private boolean isInputValidate(String numberStr, boolean isLogged) {
        if (numberStr.length() != 3) {
            log(format("3자리 정수가 아닙니다[%s]", numberStr), isLogged);
            return false;
        }
        return true;
    }

    private void log(String string, boolean isLogged) {
        if(isLogged)
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
