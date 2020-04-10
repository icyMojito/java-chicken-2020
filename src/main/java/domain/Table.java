package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Table {
    private static final int DISCOUNT_CHICKEN_COUNT = 10;
    private static final int DISCOUNT_PRICE = 10000;

    private final int number;
    private Map<Menu, MenuCount> menus = new HashMap<>();

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

    public Map<Menu, MenuCount> getMenus() {
        return Collections.unmodifiableMap(this.menus);
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        int price = 0;
        for (Menu menu : this.menus.keySet()) {
            price += this.menus.get(menu).getCount() * menu.getPrice();
        }
        return price - getDiscountValue();
    }

    private int getDiscountValue() {
        int discountValue = 0;

        for (Menu menu : this.menus.keySet()) {
            if (menu.isChicken()) {
                int menuCountValue = this.menus.get(menu).getCount();
                discountValue += (menuCountValue / DISCOUNT_CHICKEN_COUNT) * DISCOUNT_PRICE;
            }
        }

        return discountValue;
    }

    public double getCashDiscountedPrice() {
        return getPrice() * 0.95;
    }

    public void completePay() {
        this.menus = new HashMap<>();
    }
}
