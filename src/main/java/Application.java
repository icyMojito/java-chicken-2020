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

        TableNumber tableNumber;
        while (true) {
            try {
                tableNumber = TableNumber.of(InputView.inputTableNumber());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }

        OutputView.printMenus(menus);

        if (feature.isOrder()) {
        }

        if (feature.isPay()) {
        }
    }
}
