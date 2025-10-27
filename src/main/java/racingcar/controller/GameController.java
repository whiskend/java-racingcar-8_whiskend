package racingcar.controller;

import racingcar.domain.*;
import racingcar.infra.MissionUtilsRandomGenerator;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    public void run(List<String> names, int tryCount) {
        Cars cars = Cars.fromNames(names);
        RandomNumberGenerator rng = new MissionUtilsRandomGenerator();
        MovementPolicy policy = new RacingRule(rng);
        Race race = new Race(cars, policy, tryCount);

        // 출력 헤더
        OutputView.printResultHeader();

        // 라운드 진행 + 라운드별 결과 출력
        while (!race.isFinished()) {
            race.playRound();
            OutputView.printRound(race.getCars());
            OutputView.printBlankLine();
        }

        // 최중 우승자 출력
        OutputView.printWinners(race.getWinners());
    }
}
