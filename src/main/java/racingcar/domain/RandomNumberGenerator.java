package racingcar.domain;

@FunctionalInterface
public interface RandomNumberGenerator {
    int nextInt(int minInclusive, int maxInclusive);
}
