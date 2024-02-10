import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    // 입력 형태 : ["DGDMGG", "MGGMGG"]
    public List<String> readThrowing() {
        String s = scanner.nextLine();
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split(",\\s*");
        List<String> throwing = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            throwing.add(split[i].substring(1, split[i].length() - 1));
        }
        return throwing;
    }
}
