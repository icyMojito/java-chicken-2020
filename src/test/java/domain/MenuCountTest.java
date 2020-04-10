package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuCountTest {

    @ParameterizedTest
    @DisplayName("정상적인 주문 수량이 입력되면 MenuCount 클래스를 반환해야 함")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "21", "22", "50", "99"})
    void inputCorrectMenuCountThenReturnMenuCountClass(String input) {
        Assertions.assertThat(new MenuCount(input)).isInstanceOf(MenuCount.class);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 주문 수량이 입력되면 예외가 발생해야 함")
    @ValueSource(strings = {"1개", "two", "3~", "다섯개"})
    void inputNotNumberThenThrowException(String input) {
        Assertions.assertThatThrownBy(() -> new MenuCount(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("> 주문 수량은 숫자만 입력할 수 있습니다.");
    }

    @ParameterizedTest
    @DisplayName("1~99 사이가 아닌 주문 수량이 입력되면 예외가 발생해야 함")
    @ValueSource(strings = {"0", "-2", "100"})
    void inputIncorrectMenuCountThenThrowException(String input) {
        Assertions.assertThatThrownBy(() -> new MenuCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("> 주문 수량은 1 이상 99 이하여야 합니다.");
    }
}
