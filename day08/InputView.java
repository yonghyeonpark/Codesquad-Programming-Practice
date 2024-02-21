import java.util.Scanner;

public class InputView {

    private static final String INPUT_INFORM_MESSAGE = "출력할 단계를 선택하세요. ";

    public int readStep() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_INFORM_MESSAGE);
        return scanner.nextInt();
    }
}
