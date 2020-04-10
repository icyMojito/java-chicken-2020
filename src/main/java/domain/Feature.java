package domain;

import java.util.Arrays;

import static util.NullValidator.validateNull;

public enum Feature {
    ORDER("1", "주문등록"),
    PAY("2", "결제하기"),
    EXIT("3", "프로그램 종료");

    private final String number;
    private final String featureName;

    Feature(String number, String featureName) {
        this.number = number;
        this.featureName = featureName;
    }

    public static Feature of(String input) {
        validateNull(input);

        return Arrays.stream(values())
                .filter(v -> v.isEqualTo(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("> 잘못된 기능 번호를 입력하였습니다."));
    }

    private boolean isEqualTo(String input) {
        return this.number.equals(input);
    }

    public boolean isOrder() {
        return this == ORDER;
    }

    public boolean isPay() {
        return this == PAY;
    }

    public boolean isExit() {
        return this == EXIT;
    }

    public String getName() {
        return this.number + " - " + this.featureName;
    }
}
