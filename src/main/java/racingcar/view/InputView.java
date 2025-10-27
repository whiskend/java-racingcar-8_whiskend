package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputView(){
    }

    public static List<String> parseCarNames(String input) {
        if (input == null) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        return Arrays.stream(input.split(",")).map(String::trim).collect(Collectors.toList());
    }

    public static void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 1개 이상이어야 합니다.");
        }
        for (String name : carNames) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 . 없습니다.");
            }
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    public static int parseTryCount (String input) {
        if (input == null) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
        final String trimmed = input.trim();
        try{
            return Integer.parseInt(trimmed);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}