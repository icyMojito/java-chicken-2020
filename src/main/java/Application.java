import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView.printFeatures();
        Feature feature;

        while (true) {
            try {
                feature = Feature.of(InputView.inputFeatureNumber());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }

        if (feature.isExit()) {
            return;
        }

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final List<Menu> menus = MenuRepository.menus();

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

        OutputView.printMenus(menus);

        if (feature.isOrder()) {
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

            MenuCount menuCount;
            while (true) {
                try {
                    menuCount = new MenuCount(InputView.inputMenuCount());
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.printError(e.getMessage());
                }
            }

            table.saveOrder(menu, menuCount);
        }

        if (feature.isPay()) {
        }
    }
}
