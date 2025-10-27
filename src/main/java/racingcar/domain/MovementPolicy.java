package racingcar.domain;

// 전진 여부를 결정하는 인터페이스
@FunctionalInterface
public interface MovementPolicy {
    boolean canMove();
}
