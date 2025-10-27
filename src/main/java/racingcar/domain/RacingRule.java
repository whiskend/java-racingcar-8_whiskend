package racingcar.domain;

public class RacingRule implements MovementPolicy {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int THRESHOLD = 4;

    private final RandomNumberGenerator rng;

    public RacingRule(RandomNumberGenerator rng) {
        if (rng == null) {
            throw new IllegalArgumentException("RandomNumberGenerator는 null일 수 없습니다.");
        }
        this.rng = rng;
    }

    @Override
    public boolean canMove() {
        int value = rng.nextInt(MIN, MAX);
        return value >= THRESHOLD;
    }
}