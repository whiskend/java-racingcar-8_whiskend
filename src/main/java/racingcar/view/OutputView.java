package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRound(Cars cars) {
        for (Car car : cars.asList()) {
            String bar = "-".repeat(Math.max(0, car.getPosition()));
            System.out.println(car.getName() + " : " + bar);
        }
    }

    public static void printWinners(List<Car> winners) {
        String names = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + names);
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
