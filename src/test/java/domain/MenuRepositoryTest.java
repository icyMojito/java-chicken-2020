package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuRepositoryTest {

    @ParameterizedTest
    @DisplayName("정상적인 메뉴 번호가 입력되면 Menu 클래스를 반환해야 함")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "21", "22"})
    void inputCorrectMenuNumberThenReturnMenuClass(String input) {
        Assertions.assertThat(MenuRepository.find(input)).isInstanceOf(Menu.class);
    }

    @ParameterizedTest
    @DisplayName("비정상적인 메뉴 번호가 입력되면 예외가 발생해야 함")
    @ValueSource(strings = {"후라이드", "3번 메뉴", "아무거나", "?", "chicken", "#21", "0", "7", "10"})
    void inputIncorrectMenuNumberThenThrowException(String input) {
        Assertions.assertThatThrownBy(() -> MenuRepository.find(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("> 존재하지 않는 메뉴 번호를 입력하였습니다.");
    }
}
