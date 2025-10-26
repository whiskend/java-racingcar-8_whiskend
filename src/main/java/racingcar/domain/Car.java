package racingcar.domain;

public class Car {
    private final String name; // 자동차 이름(불변)
    private int position = 0; // 현재 전진 거리

    public Car(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        this.name = name;
    }

    public void move() { // 규칙에 의해 전진 조건이 참일 때 호출
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
