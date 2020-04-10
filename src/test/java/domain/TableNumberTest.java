package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TableNumberTest {

    @ParameterizedTest
    @DisplayName("정상적인 테이블 번호가 입력되면 TableNumber 클래스를 반환해야 함")
    @ValueSource(strings = {"1", "2", "3", "5", "6", "8"})
    void inputCorrectNumberThenReturnTableNumberClass(String input) {
        Assertions.assertThat(TableNumber.of(input)).isInstanceOf(TableNumber.class);
    }

    @ParameterizedTest
    @DisplayName("존재하지 않거나 비정상적인 테이블 번호가 입력되면 예외가 발생해야 함")
    @ValueSource(strings = {"4", "1번 테이블", "9", "0!", "마지막 테이블임", "#5"})
    void inputIncorrectTableNumberThenThrowException(String input) {
        Assertions.assertThatThrownBy(() -> TableNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("> 존재하지 않는 테이블 번호를 입력하였습니다.");
    }
}
