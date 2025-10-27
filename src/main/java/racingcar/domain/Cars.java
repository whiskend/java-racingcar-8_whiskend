package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

// 자동차 집합 도메인: 도메인 규칙 검증, 일괄 이동, 우승자 계산 책임
public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
    }

    // 이름 목록으로 Car들을 생성하여 Cars로 감싼다.
    public static Cars fromNames(List<String> names) {
        Objects.requireNonNull(names, "자동차 이름 목록이 null일 수 없습니다.");
        List<Car> created = names.stream().map(Car::new).collect(Collectors.toList());
        return new Cars(created);
    }

    // 전진 가능하면 해당 Car를 이동시킨다.
    public void moveAll(MovementPolicy policy) {
        Objects.requireNonNull(policy, "MovementPolicy가 null일 수 없습니다.");
        for (Car car : cars) {
            if (policy.canMove()) {
                car.move();
            }
        }
    }

    // 현재 최대 position을 가진 자동차를 반환한다.
    public List<Car> getLeaders() {
        int max = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(c -> c.getPosition() == max).collect(Collectors.toList());
    }

    public List<Car> asList() {
        return cars;
    }

    private void validate(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 최소 1대 이상이어야 합니다.");
        }
        // 이름 중복 금지
        Set<String> names = new HashSet<>();
        for (Car car : cars) {
            String name = car.getName();
            if (!names.add(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다: " + name);
            }
        }
    }
}