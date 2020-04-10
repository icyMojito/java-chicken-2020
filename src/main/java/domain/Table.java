package domain;

import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, MenuCount> menus;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
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

    public boolean isSameNumber(String input) {
        int inputValue = getNumberValue(input);

        return this.number == inputValue;
    }

    public void saveOrder(Menu menu, MenuCount menuCount) {
        this.menus.put(menu, menuCount);
    }

    public boolean hasOrder() {
        return this.menus.size() != 0;
    }
}
