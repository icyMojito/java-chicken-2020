package domain;

import static util.NullValidator.validateNull;

public class MenuCount {
    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 99;

    private final int count;

    public MenuCount(String count) {
        validateNull(count);
        validateNumberFormat(count);
        validateRange(count);

        this.count = Integer.parseInt(count);
    }

    private void validateNumberFormat(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("> 주문 수량은 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateRange(String count) {
        int countValue = Integer.parseInt(count);
        if (countValue < MIN_COUNT || MAX_COUNT < countValue) {
            throw new IllegalArgumentException("> 주문 수량은 1 이상 99 이하여야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
