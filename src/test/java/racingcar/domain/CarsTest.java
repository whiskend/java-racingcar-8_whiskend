package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.support.StubPolicies;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void 빈_목록이면_예외() {
        assertThatThrownBy(() -> new Cars(List.of())).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_중복이면_예외() {
        List<Car> list = List.of(new Car("pobi"), new Car("pobi"));
        assertThatThrownBy(() -> new Cars(list)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getLeaders_공동우승() {
        Cars cars = Cars.fromNames(List.of("a", "b"));
        // a만 두 번 전진, b는 한 번 전진
        cars.moveAll(StubPolicies.alwaysMove()); // a,b:1
        cars.moveAll(() -> { // a만 전진하게끔 첫 번째만 true
            boolean first = cars.asList().get(0).getPosition() == 1;
            return first;
        });
        //현재 a만 2, b는 1 -> a가 단독 우승하는 상황
        assertThat(cars.getLeaders()).extracting(Car::getName).containsExactly("a");
    }

}
