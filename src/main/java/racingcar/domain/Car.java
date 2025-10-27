package racingcar.domain;

public class Car {
    private final String name; // 자동차 이름(불변)
    private int position = 0; // 현재 전진 거리

    public Car(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(("자동차 이름은 1자 이상 5자 이하만 가능합니다."));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Car)) return false;
        Car that = (Car) o;
        return java.util.Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name);
    }
}
