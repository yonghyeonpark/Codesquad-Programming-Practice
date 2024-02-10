public class Condition {

    private static final String CONDITION_FORMAT_ERROR_MESSAGE = "[ERROR] 올바른 형식의 조건을 입력하셔야 합니다. (예시 - 201508,5)";
    private static final String DATE_FORMAT_ERROR_MESSAGE = "[ERROR] 올바른 형식의 날짜를 입력하셔야 합니다. (예시 - 202202)";
    private static final String DATE_RANGE_ERROR_MESSAGE = "[ERROR] 연도의 범위는 1900 ~ 2023, 월의 범위는 1 ~ 12입니다. (2023년의 경우 5월까지만 입력 가능합니다.)";
    private static final String PASSENGER_NUMBER_ERROR_MESSAGE = "[ERROR] 승객 수는 1 ~ 45명까지 가능합니다.";

    private final String[] conditions;

    public Condition(String[] conditions) {
        validateDate(conditions[0]);
        validatePassengerNumber(conditions[1]);
        this.conditions = conditions;
    }

    private void validateDate(String dateS) {
        if (dateS.length() != 6) {
            throw new IllegalArgumentException(DATE_FORMAT_ERROR_MESSAGE);
        }
        int dateI = Util.stringToInt(dateS);
        int year = dateI / 100;
        int month = dateI % 100;

        if (year < 1900 || year > 2023 || month < 1 || month > 12) {
            throw new IllegalArgumentException(DATE_RANGE_ERROR_MESSAGE);
        }
        if (year == 2023 && month > 5) {
            throw new IllegalArgumentException(DATE_RANGE_ERROR_MESSAGE);
        }
    }

    private void validatePassengerNumber(String passengerNumberS) {
        int passengerNumberI = Util.stringToInt(passengerNumberS);
        if (passengerNumberI < 1 || passengerNumberI > 45) {
            throw new IllegalArgumentException(PASSENGER_NUMBER_ERROR_MESSAGE);
        }
    }

    public String[] getConditions() {
        return conditions;
    }
}
