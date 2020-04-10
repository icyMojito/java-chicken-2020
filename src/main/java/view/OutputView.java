package view;

import domain.Feature;
import domain.Menu;
import domain.MenuCount;
import domain.Table;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDER_BOTTOM_LINE = "└ ₩ ┘";

    public static void printFeatures() {
        System.out.println("## 메인화면");
        for (Feature feature : Feature.values()) {
            System.out.println(feature.getName());
        }
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printTableBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printTableBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            if (table.hasOrder()) {
                System.out.print(ORDER_BOTTOM_LINE);
            } else {
                System.out.print(BOTTOM_LINE);
            }
        }
        System.out.println();
    }

    public static void printError(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printOrders(Table table) {
        Map<Menu, MenuCount> menus = table.getMenus();

        System.out.println("메뉴 수량 금액");
        for (Menu menu : menus.keySet()) {
            System.out.print(menu.getName() + " ");
            System.out.print(menus.get(menu).getCount() + " ");
            System.out.println(menu.getPrice());
        }
        System.out.println();
    }

    public static void printPayMethod(Table table) {
        System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", table.getNumber()));
        System.out.println("## 신용카드는 1번, 현금은 2번");
    }

    public static void printPrice(Table table) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(table.getPrice() + "원");
        System.out.println();
    }

    public static void printCashDiscountedPrice(Table table) {
        System.out.println("## 최종 결제할 금액");
        System.out.printf("%d원\n", Math.round((int) table.getCashDiscountedPrice()));
        System.out.println();
    }
}
