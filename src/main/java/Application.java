import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        while (true) {
            OutputView.printFeatures();
            Feature feature = createFeature();

            if (feature.isExit()) {
                return;
            }

            OutputView.printTables(tables);
            Table table = findTable();

            if (feature.isOrder()) {
                OutputView.printMenus(menus);
                Menu menu = findMenu();
                MenuCount menuCount = createMenuCount();
                table.saveOrder(menu, menuCount);
            }

            if (feature.isPay()) {
                OutputView.printOrders(table);
                PayMethod payMethod = findPayMethod(table);

                if (payMethod.isCash()) {
                    OutputView.printCashDiscountedPrice(table);
                } else {
                    OutputView.printPrice(table);
                }

                table.completePay();
            }
        }
    }

    private static Feature createFeature() {
        Feature feature;
        while (true) {
            try {
                feature = Feature.of(InputView.inputFeatureNumber());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return feature;
    }

    private static Table findTable() {
        Table table;
        while (true) {
            try {
                String tableNumber = InputView.inputTableNumber();
                table = TableRepository.find(tableNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return table;
    }

    private static Menu findMenu() {
        Menu menu;
        while (true) {
            try {
                String menuNumber = InputView.inputMenuNumber();
                menu = MenuRepository.find(menuNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return menu;
    }

    private static MenuCount createMenuCount() {
        MenuCount menuCount;
        while (true) {
            try {
                menuCount = new MenuCount(InputView.inputMenuCount());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return menuCount;
    }

    private static PayMethod findPayMethod(Table table) {
        PayMethod payMethod;
        while (true) {
            try {
                OutputView.printPayMethod(table);
                payMethod = PayMethod.of(InputView.inputPayMethodNumber());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return payMethod;
    }
}
