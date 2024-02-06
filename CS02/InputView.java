import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    private Scanner scanner;

    public List<ArrayList<Integer>> readArray() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringTokenizer st = Util.splitString(input);

        int size = st.countTokens();
        int round = size / 7;

        List<ArrayList<Integer>> gameStatus = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            gameStatus.add(new ArrayList<>());
        }

        int a = 0;
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i != 0 && i % 7 == 0) {
                a++;
            }
            gameStatus.get(a).add(num);
        }
        return gameStatus;
    }
}
