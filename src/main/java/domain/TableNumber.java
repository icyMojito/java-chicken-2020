package domain;

import java.util.Arrays;

public enum TableNumber {
    ONE(1),
    TWO(2),
    THREE(3),
    FIVE(5),
    SIX(6),
    EIGHT(8);

    private final int number;

    TableNumber(int number) {
        this.number = number;
    }

    public static TableNumber of(String input) {
        int inputValue = getNumberValue(input);

        return Arrays.stream(values())
                .filter(v -> v.isEqualTo(inputValue))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("> 존재하지 않는 테이블 번호를 입력하였습니다."));
    }

    private static int getNumberValue(String input) {
        int inputValue;
        try {
            inputValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("> 존재하지 않는 테이블 번호를 입력하였습니다.");
        }
        return inputValue;
    }

    private boolean isEqualTo(int input) {
        return this.number == input;
    }
}
