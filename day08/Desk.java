import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Desk {

    private final String name;
    private final Stack<String> computerParts;

    public Desk(String name) {
        this.name = name;
        this.computerParts = new Stack<>();
    }

    public String draw() {
        return computerParts.pop();
    }

    public void put(String part) {
        computerParts.push(part);
    }

    // 메서드 분리
    public List<String> getResult() {
        List<String> result = new ArrayList<>();
        if (computerParts.isEmpty()) {
            for (int i = 0; i < 9; i++) {
                result.add("         ");
            }
            return result;
        }

        // 맨 위부터 꺼내기 위해 마지막 인덱스부터 진행
        int top = computerParts.size() - 1;
        for (int i = top; i >= 0; i--) {
            String[] lines = computerParts.get(i).split("\n");
            result.addAll(Arrays.asList(lines));
        }

        int size = result.size();
        if (size == 9) {
            return result;
        }
        // 세웠을 때, 맨위에 위치 시키기 위해 인덱스 0에 추가
        for (int i = 0; i < 9 - size; i++) {
            result.add(0, "         ");
        }
        return result;
    }

    public String getName() {
        return name;
    }
}
