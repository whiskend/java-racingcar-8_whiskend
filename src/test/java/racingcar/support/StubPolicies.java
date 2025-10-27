package racingcar.support;

import racingcar.domain.MovementPolicy;

public class StubPolicies {
    private StubPolicies() {}

    public static MovementPolicy alwaysMove() {
        return () -> true;
    }

    public static MovementPolicy neverMove() {
        return () -> false;
    }
}
