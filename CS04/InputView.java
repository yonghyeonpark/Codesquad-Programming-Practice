import java.util.Scanner;

public class InputView {

    public String[] readConditions() {
        Scanner sc = new Scanner(System.in);
        // 쉼표외의 공백들은 무시하도록 설정
        return sc.nextLine().split(",\\s*", 2);
    }
}
