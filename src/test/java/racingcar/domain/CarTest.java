package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 생성자_이름_빈값이면_예외() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성자_이름_6자만_예외() {
        assertThatThrownBy(() -> new Car("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move_호출시_position_증가() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
