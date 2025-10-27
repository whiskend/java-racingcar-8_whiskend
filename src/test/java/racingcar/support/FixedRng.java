package racingcar.support;

import racingcar.domain.RandomNumberGenerator;

public class FixedRng implements RandomNumberGenerator {
    private final int[] values;
    private int idx = 0;

    public FixedRng(int... values) {
        this.values = values;
    }

    @Override
    public int nextInt(int minInclusive, int maxInclusive) {
        int v = values[idx % values.length];
        idx++;
        return v;
    }
}
