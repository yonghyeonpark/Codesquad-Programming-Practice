import java.util.Arrays;

public class OutputView {

    public void printClock(String[][] clock) {
        for (String[] line : clock) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println();
    }
}
