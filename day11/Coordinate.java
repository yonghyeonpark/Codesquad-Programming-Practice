import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(String input) {
        int[] coordinate = convertIntoCoordinate(input);
        validate(coordinate);
        this.x = coordinate[0];
        this.y = coordinate[1];
    }

    private int[] convertIntoCoordinate(String input) {
        String regex = "\\((\\d+),(\\d+)\\)";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        int[] coordinate = new int[2];
        if (matcher.matches()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            coordinate = new int[]{x, y};
        }
        return coordinate;
    }

    private void validate(int[] coordinate) {
        if (!isValidX(coordinate[0]) || !isValidY(coordinate[1])) {
            throw new IllegalArgumentException("[ERROR] 좌표의 범위는 0~24 입니다.");
        }
    }

    private boolean isValidX(int x) {
        return x >= 0 && x <= 24;
    }

    private boolean isValidY(int y) {
        return y >= 0 && y <= 24;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
