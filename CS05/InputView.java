import java.io.InputStreamReader;
import java.util.Scanner;

public class InputView {

    private static final String PLAYER_COUNT_INPUT_MESSAGE = "플레이어 수를 입력해주세요. ";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력하셔야 합니다.";
    private static final String CHOICE_FORMAT_ERROR_MESSAGE = "[ERROR] max 혹은 min을 입력하셔야 합니다.";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(new InputStreamReader(System.in));
    }

    public int readPlayerCount() {
        try {
            System.out.print(PLAYER_COUNT_INPUT_MESSAGE);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public String readChoiceOfPlayer() {
        String choice = scanner.nextLine();
        if (!choice.equals("max") && !choice.equals("min")) {
            throw new IllegalArgumentException(CHOICE_FORMAT_ERROR_MESSAGE);
        }
        return choice;
    }
}
