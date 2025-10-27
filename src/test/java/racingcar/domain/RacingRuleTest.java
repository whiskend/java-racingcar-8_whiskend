package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.support.FixedRng;

import static org.assertj.core.api.Assertions.*;

class RacingRuleTest {

    @Test
    void 랜덤값_4_이상_전진() {
        RacingRule rule = new RacingRule(new FixedRng(4,9));
        assertThat(rule.canMove()).isTrue(); // 4
        assertThat(rule.canMove()).isTrue(); // 9
    }

    @Test
    void 랜덤값_3_이하_정지() {
        RacingRule rule = new RacingRule(new FixedRng(0, 3));
        assertThat(rule.canMove()).isFalse(); // 0
        assertThat(rule.canMove()).isFalse(); //3
    }
}
