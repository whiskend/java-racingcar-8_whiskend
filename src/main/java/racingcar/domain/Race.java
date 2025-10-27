package racingcar.domain;

import java.util.List;
import java.util.Objects;

// 라운드 진행 및 우승자 계산을 담당하는 도메인
public class Race {
    private final Cars cars;
    private final MovementPolicy policy;
    private final int totalRounds;
    private int playedRounds = 0;

    public Race(Cars cars, MovementPolicy policy, int totalRounds) {
        if (totalRounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }
        this.cars = Objects.requireNonNull(cars, "Cars는 null일 수 없습니다.");
        this.policy = Objects.requireNonNull(policy, "MovementPolicy는 null일 수 없습니다.");
        this.totalRounds = totalRounds;
    }

    public void playRound() {
        cars.moveAll(policy);
        playedRounds++;
    }

    public boolean isFinished() {
        return playedRounds >= totalRounds;
    }

    // 공동 우승 가능
    public List<Car> getWinners() {
        return cars.getLeaders();
    }

    // 출력용 접근자
    public Cars getCars() {
        return cars;
    }

}
