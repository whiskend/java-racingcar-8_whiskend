package racingcar;


import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        List<String> names = InputView.parseCarNames(carNamesInput);
        InputView.validateCarNames(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();
        int tryCount = InputView.parseTryCount(tryCountInput);
        InputView.validateTryCount(tryCount);

        new GameController().run(names, tryCount);
    }
}