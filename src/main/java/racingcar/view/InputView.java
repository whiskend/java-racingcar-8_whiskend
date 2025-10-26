package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputView(){
    }

    public static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).collect(Collectors.toList());
    }

    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 . 없습니다.");
            }
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }
}