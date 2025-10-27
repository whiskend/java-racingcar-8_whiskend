package racingcar.infra;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RandomNumberGenerator;

// camp.nextstep.edu.missionutils.Randoms에 대한 어댑터 역할
public class MissionUtilsRandomGenerator implements RandomNumberGenerator {

    @Override
    public int nextInt(int minInclusive, int maxInclusive) {
        // [0,9] 범위 사용
        return Randoms.pickNumberInRange(minInclusive, maxInclusive);
    }
}
