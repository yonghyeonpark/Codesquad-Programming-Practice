import java.util.Scanner;

public class InputView {

    public String[] readCoordinates() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("좌표를 입력하세요");
        return scanner.nextLine().split("-");
    }
}
