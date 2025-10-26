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
}