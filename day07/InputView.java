import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] readCommands() {
        String input = scanner.nextLine();
        return input.substring(1, input.length() - 1)
                .split(",\\s*");
    }
}
