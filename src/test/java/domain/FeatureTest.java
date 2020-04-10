package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FeatureTest {

    @ParameterizedTest
    @DisplayName("정상적인 기능 번호가 입력되면 Feature 클래스를 반환해야 함")
    @ValueSource(strings = {"1", "2", "3"})
    void inputCorrectNumberThenReturnFeatureClass(String input) {
        Assertions.assertThat(Feature.of(input)).isInstanceOf(Feature.class);
    }

    @ParameterizedTest
    @DisplayName("비정상적인 기능 번호가 입력되면 예외가 발생해야 함")
    @ValueSource(strings = {"결제하기", "1번", "pay", "2!", "주문할래", "."})
    void inputIncorrectNumberThenThrowException(String input) {
        Assertions.assertThatThrownBy(() -> Feature.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("> 잘못된 기능 번호를 입력하였습니다.");
    }
}
