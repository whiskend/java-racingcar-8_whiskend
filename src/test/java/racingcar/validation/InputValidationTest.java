package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputValidationTest {

    @Test
    @DisplayName("이름 파싱: 쉼표 분리 + trim")
    void parseCarNames() {
        List<String> names = InputView.parseCarNames("  pobi , woni,  jun  ");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("이름 검증: 빈 문자열/6자 이상 예외")
    void validateCarNames() {
        assertThatThrownBy(() ->
                InputView.validateCarNames(List.of("pobi", ""))
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                InputView.validateCarNames(List.of("abcdef"))
                ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수 파싱: 정수 외 입력 예외")
    void parseTryCount() {
        assertThat(InputView.parseTryCount(" 5 ")).isEqualTo(5);
        assertThatThrownBy(() -> InputView.parseTryCount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수 검증: 1 미만 예외")
    void validateTryCount() {
        assertThatThrownBy(() -> InputView.validateTryCount(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputView.validateTryCount(-2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}