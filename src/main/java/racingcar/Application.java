package racingcar;


import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        List<String> carNames = InputView.parseCarNames(carNamesInput);
        InputView.validateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberOccurrences = Console.readLine();

        System.out.println("\n실행 결과");
    }
}