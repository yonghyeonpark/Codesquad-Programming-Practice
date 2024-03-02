import java.util.Scanner;

public class InputView {

    private static final String INPUT_NOTIFICATION_MESSAGE = "> 지구날짜는? ";

    public String readDate() {
        System.out.print(INPUT_NOTIFICATION_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
