import java.util.List;
import java.util.stream.Collectors;

public class Util {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력하셔야 합니다.";

    public static String listToStringByCommaWithNaturalOrdered(List<String> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.joining(","));
    }

    public static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
