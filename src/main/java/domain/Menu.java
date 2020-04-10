package domain;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    private static int getNumberValue(String input) {
        int inputValue;
        try {
            inputValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("> 존재하지 않는 메뉴 번호를 입력하였습니다.");
        }
        return inputValue;
    }

    public boolean isSameNumber(String input) {
        int inputValue = getNumberValue(input);

        return this.number == inputValue;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
