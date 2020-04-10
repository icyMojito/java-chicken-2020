package domain;

import java.util.Arrays;

import static util.NullValidator.validateNull;

public enum PayMethod {
    CARD("1"),
    CASH("2");

    private final String number;

    PayMethod(String number) {
        this.number = number;
    }

    public static PayMethod of(String input) {
        validateNull(input);

        return Arrays.stream(values())
                .filter(v -> v.isEqualTo(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("> 잘못된 결제 수단 번호를 입력하였습니다."));
    }

    private boolean isEqualTo(String input) {
        return this.number.equals(input);
    }

    public boolean isCash() {
        return this == CASH;
    }
}
