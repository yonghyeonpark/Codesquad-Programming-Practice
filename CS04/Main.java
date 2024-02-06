import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String EXTINCTION = "*";
    private static final String UNABLE_BOARD_INFORMATION_MESSAGE = "!! 탑승할 수 있는 차량이 존재하지 않습니다.";

    public static void main(String[] args) {
        // 올바른 입력이 들어올 때까지 반복
        while (true) {
            try {
                InputView inputView = new InputView();
                Condition condition = new Condition(inputView.readConditions());
                String result = solution(condition.getConditions()[0], condition.getConditions()[1]);

                if (result.isEmpty()) {
                    System.out.println(UNABLE_BOARD_INFORMATION_MESSAGE);
                    return;
                }
                System.out.println(result);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String solution(String inputDate, String inputPassengerNumber) {
        int date = Util.stringToInt(inputDate);
        int passengerNumber = Util.stringToInt(inputPassengerNumber);

        List<String> result = new ArrayList<>();

        for (Car car : Car.values()) {
            if (isValidPassengerNumber(car, passengerNumber) && isValidDate(car, date)) {
                if (car.isExtinction()) {
                    result.add(car.getName() + EXTINCTION + car.getType());
                }
                if (!car.isExtinction()) {
                    result.add(car.getName() + car.getType());
                }
            }
        }
        return Util.listToStringByCommaWithNaturalOrdered(result);
    }

    private static boolean isValidPassengerNumber(Car car, int passengerNumber) {
        if (passengerNumber <= car.getPassengerNumber()) {
            return true;
        }
        return false;
    }

    private static boolean isValidDate(Car car, int date) {
        if (date >= car.getProductionStart() && date <= car.getProductionEnd()) {
            return true;
        }
        return false;
    }
}
